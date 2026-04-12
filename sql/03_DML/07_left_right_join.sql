-- Left Join tra Studenti e Voti
-- Usa LEFT JOIN per includere tutti gli studenti
-- Domanda: dove si trovano gli studenti senza voti? (li tengo)
SELECT *
FROM Studenti AS S
LEFT JOIN Voti AS V 
ON S.Matricola = V.Matricola

-- Query per trovare gli studenti senza voti
SELECT S.Matricola, S.Nome, S.Cognome
FROM Studenti AS S
LEFT JOIN Voti AS V 
ON S.Matricola = V.Matricola
WHERE V.Voto IS NULL;

-- Right Join tra Studenti e Voti
-- Usa RIGHT JOIN per includere tutti gli studenti
-- Domanda: dove si trovano gli studenti senza voti? (li tengo)
SELECT *
FROM Voti AS V
RIGHT JOIN Studenti AS S
ON S.Matricola = V.Matricola

-- Query per trovare gli studenti senza voti
SELECT S.Matricola, S.Nome, S.Cognome
FROM Voti AS V
RIGHT JOIN Studenti AS S
ON S.Matricola = V.Matricola
WHERE V.Voto IS NULL;
