INSERT INTO Cliente (id, nome, endereco, telefone, email) VALUES
(1, 'João Silva', 'Rua A, 123', '11987654321', '[email protected]'),
(2, 'Maria Oliveira', 'Avenida B, 456', '11987654322', '[email protected]'),
(3, 'Carlos Pereira', 'Travessa C, 789', '11987654323', '[email protected]');

INSERT INTO Equipamento (id, tipo, marca, descricao, cliente_id) VALUES
(1, 'Impressora', 'HP', 'Impressora LaserJet Pro', 1),
(2, 'Notebook', 'Dell', 'Notebook Inspiron 15', 2),
(3, 'Scanner', 'Epson', 'Scanner Perfection V39', 3);

INSERT INTO OrdemServico (id, equipamento_id, data_criacao, status, descricao_problema) VALUES
(1, 1, '2025-02-17 10:00:00', 'Pendente', 'Impressora não liga'),
(2, 2, '2025-02-17 11:00:00', 'Em Andamento', 'Tela do notebook quebrada'),
(3, 3, '2025-02-17 12:00:00', 'Concluído', 'Scanner não reconhecido pelo computador');

INSERT INTO Tecnico (id, nome) VALUES
(101, 'Fernando Lima'),
(102, 'Juliana Souza'),
(103, 'Ricardo Mendes');

INSERT INTO ExecucaoServico (id, ordem_id, tecnico_id, data_inicio, data_fim, detalhes_execucao) VALUES
(1, 1, 101, '2025-02-17 10:30:00', NULL, 'Aguardando peças para substituição'),
(2, 2, 102, '2025-02-17 11:15:00', NULL, 'Substituição da tela em andamento'),
(3, 3, 103, '2025-02-17 12:30:00', '2025-02-17 13:00:00', 'Atualização de drivers realizada com sucesso');

INSERT INTO Acompanhamento (id, ordem_id, data, descricao) VALUES
(1, 1, '2025-02-17 10:45:00', 'Peças solicitadas ao fornecedor, previsão de chegada em 3 dias'),
(2, 2, '2025-02-17 11:45:00', 'Tela removida, aguardando nova peça para substituição'),
(3, 3, '2025-02-17 12:45:00', 'Teste de funcionalidade realizado, equipamento pronto para entrega');
