USE negozio;

-- La funzione CONCAT() viene utilizzata per concatenare due o più stringhe in una singola stringa. La sintassi è CONCAT(string1, string2, ...)
SELECT idCliente, CONCAT(nome, ' ', cognome) AS NomeCompleto
FROM Clienti;

-- La funzione LENGTH() restituisce la lunghezza di una stringa, ovvero il numero di caratteri presenti nella stringa. La sintassi è LENGTH(string).
SELECT idCliente, nome, cognome, LENGTH(nome) AS LunghezzaNome, LENGTH(cognome) AS LunghezzaCognome
FROM Clienti;

-- La funzione SUBSTRING() viene utilizzata per estrarre una parte di una stringa. La sintassi è SUBSTRING(string, start, length), dove start è la posizione iniziale (1-based) e length è il numero di caratteri da estrarre.
SELECT idCliente, nome, cognome, SUBSTRING(nome, 1, 3) AS InizialiNome
FROM Clienti;

-- La funzione REPLACE() viene utilizzata per sostituire tutte le occorrenze di una sottostringa con un'altra stringa. La sintassi è REPLACE(string, from_substring, to_substring).
SELECT idCliente, nome, cognome, REPLACE(email, 'example.com', 'gmail.com') AS EmailModificata
FROM Clienti;

-- La funzione UPPER() converte tutte le lettere di una stringa in maiuscolo, mentre LOWER() converte tutte le lettere in minuscolo. La sintassi è UPPER(string) e LOWER(string).
SELECT idCliente, nome, cognome, UPPER(nome) AS NomeMaiuscolo, LOWER(cognome) AS CognomeMinuscolo
FROM Clienti;

-- La funzione TRIM() viene utilizzata per rimuovere gli spazi bianchi all'inizio e alla fine di una stringa. La sintassi è TRIM(string).
SELECT idCliente, nome, cognome, LENGTH(CONCAT(nome, ' ')) AS LunghezzaNomeCompleto, TRIM(CONCAT(nome, ' ')) AS NomeCompletoTrimmed, LENGTH(TRIM(CONCAT(nome, ' '))) AS LunghezzaNomeCompletoTrimmed 
FROM Clienti;