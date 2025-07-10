# EVERALDO MARTINS

## Tarefa 02 – Instalação de Banco de Dados, Modelagem e Normalização Prática

## Análise dos problemas do modelo inicial

A tabela `pedidos` apresenta vários problemas de modelagem que violam as formas normais (**1FN**, **2FN** e **3FN**). Listando cada violação identificada:

1. **Violação da 1ª Forma Normal (1FN)**

A **1FN** exige que:

- Todos os atributos sejam atômicos (não divisíveis).
- Não haja grupos repetidos ou listas em uma única coluna.

**Problemas identificados**:

- A tabela `pedidos` armazena informações de `clientes`, `produtos` e `fornecedores` em uma única tabela, gerando repetição de dados.

2. **Violação da 2ª Forma Normal (2FN)**

A **2FN** exige que:

- A tabela esteja na 1FN.
- Todos os atributos não-chave dependam completamente da chave primária.

**Problemas identificados**:

- A chave primária é `pedido_id`, que identifica exclusivamente cada pedido.
- Atributos como `cliente_nome`, `cliente_telefone`, `fornecedor_nome` e `fornecedor_telefone` dependem de entidades distintas (clientes e fornecedores), não diretamente do `pedido_id`. Por exemplo:

    - `cliente_nome` e `cliente_telefone` dependem do cliente, não do pedido.
    - `fornecedor_nome` e `fornecedor_telefone` dependem do fornecedor, não do pedido.
    
- Isso cria dependências parciais, violando a **2FN**. Esses atributos deveriam estar em tabelas separadas (`clientes` e `fornecedores`).

3. **Violação da 3ª Forma Normal (3FN)**

A **3FN** exige que:

- A tabela esteja na 2FN.
- Não haja dependências transitivas, ou seja, atributos não-chave não devem depender de outros atributos não-chave.

**Problemas identificados**:

- Há uma dependência transitiva:
    - `produto_preco` depende de `produto_nome`, que não é a chave primária. O preço do produto é uma característica do produto, não do pedido especificamente.
    - `endereco_entrega` está relacionado ao cliente, por exemplo (Ana Silva tem o mesmo endereço em dois pedidos), mas está sendo armazenado redundantemente na tabela pedidos e se repete em cada pedido do mesmo `cliente`, o que é uma dependência transitiva.

- Isso causa redundância de dados e potenciais anomalias,  (Por exemplo caso o preço de um produto mude, será necessário atualizar várias linhas).

## Resolução dos problemas do modelo inicial

Para resolver as violações do modelo inicial, foram criadas tabelas separadas para cada entidade, normalizadas até a **3FN**, com as seguintes correções estruturais:

1. **Separação de tabelas multivaloradas** (endereços e telefones)

2. **Especificação de relacionamentos** através de chaves estrangeiras

3. **Adição de constraints** para garantir integridade dos dados.


**Lista de Tabelas**:

- **clientes**: Armazena informações básicas dos clientes (sem dados multivalorados)

- **fornecedores**: Armazena informações básicas dos fornecedores (sem dados multivalorados)

- **clientes_enderecos**: Armazena exclusivamente endereços dos clientes (separado da tabela original)

- **fornecedores_enderecos**: Armazena exclusivamente endereços dos fornecedores (separado da tabela original)

- **clientes_telefones**: Armazena exclusivamente telefones dos clientes (separado da tabela original)

- **fornecedores_telefones**: Armazena exclusivamente telefones dos fornecedores (separado da tabela original)

- **produtos**: Armazena informações completas dos produtos, incluindo relacionamento com fornecedores

- **pedidos**: Armazena informações básicas do pedido com relacionamentos para cliente e endereço de entrega

- **itens_pedido**: Relaciona pedidos a produtos com histórico de preços e quantidades

**Melhorias implementadas**

1. **Separação clara** entre tabelas de clientes e fornecedores

2. **Eliminação de ambiguidade** nos relacionamentos

3. **Especificação precisa** dos tipos de endereços e telefones

4. **Adição de constraints** para validar dados (CEP, telefone, UF)

5. **Histórico de preços** nos itens de pedido

6. **Controle de status** nos pedidos

**Estrutura SQL das tabelas**

```sql
-- Criação do banco de dados
CREATE DATABASE loja;

-- Use o banco criado
\c loja;

-- Tabela clientes
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN DEFAULT TRUE
);

-- Tabela fornecedores
CREATE TABLE fornecedores (
    fornecedor_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN DEFAULT TRUE
);

-- Tabela de endereços dos clientes
CREATE TABLE clientes_enderecos (
    endereco_id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(cliente_id) ON DELETE CASCADE,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL CHECK (estado IN ('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO')),
    cep CHAR(8) NOT NULL CHECK (cep ~ '^[0-9]{8}$'),
    tipo_endereco VARCHAR(30) NOT NULL CHECK (tipo_endereco IN ('residencial', 'comercial', 'entrega', 'outro'))
);

-- Tabela de endereços dos fornecedores
CREATE TABLE fornecedores_enderecos (
    endereco_id SERIAL PRIMARY KEY,
    fornecedor_id INT REFERENCES fornecedores(fornecedor_id) ON DELETE CASCADE,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL CHECK (estado IN ('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO')),
    cep CHAR(8) NOT NULL CHECK (cep ~ '^[0-9]{8}$'),
    tipo_endereco VARCHAR(30) NOT NULL CHECK (tipo_endereco IN ('matriz', 'filial', 'entrega', 'outro'))
);

-- Tabela de telefones dos clientes
CREATE TABLE clientes_telefones (
    telefone_id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(cliente_id) ON DELETE CASCADE,
    numero VARCHAR(15) NOT NULL CHECK (numero ~ '^[0-9]{10,11}$'),
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN ('celular', 'fixo', 'whatsapp', 'comercial')),
    principal BOOLEAN DEFAULT FALSE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de telefones dos fornecedores
CREATE TABLE fornecedores_telefones (
    telefone_id SERIAL PRIMARY KEY,
    fornecedor_id INT REFERENCES fornecedores(fornecedor_id) ON DELETE CASCADE,
    numero VARCHAR(15) NOT NULL CHECK (numero ~ '^[0-9]{10,11}$'),
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN ('celular', 'fixo', 'whatsapp', 'comercial')),
    ramal VARCHAR(10),
    principal BOOLEAN DEFAULT FALSE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de produtos
CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    codigo_barra VARCHAR(13) UNIQUE,
    descricao TEXT,
    preco_compra NUMERIC(10,2) CHECK (preco_compra >= 0),
    preco_venda NUMERIC(10,2) NOT NULL CHECK (preco_venda > 0),
    fornecedor_id INT REFERENCES fornecedores(fornecedor_id) ON DELETE SET NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_validade DATE,
    ativo BOOLEAN DEFAULT TRUE
);

-- Tabela pedidos
CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL REFERENCES clientes(cliente_id) ON DELETE RESTRICT,
    endereco_entrega_id INT REFERENCES clientes_enderecos(endereco_id) ON DELETE SET NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_entrega TIMESTAMP,
    status VARCHAR(30) DEFAULT 'pendente' CHECK (status IN ('pendente', 'processando', 'enviado', 'entregue', 'cancelado'))
);

-- Tabela itens dos pedidos
CREATE TABLE itens_pedido (
    item_id SERIAL PRIMARY KEY,
    pedido_id INT NOT NULL REFERENCES pedidos(pedido_id) ON DELETE CASCADE,
    produto_id INT NOT NULL REFERENCES produtos(produto_id) ON DELETE RESTRICT,
    quantidade INT NOT NULL CHECK (quantidade > 0),
    preco_custo NUMERIC(10,2) CHECK (preco_custo >= 0),
    preco_venda NUMERIC(10,2) NOT NULL CHECK (preco_venda > 0),
    desconto NUMERIC(10,2) DEFAULT 0 CHECK (desconto >= 0),
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (pedido_id, produto_id)
);

-- View exemplo que calcula automaticamente o valor total de cada pedido
CREATE OR REPLACE VIEW pedidos_com_valor_total AS
SELECT 
    p.pedido_id,
    p.cliente_id,
    p.endereco_entrega_id,
    p.data_pedido,
    p.data_entrega,
    p.status,
    COALESCE(SUM(ip.quantidade * (ip.preco_venda - ip.desconto)), 0) AS valor_total
FROM pedidos p
LEFT JOIN itens_pedido ip ON ip.pedido_id = p.pedido_id
GROUP BY p.pedido_id;
```

**Inseções exemplos nas tabelas**

```sql
-- Inserir clientes
INSERT INTO clientes (nome) VALUES
('João Silva'),
('Maria Oliveira'),
('Carlos Souza'),
('Ana Santos');

-- Inserir fornecedores
INSERT INTO fornecedores (nome) VALUES
('TechFornecedor Ltda'),
('EletroDistribuidora SA'),
('Componentes & Cia');

-- Inserir endereços de clientes
INSERT INTO clientes_enderecos (cliente_id, logradouro, numero, complemento, bairro, cidade, estado, cep, tipo_endereco) VALUES
(1, 'Rua das Flores', '123', 'Apto 101', 'Centro', 'São Paulo', 'SP', '01001000', 'residencial'),
(1, 'Avenida Paulista', '1000', '', 'Bela Vista', 'São Paulo', 'SP', '01310000', 'comercial'),
(2, 'Rua das Palmeiras', '45', '', 'Jardins', 'Rio de Janeiro', 'RJ', '22460000', 'residencial'),
(3, 'Avenida Brasil', '2000', 'Sala 305', 'Centro', 'Belo Horizonte', 'MG', '30140000', 'comercial'),
(4, 'Rua dos Pinheiros', '789', '', 'Pinheiros', 'São Paulo', 'SP', '05422000', 'residencial');

-- Inserir endereços de fornecedores
INSERT INTO fornecedores_enderecos (fornecedor_id, logradouro, numero, complemento, bairro, cidade, estado, cep, tipo_endereco) VALUES
(1, 'Rua da Tecnologia', '500', 'Bloco B', 'Industrial', 'Campinas', 'SP', '13035000', 'matriz'),
(2, 'Avenida das Máquinas', '2500', '', 'Centro', 'São Paulo', 'SP', '01005000', 'filial'),
(3, 'Rua dos Componentes', '33', 'Galpão 5', 'Industrial', 'Curitiba', 'PR', '81200000', 'matriz');

-- Inserir telefones de clientes
INSERT INTO clientes_telefones (cliente_id, numero, tipo, principal) VALUES
(1, '11999999999', 'celular', TRUE),
(1, '1133333333', 'fixo', FALSE),
(2, '21988888888', 'celular', TRUE),
(3, '31977777777', 'celular', TRUE),
(4, '11966666666', 'celular', TRUE);

-- Inserir telefones de fornecedores
INSERT INTO fornecedores_telefones (fornecedor_id, numero, tipo, ramal, principal) VALUES
(1, '1933334444', 'fixo', '202', TRUE),
(1, '1999998888', 'comercial', NULL, FALSE),
(2, '1133332222', 'fixo', NULL, TRUE),
(3, '4133335555', 'fixo', '101', TRUE);

-- Inserir produtos
INSERT INTO produtos (nome, codigo_barra, descricao, preco_compra, preco_venda, fornecedor_id, data_validade) VALUES
('Notebook Elite', '7891234567890', 'Notebook 15" i7 16GB RAM', 2500.00, 3999.99, 1, NULL),
('Mouse Sem Fio', '7899876543210', 'Mouse óptico 1600DPI', 45.00, 89.90, 2, NULL),
('Teclado Mecânico', '7894561237890', 'Teclado RGB switches azuis', 120.00, 249.90, 1, NULL),
('Monitor 24"', '7893216549870', 'Monitor Full HD IPS', 600.00, 999.00, 3, NULL),
('Webcam HD', '7896549873210', 'Webcam 1080p com microfone', 80.00, 149.90, 2, NULL);

-- Inserir pedidos
INSERT INTO pedidos (cliente_id, endereco_entrega_id, data_pedido, status) VALUES
(1, 1, '2023-05-10 09:15:00', 'entregue'),
(2, 3, '2023-05-12 14:30:00', 'enviado'),
(3, 4, '2023-05-15 11:00:00', 'processando'),
(1, 2, '2023-05-18 16:45:00', 'pendente');

-- Inserir itens de pedido
INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, preco_custo, preco_venda, desconto) VALUES
(1, 1, 1, 2500.00, 3999.99, 0),
(1, 3, 1, 120.00, 249.90, 10.00),
(2, 2, 2, 45.00, 89.90, 0),
(2, 5, 1, 80.00, 149.90, 5.00),
(3, 4, 1, 600.00, 999.00, 0),
(4, 1, 1, 2500.00, 3999.99, 200.00),
(4, 2, 1, 45.00, 89.90, 0);
```
### Explicação da resolução das violações

As violações das formas normais foram corrigidas por meio da normalização até a **3FN**, da seguinte forma:

- **1ª Forma Normal (1FN)**: 
  - Todos os atributos foram tornados atômicos.
  - A tabela `pedidos` que armazenava informações de cliente, produto e fornecedor em uma única tabela, foi separada.
  - Informações compostas ou repetidas, como cliente com múltiplos telefones ou endereços, foram movidas para tabelas separadas (`clientes_telefones`, `clientes_enderecos`).  - A tabela `pedidos` que armazenava informações de cliente, produto e fornecedor em uma única tabela, foi separada.

- **2ª Forma Normal (2FN)**: 
  - Atributos que não dependiam diretamente da chave primária `pedido_id`, como dados de cliente e fornecedor, foram movidos para tabelas específicas (`clientes`, `fornecedores`), eliminando dependências parciais.

- **3ª Forma Normal (3FN)**: 
  - Eliminaram-se dependências transitivas, como `produto_preco` dependendo de `produto_nome`, com a criação da tabela `produtos`.
  - O campo `endereco_entrega` foi referenciado através de chave estrangeira na tabela `clientes_enderecos`, evitando duplicidade de dados e mantendo a flexibilidade.