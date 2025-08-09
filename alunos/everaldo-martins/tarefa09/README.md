# Tarefa 09 — Spring Data JPA e Relacionamentos

## 💻 Como rodar o projeto

### Pré-requisitos

- Java 21+
- Gradle - Groovy

### Passos

1. Clone o projeto:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Acesse a pasta:
```bash
cd tarefa09/
```

3. Rode o projeto com:
```bash
./gradlew bootRun
```

### Banco de Dados

- H2 Database (em memória)
- Flyway cria as tabelas automaticamente na inicialização
- Acesse o H2 console em: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:tarefa_db`

### Saúde do projeto

- Spring Boot Actuator
- Acesse o Actuator em: `http://localhost:8080/actuator/health`