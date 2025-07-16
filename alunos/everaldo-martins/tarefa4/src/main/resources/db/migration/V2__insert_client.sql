-- Script de migração para inserir dados iniciais na tabela clients
INSERT INTO clients (id, name, email) VALUES
    (RANDOM_UUID(), 'João Silva', 'joao.silva@example.com'),
    (RANDOM_UUID(), 'Maria Souza', 'maria.souza@example.com'),
    (RANDOM_UUID(), 'Carlos Oliveira', 'carlos.oliveira@example.com'),
    (RANDOM_UUID(), 'Ana Santos', 'ana.santos@example.com'),
    (RANDOM_UUID(), 'Pedro Costa', 'pedro.costa@example.com');