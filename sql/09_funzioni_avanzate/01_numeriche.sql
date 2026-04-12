USE negozio;

-- Floor serve per arrotondare un numero decimale per difetto, restituendo il più grande intero minore o uguale al numero dato
SELECT idProdotto, nome, prezzo, FLOOR(prezzo) AS PrezzoArrotondato
FROM Prodotti;

-- Ceil serve per arrotondare un numero decimale per eccesso, restituendo il più piccolo intero maggiore o uguale al numero dato
SELECT idProdotto, nome, prezzo, CEIL(prezzo) AS PrezzoArrotondato
FROM Prodotti;

-- Round serve per arrotondare un numero decimale al numero intero più vicino, restituendo l'intero più vicino al numero dato
SELECT idProdotto, nome, prezzo, ROUND(prezzo) AS PrezzoArrotondato
FROM Prodotti;

-- La funzione RAND() restituisce un numero decimale casuale compreso tra 0 e 1. Può essere utilizzata per generare numeri casuali o per selezionare righe casuali da una tabella.
SELECT idProdotto, nome, prezzo, RAND() AS NumeroCasuale
FROM Prodotti;

-- La funzione ABS() restituisce il valore assoluto di un numero, ovvero la distanza del numero dallo zero sulla linea dei numeri. Se il numero è positivo, restituisce il numero stesso; se è negativo, restituisce il numero senza il segno negativo.
SELECT idProdotto, nome, prezzo, ABS(prezzo - 300) AS DistanzaDa300
FROM Prodotti;

-- La funzione MOD() restituisce il resto della divisione tra due numeri. La sintassi è MOD(dividendo, divisore). Se il divisore è zero, la funzione restituirà NULL.
SELECT idProdotto, nome, prezzo, MOD(idProdotto, 2) AS RestoDivisione
FROM Prodotti;

-- La funzione POWER() restituisce il risultato di un numero elevato a una potenza specificata. La sintassi è POWER(base, esponente). Ad esempio, POWER(2, 3) restituirà 8, poiché 2 elevato alla potenza di 3 è uguale a 8.
SELECT idProdotto, nome, prezzo, POWER(prezzo, 2) AS PrezzoAlQuadrato
FROM Prodotti;

--- La funzione SQRT() restituisce la radice quadrata di un numero. Se il numero è negativo, la funzione restituirà NULL.
SELECT idProdotto, nome, prezzo, SQRT(prezzo) AS RadiceQuadrataPrezzo
FROM Prodotti;

-- La funzione LOG() restituisce il logaritmo naturale di un numero. Se il numero è zero o negativo, la funzione restituirà NULL.
SELECT idProdotto, nome, prezzo, LOG(prezzo) AS LogaritmoNaturale
FROM Prodotti;

-- La funzione EXP() restituisce il valore di e (la base dei logaritmi naturali) elevato alla potenza specificata. La sintassi è EXP(esponente). Ad esempio, EXP(1) restituirà circa 2.71828, poiché e elevato alla potenza di 1 è uguale a e.
SELECT idProdotto, nome, prezzo, EXP(prezzo) AS eElevatoAlPrezzo
FROM Prodotti;

-- La funzione SIGN() restituisce il segno di un numero. Restituisce -1 se il numero è negativo, 0 se il numero è zero e 1 se il numero è positivo.
SELECT idProdotto, nome, prezzo, SIGN(prezzo - 300) AS SegnoDistanzaDa300
FROM Prodotti;