/**
 * Classe che rappresenta uno Studente.
 * Estende Persona e implementa Partecipante.
 */
public class Studente extends Persona implements Partecipante {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore dello studente.
     * @param nome Nome dello studente
     * @param cognome Cognome dello studente
     * @param email Email dello studente
     * @param matricola Matricola dello studente
     * @throws EmailNonValidaException se email non è valida
     */
    public Studente(String nome, String cognome, String email, String matricola) 
            throws EmailNonValidaException {
        super(nome, cognome, email);
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public String getTipo() {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getMatricola() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public void iscrivi(Corso c) throws StudenteGiaIscrittoException, CapacitaCorsoEsauritaException {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public void valuta(int voto) throws VotoNonValidoException {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public int[] getVoti() {
        throw new UnsupportedOperationException("Da completare");
    }

    @Override
    public double getMedia() {
        throw new UnsupportedOperationException("Da completare");
    }

    public Corso[] getCorsiIscritti() {
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
