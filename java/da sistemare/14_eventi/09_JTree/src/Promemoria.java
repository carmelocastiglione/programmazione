
public class Promemoria {

    private String titolo;
    private String testo;   
    private String categoria;
    private boolean importante;

    public Promemoria(String titolo, String testo, String categoria, boolean importante) {
        this.titolo = titolo;
        this.testo = testo;
        this.categoria = categoria;
        this.importante = importante;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }

    @Override
    public String toString() {
        return titolo;
    }

}
