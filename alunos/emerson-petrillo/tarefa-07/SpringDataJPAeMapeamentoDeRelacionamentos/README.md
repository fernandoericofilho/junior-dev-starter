# Projeto Spring Data JPA: Mapeamento de Relacionamentos

Este projeto foi desenvolvido como parte de um exercício de estudo sobre Java com Spring Boot, focando no uso do Spring Data JPA para mapeamento de entidades e relacionamentos, e no Flyway para o versionamento do banco de dados.

---

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Gradle** como gerenciador de dependências
* **Spring Data JPA (Hibernate)** para persistência de dados e ORM
* **Flyway** para migrations e versionamento de schema do banco
* **H2 Database** como banco de dados em memória para desenvolvimento e testes

---

## Como Executar o Projeto

1.  **Pré-requisitos:**
    * Ter o JDK 21 ou superior instalado.
    * Ter o Gradle instalado ou usar o Gradle Wrapper (`gradlew`) que já vem com o projeto.

2.  **Clone o projeto** para a sua máquina local.

3.  **Execute a aplicação:**
    * Abra um terminal na pasta raiz do projeto.
    * Execute o comando:
        * No Linux/Mac: `./gradlew bootRun`
        * No Windows: `gradlew.bat bootRun`

4.  **O que acontece ao executar?**
    * A aplicação Spring Boot irá iniciar.
    * O Flyway será acionado, criando as tabelas (`V1__...`) e inserindo os dados iniciais (`V2__...`) no banco H2.
    * A classe principal, implementando `CommandLineRunner`, executará uma série de testes no repositório.
    * O output dos testes será exibido no console, demonstrando o funcionamento do CRUD e das consultas customizadas.

---

## Anotações JPA Utilizadas

Para mapear as classes Java para as tabelas do banco de dados, utilizamos as seguintes anotações JPA:

* `@Entity`: Marca uma classe como uma entidade JPA, ou seja, um objeto que corresponde a uma tabela no banco de dados. É o ponto de partida para o mapeamento.

* `@Table(name = "...")`: Especifica explicitamente o nome da tabela à qual a entidade está mapeada. É uma boa prática para evitar ambiguidades.

* `@Id`: Define o atributo que atuará como a chave primária (Primary Key) da tabela.

* `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Configura a estratégia de geração da chave primária. `IDENTITY` informa ao JPA que a própria coluna do banco de dados é auto-incrementável, e que o banco se encarregará de gerar o valor.

* `@Column(name = "...")`: Mapeia um atributo da classe a uma coluna específica da tabela. Usado para definir propriedades como `nullable = false` (a coluna não pode ser nula) ou `unique = true` (o valor na coluna deve ser único).

### Anotações de Relacionamento:

* `@OneToOne`: Define um relacionamento de um-para-um.
    * No nosso caso, `Cliente` tem um `Endereco`. Usamos `mappedBy` na classe `Cliente` para indicar que a classe `Endereco` é a "dona" do relacionamento (ou seja, a tabela `endereco` é que contém a chave estrangeira `cliente_id`).
    * Usamos `cascade = CascadeType.ALL` para que operações como salvar ou deletar um cliente sejam propagadas para o seu endereço associado.

* `@OneToMany`: Define um relacionamento de um-para-muitos.
    * `Cliente` tem uma `List<Telefone>`. O `mappedBy` também é usado aqui pelo mesmo motivo que no `@OneToOne`.
    * `fetch = FetchType.LAZY` é uma otimização crucial que faz com que a lista de telefones só seja carregada do banco quando explicitamente solicitada (ex: `cliente.getTelefones()`), evitando o carregamento de dados desnecessários.

* `@ManyToOne`: O lado inverso do `@OneToMany`, define um relacionamento de muitos-para-um.
    * A entidade `Telefone` tem um atributo `Cliente`, pois muitos telefones podem pertencer ao mesmo cliente.

* `@JoinColumn(name = "cliente_id")`: Esta é a anotação que de fato cria a coluna da chave estrangeira. Ela é colocada no lado "dono" do relacionamento (nas classes `Endereco` e `Telefone`) e especifica que a coluna `cliente_id` é a que faz a ligação com a tabela `cliente`.