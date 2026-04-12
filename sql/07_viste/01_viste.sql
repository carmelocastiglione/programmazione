-- Creazione di una vista per visualizzare i dettagli degli ordini
-- La vista ClientiMilano mostra solo i clienti che risiedono a Milano

CREATE VIEW ClientiMilano AS
SELECT idCliente, nome, cognome, email
FROM Clienti
WHERE citta = 'Milano';

-- Esempio di utilizzo della vista
SELECT * FROM ClientiMilano;

-- Eliminazione della vista
DROP VIEW IF EXISTS ClientiMilano;