# 🚀 Tarefa Prática – Subindo seu primeiro projeto Spring Boot com Java! ☕

Hora de colocar a mão na massa com um dos frameworks mais usados no mercado backend: **Spring Boot**!

## ✅ Objetivos

Nesta tarefa você vai:

- ✅ Criar um projeto com o **Spring Initializr**
- ✅ Adicionar as dependências: `Spring Web`, `Spring Data JPA`, `H2 Database` e `Spring Boot Actuator`
- ✅ Importar o projeto no **IntelliJ IDEA**
- ✅ Rodar a aplicação com `./gradlew bootRun`
- ✅ Verificar o health check acessando `http://localhost:8080/actuator/health`
- ✅ Acessar o console web do banco H2 em `http://localhost:8080/h2-console`

---

## 💡 Extra – Versionamento de Banco com Flyway

- ✅ Adicionar a dependência do **Flyway** ao projeto
- ✅ Criar o script `V1__create_client_table.sql` com a tabela `client` contendo os campos:
  - `id` (chave primária)
  - `name`
  - `email`
- ✅ Criar o script `V2__insert_client.sql` com registros de exemplo
- ✅ Iniciar a aplicação e verificar os dados no H2 Console com:
- ✅ No H2 execute o comando e confira os dados
  
```sql
SELECT * FROM client;
```
