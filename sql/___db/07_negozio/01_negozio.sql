DROP DATABASE IF EXISTS negozio;
CREATE DATABASE negozio;
USE negozio;

CREATE TABLE Clienti (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    email VARCHAR(100),
    citta VARCHAR(50)
);

CREATE TABLE Prodotti (
    idProdotto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    prezzo DECIMAL(10, 2)
);

CREATE TABLE Ordini (
    idOrdine INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT,
    idProdotto INT,
    dataOrdine DATE,
    FOREIGN KEY (idCliente) REFERENCES Clienti(idCliente) ON DELETE CASCADE,
    FOREIGN KEY (idProdotto) REFERENCES Prodotti(idProdotto) ON DELETE CASCADE
);

INSERT INTO Clienti (nome, cognome, email, citta) VALUES
('Mario', 'Rossi', 'mario.rossi@example.com', 'Roma'),
('Luigi', 'Bianchi', 'luigi.bianchi@example.com', 'Milano'),
('Giulia', 'Verdi', 'giulia.verdi@example.com', 'Torino'),
('Francesca', 'Neri', 'francesca.neri@example.com', 'Napoli');

INSERT INTO Prodotti (nome, prezzo) VALUES
('Laptop', 999.99),
('Smartphone', 499.99),
('Tablet', 299.99),
('Cuffie', 199.99);

INSERT INTO Ordini (idCliente, idProdotto, dataOrdine) VALUES
(1, 1, '2024-01-15'),
(2, 2, '2024-02-20'),
(3, 3, '2024-03-10'),
(4, 4, '2024-04-05');