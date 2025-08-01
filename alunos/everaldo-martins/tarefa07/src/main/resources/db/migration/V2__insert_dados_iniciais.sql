-- Inserindo clientes
INSERT INTO cliente (id, nome, email) VALUES
  (1, 'Ana Paula', 'ana.paula@example.com'),
  (2, 'Carlos Silva', 'carlos.silva@example.com');

-- Inserindo endereços
INSERT INTO endereco (id, logradouro, cidade, estado, cep, cliente_id) VALUES
  (1, 'Rua das Flores', 'São Paulo', 'SP', '01001-000', 1),
  (2, 'Avenida Brasil', 'Rio de Janeiro', 'RJ', '20040-001', 2);

-- Inserindo telefones
INSERT INTO telefone (id, numero, tipo, cliente_id) VALUES
  (1, '(11) 91234-5678', 'CELULAR', 1),
  (2, '(21) 3234-5678', 'FIXO', 2),
  (3, '(11) 93333-4444', 'CELULAR', 1);