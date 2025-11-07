-- Seleziona il numero totale di righe nella tabella Auto
-- Restituisce il conteggio totale delle auto presenti nella tabella Auto
-- (anche se alcune colonne contengono valori NULL)
SELECT COUNT(*)
FROM Auto;

-- Seleziona il numero di righe nella tabella Auto in cui la colonna Prezzo non è NULL
-- Restituisce il conteggio delle auto che hanno un valore definito per la colonna
SELECT COUNT(Prezzo)
FROM Auto;

-- Come sopra, ma utilizzando una clausola WHERE per filtrare i risultati
SELECT COUNT(*)
FROM Auto
WHERE Prezzo IS NOT NULL;

-- Seleziona il numero di auto per 'Fiat'
SELECT COUNT(*) AS 'Numero Auto Fiat'
FROM Auto
WHERE Marca = 'Fiat';

-- Seleziona il numero di marche distinte presenti nella tabella Auto
SELECT COUNT(DISTINCT Marca) AS 'Numero Marche Distinte'
FROM Auto;

-- Seleziona il prezzo totale delle auto 'Fiat'
SELECT SUM(Prezzo) AS 'Somma Prezzi Auto Fiat'
FROM Auto
WHERE Marca = 'Fiat';

-- Seleziona la media della cilindrata delle auto 'Fiat'
SELECT AVG(Cilindrata) AS 'Media Cilindrata Auto Fiat'
FROM Auto
WHERE Marca = 'Fiat';

-- Seleziona il prezzo massimo delle auto 'Fiat'
SELECT MAX(Prezzo) AS 'Prezzo Massimo Auto Fiat'
FROM Auto
WHERE Marca = 'Fiat';

-- Seleziona il prezzo minimo delle auto 'Fiat'
SELECT MIN(Prezzo) AS 'Prezzo Minimo Auto Fiat'
FROM Auto
WHERE Marca = 'Fiat';