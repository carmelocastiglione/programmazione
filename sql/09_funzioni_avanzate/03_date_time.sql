USE negozio;

-- Data odierna
SELECT CURDATE() AS DataOdierna;

-- Ora attuale
SELECT CURTIME() AS OraAttuale;

-- Data e ora attuali
SELECT NOW() AS DataEOraAttuali;

-- Estrarre solo la data da una data completa
SELECT NOW() AS DataEOraAttuali, DATE(NOW()) AS SoloData;

-- Estrarre solo l'ora da una data completa
SELECT NOW() AS DataEOraAttuali, TIME(NOW()) AS SoloOra;

-- Estrarre anno, mese e giorno di una data
SELECT idOrdine, dataOrdine, YEAR(dataOrdine) AS Anno, MONTH
(dataOrdine) AS Mese, DAY(dataOrdine) AS Giorno
FROM Ordini;

-- Estrarre ora, minuto e secondo di una data
SELECT NOW() AS DataEOraAttuali, HOUR(NOW()) AS Ora, MINUTE(NOW()) AS Minuto, SECOND(NOW()) AS Secondo;

-- Selezionare un ordine con data maggiore di una data specifica
SELECT idOrdine, idCliente, idProdotto, dataOrdine
FROM Ordini
WHERE dataOrdine > '2024-03-01';

-- Calcolare la differenza in giorni tra due date
SELECT idOrdine, idCliente, idProdotto, dataOrdine, DATEDIFF(CURDATE(), dataOrdine) AS GiorniTrascorsi
FROM Ordini;

-- DATEADD: Aggiungere un intervallo di giorni a una data
SELECT idOrdine, idCliente, idProdotto, dataOrdine, DATE_ADD(dataOrdine, INTERVAL 7 DAY) AS DataPiùSetteGiorni
FROM Ordini;

-- DATESUB: Sottrarre un intervallo di giorni da una data
SELECT idOrdine, idCliente, idProdotto, dataOrdine, DATE_SUB(dataOrdine, INTERVAL 3 MONTH) AS DataMenoTreMesi
FROM Ordini;