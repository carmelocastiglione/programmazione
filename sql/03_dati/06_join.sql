-- Selezionare tutte le informazioni complete su Case e Auto
SELECT *
FROM Auto
INNER JOIN Casa ON Auto.marca = Casa.nome;

-- In alternativa, utilizzando la sintassi implicita di join
SELECT *
FROM Auto, Casa
WHERE Auto.marca = Casa.nome;

-- Selezionare tutti i dati dei proprietari
SELECT *
FROM Auto, Proprietario
WHERE Auto.CodP = Proprietario.Codice;

-- Usare gli alias per rendere le query più leggibili
SELECT *
FROM Auto AS A, Proprietario AS P
WHERE A.CodP = P.Codice;

-- Unire più tabelle per ottenere informazioni complete
SELECT *
FROM Auto AS A, Proprietario AS P, Casa AS C
WHERE A.CodP = P.Codice 
AND A.marca = C.nome;

-- Visualizzare targa e modello delle auto italiane
SELECT Targa, Modello
FROM Auto AS A, Casa AS C
WHERE A.marca = C.nome
AND C.nazione = 'Italia';

-- Visualizzare targa, modello, marca, nazione, cognome e nome del proprietario
-- (il nome è ambiguo perché usato anche dalla tabella Casa, quindi lo specifichiamo con l'alias della tabella)
SELECT Targa, Modello, Marca, Nazione, Cognome, P.Nome
FROM Auto AS A, Casa AS C, Proprietario AS P
WHERE A.marca = C.nome
AND A.CodP = P.Codice;
