/**
 * Giocatore
 */
public class Giocatore {
    private String nome;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
