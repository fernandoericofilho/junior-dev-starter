#!/bin/bash

echo "🛑 Parando Kafka Microservices..."

# Cores para output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${YELLOW}⏳ Parando serviços...${NC}"
docker compose down

echo -e "${GREEN}✅ Todos os serviços foram parados${NC}"
echo ""
echo -e "${YELLOW}Para reiniciar, execute: ./run.sh${NC}"