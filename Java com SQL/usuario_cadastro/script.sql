-- Comando para criar o banco de dados
CREATE DATABASE exercicios2;

-- Comando para selecionar o banco de dados
USE exercicios2;

-- Tabela para inserir cotação da moeda
CREATE TABLE cotacao_moeda (
    id INT PRIMARY KEY AUTO_INCREMENT,
    moeda VARCHAR(50),
    valor DECIMAL(10, 2)
);

-- Tabela para inserir cadastro de usuário
CREATE TABLE cadastro_usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(20)
);

-- Tabela para inserir números aleatórios
CREATE TABLE numeros_aleatorios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT
);

-- Tabela para inserir feriados nacionais
CREATE TABLE feriados_nacionais (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    descricao VARCHAR(100)
);

-- Tabela para inserir datas de eclipses solares
CREATE TABLE eclipses_solares (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    tipo VARCHAR(50)
);

CREATE TABLE produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DECIMAL(10, 2)
);

INSERT INTO produtos (nome, preco) VALUES
    ('Camiseta de Algodão', 19.99),
    ('Calça Jeans Skinny', 49.99),
    ('Tênis Esportivo Nike', 89.99),
    ('Vestido Floral', 29.99),
    ('Óculos de Sol Ray-Ban', 129.99),
    ('Relógio de Pulso Casio', 79.99),
    ('Mochila para Notebook', 39.99),
    ('Bolsa de Couro Feminina', 59.99),
    ('Boné Estilizado', 14.99),
    ('Jaqueta Corta-Vento', 54.99),
    ('Calça de Moletom', 34.99),
    ('Sapato Social Masculino', 69.99),
    ('Biquíni Estampado', 24.99),
    ('Shorts de Praia', 19.99),
    ('Perfume Importado', 89.99),
    ('Batom Matte', 9.99),
    ('Camisa Polo Lacoste', 69.99),
    ('Saia Midi Plissada', 39.99),
    ('Tênis Converse Chuck Taylor', 49.99),
    ('Camisa de Flanela', 29.99),
    ('Pulseira de Prata', 19.99),
    ('Anel de Diamante', 149.99),
    ('Colar de Pérolas', 99.99),
    ('Blusa de Tricô', 44.99),
    ('Chapéu Fedora', 24.99),
    ('Bolsa Tote de Couro', 74.99),
    ('Blazer Slim Fit', 64.99),
    ('Relógio Smartwatch', 129.99),
    ('Calça Legging Esportiva', 29.99),
    ('Camisa Social Branca', 49.99),
    ('Bota de Couro', 79.99),
    ('Vestido de Festa Longo', 129.99),
    ('Mala de Viagem Grande', 99.99),
    ('Camisola de Seda', 34.99),
    ('Sapato de Salto Alto', 54.99),
    ('Blusa de Cetim', 29.99),
    ('Sneaker Plataforma', 44.99);
   
CREATE TABLE estoque (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    quantidade INT,
    valor DECIMAL(10, 2),
    data_compra DATE
);