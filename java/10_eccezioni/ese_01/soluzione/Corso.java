/**
 * Classe che rappresenta un Corso.
 */
public class Corso {
    private String codice;
    private String nome;
    private Docente docente;
    private Studente[] studenti;
    private int numStudenti;
    private String descrizione;

    private static final int MAX_STUDENTI = 30;

    /**
     * Costruttore del corso.
     * @param codice Codice univoco del corso
     * @param nome Nome del corso
     * @param docente Docente che tiene il corso
     * @param descrizione Descrizione del corso
     */
    public Corso(String codice, String nome, Docente docente, String descrizione) {
        this.codice = codice;
        this.nome = nome;
        this.docente = docente;
        this.descrizione = descrizione;
        this.studenti = new Studente[MAX_STUDENTI];
        this.numStudenti = 0;
        // Aggiungi il docente ai corsi tenuti
        docente.aggiungiCorso(this);
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public Docente getDocente() {
        return docente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getNumStudenti() {
        return numStudenti;
    }

    public int getCapacita() {
        return MAX_STUDENTI;
    }

    /**
     * Cerca uno studente nel corso per matricola.
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
        throw new CorsoNonTrovatoException("Studente con matricola " + matricola + " non trovato nel corso");
    }

    /**
     * Iscrive uno studente al corso.
     * @param s Studente da iscrivere
     * @throws CapacitaCorsoEsceduriException se il corso è pieno
     */
    public void iscrittiStudente(Studente s) throws CapacitaCorsoEsceduriException {
        if (numStudenti >= MAX_STUDENTI) {
            throw new CapacitaCorsoEsceduriException("Corso " + codice + " è pieno");
        }
        studenti[numStudenti++] = s;
    }

    /**
     * Rimuove uno studente dal corso.
     * @param matricola Matricola dello studente da rimuovere
     * @throws CorsoNonTrovatoException se lo studente non è trovato
     */
    public void rimuoviStudente(String matricola) throws CorsoNonTrovatoException {
        for (int i = 0; i < numStudenti; i++) {
            if (studenti[i].getMatricola().equals(matricola)) {
                // Sposta l'ultimo elemento al posto dell'elemento rimosso
                studenti[i] = studenti[numStudenti - 1];
                studenti[numStudenti - 1] = null;
                numStudenti--;
                return;
            }
        }
        throw new CorsoNonTrovatoException("Studente con matricola " + matricola + " non trovato nel corso");
    }

    public Studente[] getStudenti() {
        Studente[] result = new Studente[numStudenti];
        System.arraycopy(studenti, 0, result, 0, numStudenti);
        return result;
    }

    @Override
    public String toString() {
        return "Corso{" +
                "codice='" + codice + '\'' +
                ", nome='" + nome + '\'' +
                ", docente='" + docente.getNome() + " " + docente.getCognome() + '\'' +
                ", studenti=" + numStudenti + "/" + MAX_STUDENTI +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
