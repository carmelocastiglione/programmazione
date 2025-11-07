-- Seleziona il numero di auto per ogni marca
SELECT DISTINCT Marca
FROM Auto;

-- Faccio la stessa cosa usando GROUP BY
-- Raggruppa le auto per marca
SELECT Marca
FROM Auto
GROUP BY Marca;

-- Conta il numero di auto per ogni marca
SELECT Marca, COUNT(*) AS 'Numero Auto'
FROM Auto
GROUP BY Marca;

-- Tutti i campi nella SELECT devono essere o aggregati o presenti nella clausola GROUP BY
SELECT A.Marca, C.Nazione, COUNT(*) AS 'Numero Auto'
FROM Auto AS A, Casa AS C
WHERE C.Nome = A.Marca
GROUP BY A.Marca, C.Nazione;

-- Calcola il prezzo massimo, minimo e medio delle auto per ogni marca
SELECT Marca, MAX(Prezzo) AS 'Prezzo Massimo', MIN(Prezzo) AS 'Prezzo Minimo', AVG(Prezzo) AS 'Prezzo Medio'
FROM Auto
GROUP BY Marca
ORDER BY Marca ASC;

-- Where filtra le righe prima del raggruppamento
-- Having filtra i gruppi dopo il raggruppamento
-- Calcola la cilindrata media delle auto per ogni marca con cilindrata media superiore a 1500
SELECT Marca, AVG(Cilindrata) AS 'Cilindrata Media'
FROM Auto
GROUP BY Marca
HAVING AVG(Cilindrata) > 1500
ORDER BY AVG(Cilindrata) DESC;