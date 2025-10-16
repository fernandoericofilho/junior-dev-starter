# **Apresentação Pessoal**
Olá. Meu nome é Abraão da Silva Junior, tenho 34 anos, sou de Parnamirim/RN. Estou me formando no curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas no Centro Universitário de João Pessoa (UNIPÊ)
e estou em processo de transição de carreira para esta área. Iniciar essa graduação despertou em mim o interesse pela tecnologia, em especial, programação. Com isso tenho buscado cursos e orientações de quem já atua na área
para poder ingressar na carreira de Desenvolvedor Back-end em Java.

---

## **Estudo sobre Banco de Dados**

Estudei o que é um Banco de Dados Relacional, sua estutura (Tabela, linhas e Colunas), diferença entre BD e SGBD, modelo entidade-relacionamento, a normalização do BD e as 3 primeiras formas normais.

**Fonte de estudo**:

- [Formas normais] (https://www.hashtagtreinamentos.com/o-que-sao-formas-normais-em-bancos-de-dados-sql?conversion=base-sql-go-post&gad_source=1&gad_campaignid=17672010714&gbraid=0AAAAADLlh898JTK7ejb7S6VZMBULzSD2X&gclid=CjwKCAjw2brFBhBOEiwAVJX5GLDn45LGKmR8zaEs4gp4Dl5vmEJBHeZodMnsl6yvw5YXN1waipcVVhoCPXkQAvD_BwE)

- [MER] (https://www.alura.com.br/artigos/mer-e-der-funcoes#:~:text=banco%20de%20dados.-,O%20que%20%C3%A9%20o%20MER%20?,atributos%20e%20os%20seus%20relacionamentos.)

- [ChatGPT] (https://chatgpt.com/)

### **Resumo**

Banco de Dados (BD) é uma coleção organizada de dados, podendo ser facilmente acessado e gerenciado. Um BD do tipo Relacional tem seus dados organizados em forma de tabelas, cada uma com linhas e colunas. Essas tabelas podem se relacionar umas com as outras através de chaves primárias e estrangeiras.
A diferença entre BD e SGBD é que o BD é o conjunto de dados em si e o SGBD é o sistema utilizado para gerenciar esses dados, permitindo ler, criar, atualizar ou deletar esses dados.

A modelagem relacional é a representação gráfica de um sistema de banco de dados, onde são descritas as entidades (representação das tabelas) e os atributos (colunas da tabela) e como essas entidades se relacionam. Os relacionamentos são associações entre duas ou mais entidades e podem ser do tipo:

1. Um para um (1:1): Em um banco de dados de currículo, um usuário só pode cadastrar um currículo. Da mesma maneira que um currículo pertence a um único usuário; 
2. Um para muitos (1:N): Em um sistema de plano de saúde, um usuário pode ter vários dependentes mas cada dependente só pode estar vinculado a um usuário principal;
3. Muitos para muitos (N:N): O proprietário de um imóvel pode contatar vários corretores e um corretor pode ser contatado por vários proprietários.

A normalização é um processo de organização do banco de dados que segue um conjunto de regras para garantir que as tabelas estejam bem estruturadas, prevenindo anomalias na manipulação desses dados. Isso também reduz redundância, melhora a integridade dos dados e o desempenho. O processo de normalização é realizado por etapas conhecidas como formas normais.

__1ª Forma Normal (1FN)__: Eliminar dados repetidos e garantir atomicidade. Cada linha com um valor único e cada coluna sem valores compostos;

__2ª Forma Normal (2FN)__: Eliminar dependência parcial. Cada coluna não chave deve depender da chave-primária inteira (no caso de chave-primária composta).

__3ª Forma Normal (3FN)__: Eliminar dependência transitiva. Coluna não chave não deve depender de outra coluna não chave.

---
As formas normais são etapas/processos para melhorar as tabelas em um banco de dados relacional, onde cada etapa tem sua regra expecífica a ser seguida antes de passar para a etapa seguinte. Esse processo é importante para uma melhor compreensão dos dados, eliminando valores compostos e/ou multivalorados e
deixa cada tabela somente com atributos relacionados a ela.

Veja esse exemplo de tabela de cadastro de clientes:

| Id_cliente | CPF |            Nome             |            Endereço            |  Telefone|
|:----------:|:---:|:---------------------------:|:------------------------------:|  :---:|
|    001     | 123 |            João             |     Rua Salvador. Natal/RN      |  3272-3272 / 9999-9999|
|    002     | 234 |Lucas| Rua Dom Pedro I. Parnamirim/RN |  8888-8888|
|      003   | 345 | André |  Avenida São Paulo. Natal/RN   |  7777-7777|

Para corrigir a tabela acima e deixa-lá na __1FN__ é preciso dividir o atributo endereço em partes menores e criar uma tabela de telefones para remover o atributo multivalorado:

|  Id_cliente | CPF | Nome  |        Rua        | Cidade | Estado|
|:-----------:| :---: | :---: |:-----------------:| :---: | :---:|
|     001     | 123 | João  |   Rua Salvador    | Natal | RN|
|     002     | 234 | Lucas |  Rua Dom Pedro I  |  Parnamirim | RN|
|     003     | 345 | André | Avenida São Paulo | Natal | RN|

| Id_cliente | Telefone|
|:----------:|  :---:|
|    001     | 3273-3273|
|    001     | 9999-9999|
|    002     | 8888-8888|
|      003   | 7777-7777|

A tabela matrícula a seguir precisa ser corrigida para a __2ªFN__:

| Id_matricula | Id_aluno | Nome_aluno | Curso|
|:------------:| :---: | :---: | :---:|
|     001      | 111 | José Silva | Matemática|
|     002      | 112 | Maria Rodrigues | Portugues|
|        003   | 113 | Lara Monteiro | Física|

Para deixar a tabela matrícula na 2FN é preciso criar uma outra tabela de Alunos pois o atributo aluno depende somente do campo chave Id_aluno e não da chave completa.

|  Id_aluno | Nome_aluno|
|:---------:| :---:|
|    111    | José Silva|
|    112    | Maria Rodrigues|
|    113    | Lara Monteiro|

| Id_matricula |   Id_aluno   |      Curso| 
|:------------:|:------------:|:-------:|
|     001      |     111      | Matemática|
|     002      |     112      | Portugues|
|        003   |     113      | Física|

Exemplo de tabela a ser aplicada a __3FN__:

| Id_funcionario | Nome  | Id_departamento | Nome_departamento | Gerente_departamento| 
|:--------------:|:-----:|:---------------:|:-----------------:| :---:|
|       1        | João  |        1        |      Vendas       | Maria |
|       2        | Pedro |        1        |      Vendas       | Maria| 
|           3    |  Ana  |        2        |     Marketing     | João| 

A tabela funcionário não está na 3FN porque as colunas Nome_departamento e Gerente_departamento dependem da coluna Id_departamente, que também é um atributo não-chave. Para normalizar essa tabela para 3FN deve-se criar uma tabela departamento:

| Id_departamento | Nome_departamento | Gerente_departamento|
|:---------------:| :---: | :---:|
|        1        | Vendas | Maria|
|            2    | Marketing | João|

|  Id_funionario | Nome | Id_departamento|
|:--------------:| :---: | :---:|
|       1        | João | 1|
|       2        | Pedro | 1|
|       3        | Ana | 2|