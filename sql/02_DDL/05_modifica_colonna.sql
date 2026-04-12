-- Aggiungo la colonna "nazione" alla tabella "squadre"
ALTER TABLE squadre
ADD nazione VARCHAR(50) NOT NULL;

-- Modifico la colonna "nazione" per cambiare la sua lunghezza a 25 caratteri
ALTER TABLE squadre
CHANGE COLUMN nazione nazione VARCHAR(25) NOT NULL;