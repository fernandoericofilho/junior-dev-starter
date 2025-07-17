Relatório de Análise e Correção do Modelo de Banco de Dados

Introdução

Este relatório apresenta a análise e correção do modelo de banco de dados desenvolvido anteriormente. Após a devolutiva, foram identificadas oportunidades de melhoria e implementadas mudanças para garantir a integridade referencial, normalização e boas práticas de banco de dados.

Pontos Positivos do Modelo Anterior

- Identificação correta das formas normais (1FN, 2FN, 3FN)
- Scripts bem organizados com DROP e criação limpa das tabelas
- Boas práticas de integridade referencial usando chaves estrangeiras
- Inserção de dados consistente, demonstrando entendimento prático

Sugestões de Melhoria e Correções

- Separação de telefone do cliente e do fornecedor em tabelas associativas (cliente_telefone e fornecedor_telefone) para permitir múltiplos telefones por entidade
- Inclusão de comentários nos scripts para facilitar a manutenção
- Criação de tabela produto_preco para armazenar histórico de preços de produtos
- Registro do preço de venda na tabela de itens do pedido para preservação do histórico

Modelo Corrigido

O modelo corrigido inclui as seguintes mudanças:

- Tabelas associativas para telefones (cliente_telefone e fornecedor_telefone)
- Tabela produto_preco para armazenar histórico de preços de produtos
- Chaves estrangeiras explícitas para garantir integridade referencial
- Endereço desmembrado em campos específicos (logradouro, número, CEP, cidade, etc.)

DROP TABLE IF EXISTS 
    item_pedido,
    pedido,
    cliente_telefone,
    fornecedor_telefone,
    telefone,
    endereco,
    produto_preco,
    produto,
    fornecedor,
    cliente
CASCADE;

-- FORNECEDOR
CREATE TABLE fornecedor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);

-- PRODUTO
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    fornecedor_id INT,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

-- HISTÓRICO DE PREÇOS
CREATE TABLE produto_preco (
    id SERIAL PRIMARY KEY,
    produto_id INT,
    preco DECIMAL(10,2),
    data_cadastro DATE DEFAULT CURRENT_DATE,
    data_validade DATE,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

-- CLIENTE
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);

-- ENDEREÇO
CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    cep VARCHAR(10),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- TELEFONE
CREATE TABLE telefone (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(15),
    tipo VARCHAR(20)
);

-- RELAÇÃO: cliente - telefone
CREATE TABLE cliente_telefone (
    cliente_id INT,
    telefone_id INT,
    PRIMARY KEY (cliente_id, telefone_id),
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (telefone_id) REFERENCES telefone(id)
);

-- RELAÇÃO: fornecedor - telefone
CREATE TABLE fornecedor_telefone (
    fornecedor_id INT,
    telefone_id INT,
    PRIMARY KEY (fornecedor_id, telefone_id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id),
    FOREIGN KEY (telefone_id) REFERENCES telefone(id)
);

-- PEDIDO
CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    cliente_id INT,
    endereco_entrega_id INT,
    data_pedido DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (endereco_entrega_id) REFERENCES endereco(id)
);

-- ITEM DO PEDIDO
CREATE TABLE item_pedido (
    id SERIAL PRIMARY KEY,
    pedido_id INT,
    produto_id INT,
    quantidade INT,
    valor_unitario DECIMAL(10,2), -- preserva o preço histórico
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);


Consequências e Impactos

- Melhor integridade referencial com uso explícito de FOREIGN KEY
- Maior normalização com tabelas associativas
- Histórico de preços mantido com a tabela produto_preco
- Risco: possível impacto em scripts de inserção antigos que usavam estrutura anterior

Métricas de Sucesso

- Verificar a criação correta das tabelas com FOREIGN KEY visíveis no DER
- Executar scripts de inserção e validar integridade entre registros relacionados
- Verificar se o modelo suporta múltiplos telefones por cliente e fornecedor
- Conferir se o histórico de preços é mantido independentemente de alterações futuras

Cenários de Teste

1. Rodar DROP TABLE IF EXISTS e em seguida o novo script SQL completo
2. Visualizar o DER para confirmar as conexões entre tabelas
3. Inserir registros nas tabelas cliente, telefone, cliente_telefone, produto, produto_preco
4. Verificar se os dados se relacionam corretamente (sem erros de integridade referencial)
5. Tentar inserir dados inconsistentes e confirmar que o banco rejeita

Evidências

- DER atualizado com relacionamentos visíveis
- Captura de tela do código SQL executado no DBeaver
- Prints do DBeaver com tabelas e chaves corretamente criadas