CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE endereco (
    id BIGSERIAL PRIMARY KEY,
    logradouro VARCHAR(200),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(10),
    cliente_id BIGINT UNIQUE,
    CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE telefone (
    id BIGSERIAL PRIMARY KEY,
    numero VARCHAR(20),
    tipo VARCHAR(20),
    cliente_id BIGINT,
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);