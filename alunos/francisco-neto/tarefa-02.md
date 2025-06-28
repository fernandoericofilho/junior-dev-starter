# Violação das formas normais


## Violação da 1ª Forma Normal (1FN)

O banco não possui listas dentro dos campos, mas apresenta um problema estrutural, pois não separa corretamente produtos dentro de um pedido. Isso gera repetição de dados e dificulta o controle de pedidos com múltiplos itens.

## Violação da 2ª Forma Normal (2FN)

Mesmo utilizando uma chave simples (pedido_id), há dados que não dependem diretamente do pedido, como informações do cliente e do fornecedor. Esses dados deveriam estar em tabelas próprias, o que mostra uma falha na modelagem.

## Violação da 3ª Forma Normal (3FN)

Existem dependências entre atributos não-chave, como o telefone do cliente que depende do nome do cliente, e não do pedido. Isso viola a 3FN, pois esses dados estão mal organizados e deveriam ser separados em entidades distintas.

## Sripts SQL - Modelos corrigidos

-- Tabela de Clientes
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)
);

-- Tabela de Fornecedores
CREATE TABLE fornecedores (
    fornecedor_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)
);

-- Tabela de Produtos
CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    fornecedor_id INT REFERENCES fornecedores(fornecedor_id)
);

-- Tabela de Endereços
CREATE TABLE enderecos (
    endereco_id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(cliente_id),
    logradouro VARCHAR(200) NOT NULL
);

-- Tabela de Pedidos
CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(cliente_id),
    endereco_id INT REFERENCES enderecos(endereco_id),
    data_pedido DATE DEFAULT CURRENT_DATE
);

-- Tabela de Itens do Pedido (relaciona produtos ao pedido)
CREATE TABLE itens_pedido (
    item_id SERIAL PRIMARY KEY,
    pedido_id INT REFERENCES pedidos(pedido_id),
    produto_id INT REFERENCES produtos(produto_id),
    quantidade INT NOT NULL,
    preco_unitario NUMERIC(10,2) NOT NULL -- Valor do produto no momento do pedido
);

## Inserir os dados agora.

INSERT INTO clientes (nome, telefone) VALUES
('Ana Silva', '9999-0000'),
('Bruno Costa', '8888-1111'),
('Carlos Lima', '7777-2222');

INSERT INTO fornecedores (nome, telefone) VALUES
('Fornecedor A', '1111-2222'),
('Fornecedor B', '3333-4444');

INSERT INTO produtos (nome, preco, fornecedor_id) VALUES
('Teclado', 150.00, 1),
('Mouse', 80.00, 2),
('Monitor', 700.00, 1),
('Headset', 200.00, 2);

INSERT INTO enderecos (cliente_id, logradouro) VALUES
(1, 'Rua A, 123'),
(2, 'Rua B, 456'),
(3, 'Rua C, 789');

INSERT INTO pedidos (cliente_id, endereco_id, data_pedido) VALUES
(1, 1, '2024-06-01'),
(2, 2, '2024-06-02'),
(1, 1, '2024-06-03'),
(3, 3, '2024-06-04');

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 2, 150.00), -- Ana Silva pediu 2 Teclados
(1, 2, 1, 80.00),  -- Ana Silva pediu 1 Mouse
(2, 3, 1, 700.00), -- Bruno pediu 1 Monitor
(3, 4, 3, 200.00), -- Ana Silva fez outro pedido: 3 Headsets
(4, 2, 2, 80.00);  -- Carlos pediu 2 Mouses

## Porque o novo modelo irá resolver os problemas? 

O novo modelo resolve as violações de normalização ao separar as informações em tabelas específicas, de acordo com suas entidades. Os dados de clientes, fornecedores, produtos, endereços, pedidos e itens dos pedidos foram organizados, eliminando repetições e dependências desnecessárias.

Agora, cada dado depende exclusivamente da sua chave primária, evitando redundâncias. Por exemplo, as informações de telefone do cliente estão na tabela clientes e não se repetem nos pedidos. As informações dos produtos e fornecedores também estão centralizadas. Além disso, a tabela itens_pedido permite que um pedido tenha vários produtos, resolvendo problemas de estrutura e mantendo os dados íntegros, consistentes e fáceis de atualizar.

