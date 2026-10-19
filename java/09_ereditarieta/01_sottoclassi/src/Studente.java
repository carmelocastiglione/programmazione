/**
 * Studente
 */
public class Studente {
    private String nome;
    private String cognome;
    private String scuola;

    public Studente(String nome, String cognome, String scuola) {
        this.nome = nome;
        this.cognome = cognome;
        this.scuola = scuola;
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

    // qui utilizzo super per richiamare un metodo della superclasse
    @Override
    public String toString() {
        return "Studente: " + nome + " " + cognome + ", Scuola: " + scuola;
    }
    
}
