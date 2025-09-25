-- Cancello le tabelle se esistono
DROP TABLE IF EXISTS giocatori;
DROP TABLE IF EXISTS squadre;

-- Creo le tabelle
CREATE TABLE squadre (
    id INT PRIMARY KEY,
    sigla_squadra CHAR(3) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    citta VARCHAR(50) NOT NULL
);

CREATE TABLE giocatori (
    id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    goal INT CHECK (goal >= 0),
    squadra VARCHAR(50),
    peso FLOAT,
    attivo BOOLEAN NOT NULL DEFAULT TRUE,
    data_nascita DATE,
    ora_ultima_partita TIME,
    data_ora_ultima_partita DATETIME,
    data_ora_inserimento TIMESTAMP,
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadre(id)
);

-- Creo gli indici
CREATE UNIQUE INDEX idx_sigla_squadra ON squadre(sigla_squadra);
CREATE INDEX idx_cognome ON giocatori(cognome);