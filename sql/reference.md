# SQL reference

## Creazione schema
``` sql
CREATE DATABASE databasename;
DROP DATABASE databasename;
CREATE TABLE table_name (
    column1 datatype [ PRIMARY KEY | FOREIGN KEY | UNIQUE | NOT NULL |
                       AUTO_INCREMENT | DEFAULT | ENUM | CHECK ],
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
INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);
INSERT INTO table_name VALUES (value1, value2, value3, ...);
UPDATE table_name SET column = value WHERE column = value;
DELETE FROM table_name WHERE column = value;
```

## Query
``` sql
SELECT [DISTINCT] column1 [AS 'column_name'], column2, ...
FROM table_name
WHERE condition
[ AND | OR condition ]
[ LIKE | NOT LIKE | BETWEEN | NOT BETWEEN | IS NULL | IS NOT NULL | IN | NOT IN ]
[ INNER | LEFT | RIGHT | FULL | SELF JOIN table2 ON table1.column_name = table2.column_name ]
[ GROUP BY column_name(s) ]
[ ORDER BY column_name(s) DESC | ASC ];
```
