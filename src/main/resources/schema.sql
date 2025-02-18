CREATE TABLE IF NOT EXISTS Cliente (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL, 
    endereco VARCHAR(255), 
    telefone VARCHAR(20), 
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Equipamento (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    marca VARCHAR(50),
    descricao VARCHAR(255),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE IF NOT EXISTS OrdemServico (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    equipamento_id BIGINT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,
    descricao_problema VARCHAR(255),
    FOREIGN KEY (equipamento_id) REFERENCES Equipamento(id)
);

CREATE TABLE IF NOT EXISTS ExecucaoServico (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ordem_id BIGINT,
    tecnico_id BIGINT,
    data_inicio TIMESTAMP,
    data_fim TIMESTAMP,
    detalhes TEXT,
    FOREIGN KEY (ordem_id) REFERENCES OrdemServico(id)
);

CREATE TABLE IF NOT EXISTS Acompanhamento (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ordem_id BIGINT,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao TEXT,
    FOREIGN KEY (ordem_id) REFERENCES OrdemServico(id)
);
