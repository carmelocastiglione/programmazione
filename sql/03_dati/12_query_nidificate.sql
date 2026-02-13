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