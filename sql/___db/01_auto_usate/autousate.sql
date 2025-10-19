DROP DATABASE IF EXISTS autousate;
CREATE DATABASE autousate;
USE autousate;

CREATE TABLE Casa (
    Nome     VARCHAR(12) NOT NULL PRIMARY KEY,
    Sede     VARCHAR(20) NOT NULL,
    Nazione  VARCHAR(20) DEFAULT NULL
);

CREATE TABLE Proprietario (
    Codice      INT NOT NULL PRIMARY KEY,
    Cognome     VARCHAR(20) NOT NULL,
    Nome        VARCHAR(20) NOT NULL,
    Indirizzo   VARCHAR(50) DEFAULT NULL,
    Città 	    VARCHAR(20) DEFAULT NULL
);

CREATE TABLE Auto (
    Targa            VARCHAR(8) NOT NULL PRIMARY KEY, 
    Cilindrata       INT  DEFAULT NULL,
    Prezzo           FLOAT DEFAULT NULL,
    Modello          VARCHAR(20) DEFAULT NULL,
    Colore           VARCHAR(20) DEFAULT NULL,
    Marca            VARCHAR(12) DEFAULT NULL,
    Alimentazione    VARCHAR(10) DEFAULT NULL,
    CodP             INT  DEFAULT NULL,
    FOREIGN KEY (CodP)    REFERENCES Proprietario(Codice),
    FOREIGN KEY (Marca)   REFERENCES Casa(Nome)
);

--
-- Dati per la tabella  Casa 
--

INSERT INTO  Casa  ( Nome ,  Sede ,  Nazione ) VALUES
('Alfa Romeo', 'Milano', 'Italia'),
('BMW', 'Monaco', 'Germania'),
('Citroen', 'Parigi', 'Francia'),
('Fiat', 'Torino', 'Italia'),
('Ford', 'Dearborn', 'USA'),
('Honda', 'Tokio', 'Giappone'),
('Lancia', 'Torino', 'Italia'),
('Nissan', 'Tokio', 'Giappone'),
('Renault', 'Parigi', 'Francia');

--
-- Dati per la tabella  Proprietario 
--

INSERT INTO  Proprietario  ( Codice ,  Cognome ,  Nome ,  Indirizzo ,  Città ) VALUES
(1, 'Rossi', 'Mario', 'Via Genova 10', 'Milano'),
(2, 'Verdi', 'Lucia', 'Via Roma 77', 'Verona'),
(3, 'Bianchi', 'Maria', 'Via XX Settembre', 'Torino'),
(4, 'Neri', 'Giovanni', 'Viale Zara 78', 'Milano'),
(5, 'Conti', 'Alberto', 'Via Milano 10', 'Torino'),
(6, 'Morandi', 'Simona', 'Piazza Vittorio', 'Roma');

--
-- Dati per la tabella  AUTO 
--

INSERT INTO  auto  ( Targa ,  Cilindrata ,  Prezzo ,  Modello ,  Colore ,  Marca ,  Alimentazione ,  CodP ) VALUES
('CB001LX', 1400, 27000, 'Berlingo', 'grigio', 'Citroen', 'metano', 1),
('CB342CH', 1000, 15400, 'Panda', 'rosso', 'Fiat', 'GPL', 2),
('CD564BA', 1200, 12100, 'Panda', 'bianco', 'Fiat', 'benzina', 6),
('EB800LK', 1500, 22000, 'Puma', 'verde', 'Ford', 'ibrida', 5),
('ED564BA', 1500, 12000, 'Tipo', 'bianco', 'Fiat', 'benzina', 3),
('EN129AS', 1500, 25000, '500X', 'blu', 'Fiat', 'benzina', 5),
('ER321XT', 2000, 55000, 'X3', 'rosso', 'BMW', 'ibrida', 6),
('FA666LL', 2900, 42000, 'Stelvio', 'blu', 'Alfa Romeo', 'benzina', 3),
('FB453ER', 1600, 19000, 'Juke', 'blu', 'Nissan', 'ibrida', 4),
('FX432KK', 1100, 14500, 'Clio', 'rosso', 'Renault', 'GPL', 1),
('GB401ET', 1200, 17000, 'C3', 'blu', 'Citroen', 'metano', 3);
