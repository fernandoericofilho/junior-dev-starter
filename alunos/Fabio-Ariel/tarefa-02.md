# 📦 Normalização de Banco de Dados: Correção até a 3ª Forma Normal

## ✅ 1. Análise dos Problemas no Modelo Inicial

### 🔴 Violação da 1ª Forma Normal (1FN)

**Definição:** Os atributos devem conter valores atômicos (indivisíveis).

**Problema:**  
Embora não haja campos explicitamente multivalorados, o modelo inicial armazena múltiplas entidades (cliente, produto, fornecedor) em uma única tabela. Isso fere o princípio de atomicidade e dificulta a organização e integridade dos dados.

---

### 🔴 Violação da 2ª Forma Normal (2FN)

**Definição:** Não deve haver dependência parcial de uma chave composta.

**Problema:**  
Mesmo utilizando uma chave primária simples (`pedido_id`), há mistura de atributos de diferentes entidades, o que implica em dependências parciais implícitas. Por exemplo, dados de cliente e fornecedor não estão relacionados diretamente ao pedido.

---

### 🔴 Violação da 3ª Forma Normal (3FN)

**Definição:** Todos os atributos não-chave devem depender somente da chave primária.

**Problemas Identificados:**
- `cliente_telefone` depende de `cliente_nome`, e não de `pedido_id`.
- `produto_preco` depende de `produto_nome`, e não do pedido.
- `fornecedor_telefone` depende de `fornecedor_nome`.

---

## 🛠️ 2. Scripts SQL – Modelo Corrigido

```sql
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

```
✅ 3. Explicação sobre a Correção
O novo modelo relacional resolve todas as violações de normalização identificadas anteriormente:

1FN (Forma Normal 1): Os dados são atômicos e cada coluna contém apenas um valor por registro.

2FN (Forma Normal 2): As tabelas utilizam chaves primárias simples e os atributos são dependentes totalmente da chave.

3FN (Forma Normal 3): Todos os atributos não-chave dependem somente da chave primária da tabela, eliminando dependências transitivas.

🖼️ 4. Modelo DER
![image](https://github.com/user-attachments/assets/49325cc2-d337-4fab-b8b6-3b3f1b624203)
