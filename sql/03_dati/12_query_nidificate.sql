-- Selezionare marca e modello di tutte le auto che hanno un prezzo inferiore alla media dei prezzi di tutte le auto presenti nella tabella Auto.
SELECT Marca, Modello
From Auto
WHERE Prezzo < (
    SELECT AVG(Prezzo) FROM Auto
    )

-- Selezionare marca e modello dell'auto più costosa presente nella tabella Auto.
SELECT Marca, Modello
From Auto
WHERE Prezzo = (
    SELECT MAX(Prezzo) FROM Auto
    )

-- Visualizzare in quale stato si trova la casa automobilistica che produce l'auto più cara a GPL
SELECT Nazione
FROM Casa AS C, Auto AS A
WHERE C.Nome = A.Marca
AND A.Prezzo = (
    SELECT MAX(Prezzo) FROM Auto
    WHERE Alimentazione = 'GPL'
    )

-- Visualizzare per ogni marca di auto, la percentuale di auto vendute
SELECT Marca, ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Auto), 2) AS Percentuale
FROM Auto
GROUP BY Marca
ORDER BY Percentuale DESC

-- Visualizzare per ogni marca di auto, la percentuale di auto vendute con alimentazione elettrica
SELECT Marca, ROUND(COUNT(*) * 100.0 / (SELECT COUNT(*) FROM Auto), 2) AS Percentuale
FROM Auto
WHERE Alimentazione = 'Elettrica'
GROUP BY Marca
ORDER BY Percentuale DESC

-- Visualizzare per ogni auto lo scostamento tra il prezzo e il prezzo medio delle auto della stessa marca
SELECT Marca, Modello, Prezzo, 
       ROUND(Prezzo - (SELECT AVG(Prezzo) FROM Auto AS A2 WHERE A2.Marca = A1.Marca), 2) AS Scostamento
FROM Auto AS A1
ORDER BY Scostamento DESC