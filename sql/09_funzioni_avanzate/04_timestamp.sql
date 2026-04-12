-- La differenza tra DATETIME e TIMESTAMP è che DATETIME memorizza una data e un'ora senza fuso orario, mentre TIMESTAMP memorizza una data e un'ora con riferimento al fuso orario UTC. TIMESTAMP viene spesso utilizzato per tracciare eventi in un sistema (log, accessi, modifiche), poiché si adatta automaticamente al fuso orario del server.

USE negozio;
-- Aggiungere una colonna TIMESTAMP alla tabella Ordini
ALTER TABLE Ordini
ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- Aggiornare automaticamente la colonna TIMESTAMP alla modifica di una riga
ALTER TABLE Ordini
MODIFY COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;