CREATE TABLE giocatori (
    id INT,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    goal INT,
    squadra VARCHAR(50),
    sigla_squadra CHAR(3),
    peso FLOAT,
    attivo BOOLEAN,
    data_nascita DATE,
    ora_ultima_partita TIME,
    data_ora_ultima_partita DATETIME,
    data_ora_inserimento TIMESTAMP
);

/*
-- DATA TYPE REFERENCE --
INT: Integer numbers
FLOAT: Floating-point numbers
CHAR(n): Fixed-length string with a length of n characters
VARCHAR(n): Variable-length string with a maximum length of n characters
BOOLEAN: True or False values
DATE: Date values in the format 'YYYY-MM-DD'
TIME: Time values in the format 'HH:MM:SS'
DATETIME: Combined date and time values in the format 'YYYY-MM-DD HH:MM:SS'
TIMESTAMP: Timestamp values, typically used for recording the date and time of an event
*/
