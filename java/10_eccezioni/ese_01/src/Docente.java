/**
 * Classe che rappresenta un Docente.
 * Estende Persona.
 */
public class Docente extends Persona {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore del docente.
     * @param nome Nome del docente
     * @param cognome Cognome del docente
     * @param email Email del docente
     * @param specializzazione Specializzazione del docente
     * @throws EmailNonValidaException se email non è valida
     */
    public Docente(String nome, String cognome, String email, String specializzazione) 
            throws EmailNonValidaException {
        super(nome, cognome, email);
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String getTipo() {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getSpecializzazione() {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Aggiunge un corso tenuto dal docente.
     * @param c Corso da aggiungere
     */
    public void aggiungiCorso(Corso c) {
        throw new UnsupportedOperationException("Da completare");
    }

    public Corso[] getCorsiTenuti() {
        throw new UnsupportedOperationException("Da completare");
    }

    public int getNumCorsi() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
