USE autousate;

-- Selezionare tutte le colonne della tabella Auto
SELECT * 
FROM Auto;

-- Selezionare Modello e Prezzo dalla tabella Auto
SELECT Modello, Prezzo 
FROM Auto;

-- Visualizzare tutte le cilindrate distinte presenti nella tabella Auto
SELECT DISTINCT Cilindrata;
FROM Auto;

-- Selezionare Nome e Sede dalla tabella Casa con alias
SELECT Nome AS Marca, Sede AS Città 
FROM Casa AS Azienda;

-- Selezionare Marca, Modello e Prezzo con calcolo del prezzo negli USA (supponendo un tasso di cambio di 1.17)
SELECT Marca, Modello, Prezzo * 1.17 AS Prezzo_USA
FROM Auto;