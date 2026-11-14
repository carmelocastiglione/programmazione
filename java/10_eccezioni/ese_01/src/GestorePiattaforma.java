/**
 * Classe che gestisce l'intera piattaforma e-learning.
 * Contiene collezioni di corsi, studenti e docenti.
 */
public class GestorePiattaforma {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore del gestore piattaforma.
     */
    public GestorePiattaforma() {
        throw new UnsupportedOperationException("Da completare");
    }

    // ========== METODI CORSI ==========

    /**
     * Aggiunge un corso alla piattaforma.
     * @param c Corso da aggiungere
     */
    public void aggiungiCorso(Corso c) {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Cerca un corso per codice.
     * @param codice Codice del corso
     * @return Il corso se trovato
     * @throws CorsoNonTrovatoException se il corso non è trovato
     */
    public Corso cercaCorso(String codice) throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    public Corso[] getCorsi() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumCorsi() {
        throw new UnsupportedOperationException("Da completare");
    }

    // ========== METODI STUDENTI ==========

    /**
     * Aggiunge uno studente alla piattaforma.
     * @param s Studente da aggiungere
     */
    public void aggiungiStudente(Studente s) {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Cerca uno studente per matricola.
     * @param matricola Matricola dello studente
     * @return Lo studente se trovato
     * @throws CorsoNonTrovatoException se lo studente non è trovato
     */
    public Studente cercaStudente(String matricola) throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    public Studente[] getStudenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumStudenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    // ========== METODI DOCENTI ==========

    /**
     * Aggiunge un docente alla piattaforma.
     * @param d Docente da aggiungere
     */
    public void aggiungiDocente(Docente d) {
        throw new UnsupportedOperationException("Da completare");
    }

    public Docente[] getDocenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumDocenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    // ========== METODI STATISTICHE ==========

    /**
     * Trova lo studente con la media più alta.
     * @return Lo studente con la media migliore
     * @throws CorsoNonTrovatoException se nessuno studente ha voti
     */
    public Studente studenteConMediaMigliore() throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Calcola la media di un corso.
     * @param codiceCorso Codice del corso
     * @return Media di tutti gli studenti del corso
     * @throws CorsoNonTrovatoException se il corso non è trovato
     */
    public double mediaCorso(String codiceCorso) throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
