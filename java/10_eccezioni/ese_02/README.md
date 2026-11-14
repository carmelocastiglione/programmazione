# Verifica: gestione dipendenti aziendali

Realizza un programma per gestire dipendenti, stipendi e dipartimenti. Usa
**array a dimensione fissa**, non `ArrayList`. Tempo indicativo: 2 ore.

## Come svolgere l'esercizio

1. Apri questa cartella come progetto separato in VS Code.
2. In `src/` trovi le classi con firme e metodi da completare. Dichiara tu gli
   attributi indicati sotto e sostituisci ogni
   `throw new UnsupportedOperationException("Da completare")` con il codice
   richiesto; nei costruttori delle sottoclassi mantieni la chiamata a `super(...)`.
   L'interfaccia `Calcolabile` e le eccezioni personalizzate sono già fornite.
3. Mantieni i nomi, i parametri, i tipi di ritorno e le eccezioni dichiarate:
   i test li utilizzano. Puoi aggiungere metodi di supporto e altri attributi.
4. Esegui i test durante lo svolgimento senza modificarli. All'inizio falliscono
   perché le implementazioni mancano. Completa anche `App`: il menu non è
   verificato dai test automatici.

## Requisiti

### Attributi da dichiarare

Dichiara questi attributi come privati nelle rispettive classi e inizializzali
nei costruttori. Le sottoclassi ereditano gli attributi di `Dipendente`, senza
ridichiararli. Puoi definire anche una costante per la capacità dell'array.

| Classe | Attributi richiesti |
| --- | --- |
| `Dipendente` | `nome`, `cognome`, `matricola`: `String`; `stipendioBase`: `double` |
| `Operaio` | `oreSettimanali`: `int`; `costoOrario`: `double` |
| `Impiegato` | `ral`, `bonus`: `double` |
| `Dirigente` | `presenze`: `int`; `percentualeBonusAnnuale`: `double` |
| `Dipartimento` | `nome`: `String`; `budget`: `double`; `dipendenti`: `Dipendente[]` di 100 elementi; `numDipendenti`: `int` |

`numDipendenti` indica il numero di elementi effettivamente presenti, non la
capacità dell'array; all'inizio vale zero.

### Dipendente e sottoclassi

- `Dipendente` è astratta e conserva nome, cognome, matricola e stipendio base.
  Costruttore e `setStipendioBase` rifiutano valori minori o uguali a zero con
  `StipendioNegativoException`. Completa getter, setter e `toString()`, oltre
  ai metodi astratti già dichiarati.
- `Operaio` conserva ore settimanali e costo orario. Costruttore e
  `setOreSettimanali` accettano da 1 a 40 ore, altrimenti lanciano
  `OreNonValidaException`. Per questo esercizio lo stipendio è
  `(stipendioBase / 160) * oreSettimanali`; il costo orario è memorizzato,
  ma non entra nella formula. Le tasse sono il 20% dello stipendio.
- `Impiegato` conserva RAL e bonus. Lo stipendio è `RAL / 12 + bonus` e le
  tasse sono il 23%. `setBonus` rifiuta bonus negativi con
  `StipendioNegativoException`.
- `Dirigente` conserva presenze e percentuale di bonus annuale. Costruttore e
  `setPresenze` accettano da 1 a 20 giorni, altrimenti lanciano
  `OreNonValidaException`. Lo stipendio mensile è
  `stipendioBase * 1.5 + (stipendioBase * percentualeBonusAnnuale / 100) / 12`;
  le tasse sono il 30%. La percentuale rappresenta un bonus annuale.
- Ogni sottoclasse restituisce il proprio nome (`"Operaio"`, `"Impiegato"` o
  `"Dirigente"`) da `getTipo()` e implementa `Calcolabile`: il netto è lo
  stipendio meno le tasse. Completa anche getter, setter e `toString()`.

### Dipartimento

- Memorizza nome, budget e fino a 100 dipendenti. `aggiungiDipendente` rifiuta
  matricole duplicate con `MatricolaGiaEsisteException` e, se pieno, lancia
  `CapacitaDipartimentoEsauritaException`.
- `cercaDipendente` e `removiDipendente` cercano per matricola e lanciano
  `DipendenteNonTrovatoException` se non trovano il dipendente.
  `getDipendenti` restituisce una copia con i soli elementi presenti.
- `stipendioMediaDipartimento`, `costiDipartimento` e
  `getDipendentePiuPagato` usano gli stipendi calcolati e lanciano
  `DipendenteNonTrovatoException` se il dipartimento è vuoto.
- `operaiDipartimento`, `impiegatiDipartimento` e `dirigentiDipartimento`
  contano i dipendenti per tipo. `toString()` descrive il dipartimento e include
  il conteggio nel formato `Dipendenti totali: 1`.

### App

Con `Scanner` e un ciclo `do-while`, realizza un menu per creare un dipartimento,
aggiungere dipendenti dei tre tipi, cercare un dipendente, visualizzare
statistiche e stampare il dipartimento. Gestisci le eccezioni mostrando messaggi
chiari e prevedi l'uscita dal menu.

## Eseguire i test

Servono un JDK 17 o successivo e JUnit Platform Console Standalone 6.1.3.
Il JAR deve trovarsi in `lib/junit-platform-console-standalone-6.1.3.jar`;
se manca, scaricalo da
[Maven Central](https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-console-standalone/6.1.3/junit-platform-console-standalone-6.1.3.jar)
e mettilo in `lib/`. Il JAR e i file compilati sono esclusi da Git.

In VS Code, con **Extension Pack for Java**, apri la vista **Testing** e avvia
`OperaioTest`, `ImpiegatoTest`, `DirigenteTest` e `DipartimentoTest`. Un test
rosso indica un errore: aprilo per leggere il dettaglio. Assicurati che solo
`src/` sia configurata come cartella sorgente, non `soluzione/`.

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
