-- IF: Esegue un controllo condizionale su un singolo valore
SELECT idOrdine, idCliente, idProdotto, dataOrdine,
IF(YEAR(dataOrdine) = 2024, 'Ordine del 2024', 'Ordine di un altro anno') AS TipoOrdine
FROM Ordini;

-- CASE: Esegue un controllo condizionale sui valori di una colonna
USE negozio;
SELECT idOrdine, idCliente, idProdotto, dataOrdine,
CASE
    WHEN MONTH(dataOrdine) IN (12, 1, 2) THEN 'Inverno'
    WHEN MONTH(dataOrdine) IN (3, 4, 5) THEN 'Primavera'
    WHEN MONTH(dataOrdine) IN (6, 7, 8) THEN 'Estate'
    WHEN MONTH(dataOrdine) IN (9, 10, 11) THEN 'Autunno'
    ELSE 'Sconosciuto'
END AS Stagione
FROM Ordini;

-- IFNULL: Restituisce un valore alternativo se il valore è NULL
SELECT idOrdine, idCliente, idProdotto, dataOrdine,
IFNULL(dataOrdine, 'Data non disponibile') AS DataOrdineNonNull
FROM Ordini;

-- NULLIF: Restituisce NULL se i due valori sono uguali, altrimenti restituisce il primo valore
SELECT idOrdine, idCliente, idProdotto, dataOrdine, NULLIF(dataOrdine, '2024-01-15') AS DataOrdineNullIf
FROM Ordini;