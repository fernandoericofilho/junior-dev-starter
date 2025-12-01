#!/bin/bash

echo "🚀 Iniciando build do projeto Kafka Microservices..."

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Função para verificar se o comando foi bem sucedido
check_status() {
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✅ $1${NC}"
    else
        echo -e "${RED}❌ $1${NC}"
        exit 1
    fi
}

# Verificar se Docker está instalado
if ! command -v docker &> /dev/null; then
    echo -e "${RED}❌ Docker não está instalado. Por favor, instale o Docker primeiro.${NC}"
    exit 1
fi

# Verificar se Docker Compose está instalado
if ! command -v docker-compose &> /dev/null && ! docker compose version &> /dev/null; then
    echo -e "${RED}❌ Docker Compose não está instalado. Por favor, instale o Docker Compose primeiro.${NC}"
    exit 1
fi

echo -e "${YELLOW}📦 Build do Producer API...${NC}"
cd producer
./gradlew clean build
check_status "Build do Producer concluído"
cd ..

echo -e "${YELLOW}📦 Build do Consumer API...${NC}"
cd consumer
./gradlew clean build
check_status "Build do Consumer concluído"
cd ..

echo -e "${YELLOW}🐳 Construindo imagens Docker...${NC}"
docker compose build --no-cache
check_status "Imagens Docker construídas"

echo -e "${GREEN}🎉 Build concluído com sucesso!${NC}"
echo ""
echo -e "${YELLOW}Próximo passo: Execute ./run.sh para iniciar os serviços${NC}"