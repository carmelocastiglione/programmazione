SELECT DISTINCT F2.NomeGenitore AS Nonno
FROM Famiglia AS F1, Famiglia AS F2
WHERE F1.IdGenitore = F2.IdFiglio;