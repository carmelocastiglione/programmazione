/**
 * Giocatore
 */
public class Giocatore extends Dipendente {

    public Giocatore(String nome) {
        super(nome);
    }

    @Override
    public double calcolaStipendio() {
        // Restituisce lo stipendio del giocatore
        return getStipendio() * 1.8;
    }
    
}
