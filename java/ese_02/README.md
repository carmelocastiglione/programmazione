# Esercizio: Gestore Parcheggio (2 ore)

Non usare `ArrayList`: solo vettori.

## Parte A – Classe `Veicolo` (30 min)
Completa [src/Veicolo.java](src/Veicolo.java): attributi privati, due costruttori (overloading), getter, setter con controllo e `toString`. Test: `VeicoloTest`.

## Parte B – Classe `GestoreParcheggio` (50 min)
Completa in [src/GestoreParcheggio.java](src/GestoreParcheggio.java): costruttore, `getNumVeicoli`, `parcheggia`, `cerca(targa)`, `cerca(min, max)` (overloading) e `uscita`. Test: `GestoreParcheggioTest`.

## Parte C – Statistiche e App (40 min)
Implementa `incassoTotale`, `veicoloPiuCostoso`, `contaSottoTariffa`, `targheParcheggiate`, `toString` del gestore e poi il menu in [src/App.java](src/App.java) (`Scanner`, `do-while`, `switch`). Il menu in `App` non è testato da JUnit.

### Regole
- `Veicolo`: targa e modello sono stringhe; tariffa oraria è un `double`. Il costruttore senza tariffa applica la tariffa standard di 2.0 euro all'ora.
- La tariffa può essere impostata solo se maggiore di 0; un valore non valido non modifica il veicolo.
- Il parcheggio ha capacità fissa. Non si possono parcheggiare veicoli con targa già presente o quando è pieno.
- La ricerca per targa considera i veicoli attualmente parcheggiati e restituisce `null` se non trova la targa. La ricerca per fascia di tariffa include gli estremi e restituisce un vettore della dimensione esatta (vuoto se non trova veicoli).
- `uscita(targa, ore)` registra l'uscita del veicolo, aggiunge all'incasso il costo (`tariffa oraria * ore`) e libera il posto. Restituisce `false` se la targa non è presente o se `ore <= 0`; in caso di errore non modifica parcheggio o incasso.
- `veicoloPiuCostoso` restituisce il veicolo con la tariffa oraria più alta tra quelli parcheggiati (`null` se il parcheggio è vuoto).
- `contaSottoTariffa(soglia)` conta i veicoli parcheggiati con tariffa strettamente minore della soglia. `targheParcheggiate` restituisce le targhe nello stesso ordine.
- `toString` del gestore restituisce una riga per veicolo, terminata da `\n`, usando il formato di `Veicolo.toString()`.

## Eseguire i test da VS Code
1. Apri la vista **Testing** (icona a forma di provetta nella barra laterale sinistra).
2. Espandi l'elenco: trovi `VeicoloTest` e `GestoreParcheggioTest` con i relativi test.
3. Premi il pulsante ▶ accanto a un singolo test, a una classe o in cima per eseguirli tutti.
4. Un test fallito mostra una ✗ rossa: cliccalo per leggere il messaggio (valore atteso e ottenuto).

In alternativa, accanto a ogni `@Test` nel codice c'è il pulsante ▶ **Run Test**.

Se i test non compaiono, esegui dalla palette comandi (`Ctrl+Shift+P`) **Java: Clean Java Language Server Workspace** e riavvia VS Code.

> Docente: la cartella `soluzione/` contiene la soluzione di riferimento (non distribuirla).
