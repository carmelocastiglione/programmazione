DROP DATABASE IF EXISTS prodotti;
CREATE DATABASE prodotti;
USE prodotti;

CREATE TABLE   Fornitore (
IdFornitore	VARCHAR(3)	NOT NULL PRIMARY KEY, 
Nome		VARCHAR(20)	NOT NULL , 
Indirizzo	VARCHAR(40)	NOT NULL , 
Citta		VARCHAR(20)	NOT NULL
);

CREATE TABLE Prodotto (
IdProdotto	VARCHAR(3)	NOT NULL PRIMARY KEY, 
Descrizione	 VARCHAR(30)	NOT NULL , 
Prezzo		FLOAT	NOT NULL,
Quantita	INT 	NOT NULL ,
Categoria   	VARCHAR(20)	NOT NULL ,
CodFornitore	VARCHAR(3)	NOT NULL , 
FOREIGN KEY (CodFornitore)    REFERENCES Fornitore (IdFornitore)
);

-- Creazione database e tabelle
DROP DATABASE IF EXISTS prodotti;
CREATE DATABASE prodotti;
USE prodotti;

CREATE TABLE Fornitore (
    IdFornitore VARCHAR(3) NOT NULL PRIMARY KEY, 
    Nome VARCHAR(20) NOT NULL, 
    Indirizzo VARCHAR(40) NOT NULL, 
    Citta VARCHAR(20) NOT NULL
);

CREATE TABLE Prodotto (
    IdProdotto VARCHAR(3) NOT NULL PRIMARY KEY, 
    Descrizione VARCHAR(30) NOT NULL, 
    Prezzo FLOAT NOT NULL,
    Quantita INT NOT NULL,
    Categoria VARCHAR(20) NOT NULL,
    CodFornitore VARCHAR(3) NOT NULL,
    FOREIGN KEY (CodFornitore) REFERENCES Fornitore(IdFornitore)
);

-- Inserimento fornitori
INSERT INTO Fornitore (IdFornitore, Nome, Indirizzo, Citta) VALUES
('F01', 'Pincopal', 'Via Torino 45', 'Milano'),
('F02', 'TechnoPlus', 'Corso Buenos Aires 110', 'Milano'),
('F03', 'ServiziNord', 'Via Roma 12', 'Bergamo'),
('F04', 'ItalSupply', 'Via Dante 9', 'Milano'),
('F05', 'Componenti24', 'Via Manzoni 8', 'Como'),
('F06', 'BitMarket', 'Via Verdi 23', 'Monza'),
('F07', 'NordTech', 'Via Milano 17', 'Lecco'),
('F08', 'DataLink', 'Via Garibaldi 3', 'Milano'),
('F09', 'SoftPoint', 'Via Volta 55', 'Varese'),
('F10', 'OfficePro', 'Corso Italia 77', 'Milano'),
('F11', 'MegaChip', 'Via Libertà 8', 'Bergamo'),
('F12', 'GigaStore', 'Via Amendola 4', 'Milano'),
('F13', 'ElettroWorld', 'Via Piave 32', 'Como'),
('F14', 'DigitalOne', 'Via Cadorna 20', 'Milano'),
('F15', 'Comtex', 'Via Fermi 10', 'Lecco');

-- Inserimento prodotti
INSERT INTO Prodotto (IdProdotto, Descrizione, Prezzo, Quantita, Categoria, CodFornitore) VALUES
('H74', 'Modulo di rete Gigabit', 129.90, 25, 'Elettronica', 'F01'),
('A22', 'Alimentatore 12V 2A', 34.50, 50, 'Elettronica', 'F02'),
('B15', 'Cavo HDMI 2m', 12.90, 100, 'Accessori', 'F04'),
('D08', 'Mouse wireless', 19.99, 80, 'Periferiche', 'F03'),
('K33', 'Hard Disk 1TB', 65.00, 40, 'Storage', 'F01'),
('R90', 'Scheda madre ATX', 210.00, 10, 'Componenti PC', 'F02'),
('T45', 'Router Wi-Fi 6', 175.00, 15, 'Reti', 'F01'),
('U12', 'Tastiera meccanica', 59.99, 60, 'Periferiche', 'F04'),
('Z88', 'SSD NVMe 512GB', 98.00, 35, 'Storage', 'F06'),
('M19', 'Monitor 24 pollici', 145.00, 25, 'Display', 'F07'),
('C30', 'Cavo Ethernet Cat6', 8.99, 200, 'Accessori', 'F01'),
('S55', 'Stampante laser', 189.00, 12, 'Ufficio', 'F10'),
('X11', 'Webcam HD', 49.00, 70, 'Accessori', 'F09'),
('V08', 'RAM DDR4 16GB', 79.90, 40, 'Componenti PC', 'F12'),
('P14', 'Altoparlanti Bluetooth', 39.99, 90, 'Audio', 'F05'),
('L22', 'Chiavetta USB 64GB', 15.99, 120, 'Storage', 'F13'),
('G17', 'Hub USB 3.0', 22.50, 110, 'Accessori', 'F08'),
('W21', 'Switch 8 porte', 55.00, 30, 'Reti', 'F01'),
('E99', 'CPU Intel i5', 250.00, 8, 'Componenti PC', 'F11'),
('Q71', 'Ventola 120mm', 11.50, 150, 'Accessori', 'F14'),
('Y40', 'Cuffie con microfono', 44.00, 70, 'Audio', 'F15'),
('B89', 'Proiettore portatile', 320.00, 6, 'Display', 'F07'),
('A80', 'Powerbank 20000mAh', 29.99, 85, 'Elettronica', 'F05'),
('D60', 'Scheda video RTX 4060', 549.00, 5, 'Componenti PC', 'F12'),
('K09', 'Tablet 10"', 239.00, 20, 'Mobile', 'F02');


