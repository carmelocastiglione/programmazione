/**
 * Classe che rappresenta un Corso.
 */
public class Corso {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore del corso.
     * @param codice Codice univoco del corso
     * @param nome Nome del corso
     * @param docente Docente che tiene il corso
     * @param descrizione Descrizione del corso
     */
    public Corso(String codice, String nome, Docente docente, String descrizione) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getCodice() {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public Docente getDocente() {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getDescrizione() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumStudenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getCapacita() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Cerca uno studente nel corso per matricola.
     * @param matricola Matricola dello studente
     * @return Lo studente se trovato
     * @throws CorsoNonTrovatoException se lo studente non è trovato
     */
    public Studente cercaStudente(String matricola) throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Iscrive uno studente al corso.
     * @param s Studente da iscrivere
     * @throws CapacitaCorsoEsceduriException se il corso è pieno
     */
    public void iscrittiStudente(Studente s) throws CapacitaCorsoEsceduriException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Rimuove uno studente dal corso.
     * @param matricola Matricola dello studente da rimuovere
     * @throws CorsoNonTrovatoException se lo studente non è trovato
     */
    public void rimuoviStudente(String matricola) throws CorsoNonTrovatoException {
        throw new UnsupportedOperationException("Da completare");
    }

    public Studente[] getStudenti() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
