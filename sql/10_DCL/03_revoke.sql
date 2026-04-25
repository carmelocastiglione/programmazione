-- Tolgo i privilegi di inserimento e aggiornamento all'utente 'utentetest' sul database Negozio
REVOKE INSERT, UPDATE ON Negozio.* FROM 'utentetest';

-- Tolgo tutti i privilegi all'utente 'utentetest' su tutte le tabelle del database
REVOKE ALL PRIVILEGES ON *.* FROM 'utentetest';