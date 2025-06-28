# 📘 Tarefa 02 – Instalação de Banco de Dados, Modelagem e Normalização Prática

---

## 🎯 Objetivo

Nesta etapa, vamos aprofundar o entendimento sobre bancos de dados relacionais, focando na instalação prática, criação de tabelas e identificação de problemas comuns de modelagem que violam as 1ª, 2ª e 3ª formas normais (1FN, 2FN, 3FN). Você também vai aprender a usar o DBeaver para visualizar os dados e entender a modelagem através de um Diagrama Entidade-Relacionamento (DER).

---

## 1. Instalação do Banco de Dados

Recomendamos instalar o **PostgreSQL** (ou outro SGBD relacional de sua preferência).

- Link para download e instalação do PostgreSQL:  
  https://www.postgresql.org/download/

- Instalação do DBeaver para visualização e gerenciamento do banco:  
  https://dbeaver.io/download/

> **Dica:** O DBeaver é uma ferramenta gratuita, fácil de usar, e permite conectar a diversos bancos relacionais para explorar tabelas, dados e diagramas.

---

## 2. Criação de um banco e tabelas com erros de normalização

### Script para criar banco e tabelas com falhas (violação das 1FN, 2FN e 3FN):

```sql
-- Criação do banco de dados
CREATE DATABASE loja;

-- Use o banco criado
\c loja;

-- Tabela com problemas nas formas normais
CREATE TABLE pedidos (
  pedido_id SERIAL PRIMARY KEY,
  cliente_nome VARCHAR(100),
  cliente_telefone VARCHAR(20),
  produto_nome VARCHAR(100),
  produto_preco NUMERIC(10,2),
  quantidade INT,
  fornecedor_nome VARCHAR(100),
  fornecedor_telefone VARCHAR(20),
  endereco_entrega VARCHAR(200)
);

-- Inserindo dados
INSERT INTO pedidos (cliente_nome, cliente_telefone, produto_nome, produto_preco, quantidade, fornecedor_nome, fornecedor_telefone, endereco_entrega) VALUES
('Ana Silva', '9999-0000', 'Teclado', 150.00, 2, 'Fornecedor A', '1111-2222', 'Rua A, 123'),
('Ana Silva', '9999-0000', 'Mouse', 80.00, 1, 'Fornecedor B', '3333-4444', 'Rua A, 123'),
('Bruno Costa', '8888-1111', 'Monitor', 700.00, 1, 'Fornecedor A', '1111-2222', 'Rua B, 456');
```

---

## 3. Análise dos problemas no modelo acima

Observe atentamente a tabela `pedidos` criada e os dados inseridos.

- Identifique e descreva os problemas de modelagem que violam as formas normais:
    - Violação da 1ª Forma Normal (1FN)
    - Violação da 2ª Forma Normal (2FN)
    - Violação da 3ª Forma Normal (3FN)

---

## 4. Exercício prático

Com base nos problemas identificados:

- Reestruture o modelo criando novas tabelas que eliminem as repetições, dependências parciais e transitivas.
- Utilize chaves primárias e estrangeiras para garantir a integridade referencial.
- Garanta que as tabelas estejam normalizadas até a 3ª Forma Normal (3FN).

---

## 5. Scripts a serem criados

- Crie scripts SQL para:
    - Criação das tabelas corrigidas.
    - Inserção dos dados correspondentes.

---

## 6. Visualização e Modelagem

- Instale o DBeaver (se ainda não instalou).
- Conecte ao banco PostgreSQL criado.
- Importe suas tabelas e dados.
- Gere o Diagrama Entidade-Relacionamento (DER) para visualizar a modelagem final.

---

## 7. Entregas

No arquivo `tarefa-02.md`, inclua:

- A análise dos problemas do modelo inicial.
- Os scripts SQL de criação e inserção das tabelas corrigidas.
- Um breve texto explicando como seu novo modelo resolve as violações de normalização.
- Print(s) do DER gerado no DBeaver (opcional, mas recomendado).

---

**Bons estudos!**  
Se precisar de ajuda, estarei aqui para revisar ou tirar dúvidas.

