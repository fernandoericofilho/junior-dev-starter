# Tarefa 02 - Instalação de Banco de Dados, Modelagem e Normalização na Prática

Como parte da tarefa foi apresentado o seguinte script SQL contendo uma tabela com problemas de normalização:

```sql

-- Criação do banco de dados
CREATE DATABASE loja;

-- Use o banco criado
\c loja;

-- Tabela com problemas nas formas normais
CREATE TABLE pedidos (
  pedido_id SERIAL PRIMARY KEY,
  cliente_nome VARCHAR(100),
  cliente_telefone VARCHAR(20),
  produto_nome VARCHAR(100),
  produto_preco NUMERIC(10,2),
  quantidade INT,
  fornecedor_nome VARCHAR(100),
  fornecedor_telefone VARCHAR(20),
  endereco_entrega VARCHAR(200)
);

-- Inserindo dados
INSERT INTO pedidos (cliente_nome, cliente_telefone, produto_nome, produto_preco, quantidade, fornecedor_nome, fornecedor_telefone, endereco_entrega) VALUES
('Ana Silva', '9999-0000', 'Teclado', 150.00, 2, 'Fornecedor A', '1111-2222', 'Rua A, 123'),
('Ana Silva', '9999-0000', 'Mouse', 80.00, 1, 'Fornecedor B', '3333-4444', 'Rua A, 123'),
('Bruno Costa', '8888-1111', 'Monitor', 700.00, 1, 'Fornecedor A', '1111-2222', 'Rua B, 456');
```

A partir desse script, foi proposta a análise e identificação de violação das três formas normais, bem como a correção dessas. Antes de começar a análise, eu fiz uma modelagem da tabela criada no script, utilizando a ferramenta online [DrawSQL](https://drawsql.app/)

![Modelagem Inicial](imagens/ModelagemInicial.png)  
*Obs: No script apresentado, o preço do produto (`produto_preco`) está com o tipo `numeric`, mas como no **DrawSQL** não tinha essa opção, optei por `decimal` mesmo.*

## Análise da Modelagem Inicial

A tabela `pedidos` possui diversas violações às formais normais, iremos ver cada uma detalhadamente:

### 1ª Forma Normal (1FN)

A **1ª Forma Normal** exige que uma tabela possua atributos atômicos (indivisíveis), ou seja, atributos que possuam apenas um valor e não apresente dados repetidos. Apesar da tabela `pedidos` não possuir atributos multivalorados explicitamente, por conter informações de clientes, produtos, fornecedores e pedidos em uma única tabela, durante a inserção/armazenamento dos dados nessa, haverá a presença de dados repetidos o que poderá compremeter no desempenho e na manutenção do banco (por exemplo ao tentar atualizar/modificar algum registro).

### 2ª Forma Normal (2FN)

A **2ª Forma Normal** exige que uma tabela esteja na 1FN e não possua **Dependência Funcional Parcial**, ou seja, os atributos não-chave devem depender completamente da chave primária e não apenas de uma parte da chave primária (caso seja uma chave composta), apesar dos atributos não-chave não dependerem "diretamente" da chave primária da tabela (`pedido_id`), a chave primária da tabela não é composta. Dessa maneira, caso estivesse na 1FN, a tabela também poderia está na 2FN já que não possui uma chave primária composta de forma que os atributos dependessem apenas de parte da chave (mesmo que essa tabela apresente alguns problemas de normalização, ao primeiro olhar).

### 3º Forma Normal (3FN)

A **3ª Forma Normal** exige que uma tabela esteja na 2FN e não possua **Dependência Funcional Transitiva**, ou seja, não deve possuir atributos não-chave que dependam de outros atributos não-chave. A tabela `pedidos` possui atributos que dependem de outros atributos que não são chave primária da tabela, como `cliente_telefone` depende de `cliente_nome`, `produto_preco` depende de `produto_nome` e `fornecedor_telefone` depende de `fornecedor_nome`.

## Resolução das Violações das Formas Normas 

Para resolver essas violações, foram criadas novas tabelas de acordo com as entidades desse contexto (como `clientes`, `fornecedores` e `produtos`) e tendo os seus atributos originados a partir de alguns atributos que foram retirados da tabela inicial `pedidos`, acrescidos de chaves e respeitando as Formas Normais. Ficando a modelagem desta forma:

![Modelagem Normalizada](imagens/ModelagemNormalizada.png)

Como pode ser visto na imagem acima, os fornecedores distribuem **um ou vários** produtos, enquanto cada produto é fornecido por um fornecedor **unicamente**. **Um ou vários** clientes podem fazer a compra de **um ou vários** produtos, mas cada pedido é referente a um cliente **unicamente**. Além disso, com a separação dos atributos para as tabelas `clientes`, `fornecedores` e `produtos`, houve a eliminação da possibilidade de ocorrências de **Dependências Funcionais Parciais** e **Dependências Funcionais Transitivas** que ferem as normas 2FN e 3FN respectivamente.

## Script da Modelagem Normalizada

Com isso, o novo script para a modelagem normalizada, o qual é dividido em: criação do banco e seleção/conexão do mesmo, criação das tabelas; Será o seguinte:

```sql
-- Criação do Banco de Dados loja
CREATE DATABASE loja;

-- Selecionando/Conectando ao banco loja
/c loja;

-- Criação da tabela clientes
CREATE TABLE clientes (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

-- Criação da tabela enderecos_clientes
CREATE TABLE enderecos_clientes (
	id SERIAL PRIMARY KEY,
	estado CHAR(2) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	bairro VARCHAR(100) NOT NULL,
	cep CHAR(8) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	complemento VARCHAR(50),
	cliente_id INT NOT NULL REFERENCES clientes(id)
);

-- Criação da tabela fornecedores
CREATE TABLE fornecedores (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
);

-- Criação da tabela telefones
CREATE TABLE telefones (
	id SERIAL PRIMARY KEY,
	numero VARCHAR(20) NOT NULL,
	cliente_id INT REFERENCES clientes(id),
	fornecedor_id INT REFERENCES fornecedores(id)
);

-- Criação da tabela produtos
CREATE TABLE produtos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	preco NUMERIC(10, 2) NOT NULL,
	data_cadastro TIMESTAMP NOT NULL,
	data_atualizacao TIMESTAMP NOT NULL,
	data_validade TIMESTAMP,
	fornecedor_id INT REFERENCES fornecedores(id)
);

-- Criação da tabela pedidos
CREATE TABLE pedidos (
	id SERIAL PRIMARY KEY,
	data_compra TIMESTAMP NOT NULL,
	data_entrega TIMESTAMP NOT NULL,
	status_pedido VARCHAR(20) NOT NULL,
	cliente_id INT NOT NULL REFERENCES clientes(id),
	endereco_entrega_id INT NOT NULL REFERENCES enderecos_clientes(id)
);

-- Criação da tabela produtos_pedidos
CREATE TABLE produtos_pedidos (
	id SERIAL PRIMARY KEY,
	quantidade INT NOT NULL,
	preco_venda DECIMAL(10, 2) NOT NULL,
	pedido_id INT NOT NULL REFERENCES pedidos(id),
	produto_id INT NOT NULL REFERENCES produtos(id)
);
```

Após criadas as tabelas, é possível visualizar um Diagrama Entidade-Relacionamento (ER) gerado pelo **DBeaver** (ferramenta sugerida para ser utilizada nessa tarefa, que permite a visualização e o gerenciamento de diversos bancos de dados), baseado nessas tabelas criadas pelo script anterior.

![DER do DBeaver](imagens/ModelagemDBeaver.png)

Por fim, podemos inserir os dados em cada uma das tabelas criadas anteriormente, por meio do seguinte script:

```sql
-- Inserindo dados na tabela clientes
INSERT INTO clientes (nome) VALUES
('Ana Silva'),
('Bruno Costa'),
('Carlos Henrique'),
('Daniel Lacerda');

-- Inserindo dados na tabela enderecos_clientes
INSERT INTO enderecos_clientes(estado, cidade, bairro, cep, logradouro, cliente_id) VALUES
('PB', 'João Pessoa', 'Valentina de Figueiredo', '58064510', 'Rua Professora Heline Campos da Costa', 1),
('PE', 'Recife', 'Nova Descoberta', '52090040', 'Rua Maripá', 2),
('SP', 'São Paulo', 'Jardim Nakamura', '04942160', 'Rua Churchill', 3),
('RJ', 'Teresópolis', 'Albuquerque', '25977350', 'Estrada Angola', 4);

-- Inserindo dados na tabela fornecedores
INSERT INTO fornecedores (nome) VALUES
('Comercial Nova Era Ltda'),
('Distribuidora Sol Nascente'),
('Fornecedora GlobalTech'),
('Atacadista Verde Vale');

-- Inserindo dados na tabela telefones
INSERT INTO telefones (numero, cliente_id, fornecedor_id) VALUES
('(83)98765-4321', 1, NULL),
('(81)99612-3456', 2, NULL),
('(11)91234-5678', 3, NULL),
('(21)99876-5432', 4, NULL),
('(83)99123-4567', NULL, 1),
('(83)99987-6543', NULL, 2),
('(81)99321-7890', NULL, 3),
('(21)99456-1234', NULL, 4);

-- Inserindo dados na tabela produtos
INSERT INTO produtos (nome, preco, data_cadastro, data_atualizacao, data_validade, fornecedor_id) VALUES
('Teclado', 150.00, '2025-06-01 10:15:00', '2025-07-10 08:30:00', NULL, 1),
('Mouse', 80.00, '2025-06-02 11:00:00', '2025-07-12 09:45:00', NULL, 1),
('Monitor', 700.00, '2025-06-03 12:20:00', '2025-07-13 14:10:00', NULL, 2),
('Webcam HD', 249.90, '2025-06-05 09:10:00', '2025-07-14 10:00:00', NULL, 2),
('Cadeira Ergonômica', 1199.00, '2025-06-06 14:40:00', '2025-07-10 16:00:00', NULL, 3),
('Cartucho de Tinta', 89.50, '2025-06-08 08:00:00', '2025-07-12 13:20:00', '2026-06-08 00:00:00', 4);

-- Inserindo dados na tabela pedidos
INSERT INTO pedidos (data_compra, data_entrega, status_pedido, cliente_id, endereco_entrega_id) VALUES
('2025-07-01 10:00:00', '2025-07-04 15:30:00', 'entregue', 1, 1),
('2025-07-05 14:20:00', '2025-07-08 13:10:00', 'processando', 2, 2),
('2025-07-07 09:45:00', '2025-07-12 11:00:00', 'enviado', 3, 3),
('2025-07-10 16:30:00', '2025-07-13 17:45:00', 'pendente', 4, 4);

-- Inserindo dados na tabela produtos_pedidos
INSERT INTO produtos_pedidos (quantidade, preco_venda, pedido_id, produto_id) VALUES
(1, 150.00, 1, 1),
(1, 80.00, 1, 2),
(2, 89.50, 2, 6),
(1, 249.90, 2, 4),
(1, 700.00, 3, 3),
(1, 80.00, 3, 2),
(1, 89.50, 3, 6),
(1, 1199.00, 4, 5);
```