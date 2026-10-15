# Verifica: Gestore Magazzino (2 ore)

Non usare `ArrayList`: solo vettori.

## Parte A – Classe `Prodotto` (30 min)
Completa [src/Prodotto.java](src/Prodotto.java): attributi privati, due costruttori (overloading), getter, setter con controllo, `toString`. Test: `ProdottoTest`.

## Parte B – Classe `GestoreMagazzino` (50 min)
Completa in [src/GestoreMagazzino.java](src/GestoreMagazzino.java): costruttore, `getNumProdotti`, `aggiungi`, `cerca(codice)`, `cerca(min, max)` (overloading), `carica`, `scarica`, `rimuovi`. Test: `GestoreMagazzinoTest`.

## Parte C – Statistiche e App (40 min)
`valoreTotale`, `piuCostoso`, `contaSottoScorta`, `nomiProdotti`, `toString` del gestore, poi il menu in [src/App.java](src/App.java) (Scanner, `do-while`, `switch`). Il menu in `App` non è testato da JUnit.

## Eseguire i test da VS Code
1. Apri la vista **Testing** (icona a forma di provetta nella barra laterale sinistra).
2. Espandi l'elenco: trovi `ProdottoTest` e `GestoreMagazzinoTest` con tutti i test.
3. Premi il pulsante ▶ accanto a un singolo test, a una classe o in cima per eseguirli tutti.
4. Un test fallito mostra una ✗ rossa: cliccalo per leggere il messaggio (valore atteso e ottenuto).

In alternativa, accanto a ogni `@Test` nel codice c'è il pulsante ▶ **Run Test**.

Se i test non compaiono, esegui da palette comandi (`Ctrl+Shift+P`) **Java: Clean Java Language Server Workspace** e riavvia VS Code.

> Docente: la cartella `soluzione/` contiene la soluzione di riferimento (non distribuirla) e passa tutti i 30 test.
