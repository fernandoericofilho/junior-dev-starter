-- Inserindo clientes
INSERT INTO cliente (nome, email) VALUES
('Ana Paula', 'ana.paula@example.com'),
('Carlos Silva', 'carlos.silva@example.com');

-- Inserindo endereços
INSERT INTO endereco (logradouro, cidade, estado, cep, cliente_id) VALUES
('Rua das Flores', 'São Paulo', 'SP', '01001-000', 1),
('Avenida Brasil', 'Rio de Janeiro', 'RJ', '20040-001', 2);

-- Inserindo telefones
INSERT INTO telefone (numero, tipo, cliente_id) VALUES
('(11) 91234-5678', 'CELULAR', 1),
('(21) 3234-5678', 'FIXO', 2),
('(11) 93333-4444', 'CELULAR', 1);