public class Voto {
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
    public String writeToFile() {
        return tipo + "," + voto + ";";
    }

}
