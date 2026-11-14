/**
 * Classe che gestisce l'intera piattaforma e-learning.
 * Contiene collezioni di corsi, studenti e docenti.
 */
public class GestorePiattaforma {
    private Corso[] corsi;
    private int numCorsi;
    private Studente[] studenti;
    private int numStudenti;
    private Docente[] docenti;
    private int numDocenti;

    private static final int MAX_CORSI = 100;
    private static final int MAX_STUDENTI = 1000;
    private static final int MAX_DOCENTI = 100;

    /**
     * Costruttore del gestore piattaforma.
     */
    public GestorePiattaforma() {
        this.corsi = new Corso[MAX_CORSI];
        this.numCorsi = 0;
        this.studenti = new Studente[MAX_STUDENTI];
        this.numStudenti = 0;
        this.docenti = new Docente[MAX_DOCENTI];
        this.numDocenti = 0;
    }

    // ========== METODI CORSI ==========

    /**
     * Aggiunge un corso alla piattaforma.
     * @param c Corso da aggiungere
     */
    public void aggiungiCorso(Corso c) {
        if (numCorsi < MAX_CORSI) {
            corsi[numCorsi++] = c;
        }
    }

    /**
     * Cerca un corso per codice.
     * @param codice Codice del corso
     * @return Il corso se trovato
     * @throws CorsoNonTrovatoException se il corso non è trovato
     */
    public Corso cercaCorso(String codice) throws CorsoNonTrovatoException {
        for (int i = 0; i < numCorsi; i++) {
            if (corsi[i].getCodice().equals(codice)) {
                return corsi[i];
            }
        }
        throw new CorsoNonTrovatoException("Corso con codice " + codice + " non trovato");
    }

    public Corso[] getCorsi() {
        Corso[] result = new Corso[numCorsi];
        System.arraycopy(corsi, 0, result, 0, numCorsi);
        return result;
    }

    public int getNumCorsi() {
        return numCorsi;
    }

    // ========== METODI STUDENTI ==========

    /**
     * Aggiunge uno studente alla piattaforma.
     * @param s Studente da aggiungere
     */
    public void aggiungiStudente(Studente s) {
        if (numStudenti < MAX_STUDENTI) {
            studenti[numStudenti++] = s;
        }
    }

    /**
     * Cerca uno studente per matricola.
     * @param matricola Matricola dello studente
     * @return Lo studente se trovato
     * @throws CorsoNonTrovatoException se lo studente non è trovato
     */
    public Studente cercaStudente(String matricola) throws CorsoNonTrovatoException {
        for (int i = 0; i < numStudenti; i++) {
            if (studenti[i].getMatricola().equals(matricola)) {
                return studenti[i];
            }
        }
        throw new CorsoNonTrovatoException("Studente con matricola " + matricola + " non trovato");
    }

    public Studente[] getStudenti() {
        Studente[] result = new Studente[numStudenti];
        System.arraycopy(studenti, 0, result, 0, numStudenti);
        return result;
    }

    public int getNumStudenti() {
        return numStudenti;
    }

    // ========== METODI DOCENTI ==========

    /**
     * Aggiunge un docente alla piattaforma.
     * @param d Docente da aggiungere
     */
    public void aggiungiDocente(Docente d) {
        if (numDocenti < MAX_DOCENTI) {
            docenti[numDocenti++] = d;
        }
    }

    public Docente[] getDocenti() {
        Docente[] result = new Docente[numDocenti];
        System.arraycopy(docenti, 0, result, 0, numDocenti);
        return result;
    }

    public int getNumDocenti() {
        return numDocenti;
    }

    // ========== METODI STATISTICHE ==========

    /**
     * Trova lo studente con la media più alta.
     * @return Lo studente con la media migliore
     * @throws CorsoNonTrovatoException se nessuno studente ha voti
     */
    public Studente studenteConMediaMigliore() throws CorsoNonTrovatoException {
        if (numStudenti == 0) {
            throw new CorsoNonTrovatoException("Nessuno studente registrato");
        }
        Studente miglior = null;
        double mediaMigliore = -1;
        for (int i = 0; i < numStudenti; i++) {
            double media = studenti[i].getMedia();
            if (media > mediaMigliore) {
                mediaMigliore = media;
                miglior = studenti[i];
            }
        }
        if (miglior == null || mediaMigliore == 0) {
            throw new CorsoNonTrovatoException("Nessuno studente ha voti registrati");
        }
        return miglior;
    }

    /**
     * Calcola la media di un corso.
     * @param codiceCorso Codice del corso
     * @return Media di tutti gli studenti del corso
     * @throws CorsoNonTrovatoException se il corso non è trovato
     */
    public double mediaCorso(String codiceCorso) throws CorsoNonTrovatoException {
        Corso c = cercaCorso(codiceCorso);
        Studente[] studentiCorso = c.getStudenti();
        if (studentiCorso.length == 0) {
            return 0.0;
        }
        double sommaMedia = 0;
        for (Studente s : studentiCorso) {
            sommaMedia += s.getMedia();
        }
        return sommaMedia / studentiCorso.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PIATTAFORMA E-LEARNING ===\n");
        sb.append("Docenti: ").append(numDocenti).append("\n");
        for (int i = 0; i < numDocenti; i++) {
            sb.append("  - ").append(docenti[i]).append("\n");
        }
        sb.append("Corsi: ").append(numCorsi).append("\n");
        for (int i = 0; i < numCorsi; i++) {
            sb.append("  - ").append(corsi[i]).append("\n");
        }
        sb.append("Studenti: ").append(numStudenti).append("\n");
        for (int i = 0; i < numStudenti; i++) {
            sb.append("  - ").append(studenti[i]).append("\n");
        }
        return sb.toString();
    }
}
