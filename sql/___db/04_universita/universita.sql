-- Creazione del database
DROP DATABASE IF EXISTS universita;
CREATE DATABASE universita;
USE universita;

-- Tabella degli studenti
CREATE TABLE Studenti (
    Matricola      INT PRIMARY KEY,
    Nome           VARCHAR(30) NOT NULL,
    Cognome        VARCHAR(30) NOT NULL
);

-- Tabella dei voti
CREATE TABLE Voti (
    IdVoto         INT PRIMARY KEY AUTO_INCREMENT,
    Matricola      INT,
    Materia        VARCHAR(50) NOT NULL,
    Voto           INT CHECK (Voto >= 0 AND Voto <= 30),
    FOREIGN KEY (Matricola) REFERENCES Studenti(Matricola)
);

-- Inserimento dati nella tabella Studenti
INSERT INTO Studenti (Matricola, Nome, Cognome) VALUES
(1001, 'Luca', 'Rossi'),
(1002, 'Maria', 'Bianchi'),
(1003, 'Giovanni', 'Verdi'),
(1004, 'Sara', 'Neri'),
(1005, 'Francesca', 'Esposito'),
(1006, 'Marco', 'Ferrari'),
(1007, 'Giulia', 'Russo'),
(1008, 'Andrea', 'Romano');

-- Inserimento dati nella tabella Voti
INSERT INTO Voti (Matricola, Materia, Voto) VALUES
(1001, 'Programmazione 1', 28),
(1001, 'Analisi Matematica', 24),
(1002, 'Economia Aziendale', 30),
(1002, 'Statistica', 27),
(1003, 'Informatica', 25),
(1003, 'Sistemi Operativi', 26),
(1004, 'Diritto Privato', 29),
(1004, 'Microeconomia', 30),
(1006, 'Fisica', 22),
(1006, 'Chimica', 23),
(1007, 'Programmazione 1', 26);
