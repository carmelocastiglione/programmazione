CREATE TABLE squadre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sigla_squadra CHAR(3) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    citta VARCHAR(50) NOT NULL
);

CREATE TABLE giocatori (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    goal INT CHECK (goal >= 0),
    peso FLOAT,
    attivo BOOLEAN NOT NULL DEFAULT TRUE,
    data_nascita DATE,
    ora_ultima_partita TIME,
    data_ora_ultima_partita DATETIME,
    data_ora_inserimento TIMESTAMP,
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadre(id)
);

/* 
-- CONSTRAINTS REFERENCE --
NOT NULL: Ensures that a column cannot have a NULL value
UNIQUE: Ensures that all values in a column are unique
PRIMARY KEY: Uniquely identifies each record in a table. A combination of NOT NULL and UNIQUE
CHECK: Ensures that all values in a column satisfy a specific condition
DEFAULT: Sets a default value for a column when no value is specified
FOREIGN KEY: Ensures referential integrity by linking to a primary key in another table
AUTO_INCREMENT: Automatically generates a unique number for new rows (specific to certain SQL databases)
*/