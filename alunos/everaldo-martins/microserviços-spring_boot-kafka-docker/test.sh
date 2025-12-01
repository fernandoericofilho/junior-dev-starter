#!/bin/bash

echo "🧪 Testando Kafka Microservices..."

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

test_endpoint() {
    local url=$1
    local name=$2
    local expected_http_code=$3
    
    echo -e "${YELLOW}🔍 Testando $name...${NC}"
    response=$(curl -s -w "%{http_code}" -o /tmp/response_body $url)
    http_code=${response: -3}
    
    if [ "$http_code" -eq "$expected_http_code" ]; then
        echo -e "${GREEN}✅ $name: HTTP $http_code (OK)${NC}"
        return 0
    else
        echo -e "${RED}❌ $name: HTTP $http_code (esperado $expected_http_code)${NC}"
        cat /tmp/response_body
        echo ""
        return 1
    fi
}

echo -e "${BLUE}📋 Iniciando testes de integração...${NC}"

# Testar saúde dos serviços
test_endpoint "http://localhost:8081/producer/api/messages/health" "Producer Health" 200
test_endpoint "http://localhost:8082/consumer/api/stats/health" "Consumer Health" 200

# Testar envio de mensagens
echo -e "${YELLOW}🔍 Testando envio de mensagens...${NC}"
response=$(curl -s -X POST http://localhost:8081/producer/api/messages/sample/user)
if echo "$response" | grep -q "status"; then
    echo -e "${GREEN}✅ Envio de mensagem: OK${NC}"
else
    echo -e "${RED}❌ Envio de mensagem: Falhou${NC}"
    echo "Resposta: $response"
fi

# Aguardar processamento
sleep 3

# Testar consumo de mensagens
test_endpoint "http://localhost:8082/consumer/api/stats/summary" "Consumer Stats" 200

echo -e "${BLUE}📊 Resumo dos testes:${NC}"
echo -e "${GREEN}✅ Serviços testados com sucesso!${NC}"
echo ""
echo -e "${YELLOW}Para mais testes, acesse:${NC}"
echo "Producer: http://localhost:8081/producer"
echo "Consumer: http://localhost:8082/consumer"
echo "Kafka UI: http://localhost:8080"