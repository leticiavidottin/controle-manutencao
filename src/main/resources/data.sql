INSERT INTO cliente (nome, cpf, endereco, telefone, email) VALUES
('Maria Oliveira', 11111111111, 'Av. Paulista, 1000', '11999998888', 'maria@email.com'),
('João Silva', 22222222222, 'Rua das Flores, 123', '11987654321', 'joao@email.com'),
('Carlos Souza', 33333333333, 'Rua dos Pinheiros, 500', '11955556666', 'carlos@email.com');

INSERT INTO equipamento (tipo, marca, descricao, cliente_id) VALUES
    ('Computador', 'Dell', 'Computador de mesa', (SELECT id FROM cliente WHERE cpf = 11111111111)),
    ('Impressora', 'HP', 'Impressora a laser', (SELECT id FROM cliente WHERE cpf = 11111111111));

INSERT INTO equipamento (tipo, marca, descricao, cliente_id) VALUES
    ('Tablet', 'Samsung', 'Tablet Galaxy Tab', (SELECT id FROM cliente WHERE cpf = 22222222222));

INSERT INTO equipamento (tipo, marca, descricao, cliente_id) VALUES
    ('Monitor', 'LG', 'Monitor 24" Full HD', (SELECT id FROM cliente WHERE cpf = 33333333333));


