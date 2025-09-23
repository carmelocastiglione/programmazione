CREATE TABLE giocatori (
    id INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    goal INT CHECK (goal >= 0),
    squadra VARCHAR(50),
    attivo BOOLEAN NOT NULL DEFAULT TRUE
);