# Prova de Conhecimentos Técnicos

## Questões

### 1. Qual das alternativas representa corretamente a **1ª Forma Normal (1FN)**?
- (A) Eliminar atributos multivalorados.  
- (B) Eliminar dependências transitivas.  
- (C) Eliminar dependências parciais.  
- (D) Criar chave estrangeira.  
- (E) Criar índice na tabela.

**Resposta: Letra A**

### 2. A **cardinalidade** de um relacionamento define:
- (A) A ordem dos atributos em uma tabela.  
- (B) O número de registros permitidos em uma tabela.  
- (C) A quantidade de relacionamentos possíveis entre entidades.  
- (D) O tipo da chave primária.  
- (E) O modelo físico do banco de dados.

**Resposta: Letra C**

### 3. Qual das alternativas caracteriza uma **chave primária**?
- (A) Pode conter valores nulos.  
- (B) Pode se repetir.  
- (C) É usada apenas para relacionamentos.  
- (D) Identifica unicamente cada linha.  
- (E) É opcional em uma tabela.

**Resposta: Letra D**

### 4. Qual comando Git cria uma nova **branch**?
- (A) `git init`  
- (B) `git status`  
- (C) `git checkout`  
- (D) `git branch nome-da-branch`  
- (E) `git push -u origin main`

**Resposta: Letra C** (*Fiquei em dúvida entre C e D*)

### 5. No **GitFlow**, qual branch é usada para subir código pronto para produção?
- (A) develop  
- (B) release  
- (C) main  
- (D) hotfix  
- (E) feature

**Resposta: Letra C**

### 6. Qual comando é usado para **ver o histórico de commits** no Git?
- (A) `git branch`  
- (B) `git log`  
- (C) `git revert`  
- (D) `git init`  
- (E) `git clone`

**Resposta: Letra B**

### 7. O que o comando `git clone` faz?
- (A) Exclui um repositório remoto.  
- (B) Atualiza arquivos locais.  
- (C) Copia um repositório remoto para a máquina local.  
- (D) Cria uma nova branch.  
- (E) Exibe os arquivos modificados.

**Resposta: Letra C**

### 8. O que representa a **2ª Forma Normal (2FN)**?
- (A) Não permitir valores nulos.  
- (B) Eliminar dependências parciais de uma chave primária composta.  
- (C) Criar chave estrangeira.  
- (D) Normalizar o nome das colunas.  
- (E) Usar índice em todas as colunas.

**Resposta: Letra B**

### 9. O que define a **3ª Forma Normal (3FN)**?
- (A) Nenhuma coluna depende de outra que não seja chave primária.  
- (B) Eliminar colunas nulas.  
- (C) Remover chave estrangeira.  
- (D) Criar views.  
- (E) Gerar triggers automáticas.

**Resposta: Letra A**

### 10. O que o comando `git checkout -b feature/login` faz?
- (A) Exclui a branch `feature/login`.  
- (B) Cria e entra na branch `feature/login`.  
- (C) Muda para a branch `main`.  
- (D) Realiza merge automático.  
- (E) Faz push remoto da branch.

**Resposta: Letra B**

### 11. Qual objetivo principal do **Flyway** em projetos Java?
- (A) Compilar arquivos Java.  
- (B) Fazer versionamento de scripts de banco de dados.  
- (C) Controlar branches de código.  
- (D) Criar containers Docker.  
- (E) Gerenciar dependências Maven.

**Resposta: Letra B**

### 12. Um script Flyway deve:
- (A) Ser nomeado com qualquer padrão.  
- (B) Ser escrito apenas em JSON.  
- (C) Começar com `V` seguido da versão, por exemplo: `V1__init.sql`.  
- (D) Ser criptografado.  
- (E) Ser executado manualmente no banco.

**Resposta: Letra C**

### 13. No **Spring Initializr**, para criar uma aplicação web com acesso a banco, é necessário incluir:
- (A) DevTools e Apache Commons  
- (B) Spring Web e Spring Data JPA  
- (C) Lombok e Spring Boot DevTools  
- (D) Spring Batch e Apache Kafka  
- (E) Spring Cloud e Eureka Client

**Resposta: Letra B**

### 14. Qual das alternativas representa um benefício do **Spring Initializr**?
- (A) Elimina o uso de Git.  
- (B) Permite criar projetos prontos para produção em poucos cliques.  
- (C) Compila o código automaticamente.  
- (D) Cria imagens Docker automaticamente.  
- (E) Elimina a necessidade do Maven.

**Resposta: Letra B** (*Fiquei em dúvida entre B e E*)

### 15. O que o comando `git merge` faz?
- (A) Exclui uma branch.  
- (B) Atualiza a branch remota.  
- (C) Junta alterações de uma branch na atual.  
- (D) Mostra conflitos.  
- (E) Faz backup da branch.

**Resposta: Letra C**

### 16. Quando ocorre um **conflito de merge** no Git?
- (A) Sempre que criamos uma branch nova.  
- (B) Quando há alterações diferentes na mesma linha em branches diferentes.  
- (C) Quando usamos o comando `git log`.  
- (D) Ao fazer o primeiro commit.  
- (E) Quando o push é feito antes do pull.

**Resposta: Letra E** (*Fiquei em dúvida entre B e E*)

### 17. O que representa um relacionamento de cardinalidade **1:N**?
- (A) Um registro em uma tabela A se relaciona com um registro em B.  
- (B) Muitos registros em A se relacionam com muitos em B.  
- (C) Um registro em A se relaciona com muitos em B.  
- (D) Muitos registros em A se relacionam com um em B.  
- (E) Nenhuma das anteriores.

**Resposta: Letra C**

### 18. O que o comando `git pull` realiza?
- (A) Envia alterações locais para o repositório remoto.  
- (B) Cria uma nova branch remota.  
- (C) Baixa e integra alterações do repositório remoto.  
- (D) Mostra a branch atual.  
- (E) Faz backup do repositório.

**Resposta: Letra C**

### 19. Qual dependência deve ser adicionada no Spring Initializr para que o Flyway funcione corretamente em um projeto com banco de dados?
- (A) Spring Security  
- (B) Spring Boot DevTools  
- (C) Flyway Migration  
- (D) Spring Batch  
- (E) Liquibase Core

**Resposta: Letra C**

### 20. Qual endpoint exposto pelo Spring Boot Actuator verifica se a aplicação está de pé?
- (A) `/start`  
- (B) `/monitoring`  
- (C) `/up`  
- (D) `/status`  
- (E) `/health`

**Resposta: Letra E**