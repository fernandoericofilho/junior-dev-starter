
🔍 Problemas no Modelo Atual
1. Violação da 1ª Forma Normal (1FN) – Atomicidade
A tabela está em 1FN (todos os campos são atômicos), mas ela mistura múltiplas entidades em uma só tabela: cliente, produto, fornecedor e entrega.

2. Violação da 2ª Forma Normal (2FN) – Dependência Parcial
O cliente_nome e cliente_telefone dependem apenas do pedido_id, não da combinação de colunas (não há chave composta, mas o problema ainda existe conceitualmente).

O mesmo vale para o produto_nome, produto_preco, fornecedor_nome, fornecedor_telefone.

3. Violação da 3ª Forma Normal (3FN) – Dependência Transitiva
fornecedor_telefone depende de fornecedor_nome, não do pedido.

produto_preco depende de produto_nome, e não diretamente do pedido.

-- Tabela de clientes
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20)
);

-- Tabela de fornecedores
CREATE TABLE fornecedores (
    fornecedor_id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20)
);

-- Tabela de produtos
CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    preco NUMERIC(10,2),
    fornecedor_id INT REFERENCES fornecedores(fornecedor_id)
);

-- Tabela de pedidos
CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(cliente_id),
    endereco_entrega VARCHAR(200)
);

-- Tabela de itens do pedido
CREATE TABLE itens_pedido (
    item_id SERIAL PRIMARY KEY,
    pedido_id INT REFERENCES pedidos(pedido_id),
    produto_id INT REFERENCES produtos(produto_id),
    quantidade INT
);

-- Inserção de dados

-- Clientes
INSERT INTO clientes (nome, telefone) VALUES
('Ana Silva', '9999-0000'),
('Bruno Costa', '8888-1111');

-- Fornecedores
INSERT INTO fornecedores (nome, telefone) VALUES
('Fornecedor A', '1111-2222'),
('Fornecedor B', '3333-4444');

-- Produtos
INSERT INTO produtos (nome, preco, fornecedor_id) VALUES
('Teclado', 150.00, 1),
('Mouse', 80.00, 2),
('Monitor', 700.00, 1);

-- Pedidos
INSERT INTO pedidos (cliente_id, endereco_entrega) VALUES
(1, 'Rua A, 123'),
(2, 'Rua B, 456');

-- Itens dos pedidos
INSERT INTO itens_pedido (pedido_id, produto_id, quantidade) VALUES
(1, 1, 2), -- Teclado
(1, 2, 1), -- Mouse
(2, 3, 1); -- Monitor

	📌Modelo DER

![Captura de tela 2025-07-04 184233](https://github.com/user-attachments/assets/4dcec4fd-4e43-41da-9e23-8aa91fdb66af)

