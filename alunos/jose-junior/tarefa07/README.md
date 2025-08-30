# Tarefa 07 - Spring Data JPA e Relacionamentos

## Pré-requisitos ⚙️
- Java 22
- Gradle/Groovy

## Como rodar o projeto ▶️

**1** - Clone o repositório utilizando o seguinte comando:  
`git clone https://github.com/fernandoericofilho/junior-dev-starter.git`

**2** - Navegue até a pasta da seguinte tarefa pelo comando `cd`(*Change Directory*) do Windows/Linux:  
`cd ./alunos/jose-junior/tarefa07`

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

- `@Entity`, `@Table(name = '')`, `@Id`, `@GeneratedValue(strategy = GeneratedType.IDENTITY)` nas entidades que serão mapeadas para tabelas do banco de dados;
- `@Getter`, `@Setter` da dependência Lombok, para o *boilerplate* dos métodos **Getter** e **Setter**;
- `@OneToOne`, `@OneToMany`, `@ManyToOne` para os relacionamentos/chaves estrangeiras (FKs) entre as entidades/tabelas;
- `@Repository` para indicar que a interface trata-se de um ***Repository***.