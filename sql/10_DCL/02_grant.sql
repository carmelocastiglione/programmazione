-- GRANT serve per assegnare permessi a utenti o ruoli specifici. Ecco un esempio di come utilizzare GRANT per concedere permessi su un database:
CREATE USER 'utentetest' IDENTIFIED BY '1234';

-- Privilegi globali. Concedono tutti i permessi su tutte le tabelle di tutti i database. With GRANT OPTION permette all'utente di concedere a sua volta i permessi ad altri utenti.
GRANT ALL PRIVILEGES ON *.* TO 'utentetest' WITH GRANT OPTION;

-- Privilegi su un database specifico
GRANT SELECT, INSERT, UPDATE ON Negozio.* TO 'utentetest';