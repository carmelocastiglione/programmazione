public class Prodotto {
    private String codice;
    private String nome;
    private double prezzo;
    private int quantita;

    public Prodotto(String codice, String nome, double prezzo, int quantita) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public Prodotto(String codice, String nome, double prezzo) {
        this(codice, nome, prezzo, 0);
    }

    public String getCodice() { return codice; }
    public String getNome() { return nome; }
    public double getPrezzo() { return prezzo; }
    public int getQuantita() { return quantita; }

    public void setPrezzo(double prezzo) {
        if (prezzo > 0) this.prezzo = prezzo;
    }

    public void setQuantita(int quantita) {
        if (quantita >= 0) this.quantita = quantita;
    }

    @Override
    public String toString() {
        return "[" + codice + "] " + nome + " | prezzo: " + prezzo + " | quantita: " + quantita;
    }
}
