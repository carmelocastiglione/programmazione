/**
 * Classe astratta che rappresenta una Persona (Studente o Docente).
 * Attributi comuni: nome, cognome, email.
 */
public abstract class Persona {
    private String nome;
    private String cognome;
    private String email;

    /**
     * Costruttore della persona.
     * @param nome Nome della persona
     * @param cognome Cognome della persona
     * @param email Email della persona (deve contenere @)
     * @throws EmailNonValidaException se email non è valida
     */
    public Persona(String nome, String cognome, String email) throws EmailNonValidaException {
        if (email == null || !email.contains("@")) {
            throw new EmailNonValidaException("Email non valida: " + email);
        }
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailNonValidaException {
        if (email == null || !email.contains("@")) {
            throw new EmailNonValidaException("Email non valida: " + email);
        }
        this.email = email;
    }

    /**
     * Metodo astratto che restituisce il tipo di persona.
     * @return "Studente" o "Docente"
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " - " + nome + " " + cognome + " (" + email + ")";
    }
}
