CREATE TABLE clientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE enderecos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(200),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(10),
    cliente_id BIGINT UNIQUE,
    CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE telefones (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(20),
    tipo VARCHAR(20),
    cliente_id BIGINT,
    CONSTRAINT fk_telefone_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);