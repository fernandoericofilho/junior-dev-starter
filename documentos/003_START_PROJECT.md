# Demonstração de Projeto Spring Boot com Java

## 1. Criação do Projeto com Spring Initializr
- Projeto criado via [https://start.spring.io](https://start.spring.io)
- Configurações:
    - Linguagem: **Java**
    - Versão do Spring Boot: **3.5.x**
    - Versão do Java: **17**
    - Dependências selecionadas:
        - Spring Web
        - Spring Data JPA
        - H2 Database
        - Spring Boot Actuator

---

## 2. Dependências no `build.gradle.kts`

```kotlin
  dependencies {
      implementation("org.springframework.boot:spring-boot-starter-web")
      implementation("org.springframework.boot:spring-boot-starter-data-jpa")
      implementation("org.springframework.boot:spring-boot-starter-actuator")
      runtimeOnly("com.h2database:h2")
  }
```

## 3. Importação do Projeto no IntelliJ IDEA

- Abra o IntelliJ IDEA.
- Use a opção **Open** para abrir a pasta do projeto.
- O IntelliJ detecta automaticamente o arquivo `build.gradle.kts`.
- As dependências são baixadas e o projeto é indexado.
- O projeto fica pronto para ser executado.

---

## 4. Execução da Aplicação

- Execute a classe principal da aplicação, por exemplo:

Limpar e gerar os arquivos compilados:
```
./gradlew clean build 
```

Rodar a aplicação via linha de comando:
```
./gradlew bootRun
```

```java
public class TesteApplication {
  public static void main(String[] args) {
      SpringApplication.run(TesteApplication.class, args);
  }
}
```
- O Spring Boot inicializa o servidor Tomcat embutido na porta padrão 8080.

- O banco H2 em memória é configurado automaticamente.

## 5. Monitoramento de Saúde com Spring Boot Actuator

- No arquivo `application.properties`, adicione:

```properties
management.endpoints.web.exposure.include=health,info
```

- Acesse o endpoint de health check via navegador ou curl:
```
  http://localhost:8080/actuator/health
```

## 6. Acesso ao Console Web do Banco H2

- No arquivo application.properties, configure:

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

- Acesse o endpoint do h2 via navegador:

```
http://localhost:8080/h2-console
```
- Configure o console com:

```
Campo	      Valor
JDBC URL      jdbc:h2:mem:testdb
Usuário	      sa
Senha	      (deixe em branco)
```
