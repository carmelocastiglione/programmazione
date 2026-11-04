# Verifica: Gestore Biblioteca (2 ore)

Non usare `ArrayList`: solo vettori.

## Parte A – Classi `Libro` e `Prestito` (30 min)
Completa [src/Libro.java](src/Libro.java) e [src/Prestito.java](src/Prestito.java): attributi privati, due costruttori (overloading), getter, setter con controllo e `toString`. In `Libro` implementa anche `presta()` e `restituisci()`. Test: `LibroTest` e `PrestitoTest`.

## Parte B – Classe `GestoreBiblioteca` (50 min)
Completa in [src/GestoreBiblioteca.java](src/GestoreBiblioteca.java): costruttore, `getNumLibri`, `getNumPrestiti`, `aggiungi`, `cerca(isbn)`, `cerca(minCopie, maxCopie)` (overloading), `presta`, `restituisci` e `rimuovi`. Test: `GestoreBibliotecaTest`.

## Parte C – Statistiche e App (40 min)
Implementa `incassoMulte`, `libroPiuRichiesto`, `contaLibriEsauriti`, `prestitiUtente`, `toString` del gestore e poi il menu in [src/App.java](src/App.java) (`Scanner`, `do-while`, `switch`). Il menu in `App` non è testato da JUnit.

### Regole
- `Libro`: isbn e titolo sono stringhe; copie totali, copie disponibili e numero di prestiti storici sono `int`. Il costruttore senza copie crea un libro con una sola copia.
- `setCopieTotali` accetta solo valori `>= 1` e non inferiori alle copie attualmente in prestito; un valore non valido non modifica il libro. Le copie disponibili si adeguano.
- `Libro.presta()` fallisce se non ci sono copie disponibili; se riesce aumenta anche il numero di prestiti storici. `Libro.restituisci()` fallisce se tutte le copie sono già in biblioteca.
- `Prestito`: isbn, utente e giorni previsti. Il costruttore senza giorni applica la durata standard di 14 giorni. `setGiorniPrevisti` accetta solo valori maggiori di 0.
- Il gestore ha due vettori a capacità fissa: uno per i libri e uno per i prestiti attivi. Non si possono aggiungere libri con ISBN già presente o quando il catalogo è pieno.
- La ricerca per ISBN restituisce `null` se non trova il libro. La ricerca per copie considera le copie **disponibili**, include gli estremi e restituisce un vettore della dimensione esatta (vuoto se non trova libri).
- `presta(isbn, utente, giorni)` restituisce `false`, senza modificare nulla, se il libro non esiste, non ha copie disponibili, `giorni <= 0`, il vettore dei prestiti è pieno o lo stesso utente ha già in prestito quel libro.
- `restituisci(isbn, utente, giorniEffettivi)` chiude il prestito, libera la copia ed elimina il prestito dal vettore (gli elementi successivi scalano a sinistra). Restituisce la multa: `MULTA_GIORNALIERA * (giorniEffettivi - giorniPrevisti)` se c'è ritardo, altrimenti `0`. La multa viene sommata all'incasso. Restituisce `-1`, senza modificare nulla, se il prestito non esiste o se `giorniEffettivi <= 0`.
- `rimuovi(isbn)` elimina il libro solo se tutte le sue copie sono in biblioteca.
- `libroPiuRichiesto` restituisce il libro con più prestiti storici (`null` se il catalogo è vuoto). `contaLibriEsauriti` conta i libri con 0 copie disponibili. `prestitiUtente` restituisce gli ISBN dei prestiti attivi dell'utente, nell'ordine di registrazione.
- `toString` del gestore restituisce una riga per libro, terminata da `\n`, usando il formato di `Libro.toString()`.

## Eseguire i test da VS Code
1. Apri la vista **Testing** (icona a forma di provetta nella barra laterale sinistra).
2. Espandi l'elenco: trovi `LibroTest`, `PrestitoTest` e `GestoreBibliotecaTest` con i relativi test.
3. Premi il pulsante ▶ accanto a un singolo test, a una classe o in cima per eseguirli tutti.
4. Un test fallito mostra una ✗ rossa: cliccalo per leggere il messaggio (valore atteso e ottenuto).

In alternativa, accanto a ogni `@Test` nel codice c'è il pulsante ▶ **Run Test**.

Se i test non compaiono, esegui dalla palette comandi (`Ctrl+Shift+P`) **Java: Clean Java Language Server Workspace** e riavvia VS Code.

> Docente: la cartella `soluzione/` contiene la soluzione di riferimento (non distribuirla).
