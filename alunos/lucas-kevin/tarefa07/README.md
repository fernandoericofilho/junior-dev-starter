# Tarefa 07: API de Clientes com Spring Data JPA

Este projeto é uma API simples para gerenciamento de clientes, seus endereços e telefones, desenvolvida como parte do curso de Java e Spring Boot. O objetivo é demonstrar o uso de Spring Data JPA, relacionamentos entre entidades e versionamento de banco com Flyway.

## 🚀 Como Rodar o Projeto

1.  **Pré-requisitos:**
    * Java 21 (ou superior)
    * IntelliJ IDEA
    * Git

2.  **Execução:**
    * Clone o repositório para sua máquina local.
    * Abra o projeto `tarefa-07` no IntelliJ IDEA.
    * Aguarde o Gradle sincronizar e baixar todas as dependências.
    * Execute a classe principal `br.com.lucaskevin.tarefa07.Tarefa07Application`. A aplicação subirá na porta `8080`.

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Java 21:** Linguagem de programação.
* **Spring Boot:** Framework principal para criação da aplicação.
* **Spring Data JPA:** Para persistência de dados e comunicação com o banco.
* **H2 Database:** Banco de dados em memória para ambiente de desenvolvimento.
* **Flyway:** Para versionamento e migração do schema do banco de dados.
* **Lombok:** Para reduzir código boilerplate (getters, setters, construtores, etc.).

## 📝 Anotações JPA Utilizadas e o Porquê

Neste projeto, utilizei as seguintes anotações de mapeamento objeto-relacional para conectar as classes Java às tabelas do banco de dados:

* **`@Entity` e `@Table`:**
    * **Por quê?** Para marcar uma classe Java como uma "entidade" e ligá-la a uma tabela específica do banco de dados (ex: `@Table(name = "cliente")`). Isso informa ao JPA que objetos dessa classe podem ser salvos no banco.

* **`@Id` e `@GeneratedValue`:**
    * **Por quê?** Para definir o atributo `id` como a chave primária da tabela e para delegar a geração do seu valor para o banco de dados (usando a estratégia `IDENTITY` que corresponde ao `AUTO_INCREMENT` do H2).

* **`@OneToOne` (em `Cliente` e `Endereco`):**
    * **Por quê?** Para mapear o relacionamento "um-para-um" entre um Cliente e um Endereço. Usei `mappedBy = "cliente"` na classe `Cliente` para indicar que a classe `Endereco` é a "dona" do relacionamento e contém a chave estrangeira (`@JoinColumn`), evitando redundância.

* **`@OneToMany` (na classe `Cliente`) e `@ManyToOne` (na classe `Telefone`):**
    * **Por quê?** Para mapear o relacionamento "um-para-muitos" entre um Cliente e seus Telefones. `@OneToMany` na lista de telefones do cliente e `@ManyToOne` no atributo cliente do telefone estabelecem a ligação bidirecional, refletindo a estrutura do banco.

## ✅ Testando os Resultados

A aplicação utiliza duas classes que implementam `CommandLineRunner` (`TesteCustomRepository` e `TesteCrudRepository`) para executar testes automaticamente na inicialização.

Os resultados das buscas customizadas e das operações de CRUD (Criar, Ler, Atualizar, Apagar) são impressos diretamente no console do IntelliJ.

Para verificar a estrutura do banco e os dados, acesse o console do H2 enquanto a aplicação está rodando:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User Name:** `lk`
* **Password:** 123