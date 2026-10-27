/**
 * Dipendente
 */

// Classe astratta che rappresenta un dipendente generico
// Le classi astratte possono avere un costruttore e metodi concreti, ma non possono essere istanziate direttamente
public abstract class Dipendente {
    private String nome;
    private double stipendio = 1000;

    public Dipendente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public double getStipendio() {
        return this.stipendio;
    }

    // Metodo astratto che deve essere implementato dalle sottoclassi
    public abstract double calcolaStipendio();
}
