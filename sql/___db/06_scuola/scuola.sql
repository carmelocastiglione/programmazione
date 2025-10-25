-- Creazione del database
DROP DATABASE IF EXISTS scuola;
CREATE DATABASE scuola;
USE scuola;

CREATE TABLE Studente (
IdStudente	VARCHAR(8)	NOT NULL PRIMARY KEY, 
Cognome	 VARCHAR(20)	NOT NULL, 
Nome	 	VARCHAR(20)	NOT NULL, 
Classe		VARCHAR(8)	NOT NULL 
);

CREATE TABLE   Materia (
IdMateria	VARCHAR(3)	NOT NULL PRIMARY KEY, 
NomeMateria	VARCHAR(30)	NOT NULL, 
Insegnante	VARCHAR(40)	NOT NULL 
);

CREATE TABLE   Prova (
CodStudente	VARCHAR(8)	NOT NULL, 
CodMateria	VARCHAR(3)	NOT NULL ,  
Data		DATE	NOT NULL ,  
Voto		Float	NOT NULL,
PRIMARY KEY (CodStudente, CodMateria, Data),
FOREIGN KEY (CodStudente)    REFERENCES Studente (IdStudente),
FOREIGN KEY (CodMateria)    REFERENCES Materia (IdMateria)
);

INSERT INTO Studente (IdStudente, Cognome, Nome, Classe) VALUES
('S001','Rossi','Luca','4A INF'),
('S002','Bianchi','Maria','4A INF'),
('S003','Verdi','Giovanni','4A INF'),
('S004','Neri','Sara','4A INF'),
('S005','Esposito','Francesca','4A INF'),
('S006','Ferrari','Marco','4A INF'),
('S007','Russo','Giulia','4A INF'),
('S008','Romano','Andrea','4A INF'),
('S009','Galli','Alessandro','4A INF'),
('S010','Greco','Martina','4A INF'),
('S011','Fontana','Davide','4A INF'),
('S012','Marino','Sofia','4A INF'),
('S013','De Luca','Tommaso','4A INF'),
('S014','Costa','Elena','4A INF'),
('S015','Rinaldi','Matteo','4A INF'),
('S016','Ferraro','Chiara','4A INF'),
('S017','Barbieri','Lorenzo','4A INF'),
('S018','Moretti','Giulia','4A INF'),
('S019','Conti','Federico','4A INF'),
('S020','Guerra','Francesca','4A INF'),
('S021','Martini','Nicola','4A INF'),
('S022','Basile','Alessia','4A INF'),
('S023','Villa','Riccardo','4A INF'),
('S024','Parisi','Valentina','4A INF'),
('S025','Santoro','Gabriele','4A INF'),
('S026','Milani','Claudia','4A INF'),
('S027','Bellini','Simone','4A INF');

INSERT INTO Studente (IdStudente, Cognome, Nome, Classe) VALUES
('S028','Martini','Alessandro','4B INF'),
('S029','Galli','Francesca','4B INF'),
('S030','Moretti','Luca','4B INF'),
('S031','Costa','Elena','4B INF'),
('S032','Rinaldi','Matteo','4B INF'),
('S033','Ferraro','Chiara','4B INF'),
('S034','Barbieri','Lorenzo','4B INF'),
('S035','Conti','Giulia','4B INF'),
('S036','Villa','Federico','4B INF'),
('S037','Parisi','Alessia','4B INF'),
('S038','Santoro','Riccardo','4B INF'),
('S039','Milani','Valentina','4B INF'),
('S040','Bellini','Gabriele','4B INF'),
('S041','Marino','Claudia','4B INF'),
('S042','De Luca','Simone','4B INF'),
('S043','Greco','Sofia','4B INF'),
('S044','Fontana','Davide','4B INF'),
('S045','Romano','Andrea','4B INF'),
('S046','Esposito','Chiara','4B INF'),
('S047','Bianchi','Matteo','4B INF');


INSERT INTO Materia (IdMateria, NomeMateria, Insegnante) VALUES
('MAT', 'Matematica', 'Prof.ssa Carla Conti'),
('ITA', 'Italiano', 'Prof. Giorgio Serra'),
('INF', 'Informatica', 'Prof.ssa Elena Riva'),
('STO', 'Storia', 'Prof. Luigi Bianchi'),
('ING', 'Inglese', 'Prof.ssa Anna Colombo');

INSERT INTO Prova (CodStudente, CodMateria, Data, Voto) VALUES
('S001','MAT','2025-03-15',7.5),
('S001','INF','2025-04-10',9.0),
('S002','MAT','2025-03-16',6.0),
('S002','ITA','2025-04-12',7.0),
('S003','INF','2025-03-20',8.0),
('S003','STO','2025-04-15',7.5),
('S004','MAT','2025-03-25',8.5),
('S004','ING','2025-04-18',9.0),
('S005','ITA','2025-03-30',7.0),
('S006','INF','2025-03-28',8.0),
('S006','STO','2025-04-25',7.5),
('S007','INF','2025-04-02',7.0),
('S007','ITA','2025-04-28',6.5),
('S008','INF','2025-03-22',9.0),
('S009','MAT','2025-03-23',6.5),
('S009','STO','2025-04-12',7.0),
('S010','INF','2025-03-24',8.5),
('S011','ITA','2025-03-25',7.5),
('S012','MAT','2025-03-26',8.0),
('S013','STO','2025-03-27',6.5),
('S014','ING','2025-03-28',9.0),
('S015','INF','2025-03-29',7.5),
('S016','MAT','2025-03-30',6.0),
('S017','ITA','2025-03-31',8.5),
('S018','STO','2025-04-01',7.0),
('S019','INF','2025-04-02',9.0),
('S020','MAT','2025-04-03',8.0),
('S021','ING','2025-04-04',7.5),
('S022','INF','2025-04-05',6.5),
('S023','ITA','2025-04-06',8.0),
('S024','MAT','2025-04-07',7.0),
('S025','STO','2025-04-08',7.5),
('S026','INF','2025-04-09',8.5),
('S027','ING','2025-04-10',9.0);

INSERT INTO Prova (CodStudente, CodMateria, Data, Voto) VALUES
('S028','MAT','2025-03-15',7.0),
('S028','INF','2025-04-10',8.5),
('S029','MAT','2025-03-16',6.5),
('S029','ITA','2025-04-12',7.0),
('S030','INF','2025-03-20',8.0),
('S030','STO','2025-04-15',7.5),
('S031','MAT','2025-03-25',9.0),
('S032','INF','2025-03-28',6.5),
('S033','MAT','2025-03-30',8.0),
('S034','ITA','2025-03-31',7.5),
('S035','STO','2025-04-01',8.0),
('S036','INF','2025-04-02',9.0),
('S037','MAT','2025-04-03',6.5),
('S038','ING','2025-04-04',7.5),
('S039','INF','2025-04-05',8.5),
('S040','ITA','2025-04-06',7.0),
('S041','MAT','2025-04-07',8.0),
('S042','STO','2025-04-08',7.5),
('S043','INF','2025-04-09',9.0),
('S044','ING','2025-04-10',8.5);