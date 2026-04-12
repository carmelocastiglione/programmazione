-- Creare un utente 
CREATE USER 'utentetest' IDENTIFIED BY '1234';

-- Modificare il nome di un utente
RENAME USER 'utentetest' TO 'nuovoutente';

-- Modificare la password di un utente
ALTER USER 'nuovoutente' IDENTIFIED BY 'nuovapassword';

-- Eliminare un utente
DROP USER 'nuovoutente';