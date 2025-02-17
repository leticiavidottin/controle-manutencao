CREATE TABLE Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE Equipamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    marca VARCHAR(50),
    descricao VARCHAR(255),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE OrdemServico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    equipamento_id BIGINT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,
    descricao_problema VARCHAR(255),
    FOREIGN KEY (equipamento_id) REFERENCES Equipamento(id)
);

CREATE TABLE ExecucaoServico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ordem_id BIGINT,
    tecnico_id BIGINT,
    data_inicio TIMESTAMP,
    data_fim TIMESTAMP,
    detalhes TEXT,
    FOREIGN KEY (ordem_id) REFERENCES OrdemServico(id)
);

CREATE TABLE Acompanhamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ordem_id BIGINT,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (ordem_id) REFERENCES OrdemServico(id)
);
