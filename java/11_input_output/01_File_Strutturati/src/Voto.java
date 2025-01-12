import java.io.Serializable;

public class Voto implements Serializable {
    private String tipo;
    private int voto;
    public Voto(String t, int v) {
        this.tipo = t;
        this.voto = v;
    }
    @Override
    public String toString() {
        return "Voto [tipo=" + tipo + ", voto=" + voto + "]";
    }

}
