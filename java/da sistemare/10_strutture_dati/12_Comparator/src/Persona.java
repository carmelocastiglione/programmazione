
public class Persona implements Comparable<Persona> {
    private String nome;
    private String cognome;
    private Integer eta;

    public Persona(String nome, String cognome, Integer eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\tCognome: " + cognome + "\tEtà: " + eta;
    }

    @Override
    public int compareTo(Persona other) {
        int i;
        i = nome.compareTo(other.nome);
        if (i != 0) return i;

        i = cognome.compareTo(other.cognome);
        if (i != 0) return i;

        return eta.compareTo(other.eta);
    }
    
}
