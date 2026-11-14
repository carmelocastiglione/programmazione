# Verifica: piattaforma e-learning

Realizza una piattaforma per gestire docenti, corsi, studenti e voti. Usa **array
a dimensione fissa**, non `ArrayList`. Tempo indicativo: 2 ore.

## Come svolgere l'esercizio

1. Apri questa cartella come progetto separato in VS Code.
2. In `src/` trovi le classi con firme e metodi da completare. Dichiara tu gli
   attributi indicati sotto e sostituisci ogni
   `throw new UnsupportedOperationException("Da completare")` con il codice
   richiesto; nei costruttori delle sottoclassi mantieni la chiamata a `super(...)`.
   L'interfaccia `Partecipante` e le eccezioni personalizzate sono già fornite.
3. Mantieni i nomi, i parametri, i tipi di ritorno e le eccezioni dichiarate:
   i test li utilizzano. Puoi aggiungere metodi di supporto e altri attributi.
4. Esegui i test durante lo svolgimento senza modificarli. All'inizio falliscono
   perché le implementazioni mancano. Completa anche `App`: il menu non è
   verificato dai test automatici.

## Requisiti

### Attributi da dichiarare

Dichiara questi attributi come privati nelle rispettive classi e inizializzali
nei costruttori. Le sottoclassi ereditano gli attributi di `Persona`, senza
ridichiararli. Puoi definire anche costanti per le capacità degli array.

| Classe | Attributi richiesti |
| --- | --- |
| `Persona` | `nome`, `cognome`, `email`: `String` |
| `Docente` | `specializzazione`: `String`; `corsiTenuti`: `Corso[]` di 5 elementi; `numCorsi`: `int` |
| `Studente` | `matricola`: `String`; `voti`: `int[]` di 50 elementi; `numVoti`: `int`; `corsiIscritti`: `Corso[]` di 10 elementi; `numCorsi`: `int` |
| `Corso` | `codice`, `nome`, `descrizione`: `String`; `docente`: `Docente`; `studenti`: `Studente[]` di 30 elementi; `numStudenti`: `int` |
| `GestorePiattaforma` | `corsi`: `Corso[]` di 100 elementi; `numCorsi`: `int`; `studenti`: `Studente[]` di 1000 elementi; `numStudenti`: `int`; `docenti`: `Docente[]` di 100 elementi; `numDocenti`: `int` |

I contatori indicano il numero di elementi effettivamente presenti, non la
capacità degli array; all'inizio valgono zero.

### Persona, Docente e Studente

- `Persona`: memorizza nome, cognome ed email. Costruttore e `setEmail`
  rifiutano `null` o email senza `@` con `EmailNonValidaException`. Fornisci
  getter, setter, `toString()` e il metodo astratto `getTipo()`.
- `Docente`: restituisce `"Docente"` come tipo e memorizza specializzazione e
  fino a 5 corsi tenuti. `aggiungiCorso`, `getCorsiTenuti` e `getNumCorsi`
  gestiscono l'elenco.
- `Studente`: restituisce `"Studente"` come tipo, memorizza la matricola,
  fino a 50 voti e fino a 10 corsi. `valuta` accetta voti da 0 a 30 inclusi;
  per voto non valido o limite raggiunto lancia `VotoNonValidoException`.
  `getMedia` restituisce la media aritmetica oppure 0 senza voti.
- `iscrivi` impedisce iscrizioni duplicate per codice del corso con
  `StudenteGiaIscrittoException`, usa la stessa eccezione al limite di 10 corsi e registra
  lo studente anche nel corso. Se il corso è pieno propaga
  `CapacitaCorsoEsceduriException` senza aggiungere il corso allo studente.
- I getter degli array restituiscono copie contenenti solo gli elementi presenti,
  non l'intero array con le posizioni vuote.

### Corso e GestorePiattaforma

- `Corso`: conserva codice, nome, docente, descrizione e fino a 30 studenti.
  Alla creazione aggiunge il corso ai corsi tenuti dal docente.
  `getCapacita()` restituisce 30; `iscrittiStudente` aggiunge uno studente o
  lancia `CapacitaCorsoEsceduriException` se pieno. `cercaStudente` e
  `rimuoviStudente` cercano per matricola e lanciano
  `CorsoNonTrovatoException` se non trovano lo studente.
- `GestorePiattaforma`: gestisce al massimo 100 corsi, 1000 studenti e
  100 docenti. Implementa aggiunta, ricerca, conteggi e copie degli elenchi.
  `cercaCorso` e `cercaStudente` lanciano `CorsoNonTrovatoException` se
  l'elemento non esiste.
- `mediaCorso` è la media delle medie degli studenti iscritti, oppure 0 se
  il corso è vuoto; lancia `CorsoNonTrovatoException` se il corso non esiste.
  `studenteConMediaMigliore` restituisce lo studente con media più alta e
  lancia la stessa eccezione se non ci sono studenti con media positiva.
- Implementa `toString()` per descrivere gli oggetti; quello del gestore
  include `PIATTAFORMA E-LEARNING` e i conteggi, ad esempio `Docenti: 1`.

### App

Con `Scanner` e un ciclo `do-while`, realizza un menu per aggiungere docenti,
corsi e studenti, iscrivere uno studente, registrare un voto, visualizzare
statistiche e stampare la piattaforma. Gestisci le eccezioni mostrando messaggi
chiari e prevedi l'uscita dal menu.

## Eseguire i test

Servono un JDK 17 o successivo e JUnit Platform Console Standalone 6.1.3.
Il JAR deve trovarsi in `lib/junit-platform-console-standalone-6.1.3.jar`;
se manca, scaricalo da
[Maven Central](https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-console-standalone/6.1.3/junit-platform-console-standalone-6.1.3.jar)
e mettilo in `lib/`. Il JAR e i file compilati sono esclusi da Git.

In VS Code, con **Extension Pack for Java**, apri la vista **Testing** e avvia
`PersonaTest`, `DocenteTest`, `StudenteTest`, `CorsoTest` e
`GestorePiattaformaTest`. Un test rosso indica un errore: aprilo per leggere
il dettaglio. Assicurati che solo `src/` sia configurata come cartella sorgente,
non `soluzione/`.

In alternativa, da PowerShell **in questa cartella**:

```powershell
New-Item -ItemType Directory -Force build | Out-Null
$jar = "lib\junit-platform-console-standalone-6.1.3.jar"
$sorgenti = @(Get-ChildItem src\*.java | ForEach-Object { $_.FullName })
javac -encoding UTF-8 -cp $jar -d build $sorgenti
if ($LASTEXITCODE -eq 0) {
    java -jar $jar execute --class-path build --scan-class-path --fail-if-no-tests
}
```

Il successo dei test non verifica il menu interattivo: prova anche `App`
manualmente dopo averlo completato, usando `java -cp build App` dopo la
compilazione oppure il pulsante **Run** di VS Code.

> Per il docente: `soluzione/` contiene i sorgenti originali di riferimento.
> Non distribuirla agli studenti e non compilarla insieme a `src/`, perché
> contiene classi con gli stessi nomi. Non distribuire neanche i file compilati
> preesistenti nelle cartelle `bin/` o `build/`.
