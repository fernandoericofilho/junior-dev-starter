# __Violação das Formas Normais__

### __1ª Forma Normal__

Para uma tabela estar na 1FN precisa ter valores atômicos (não divisíveis), o que não é o caso da tabela 'pedidos', pois, o atributo 'endereco_entrega' é um atributo composto
e pode ser desmembrado em mais de uma informação. Já o atributo 'cliente_telefone' e 'fornecedor_telefone', embora não sejam multivalorados, há a possibilidade de se tornarem, a partir do momento em que o cliente ou fornecedor informe mais de um número de telefone.

### __2ª Forma Normal__

A tabela 'pedidos' não pode estar na 2FN, pois ela precisa estar na 1FN e que atributos não chave dependam da chave primária completa (no caso de chaves primárias compostas).

### __3ª Forma Normal__

Na 3FN, além de obedecer à 1FN e a 2FN, não pode haver atributos não-chave que dependam de outro atributo não-chave, ou seja, dependência transitiva, como vemos na tabela 'pedidos' que o atributo 'produto_preco' depende do atributo 'produto_nome'.


## __Correção da tabela 'pedidos'__

Script SQL usado para criar tabelas corrigidas:

-- CREATE TABLE `cliente` (
`id_cliente` int NOT NULL AUTO_INCREMENT,
`nome_cliente` varchar(150) NOT NULL,
PRIMARY KEY (`id_cliente`)
);

--CREATE TABLE `telefone_cliente` (
`id_cliente` int NOT NULL AUTO_INCREMENT,
`num_telefone` varchar(15) NOT NULL,
KEY `telefone_cliente_cliente_FK` (`id_cliente`),
CONSTRAINT `telefone_cliente_cliente_FK` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
);

--CREATE TABLE `endereco_entrega` (
`endereco_id` int NOT NULL AUTO_INCREMENT,
`id_cliente` int NOT NULL,
`logradouro` varchar(200) NOT NULL,
`numero` int NOT NULL,
PRIMARY KEY (`endereco_id`),
KEY `endereco_entrega_cliente_FK` (`id_cliente`),
CONSTRAINT `endereco_entrega_cliente_FK` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
);

--CREATE TABLE `fornecedores` (
`id_fornecedor` int NOT NULL AUTO_INCREMENT,
`nome_fornecedor` varchar(100) DEFAULT NULL,
PRIMARY KEY (`id_fornecedor`)
);

--CREATE TABLE `telefone_fornecedor` (
`id_fornecedor` int NOT NULL,
`num_telefone` varchar(150) NOT NULL,
KEY `telefone_fornecedor_fornecedores_FK` (`id_fornecedor`),
CONSTRAINT `telefone_fornecedor_fornecedores_FK` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedores` (`id_fornecedor`)
);

CREATE TABLE `produtos` (
`id_produto` int NOT NULL AUTO_INCREMENT,
`nome_produto` varchar(100) NOT NULL,
`preco_produto` decimal(10,2) NOT NULL,
`id_fornecedor` int NOT NULL,
PRIMARY KEY (`id_produto`),
KEY `produtos_fornecedores_FK` (`id_fornecedor`),
CONSTRAINT `produtos_fornecedores_FK` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedores` (`id_fornecedor`)
);

--CREATE TABLE `pedidos` (
`pedido_id` int NOT NULL AUTO_INCREMENT,
`id_cliente` int NOT NULL,
`endereco_id` int NOT NULL,
PRIMARY KEY (`pedido_id`),
KEY `pedidos_cliente_FK` (`id_cliente`),
KEY `pedidos_endereco_entrega_FK` (`endereco_id`),
CONSTRAINT `pedidos_cliente_FK` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
CONSTRAINT `pedidos_endereco_entrega_FK` FOREIGN KEY (`endereco_id`) REFERENCES `endereco_entrega` (`endereco_id`)
);

--CREATE TABLE `itens_pedido` (
`itens_id` int NOT NULL AUTO_INCREMENT,
`id_pedido` int NOT NULL,
`id_produto` int NOT NULL,
`quantidade` int NOT NULL,
PRIMARY KEY (`itens_id`),
KEY `itens_pedido_pedidos_FK` (`id_pedido`),
KEY `itens_pedido_produtos_FK` (`id_produto`),
CONSTRAINT `itens_pedido_pedidos_FK` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`pedido_id`),
CONSTRAINT `itens_pedido_produtos_FK` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id_produto`)
);

Estas novas tabelas corrigem os problemas que a tabela pedidos tinha inicialmente, pois separa os atributos em suas respectivas tabelas, cada uma com sua chave primária e os atributos não-chave dependendo do atributo chave de sua tabela.
Dessa forma também é possível criar os relacionamentos entre as tabelas através da chave estrangeira.

