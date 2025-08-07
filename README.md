# 📄 Entrevista Técnica – Engenheiro de Software Júnior

## 🎯 Objetivo Geral

O objetivo deste material é **treinar e preparar novos desenvolvedores** para os desafios do mercado de tecnologia, por meio do desenvolvimento de **soft skills e hard skills** essenciais para sua carreira.

A proposta é oferecer uma trilha de aprendizado que ajude você a se destacar desde os primeiros contatos com recrutadores até o ambiente profissional. Aqui, vamos abordar:

- ✅ **Apresentação pessoal**: como se comunicar bem em entrevistas e processos seletivos.
- ✅ **Entrevistas técnicas**: como estruturar suas respostas e mostrar seu potencial mesmo com pouca experiência.
- ✅ **Construção de presença profissional**: como organizar e destacar seu perfil no LinkedIn e GitHub.
- ✅ **Aprimoramento técnico**: práticas de estudos, projetos pessoais e como evoluir constantemente em tecnologias exigidas pelo mercado.
- ✅ **Comunicação e postura profissional**: saber se posicionar, receber feedbacks, trabalhar em equipe e demonstrar atitude proativa.

---

## 1. Tarefa 01 - Apresentação Pessoal

Nesta tarefa inicial, cada aluno deve criar uma apresentação curta com informações sobre sua formação, objetivos e interesses com a tecnologia. O objetivo é desenvolver uma narrativa pessoal que possa ser usada também no LinkedIn e em entrevistas. Assim como exercitar um novo tema e desenvolver a pesquisa e aprendizado.

📄 [Documentação](documentos/001_APRESENTACAO.md)  
📄 [Acesse a tarefa aqui](tarefas/001_TAREFA_APRESENTACAO.md)

---

## 2. Tarefa 02 - Instalação de Banco de Dados, Modelagem e Normalização Prática

Nesta etapa, vamos aprofundar o entendimento sobre bancos de dados relacionais, focando na instalação prática, criação de tabelas e identificação de problemas comuns de modelagem que violam as 1ª, 2ª e 3ª formas normais (1FN, 2FN, 3FN). Você também aprenderá a usar o DBeaver para explorar dados e visualizar a modelagem por meio de um Diagrama Entidade-Relacionamento (DER).

---

📄 [Acesse a tarefa aqui](tarefas/002_TAREFA_BANCO_DE_DADOS.md)

---

## 3. Tarefa 03 - Comandos GIT e GitFlow

Nesta etapa, vamos aprofundar o conhecimento sobre comandos do git e funcionamento do gitflow.

---

📄 [Documentação](documentos/002_GIT_FLOW.MD)  
📄 [Acesse a tarefa aqui](tarefas/003_TAREFA_GITFLOW.md)

---

## 4. Tarefa 04 - Spring Initializr, H2 e Configuração Inicial do Projeto

Nesta etapa, você irá criar e executar seu primeiro projeto com Spring Boot utilizando o Spring Initializr. Vai aprender a configurar o banco H2 em memória, utilizar o Actuator para health check e aplicar versionamento de banco com Flyway.

---

📄 [Documentação](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/documentos/003_START_PROJECT.md)  
📄 [Acesse a tarefa aqui](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/004_TAREFA_SPRING_INITIALIZER.md)

---

## 5. Tarefa 05 - Prova de Conhecimentos Técnicos

Esta prova tem como objetivo revisar os fundamentos de programação com foco em lógica, sintaxe e estrutura da linguagem Java. São exercícios práticos que abordam desde variáveis e operadores até classes, métodos e estruturas de dados.

📄 [Acesse a prova aqui](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/005_PROVA_01.md)

---

## 6. Tarefa 06 - Revisão de Fundamentos Java

Material complementar para reforçar conceitos básicos e intermediários da linguagem Java. É essencial para se preparar para os exercícios da prova e para outras tarefas práticas da trilha.

📄 [Acesse o material aqui](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/006_REVISAO_JAVA_BASICO.md)

---

## 7. Tarefa 07 - Spring Data JPA e Mapeamento de Relacionamentos

Nesta tarefa você deverá criar um projeto Java com Spring Boot utilizando o Spring Data JPA para reforçar o entendimento de:

- Mapeamento de entidades com anotações JPA
- Criação de relacionamentos entre tabelas
- Uso do Flyway para versionamento de scripts SQL
- Implementação de repositórios com métodos usando JPA Query Methods

📄 [Acesse a tarefa aqui](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/007_SPRING_DATA_JPA.md)

---

## 8. Tarefa 08 - Primeiro Endpoint com Spring MVC

Nesta tarefa você deverá criar um projeto Java com Spring Boot utilizando Spring MVC para reforçar o entendimento de:

- Criação de controller REST com `@RestController`
- Implementação do método `GET /clientes`
- Criação de classes `Repository` e `Service`
- Uso de `@Autowired` para injeção de dependências
- Testes de requisições com o Postman

📄 [Acesse a tarefa aqui](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/008_FIRST_ENDPOINT.md)

---

## 9. Tarefa 09 - Cliente: Uso de DTOs, Optional e Princípio do Mínimo Privilégio

Nesta tarefa você deverá refatorar o CRUD da entidade Cliente aplicando boas práticas de arquitetura, como o uso de DTOs para entrada e saída, separação entre as camadas (Controller, Service e Repository), aplicação do princípio do mínimo privilégio e tratamento global de exceções.

Requisitos principais desta tarefa:

- Separar responsabilidades entre Controller, Service e Repository
- Criar e utilizar DTOs (`ClienteRequestDTO` e `ClienteResponseDTO`)
- Usar `Optional` para tratar buscas na camada de serviço
- Implementar um handler global de exceções com `@ControllerAdvice`
- Evitar que a camada Controller tenha acesso direto ao modelo de domínio

🚀 Tarefa Extra: adicionar Swagger para documentação dos endpoints do `ClienteController`.

📄 Acesse a tarefa aqui: [tarefas/009_CONTRACTS.md](https://github.com/fernandoericofilho/junior-dev-starter/blob/main/tarefas/009_CONTRACTS.md)

