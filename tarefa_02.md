Tarefa 02 - Relatório
Análise dos Problemas do Modelo Inicial
O modelo inicial apresentava diversas violações das formas normais de normalização de dados:
1.	Redundância de dados: Dados como nome do cliente, telefone e endereço estavam se repetindo em várias linhas da tabela de pedidos, causando desperdício de espaço e risco de inconsistências.
2.	Dependências parciais e transitivas: O modelo misturava dados de cliente, produto, fornecedor e pedido em uma única estrutura, dificultando a manutenção e a compreensão.
3.	Falta de integridade referencial: Não havia controle adequado entre os relacionamentos das entidades. Por exemplo, não se garantia que o produto informado no pedido existisse previamente.
Além disso, tentamos inicialmente criar as tabelas fora de ordem, o que causava erros de dependência por causa das chaves estrangeiras. Esse problema foi resolvido reordenando a criação das tabelas e utilizando DROP TABLE IF EXISTS ... CASCADE para limpar o banco.
Scripts SQL de Criação e Inserção
-- Apagando tabelas antigas
DROP TABLE IF EXISTS
    item_pedido,
    pedido,
    endereco,
    telefone,
    produto,
    fornecedor,
    cliente
CASCADE;

-- Criando as tabelas
CREATE TABLE fornecedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    fornecedor_id INT,
    CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    rua VARCHAR(100),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE telefone (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(15),
    tipo VARCHAR(20),
    cliente_id INT,
    fornecedor_id INT,
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_telefone_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    endereco_entrega_id INT,
    data_pedido DATE,
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_pedido_endereco FOREIGN KEY (endereco_entrega_id) REFERENCES endereco(id)
);

CREATE TABLE item_pedido (
    id SERIAL PRIMARY KEY,
    pedido_id INT,
    produto_id INT,
    quantidade INT,
    valor_unitario DECIMAL(10,2),
    CONSTRAINT fk_item_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    CONSTRAINT fk_item_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);

-- Inserindo dados
INSERT INTO fornecedor (nome) VALUES ('Fornecedor A'), ('Fornecedor B');

INSERT INTO produto (nome, fornecedor_id)
VALUES ('Teclado', 1), ('Mouse', 2), ('Monitor', 1);

INSERT INTO cliente (nome) VALUES ('Ana Silva'), ('Bruno Costa');

INSERT INTO endereco (cliente_id, rua, cidade, estado)
VALUES (1, 'Rua A, 123', 'Campinas', 'SP'),
       (2, 'Rua B, 456', 'Campinas', 'SP');

INSERT INTO telefone (numero, tipo, cliente_id)
VALUES ('9999-0000', 'residencial', 1),
       ('8888-1111', 'residencial', 2);

INSERT INTO telefone (numero, tipo, fornecedor_id)
VALUES ('1111-2222', 'comercial', 1),
       ('3333-4444', 'comercial', 2);

INSERT INTO pedido (cliente_id, endereco_entrega_id, data_pedido)
VALUES (1, 1, CURRENT_DATE), (2, 2, CURRENT_DATE);

INSERT INTO item_pedido (pedido_id, produto_id, quantidade, valor_unitario)
VALUES (1, 1, 2, 150.00),
       (1, 2, 1, 80.00),
       (2, 3, 1, 700.00);
Como o Novo Modelo Resolve as Violações de Normalização
O novo modelo foi projetado com base nos princípios da normalização (até a 3ª Forma Normal):
•	1FN: Nenhuma tabela possui grupos repetitivos. Cada campo é atômico.
•	2FN: Todos os atributos não-chave são dependentes da chave primária inteira. Por exemplo, os dados de produto não estão misturados com os dados do pedido.
•	3FN: Não existem dependências transitivas. Por exemplo, o nome do cliente é armazenado apenas na tabela cliente, e não dentro de pedido ou item_pedido.
Além disso, foram criadas as chaves estrangeiras (FOREIGN KEY) para garantir a integridade entre as tabelas, e os dados foram divididos logicamente entre entidades distintas como cliente, produto, fornecedor, endereco, telefone, pedido e item_pedido.
Prints do DER
Os prints do DER estão anexados como recomendação visual para facilitar o entendimento da estrutura relacional.
