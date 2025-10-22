DROP DATABASE IF EXISTS campionato;
CREATE DATABASE campionato;
USE campionato;

CREATE TABLE Citta (
idC	INT 		NOT NULL  PRIMARY KEY, 
NomeC	VARCHAR(20)	NOT NULL , 
Prov	VARCHAR(20)	NOT NULL );

CREATE TABLE Squadra (
idS	 INT 		NOT NULL PRIMARY KEY, 
NomeS	 VARCHAR(20)	NOT NULL , 
Punti	 INT 		NOT NULL , 
Serie	 CHAR (1)	NOT NULL ,
codCitta INT 	NOT NULL, 
FOREIGN KEY (codCitta) REFERENCES Citta(idC));

CREATE TABLE Giocatore (
idG	INT 	NOT NULL  Primary  KEY, 
NomeG  VARCHAR(20)	NOT NULL , 
Costo	INT 	NOT NULL , 
Reti	INT 	NOT NULL ,
Ruolo  VARCHAR(20)	NOT NULL ,
CodSquadra 	INT 	NOT NULL , 
FOREIGN KEY (CodSquadra) REFERENCES Squadra(idS));

INSERT INTO Citta (idC, NomeC, Prov) VALUES
(1, 'Torino', 'TO'),
(2, 'Milano', 'MI'),
(3, 'Roma', 'RM'),
(4, 'Napoli', 'NA'),
(5, 'Bologna', 'BO'),
(6, 'Firenze', 'FI'),
(7, 'Genova', 'GE'),
(8, 'Verona', 'VR'),
(9, 'Bergamo', 'BG'),
(10, 'Udine', 'UD'),
(11, 'Lecce', 'LE'),
(12, 'Cagliari', 'CA'),
(13, 'Empoli', 'FI'),
(14, 'Monza', 'MB'),
(15, 'Salerno', 'SA'),
(16, 'Sassuolo', 'MO'),
(17, 'Frosinone', 'FR'),
(18, 'La Spezia', 'SP'),
(19, 'Reggio Emilia', 'RE'),
(20, 'Venezia', 'VE');

INSERT INTO Squadra (idS, NomeS, Punti, Serie, codCitta) VALUES
(1, 'Juventus', 18, 'A', 1),
(2, 'Torino', 12, 'A', 1),
(3, 'Inter', 22, 'A', 2),
(4, 'Milan', 20, 'A', 2),
(5, 'Roma', 17, 'A', 3),
(6, 'Lazio', 15, 'A', 3),
(7, 'Napoli', 19, 'A', 4),
(8, 'Bologna', 14, 'A', 5),
(9, 'Fiorentina', 16, 'A', 6),
(10, 'Genoa', 11, 'A', 7),
(11, 'Verona', 9, 'A', 8),
(12, 'Atalanta', 18, 'A', 9),
(13, 'Udinese', 10, 'A', 10),
(14, 'Lecce', 13, 'A', 11),
(15, 'Cagliari', 7, 'A', 12),
(16, 'Empoli', 8, 'A', 13),
(17, 'Monza', 12, 'A', 14),
(18, 'Salernitana', 6, 'A', 15),
(19, 'Sassuolo', 10, 'A', 20),
(20, 'Frosinone', 9, 'A', 17);

INSERT INTO Giocatore (idG, NomeG, Costo, Reti, Ruolo, CodSquadra) VALUES
(1,  'Lautaro Martínez',     110000000, 18, 'Attaccante', 3),
(2,  'Victor Osimhen',      100000000, 20, 'Attaccante', 7),
(3,  'Rafael Leão',          90000000, 15, 'Attaccante', 4),
(4,  'Nicolo Barella',        80000000, 5, 'Centrocampista', 3),
(5,  'Khvicha Kvaratskhelia',80000000, 10, 'Attaccante', 7),
(6,  'Douglas Luiz',         70000000, 4, 'Centrocampista', 1),
(7,  'Alessandro Bastoni',   70000000, 2, 'Difensore', 3),
(8,  'Dusan Vlahovic',       65000000, 14, 'Attaccante', 1),
(9,  'Theo Hernández',       60000000, 3, 'Difensore', 4),
(10, 'Gleison Bremer',       60000000, 1, 'Difensore', 1),
(11, 'Benjamin Pavard',      50000000, 2, 'Difensore', 3),
(12, 'Teun Koopmeiners',     50000000, 6, 'Centrocampista', 9),
(13, 'Federico Dimarco',     50000000, 4, 'Difensore', 3),
(14, 'Giorgio Scalvini',     45000000, 1, 'Difensore', 9),
(15, 'Hakan Çalhanoğlu',     45000000, 3, 'Centrocampista', 3),
(16, 'Christian Pulisic',    40000000, 7, 'Attaccante', 4),
(17, 'Éderson',              40000000, 5, 'Difensore', 9),
(18, 'Ademola Lookman',      40000000, 11, 'Attaccante', 9),
(19, 'Fikayo Tomori',        40000000, 1, 'Difensore', 4),
(20, 'Alexis Saelemaekers',   35000000, 4, 'Attaccante', 4),
(21, 'Davide Frattesi',       30000000, 5, 'Centrocampista', 3),
(22, 'Matteo Ruggeri',        28000000, 0, 'Difensore', 3),
(23, 'Moise Kean',            25000000, 8, 'Attaccante', 5),
(24, 'Mattia Zaccagni',       24000000, 6, 'Attaccante', 6),
(25, 'Bryan Cristante',       22000000, 2, 'Centrocampista', 9),
(26, 'Giovanni Di Lorenzo',   20000000, 1, 'Difensore', 7),
(27, 'Amir Rrahmani',         18000000, 2, 'Difensore', 7),
(28, 'Yann Sommer',           17000000, 0, 'Portiere', 4),
(29, 'Benjamin Siegrist',     16000000, 0, 'Portiere', 6),
(30, 'Rolando Mandragora',    15000000, 1, 'Centrocampista', 9);

INSERT INTO Giocatore (idG, NomeG, Costo, Reti, Ruolo, CodSquadra) VALUES
(31, 'Marco Rossi',          8000000,  3, 'Centrocampista', 2),
(32, 'Alessio Bianchi',      7500000,  1, 'Difensore',       2),
(33, 'Luca Verdi',           7000000,  5, 'Attaccante',      5),
(34, 'Giuseppe Neri',        6500000,  0, 'Portiere',        6),
(35, 'Stefano Galli',        6000000,  2, 'Difensore',       8),
(36, 'Davide Moretti',       5500000,  4, 'Centrocampista', 10),
(37, 'Federico Pianetti',    5000000,  6, 'Attaccante',      11),
(38, 'Andrea Marchetti',     4500000,  1, 'Centrocampista', 12),
(39, 'Riccardo Fontana',      4000000,  0, 'Difensore',        14),
(40, 'Giorgio Romano',        3500000,  7, 'Attaccante',      15);

