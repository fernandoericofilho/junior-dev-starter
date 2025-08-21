-- Inserindo clientes
INSERT INTO cliente (nome, email) VALUES
  ('Ana Paula', 'ana.paula@example.com'),
  ('Carlos Silva', 'carlos.silva@example.com'),
  ('Mariana Costa', 'mariana.costa@example.com'),
  ('João Pereira', 'joao.pereira@example.com'),
  ('Fernanda Almeida', 'fernanda.almeida@example.com');

-- Inserindo endereços
INSERT INTO endereco (logradouro, cidade, estado, cep, cliente_id) VALUES
  ('Rua das Flores', 'São Paulo', 'SP', '01001-000', 1),
  ('Avenida Brasil', 'Rio de Janeiro', 'RJ', '20040-001', 2),
  ('Rua dos Ipês', 'Belo Horizonte', 'MG', '30110-012', 3),
  ('Avenida das Nações', 'Curitiba', 'PR', '80010-050', 4),
  ('Praça Central', 'Porto Alegre', 'RS', '90020-030', 5);

-- Inserindo telefones
INSERT INTO telefone (numero, tipo, cliente_id) VALUES
  ('(11) 91234-5678', 'CELULAR', 1),
  ('(21) 3234-5678', 'FIXO', 2),
  ('(11) 93333-4444', 'CELULAR', 1),
  ('(31) 98888-7777', 'CELULAR', 3),
  ('(41) 4002-8922', 'FIXO', 4),
  ('(51) 97777-8888', 'CELULAR', 5);
