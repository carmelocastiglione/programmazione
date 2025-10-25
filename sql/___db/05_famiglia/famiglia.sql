-- Creazione del database
DROP DATABASE IF EXISTS famiglia;
CREATE DATABASE famiglia;
USE famiglia;

CREATE TABLE Famiglia (
    IdGenitore    INT NOT NULL,
    NomeGenitore  VARCHAR(30) NOT NULL,
    IdFiglio      INT NOT NULL,
    NomeFiglio    VARCHAR(30) NOT NULL,
    PRIMARY KEY (IdGenitore, IdFiglio)
);

INSERT INTO Famiglia (IdGenitore, NomeGenitore, IdFiglio, NomeFiglio) VALUES
-- Prima generazione (genitori -> figli)
(1, 'Mario Rossi', 101, 'Luca Rossi'),
(1, 'Mario Rossi', 102, 'Anna Rossi'),
(2, 'Giulia Bianchi', 101, 'Luca Rossi'),
(2, 'Giulia Bianchi', 102, 'Anna Rossi'),
(3, 'Paolo Verdi', 103, 'Marco Verdi'),
(4, 'Laura Neri', 103, 'Marco Verdi'),

-- Seconda generazione (i figli diventano genitori)
(101, 'Luca Rossi', 201, 'Giorgio Rossi'),
(101, 'Luca Rossi', 202, 'Elena Rossi'),
(102, 'Anna Rossi', 203, 'Chiara Neri'),
(103, 'Marco Verdi', 204, 'Matteo Verdi'),
(103, 'Marco Verdi', 205, 'Laura Verdi');
