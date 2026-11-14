/**
 * Classe astratta che rappresenta una Persona (Studente o Docente).
 * Attributi comuni: nome, cognome, email.
 */
public abstract class Persona {
    // TODO: dichiara gli attributi richiesti nel README.

    /**
     * Costruttore della persona.
     * @param nome Nome della persona
     * @param cognome Cognome della persona
     * @param email Email della persona (deve contenere @)
     * @throws EmailNonValidaException se email non è valida
     */
    public Persona(String nome, String cognome, String email) throws EmailNonValidaException {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getNome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setNome(String nome) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getCognome() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setCognome(String cognome) {
        throw new UnsupportedOperationException("Da completare");
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Da completare");
    }

    public void setEmail(String email) throws EmailNonValidaException {
        throw new UnsupportedOperationException("Da completare");
    }

    /**
     * Metodo astratto che restituisce il tipo di persona.
     * @return "Studente" o "Docente"
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Da completare");
    }
}
