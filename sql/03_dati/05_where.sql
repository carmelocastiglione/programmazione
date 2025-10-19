USE autousate;

-- Selezionare tutte le auto con prezzo inferiore a 20000
SELECT *
FROM Auto
WHERE Prezzo < 20000;

-- Selezionare tutte le auto con cilindrata superiore a 1500 e prezzo inferiore o uguale a 20000
SELECT *
FROM Auto
WHERE Prezzo <= 20000
AND Cilindrata > 1500;

-- Utilizzo del carattere jolly '_' per rappresentare un singolo carattere
-- Utilizzo del carattere jolly '%' per rappresentare una sequenza di caratteri

-- Selezionare targa, modello, marca e prezzo di tutte le auto con la lettera 'B' come seconda lettera della targa
SELECT Targa, Modello, Marca, Prezzo
FROM Auto
WHERE Targa LIKE '_B%';

SELECT Nome

-- Selezionare tutte le case automobilistiche il cui nome non inizia con la lettera 'F'
SELECT *
FROM Casa
WHERE Nome NOT LIKE 'F%';

-- Selezionare tutte le auto con prezzo compreso tra 15000 e 30000
SELECT * 
FROM Auto
WHERE Prezzo BETWEEN 15000 AND 30000;

-- Selezionare tutte le auto con prezzo non compreso tra 15000 e 30000
SELECT * 
FROM Auto
WHERE Prezzo NOT BETWEEN 15000 AND 30000;

-- Selezionare tutte le auto che non hanno un proprietario assegnato (CodP è NULL)
SELECT *
FROM Auto
WHERE CodP IS NULL;

-- Selezionare tutte le auto che hanno un proprietario assegnato (CodP non è NULL)
SELECT *
FROM Auto
WHERE CodP IS NOT NULL;

-- Selezionare tutte le auto con alimentazione Benzina o GPL
SELECT *
FROM Auto
WHERE Alimentazione IN ('Benzina', 'GPL');

-- Selezionare tutte le auto con alimentazione Benzina o GPL
SELECT *
FROM Auto
WHERE Alimentazione NOT IN ('Benzina', 'GPL');
