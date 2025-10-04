# Tarefa 08 - Primeiros Endpoints Utilizando Controller, Service e Repository com Spring Boot

## Pré-requisitos ⚙️
- Java 22
- Gradle/Groovy

## Como rodar o projeto ▶️

**1** - Clone o repositório utilizando o seguinte comando:  
`git clone https://github.com/fernandoericofilho/junior-dev-starter.git`

**2** - Navegue até a pasta da seguinte tarefa pelo comando `cd`(*Change Directory*) do Windows/Linux:  
`cd ./alunos/jose-junior/tarefa08`

**3** - Por fim, rode o projeto com o seguinte comando:  
`./gradlew bootRun`

**4** - Com o projeto em execução, para acessar o console do banco de dados H2 e verificar o resultado do *Flyway Migrations*, insira a seguinte URL no seu navegador:  
`http://localhost:8080/h2-console`

**5** - Ao acessar o console do H2, insira as seguintes credenciais:  
```txt
Driver class: org.h2.driver
JDBC URL: jdbc:h2:mem:tarefadb
User Name: junior
Password:
```

**6** - Para acessar o ***Actuator***, insira a seguinte URL no seu navegador:  
`http://localhost:8080/actuator/health`  

## Dependências utilizadas no projeto 📦

### Banco de Dados
- **H2 Database** (Banco de Dados em memória do Spring)
- **Flyway Migrations** (Dependência para o gerenciamento de *migrations*/migrações)
- **Spring Data JPA** (Simplificação da camada de persistência de dados)

### Saúde do Projeto
- **Actuator** (Monitorar o estado/"saúde" da aplicação)

### Web/Outros
- **Spring Web** (Facilitar a criação de APIs RESTful para a Web)
- **Lombok** (*Boilerplate* para métodos especiais/acessores como Getter e Setter)

## Anotações utilizadas no projeto 📌

### Entidades e JPA

- `@Entity`, `@Table(name = '')`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)` nas entidades que serão mapeadas para tabelas do banco de dados;

- `@OneToOne`, `@OneToMany`, `@ManyToOne` para os relacionamentos/chaves estrangeiras (FKs) entre as entidades/tabelas;

- `@Repository` para indicar que a interface trata-se de um ***Repository***.

### Lombok

- `@Getter`, `@Setter` da dependência Lombok, para o *boilerplate* dos métodos **Getter** e **Setter**.

### Controllers e Endpoints

- `@RestController` para indicar que a classe expõe endpoints REST;

- `@RequestMapping("/clientes")` para definir o caminho base da API;

- `@GetMapping` e `@PostMapping` para definir os métodos HTTPs utilizados;

- `@RequestBody` para receber o JSON no corpo da requisição;

- `@PathVariable` para endpoints com parâmetros na URL.

### Injeção de Dependência

- `@Autowired` para fazer a injeção de dependência entre as camadas repositories/services;

- `@Service` para indicar uma classe de regra de negócios.

### Serialização JSON (Jackson)

- `@JsonManagedReference` e `@JsonBackReference` utilizadas em pares para controlar os relacionamentos bidirecionais, sendo o `@JsonManagedeReference` o lado "dono" que aparece no JSON e o `@JsonBackReference` o lado "dependente" que é ignorado na serialização.