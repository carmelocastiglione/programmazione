/* 
-- CONSTRAINTS REFERENCE --
NOT NULL: Ensures that a column cannot have a NULL value
UNIQUE: Ensures that all values in a column are unique
PRIMARY KEY: Uniquely identifies each record in a table. A combination of NOT NULL and UNIQUE
CHECK: Ensures that all values in a column satisfy a specific condition
DEFAULT: Sets a default value for a column when no value is specified
FOREIGN KEY: Ensures referential integrity by linking to a primary key in another table
AUTO_INCREMENT: Automatically generates a unique number for new rows (specific to certain SQL databases)
ENUM: A string object that can have only one value, chosen from a list of allowed values
*/

DROP DATABASE IF EXISTS campionato;
CREATE DATABASE campionato;

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
    ruolo ENUM('Portiere', 'Difensore', 'Centrocampista', 'Attaccante'),
    data_nascita DATE,
    ora_ultima_partita TIME,
    data_ora_ultima_partita DATETIME,
    data_ora_inserimento TIMESTAMP,
    id_squadra INT,
    FOREIGN KEY (id_squadra) REFERENCES squadre(id)
);

/* FOREIGN KEY CONSTRAINT OPTIONS REFERENCE */
/* ON DELETE CASCADE: If a referenced record in the parent table is deleted, all related records in the child table are also deleted. */
/* ON DELETE SET NULL: If a referenced record in the parent table is deleted, the foreign key in the child table is set to NULL. */
/* ON DELETE RESTRICT: Prevents the deletion of a referenced record in the parent table if there are related records in the child table. */
/* ON DELETE NO ACTION: Similar to RESTRICT, it prevents deletion if there are related records, but the check is deferred until the end of the transaction. */
/* ON UPDATE CASCADE: If the primary key in the parent table is updated, all related foreign keys in the child table are also updated. */
/* ON UPDATE SET NULL: If the primary key in the parent table is updated, the foreign key in the child table is set to NULL. */
/* ON UPDATE RESTRICT: Prevents the update of a primary key in the parent table if there are related foreign keys in the child table. */
/* ON UPDATE NO ACTION: Similar to RESTRICT, it prevents updates if there are related foreign keys, but the check is deferred until the end of the transaction. */
/* SET DEFAULT behavior is equivalent to NO ACTION. */

CREATE TABLE partite (
    id INT AUTO_INCREMENT,
    data_partita DATE NOT NULL,
    ora_partita TIME NOT NULL,
    casa INT,
    trasferta INT,
    PRIMARY KEY (id),
    FOREIGN KEY (casa) REFERENCES squadre(id) ON DELETE CASCADE,
    FOREIGN KEY (trasferta) REFERENCES squadre(id) ON DELETE CASCADE
);