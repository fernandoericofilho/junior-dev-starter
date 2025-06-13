# Tarefa 01

## Apresentação Pessoal

Olá! Meu nome é José Júnior, moro em Santa Luzia na Paraíba, sou técnico em Informática pelo IFPB e graduando em Ciência da Computação pela UEPB, Tenho afinidade pela área de Engenharia e Desenvolvimento de Software, bem como conhecimentos nas linguagens de programação **Python**, **Java**, **JavaScript** e **PHP**; em frameworks e bibliotecas como **Bootstrap**, **React** e **Django**. Também possuo conhecimentos em bancos de dados relacionais como **MySQL** e **PostgreSQL**. Também vale mencionar que estagiei durante 5 meses na empresa *Compass UOL*, onde pude aprender tanto na teoria como na prática, tecnologias como **Blockchain**, **Ethereum** e a linguagem de programação orientada a contratos **Solidity** e métodos ágeis, como o **Scrum**, para a organização e trabalho em equipe; o último mês do Estágio foi dedicado a se preparar para a prova da certificação *Cloud Practitioner* da **AWS**, em que pude adquirir conhecimentos em **Computação em Nuvem** utilizando a plataforma da AWS.

## Estudo Técnico - Banco de Dados Relacional

Um Banco de Dados Relacional é um tipo de banco de dados que segue o **Modelo Relacional**, ou seja, os dados são organizados em **tabelas** (também chamadas de **relações**). Cada tabela possui **linhas** (ou **registros**) e **colunas** (ou **atributos**). Os dados em diferentes tabelas podem se relacionar entre si por meio de **chaves primárias** (*primary keys*) e **chaves estrangeiras** (*foreign keys*), em que a chave primária é utilizada para identificar unicamente cada registro de uma tabela (podendo ser composta por um ou mais atributos) e a chave estrangeira é utilizada para estabelecer relações entre tabelas, apontando para a chave primária de outra tabela.

tomamos como exemplo duas tabelas: `Clientes` e `Pedidos`.

- `Clientes` possui os seguintes atributos: `id`, `nome`, `email`.
- `Pedidos` possui os atributos: `id`, `descricao`, `valor`, `data`, `id_cliente`.

O `id_cliente` em `Pedidos` é uma chave estrangeira que aponta para a chave primária (`id`) da tabela `Clientes`.

Um Banco de Dados pode ser definido como uma coleção organizada de dados armazenados, os quais serão utilizados futuramente; um Sistema Gerenciador de Banco de Dados ou Sistema de Gerenciamento de Banco de Dados (SGBD), por sua vez, é um software que permite criar, gerenciar e manter um banco de dados. Como exemplos de SGBDs temos: `MySQL`, `PostgreSQL` e `SQL Server`.

### Modelagem Relacional

O **Modelo Entidade-Relacionamento** (ER) é uma **representação conceitual** dos dados de um sistema, utilizada na modelagem de banco de dados. Este modelo foi proposto por *Peter Chen* em 1976 e tem como objetivo representar graficamente as informações do mundo real, de forma estruturada e compreensível.

#### Principais elementos do Modelo ER

1. **Entidades**
    - Representam algo do mundo real com existência física ou conceitual;
    - Por exemplo: `Alunos`, `Professores`, `Clientes`, `Produtos`, `Cursos`, `Disciplinas`, `Empresas`, `Consultas`;
    - São representadas como **retângulos** no diagrama.
    
2. **Atributos**
    - São **características** ou **propriedades** que **qualificam as entidades**;
    - Por exemplo: `nome`, `data_nascimento`, `matrícula` são atributos da entidade `Alunos`;
    - São representados no diagrama como **elipses** ligadas à entidade e possuem diversos tipos:
        - **Simples ou atômicos**: indivisíveis (exemplo: `nome`);
        - **Compostos**: podem ser divididos em outros atributos (exemplo: `endereço` &rarr; `rua`, `bairro`);
        - **Multivalorados**: Possuem mais de um valor (exemplo: `telefones`);
        - **Atributo-Identificador**: permite a identificação de cada registro de uma entidade (como exemplo: `cpf` ou `id`).

3. **Relacionamentos**
    - **Conectam duas ou mais entidades** que possuem alguma associação entre si;
    - Por exemplo: `Alunos` **matriculam-se** em `Cursos`;
    - São representados como **losangos** entre as entidades e podem possuir atributos próprios.

4. **Cardinalidade**
    - Define a **quantidade de ocorrências** de um relacionamento entre entidades, especificando a quantidade mínima e quantidade máxima de uma entidade em relação a outra;
    - A cardinalidade máxima **indica o tipo de relacionamento**;
    - A cardinalidade mínima **indica a obrigatoriedade ou não de uma associação**;
    - Entre os tipos de cardinalidade estão:
        - **1:1** (um para um);
        - **1:N** (um para muitos);
        - **N:N** (muitos para muitos).

#### Como as entidades se relacionam

As entidades se relacionam por meio dos relacionamentos, que representam ações ou conexões lógicas entre elas.

**Por exemplo**:  
Entidades: `Pessoas` e `CarteirasIdentidade`;  
Relacionamento: `Possuem`.

![Exemplo de Relacionamento Um para Um](imagens/ExemploRelacionamentoUmParaUm.png)

- Cada **pessoa** possui no **máximo uma carteira de identidade**;
- Cada **carteira de identidade** pertence **unicamente a uma pessoa**;
- Este é um exemplo de **relacionamento 1:1**.

**Outro exemplo:**  
Entidades: `Fornecedores` e `Produtos`;  
Relacionamento: `Fornecem`.

![Exemplo de Relacionamento Um para Muitos](imagens/ExemploRelacionamentoUmParaMuitos.png)

- Cada **fornecedor** fornece **um ou vários produtos**;
- Cada **produto** é fornecido **por um único fornecedor**;
- Este é um exemplo de **relacionamento 1:N**.

**Outro exemplo:**  
Entidades: `Alunos` e `Cursos`;  
Relacionamento: `Matriculam-se`.

![Exemplo de Relacionamento Muitos para Muitos](imagens/ExemploRelacionamentoMuitosParaMuitos.png)

- Um **aluno** pode se matricular em **vários cursos**;
- Cada **curso** pode ter **vários alunos**;
- Este é um exemplo de **relacionamento N:N**.