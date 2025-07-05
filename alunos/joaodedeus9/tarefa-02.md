
🔍 Problemas no Modelo Atual
1. Violação da 1ª Forma Normal (1FN) – Atomicidade
A tabela está em 1FN (todos os campos são atômicos), mas ela mistura múltiplas entidades em uma só tabela: cliente, produto, fornecedor e entrega.

2. Violação da 2ª Forma Normal (2FN) – Dependência Parcial
O cliente_nome e cliente_telefone dependem apenas do pedido_id, não da combinação de colunas (não há chave composta, mas o problema ainda existe conceitualmente).

O mesmo vale para o produto_nome, produto_preco, fornecedor_nome, fornecedor_telefone.

3. Violação da 3ª Forma Normal (3FN) – Dependência Transitiva
fornecedor_telefone depende de fornecedor_nome, não do pedido.

produto_preco depende de produto_nome, e não diretamente do pedido.

Modelo Corrigido

CREATE TABLE clientes (
  cliente_id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE telefones_cliente (
  telefone_id SERIAL PRIMARY KEY,
  cliente_id INT NOT NULL REFERENCES clientes(cliente_id),
  telefone VARCHAR(20) NOT NULL
);

CREATE TABLE enderecos_cliente (
  endereco_id SERIAL PRIMARY KEY,
  cliente_id INT NOT NULL REFERENCES clientes(cliente_id),
  logradouro VARCHAR(100),
  numero VARCHAR(10),
  complemento VARCHAR(50),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  estado VARCHAR(2),
  cep VARCHAR(10)
);

Tabelas de Fornecedores

CREATE TABLE fornecedores (
  fornecedor_id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE telefones_fornecedor (
  telefone_id SERIAL PRIMARY KEY,
  fornecedor_id INT NOT NULL REFERENCES fornecedores(fornecedor_id),
  telefone VARCHAR(20) NOT NULL
);

CREATE TABLE enderecos_fornecedor (
  endereco_id SERIAL PRIMARY KEY,
  fornecedor_id INT NOT NULL REFERENCES fornecedores(fornecedor_id),
  logradouro VARCHAR(100),
  numero VARCHAR(10),
  complemento VARCHAR(50),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  estado VARCHAR(2),
  cep VARCHAR(10)
);


Produtos

CREATE TABLE produtos (
  produto_id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  preco NUMERIC(10,2) NOT NULL,
  fornecedor_id INT NOT NULL REFERENCES fornecedores(fornecedor_id),
  data_cadastro DATE DEFAULT CURRENT_DATE,
  data_atualizacao DATE,
  data_validade DATE
);

Pedidos

CREATE TABLE pedidos (
  pedido_id SERIAL PRIMARY KEY,
  cliente_id INT NOT NULL REFERENCES clientes(cliente_id),
  endereco_entrega_id INT REFERENCES enderecos_cliente(endereco_id)
);

 Itens do Pedido

CREATE TABLE itens_pedido (
  item_id SERIAL PRIMARY KEY,
  pedido_id INT NOT NULL REFERENCES pedidos(pedido_id),
  produto_id INT NOT NULL REFERENCES produtos(produto_id),
  quantidade INT NOT NULL,
  preco_unitario NUMERIC(10,2) NOT NULL,
  data_venda DATE DEFAULT CURRENT_DATE
);

 Inserção de Dados

-- Clientes
INSERT INTO clientes (nome) VALUES ('Ana Silva'), ('Bruno Costa');

-- Telefones dos Clientes
INSERT INTO telefones_cliente (cliente_id, telefone) VALUES
(1, '9999-0000'),
(1, '9888-1111'),
(2, '8888-1111');

-- Endereços dos Clientes
INSERT INTO enderecos_cliente (cliente_id, logradouro, numero, cidade, estado, cep) VALUES
(1, 'Rua A', '123', 'São Paulo', 'SP', '01000-000'),
(2, 'Rua B', '456', 'Rio de Janeiro', 'RJ', '20000-000');

-- Fornecedores
INSERT INTO fornecedores (nome) VALUES ('Fornecedor A'), ('Fornecedor B');

-- Telefones dos Fornecedores
INSERT INTO telefones_fornecedor (fornecedor_id, telefone) VALUES
(1, '1111-2222'),
(2, '3333-4444');

-- Endereços dos Fornecedores
INSERT INTO enderecos_fornecedor (fornecedor_id, logradouro, numero, cidade, estado, cep) VALUES
(1, 'Av Central', '1000', 'São Paulo', 'SP', '01111-111'),
(2, 'Rua das Flores', '200', 'Belo Horizonte', 'MG', '30100-000');

-- Produtos
INSERT INTO produtos (nome, preco, fornecedor_id, data_cadastro, data_validade) VALUES
('Teclado', 150.00, 1, CURRENT_DATE, '2026-12-31'),
('Mouse', 80.00, 2, CURRENT_DATE, '2026-06-30'),
('Monitor', 700.00, 1, CURRENT_DATE, '2027-01-01');

-- Pedidos
INSERT INTO pedidos (cliente_id, endereco_entrega_id) VALUES
(1, 1),
(2, 2);

-- Itens do Pedido
INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 2, 150.00),
(1, 2, 1, 80.00),
(2, 3, 1, 700.00);

	📌Modelo DER

![Captura de tela 2025-07-04 184233](https://github.com/user-attachments/assets/4dcec4fd-4e43-41da-9e23-8aa91fdb66af)

