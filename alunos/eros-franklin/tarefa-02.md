# Violação das formas normais

## 1ª Forma Normal (1FN)

A primeira norma exige que existe atomicidade dos dados, ou seja, sem valores repetidos ou compostos em um único campo.

No modelo criado não há essa violação explicitamente, no entanto, se um cliente comprasse dois produtos no mesmo pedido acabaria violando esta primeira norma.

## 2ª Forma Normal (2FN)

Nessa segunda norma diz que todos os atributos não-chave devem depender da chave primária inteira.

No modelo, os campos - cliente_nome, cliente_telefone, fornecedor_nome, fornecedor_telefone, endereco_entrega dependem apenas de partes do pedido_id e não variam de forma independente dentro da tabela.

## 3ª Forma Normal (3FN)

Por último, a terceira norma exige que não pode haver dependências transitivas.

No modelo, o campo cliente_telefone depende de cliente_nome, e fornecedor_telefone depende de fornecedor_nome.

## Resolução

Então para resolucionar esse problema, criei as tabelas:

clientes (cliente_id, nome, telefone)
fornecedores (fornecedor_id, nome, telefone)
produtos (produto_id, nome, preco, fornecedor_id)
pedidos (pedido_id, cliente_id, endereco_entrega)
itens_pedido (pedido_id, produto_id, quantidade)

Sript da criação: 

DROP TABLE pedidos;

CREATE TABLE clientes (
	cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE fornecedores (
	fornecedor_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE produtos(
	produto_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco NUMERIC(10,2),
    fornecedor_id INT,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedores(fornecedor_id)
);

CREATE TABLE pedidos(
	pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    endereco_entrega VARCHAR(200),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

CREATE TABLE itens_pedido (
  pedido_id INT,
  produto_id INT,
  quantidade INT,
  PRIMARY KEY (pedido_id, produto_id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id),
  FOREIGN KEY (produto_id) REFERENCES produtos(produto_id)
);

Em seguida inserir os dados as tabelas de maneira reorganizada

INSERT INTO clientes (nome, telefone) values ('Ana Silva', '9999-0000'),
('Bruno Costa','8888-1111');

INSERT INTO fornecedores (nome, telefone) values
('Fornecedor A', '1111-2222'),
('Fornecedor B', '3333-4444');

INSERT INTO produtos (nome, preco, fornecedor_id) values
('Teclado', 150.00, 1),
('Mouse', 80.00, 2),
('Monitor', 700.00, 1);

INSERT INTO pedidos (cliente_id, endereco_entrega) values
(1, 'Rua A, 123'),
(2, 'Rua B, 456');

INSERT INTO itens_pedido (pedido_id, produto_id, quantidade) values
(1, 1, 2),  
(1, 2, 1),  
(2, 3, 1);


Com essa nova reorganização os dados são seprados por entidades de maneira organizada, eliminando as repetições e dependências transitivas que existe no modelo anterior, além de está em conformidade com as formas normais e sendo mais fácil o consulta e expansão.