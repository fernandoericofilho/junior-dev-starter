-- Criação do Banco de Dados loja
CREATE DATABASE loja;

-- Selecionando/Conectando ao banco loja
/c loja;

-- Criação da tabela clientes
CREATE TABLE clientes (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	endereco_entrega VARCHAR(200) NOT NULL
);

-- Criação da tabela fornecedores
CREATE TABLE fornecedores (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL
);

-- Criação da tabela produtos
CREATE TABLE produtos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	preco NUMERIC(10, 2) NOT NULL,
	fornecedor_id INT REFERENCES fornecedores(id)
);

-- Criação da tabela pedidos
CREATE TABLE pedidos (
	id SERIAL PRIMARY KEY,
	quantidade INT NOT NULL,
	cliente_id INT REFERENCES clientes(id),
	produto_id INT REFERENCES produtos(id)
);

-- Inserindo dados na tabela clientes
INSERT INTO clientes (nome, telefone, endereco_entrega) VALUES
('Ana Silva', '9999-0000', 'Rua A, 123'),
('Bruno Costa', '8888-1111', 'Rua B, 456');

-- Inserindo dados na tabela fornecedores
INSERT INTO fornecedores (nome, telefone) VALUES
('Fornecedor A', '1111-2222'),
('Fornecedor B', '3333-4444');

-- Inserindo dados na tabela produtos
INSERT INTO produtos (nome, preco, fornecedor_id) VALUES
('Teclado', 150.00, 1),
('Mouse', 80.00, 2),
('Monitor', 700.00, 1);

-- Inserindo dados na tabela pedidos
INSERT INTO pedidos (quantidade, cliente_id, produto_id) VALUES
(2, 1, 1),
(1, 1, 2),
(1, 2, 3);
