#!/bin/bash

echo "🚀 Iniciando Kafka Microservices..."

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Função para verificar se o comando foi bem sucedido
check_status() {
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✅ $1${NC}"
    else
        echo -e "${RED}❌ $1${NC}"
        return 1
    fi
}

# Função para aguardar até que um serviço esteja saudável
wait_for_service() {
    local service=$1
    local max_attempts=$2
    local attempt=1
    
    echo -e "${YELLOW}⏳ Aguardando $service ficar pronto...${NC}"
    
    while [ $attempt -le $max_attempts ]; do
        case $service in
            "kafka")
                if docker compose exec kafka kafka-topics --list --bootstrap-server localhost:9092 &> /dev/null; then
                    echo -e "${GREEN}✅ Kafka está pronto!${NC}"
                    return 0
                fi
                ;;
            "producer")
                if curl -s http://localhost:8081/producer/api/messages/health &> /dev/null; then
                    echo -e "${GREEN}✅ Producer API está pronto!${NC}"
                    return 0
                fi
                ;;
            "consumer")
                if curl -s http://localhost:8082/consumer/api/stats/health &> /dev/null; then
                    echo -e "${GREEN}✅ Consumer API está pronto!${NC}"
                    return 0
                fi
                ;;
        esac
        
        echo -e "${YELLOW}⏳ Tentativa $attempt/$max_attempts...${NC}"
        sleep 5
        ((attempt++))
    done
    
    echo -e "${RED}❌ $service não ficou pronto após $max_attempts tentativas${NC}"
    return 1
}

# Verificar se as imagens existem
echo -e "${YELLOW}🔍 Verificando imagens Docker...${NC}"
if ! docker images | grep -q "spring_boot-kafka-docker-producer" || ! docker images | grep -q "spring_boot-kafka-docker-consumer"; then
    echo -e "${RED}❌ Imagens Docker não encontradas. Execute ./build.sh primeiro.${NC}"
    exit 1
fi

# Parar serviços se já estiverem rodando
echo -e "${YELLOW}🛑 Parando serviços existentes...${NC}"
docker-compose down
check_status "Serviços parados"

# Iniciar Zookeeper e Kafka primeiro
echo -e "${YELLOW}🐳 Iniciando Zookeeper e Kafka...${NC}"
docker-compose up -d zookeeper kafka
check_status "Zookeeper e Kafka iniciados"

# Aguardar Kafka ficar pronto
wait_for_service "kafka" 12

if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Kafka não conseguiu iniciar. Verificando logs...${NC}"
    docker-compose logs kafka | tail -20
    exit 1
fi

# Criar tópicos manualmente para garantir
echo -e "${YELLOW}📝 Criando tópicos Kafka...${NC}"
docker-compose exec kafka kafka-topics --create --topic user-topic --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092 --if-not-exists
docker-compose exec kafka kafka-topics --create --topic order-topic --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092 --if-not-exists

echo -e "${GREEN}📊 Tópicos criados:${NC}"
docker-compose exec kafka kafka-topics --list --bootstrap-server localhost:9092

# Iniciar aplicações
echo -e "${YELLOW}🐳 Iniciando Producer e Consumer APIs...${NC}"
docker-compose up -d producer consumer kafka-ui
check_status "APIs iniciadas"

# Aguardar aplicações ficarem prontas
echo -e "${YELLOW}⏳ Aguardando aplicações inicializarem...${NC}"
sleep 20

wait_for_service "producer" 6
wait_for_service "consumer" 6

# Status final
echo ""
echo -e "${GREEN}🎉 Todos os serviços estão rodando!${NC}"
echo ""
echo -e "${BLUE}📊 Endpoints disponíveis:${NC}"
echo -e "${YELLOW}┌─────────────────────────────────────────────┐${NC}"
echo -e "${YELLOW}│ ${GREEN}Producer API:${NC}  http://localhost:8081/producer   ${YELLOW}│${NC}"
echo -e "${YELLOW}│ ${GREEN}Consumer API:${NC}  http://localhost:8082/consumer   ${YELLOW}│${NC}"
echo -e "${YELLOW}│ ${GREEN}Kafka UI:${NC}      http://localhost:8080            ${YELLOW}│${NC}"
echo -e "${YELLOW}└─────────────────────────────────────────────┘${NC}"
echo ""
echo -e "${BLUE}🛠️  Comandos úteis:${NC}"
echo -e "${YELLOW}• Ver logs:${NC}              docker compose logs -f [serviço]"
echo -e "${YELLOW}• Parar serviços:${NC}        docker compose down"
echo -e "${YELLOW}• Reiniciar:${NC}             ./run.sh"
echo ""
echo -e "${BLUE}🧪 Testar integração:${NC}"
echo -e "${YELLOW}curl -X POST http://localhost:8081/producer/api/messages/sample/user${NC}"
echo -e "${YELLOW}curl http://localhost:8082/consumer/api/stats/summary${NC}"
echo ""

# Teste rápido automático
echo -e "${YELLOW}🧪 Executando teste rápido...${NC}"
sleep 5

if curl -s -X POST http://localhost:8081/producer/api/messages/sample/user > /dev/null; then
    echo -e "${GREEN}✅ Teste do Producer: OK${NC}"
else
    echo -e "${RED}❌ Teste do Producer: Falhou${NC}"
fi

sleep 3

if curl -s http://localhost:8082/consumer/api/stats/summary > /dev/null; then
    echo -e "${GREEN}✅ Teste do Consumer: OK${NC}"
else
    echo -e "${RED}❌ Teste do Consumer: Falhou${NC}"
fi

echo ""
echo -e "${GREEN}✨ Kafka Microservices está rodando e pronto para uso!${NC}"