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