# Tarefa 12: API de Clientes (Microserviço de Clientes)

Esta é uma API RESTful completa para a gestão de clientes, desenvolvida com Spring Boot 3.x. O projeto segue as melhores práticas de arquitetura em camadas e utiliza o conceito HATEOAS para garantir a navegabilidade entre os recursos.

## Pré-requisitos

**Ferramentas e Ambiente:**
* **Java 21+**: A versão da JDK necessária para compilar e rodar a aplicação.
* **Gradle**: O sistema de build utilizado para gerenciar dependências e tarefas do projeto.
* **Plugin do Lombok para a IDE**: Essencial para evitar erros de compilação, já que o projeto utiliza anotações do Lombok (como `@Data`).

**Principais Tecnologias do Projeto:**
* **Spring Boot**: A base do projeto, responsável por automatizar a configuração e a execução da aplicação.
* **Spring Data JPA**: Utilizado para a persistência de dados e a comunicação com o banco de dados.
* **Flyway**: Ferramenta de migração de banco de dados, que gerencia o schema e as tabelas do projeto.
* **SpringDoc OpenAPI (Swagger)**: A biblioteca que gera a documentação da API em tempo real.

## Como rodar o projeto

### Passos

1.  Clone o projeto:

<!-- end list -->

```bash
git clone https://github.com/fernandoericofilho/junior-dev-starter.git
```

2.  Acesse a pasta:

<!-- end list -->

```bash
cd alunos/everaldo-martins/tarefa12/
```

3.  Rode o projeto com:

<!-- end list -->

```bash
./gradlew bootRun
```

### Banco de Dados

  - **H2 Database (em memória)**: Banco de dados em memória para desenvolvimento.
  - **Flyway**: Gerencia as migrações e a criação das tabelas automaticamente na inicialização da aplicação.
  - Acesse o H2 console em: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:tarefa_db`

### Saúde do projeto

  - **Spring Boot Actuator**: Monitora a saúde e o status da aplicação.
  - Acesse o Actuator em: `http://localhost:8080/actuator/health`

### Arquitetura e Conceitos-Chave

O projeto segue as melhores práticas de uma arquitetura em camadas, utilizando conceitos importantes para a criação de uma API robusta.

#### **HATEOAS (Hypermedia as an Engine of Application State)**

Esta API é projetada com o princípio HATEOAS. Em vez de simplesmente retornar dados, as respostas incluem links que permitem aos clientes da API descobrirem e navegarem para outros recursos relacionados.

* **`RepresentationModel` e `PagedModel`**: As respostas da API não são DTOs puros, mas sim modelos de representação que contêm os dados e uma coleção de links (`_links`). A paginação utiliza o `PagedModel` para fornecer links de navegação entre as páginas (`next`, `prev`, `first`, `last`).
* **Assembler (`ClienteResponseDTOAssembler`)**: Uma classe dedicada que converte DTOs puros em modelos de representação HATEOAS, adicionando os links de navegação para ações como `update` e `delete`.

#### **Swagger / OpenAPI**

A API é totalmente documentada usando as especificações OpenAPI, facilitando a interação e o entendimento de todos os endpoints.

* **Swagger UI**: A interface interativa está disponível em `http://localhost:8080/swagger-ui.html`.
* **Anotações**: Foram utilizadas anotações como `@Tag`, `@Operation`, `@ApiResponses`, `@Parameter` e `@RequestBody` para descrever cada endpoint, seus parâmetros, o corpo da requisição e as possíveis respostas.
* **Configuração Customizada**: O projeto inclui uma configuração personalizada para que o Swagger exiba corretamente os parâmetros de paginação (`page`, `size`, `sort`) em vez de um único objeto `Pageable`.

#### **Paginação (Pageable)**

Todos os endpoints que retornam listas de clientes utilizam paginação para lidar de forma eficiente com grandes volumes de dados.

* **`@PageableDefault`**: A anotação `@PageableDefault` define um comportamento padrão para os parâmetros de paginação, como a ordenação inicial por `nome`.
* **Parâmetros de Consulta**: Os endpoints aceitam os seguintes parâmetros de consulta para controlar a paginação:
    * `page`: O número da página desejada (começa em 0).
    * `size`: O número de itens por página.
    * `sort`: A propriedade do objeto pela qual ordenar, seguida pela direção (ex: `nome,asc` ou `email,desc`).


## Endpoints da API

A API oferece um conjunto completo de endpoints RESTful para o gerenciamento de clientes. As respostas incluem links **HATEOAS** para facilitar a descoberta de recursos e a navegação.

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| `GET` | `/clientes` | Retorna uma lista paginada de todos os clientes. Suporta filtros por `page`, `size` e `sort`. |
| `GET` | `/clientes/{id}` | Retorna um cliente específico por ID. |
| `GET` | `/clientes/nome/{nome}` | Busca clientes cujo nome contenha o texto fornecido (case-insensitive). |
| `POST` | `/clientes` | Cria um novo cliente. |
| `PUT` | `/clientes/{id}` | Atualiza um cliente existente por ID. |
| `DELETE` | `/clientes/{id}` | Remove um cliente do banco de dados por ID. |

-----

## Arquitetura do Projeto

O projeto é estruturado em camadas para garantir a separação de responsabilidades e a manutenibilidade:

  - **Controller (`ClienteController`)**: Responsável por lidar com as requisições HTTP, validar os dados de entrada e delegar a lógica de negócio para a camada de serviço. Também aplica a lógica **HATEOAS** para enriquecer a resposta.
  - **Service (`ClienteService`)**: Contém a lógica de negócio. Gerencia as transações, valida dados (como e-mail duplicado) e interage com a camada de repositório.
  - **Repository (`ClienteRepository`)**: Camada de acesso a dados. Utiliza Spring Data JPA para interagir com o banco de dados.
  - **DTOs (`ClienteRequestDTO`, `ClienteResponseDTO`)**: Objetos de Transferência de Dados, usados para desacoplar as camadas e garantir que a entidade de domínio (`Cliente`) não seja exposta diretamente.
  - **Assembler (`ClienteResponseDTOAssembler`)**: Uma classe dedicada que converte os DTOs puros do serviço em modelos de representação HATEOAS, adicionando os links de navegação.

-----

## Tecnologias e Conceitos

Este projeto utiliza e demonstra diversos conceitos e tecnologias importantes:

  - **Spring HATEOAS**: Implementa o HATEOAS para criar APIs autodocumentáveis, onde os links são parte da resposta.
  - **Spring Data JPA**: Facilita a interação com o banco de dados usando repositórios, com métodos de consulta customizados.
      - Anotações de Relacionamento: `@OneToOne`, `@OneToMany`, `@ManyToOne`.
      - Mapeamento: `mappedBy`, `@JoinColumn`.
  - **SpringDoc OpenAPI / Swagger UI**: Gera a documentação da API de forma automática.
      - Anotações: `@Tag`, `@Operation`, `@ApiResponses`, `@Parameter`, `@RequestBody`.
      - Configuração: Personalizada para lidar corretamente com o objeto `Pageable`.
  - **Bean Validation**: Garante a integridade dos dados de entrada antes que cheguem à camada de serviço.
      - Anotações: `@Validated`, `@NotBlank`, `@Email`, `@Size`.
  - **Lombok**: Reduz a verbosidade do código com anotações como `@Data` e `@AllArgsConstructor`.
  - **Segurança de Nulidade**: Utiliza anotações como `@NonNull` e `@NonNullApi` para garantir contratos de nulidade e prevenir `NullPointerException`s em tempo de compilação.

-----

## Testes

O projeto conta com uma suíte completa de testes automatizados que garantem o correto funcionamento da API e das regras de negócio.

### **Tipos de Testes**

| Tipo                     | Camada                    | Descrição                                                                                                                           |
| ------------------------ | ------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| **Testes Unitários**     | *Service / Mapper*        | Validam a lógica isolada de cada componente, como mapeamentos entre DTOs e entidades, regras de validação e tratamento de exceções. |
| **Testes de Integração** | *Controller / Repository* | Garantem que os componentes funcionem corretamente em conjunto, verificando endpoints REST, persistência e comportamento HATEOAS.   |

---

### **Execução dos Testes**

Para rodar todos os testes automatizados, use:

```bash
./gradlew test
```

Os relatórios de cobertura de código (gerados pelo **JaCoCo**) podem ser encontrados após a execução em:

```
build/reports/jacoco/test/html/index.html
```

Abra o arquivo `index.html` em seu navegador para visualizar a cobertura detalhada.

---

### **Cobertura e Ferramentas**

* **JUnit 5 (Jupiter)** — Framework principal de testes.
* **Mockito** — Criação de mocks e simulação de comportamentos para testar regras de negócio.
* **Spring Boot Test / MockMvc** — Testes de integração com contexto real da aplicação.
* **JaCoCo** — Geração de relatórios de cobertura de código.

---

### **Estrutura dos Testes**

**Testes Unitários:**

* `ClienteServiceTest`:

    * Verifica a criação, atualização, exclusão e busca de clientes.
    * Testa cenários de exceção (ex: cliente inexistente, e-mail duplicado).

**Testes de Integração:**

* `ClienteControllerIT`:

    * Simula chamadas HTTP reais com `MockMvc`.
    * Testa criação, atualização, busca e exclusão de clientes via endpoints REST.
    * Valida respostas com links **HATEOAS** e status HTTP esperados.

---

### **Boas Práticas Aplicadas**

* **Isolamento de camadas:** uso de `@Mock` e `@InjectMocks` em testes unitários.
* **Banco de dados em memória (H2):** garante reprodutibilidade dos testes de integração.
* **Transações revertidas automaticamente:** uso de `@Transactional` evita persistência entre testes.
* **Validação de logs e mensagens de erro:** garante clareza em casos de falhas.
