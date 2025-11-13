# SQL reference

## Creazione schema
``` sql
CREATE DATABASE databasename;
DROP DATABASE databasename;
CREATE TABLE table_name (
    column1 datatype [PRIMARY KEY | FOREIGN KEY | UNIQUE | NOT NULL | AUTO_INCREMENT | DEFAULT | ENUM | CHECK ],
    column2 datatype,
    column3 datatype,
    ....
);
DROP TABLE IF EXISTS table_name;
CREATE [UNIQUE] INDEX index_name ON table_name(column);
```

## Modifica schema
``` sql
ALTER TABLE table_name ADD column datatype;
ALTER TABLE table_name DROP column;
ALTER TABLE table_name CHANGE COLUMN column column datatype;
ALTER TABLE table_name DROP INDEX index_name;
```

## Inserimento dati
``` sql
INSERT INTO table_name (column) VALUES ('value');
UPDATE table_name SET column = value WHERE column = value;
DELETE FROM table_name WHERE column = value;
```