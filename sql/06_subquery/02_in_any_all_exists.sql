-- Seleziona tutte le auto di marche che hanno più di 2 modelli
SELECT Marca, Modello
FROM Auto
WHERE Marca IN (
    SELECT Marca
    FROM Auto
    GROUP BY Marca
    HAVING COUNT(*) > 2
)

-- Seleziona tutte le auto Fiat con prezzo superiore a quello di almeno una auto Citroen
SELECT Modello, Prezzo, Cilindrata
FROM Auto
WHERE Marca = 'Fiat'
AND Prezzo > ANY (
    SELECT Prezzo
    FROM Auto
    WHERE Marca = 'Citroen'
)

-- Seleziona tutte le auto Fiat con prezzo superiore a quello di tutte le auto Citroen
SELECT Modello, Prezzo, Cilindrata
FROM Auto
WHERE Marca = 'Fiat'
AND Prezzo > ALL (
    SELECT Prezzo
    FROM Auto
    WHERE Marca = 'Citroen'
)

-- Seleziona le case automobilistiche di cui non ho venduto nessuna auto
SELECT C.Nome
FROM Casa AS C
WHERE NOT EXISTS (
    SELECT *
    FROM Auto AS A
    WHERE A.Marca = C.Nome
)