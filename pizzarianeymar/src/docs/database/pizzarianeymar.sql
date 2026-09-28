CREATE DATABASE pizzarianeymar;
GO
USE pizzarianeymar;
GO
CREATE TABLE categoria (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    descricao VARCHAR(255) NULL,
    cod_status BIT NOT NULL DEFAULT 1
);
CREATE TABLE usuario (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(120) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    sexo VARCHAR(20) NULL,
    logradouro VARCHAR(150) NULL,
    cep VARCHAR(9) NULL,
    bairro VARCHAR(80) NULL,
    cidade VARCHAR(80) NULL,
    uf VARCHAR(2) NULL,
    cod_status BIT NOT NULL DEFAULT 1,
    tipo_usuario VARCHAR(20) NOT NULL
);
CREATE TABLE produto (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NULL,
    valor_compra DECIMAL(10,2) NULL,
    valor_venda DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    cod_status BIT NOT NULL DEFAULT 1,
    categoria_id BIGINT NULL,
    CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);
CREATE TABLE telefone (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    numero VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_telefone_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
CREATE TABLE pedido (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    data_pedido DATETIME2 NOT NULL,
    status VARCHAR(30) NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_pedido_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
CREATE TABLE item_pedido (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    CONSTRAINT fk_item_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    CONSTRAINT fk_item_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);
GO
