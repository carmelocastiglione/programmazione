-- Seleziona tutte le auto ordinate per prezzo in modo crescente
SELECT Targa, Marca, Modello, Prezzo
FROM Auto
ORDER BY Prezzo;

-- Seleziona le auto di alcune marche specifiche ordinate per prezzo in modo decrescente
SELECT Targa, Marca, Modello, Prezzo
FROM Auto
WHERE Marca IN ('Fiat', 'Ford', 'BMW')
ORDER BY Prezzo DESC;