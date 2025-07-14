-- CRIAÇÃO DO BANCO DE DADOS
CREATE DATABASE loja;

-- SELECIONA O BANCO
\c loja;

-- TABELA DE CLIENTES
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- TABELA DE ENDEREÇOS
CREATE TABLE enderecos (
    endereco_id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    cep VARCHAR(10),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- TABELA DE TELEFONES DOS CLIENTES
CREATE TABLE telefones_clientes (
    telefone_id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- TABELA DE FORNECEDORES
CREATE TABLE fornecedores (
    fornecedor_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- TABELA DE TELEFONES DOS FORNECEDORES
CREATE TABLE telefones_fornecedores (
    telefone_id SERIAL PRIMARY KEY,
    fornecedor_id INT NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(fornecedor_id)
);

-- TABELA DE PRODUTOS
CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    fornecedor_id INT NOT NULL,
    data_cadastro DATE DEFAULT CURRENT_DATE,
    data_atualizacao DATE,
    validade DATE,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(fornecedor_id)
);

-- TABELA DE PEDIDOS
CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    data_pedido DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- TABELA DE ITENS DO PEDIDO
CREATE TABLE itens_pedido (
    item_pedido_id SERIAL PRIMARY KEY,
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    preco_venda NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id),
    FOREIGN KEY (produto_id) REFERENCES produtos(produto_id)
);

-- INSERÇÃO DE CLIENTES
INSERT INTO clientes (nome) VALUES 
('João Silva'),
('Maria Oliveira');

-- INSERÇÃO DE ENDEREÇOS
INSERT INTO enderecos (cliente_id, logradouro, numero, complemento, bairro, cidade, estado, cep) VALUES 
(1, 'Rua das Flores', '123', 'Apto 101', 'Centro', 'Campina Grande', 'PB', '58400-000'),
(2, 'Av. Brasil', '456', NULL, 'Bairro Novo', 'João Pessoa', 'PB', '58000-000');

-- INSERÇÃO DE TELEFONES DOS CLIENTES
INSERT INTO telefones_clientes (cliente_id, telefone) VALUES 
(1, '(83) 98888-1111'),
(1, '(83) 99999-2222'),
(2, '(83) 97777-3333');

-- INSERÇÃO DE FORNECEDORES
INSERT INTO fornecedores (nome) VALUES 
('Tech Distribuidora'),
('Eletrônicos PB');

-- INSERÇÃO DE TELEFONES DOS FORNECEDORES
INSERT INTO telefones_fornecedores (fornecedor_id, telefone) VALUES 
(1, '(83) 91234-5678'),
(1, '(83) 93456-7890'),
(2, '(83) 99876-5432');

-- INSERÇÃO DE PRODUTOS
INSERT INTO produtos (nome, preco, fornecedor_id, data_cadastro, data_atualizacao, validade) VALUES 
('Mouse Óptico', 49.90, 1, CURRENT_DATE, CURRENT_DATE, '2026-12-31'),
('Teclado Mecânico', 199.99, 2, CURRENT_DATE, CURRENT_DATE, '2027-01-01'),
('Monitor LED 21"', 799.00, 1, CURRENT_DATE, NULL, NULL);

-- INSERÇÃO DE PEDIDOS
INSERT INTO pedidos (cliente_id, data_pedido) VALUES 
(1, '2025-07-10'),
(2, '2025-07-11');

-- INSERÇÃO DE ITENS DO PEDIDO
INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_venda) VALUES 
(1, 1, 2, 49.90),    -- João comprou 2 mouses
(1, 3, 1, 799.00),   -- João comprou 1 monitor
(2, 2, 1, 199.99);   -- Maria comprou 1 teclado
