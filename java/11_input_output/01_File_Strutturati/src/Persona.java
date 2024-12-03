import java.io.Serializable;

public class Persona implements Serializable {
    private String nome;
    private Integer eta;

    public Persona(String nome, Integer eta) {
        this.nome = nome;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", eta=" + eta + "]";
    }
}
