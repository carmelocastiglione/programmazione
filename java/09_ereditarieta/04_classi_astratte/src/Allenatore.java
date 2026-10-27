/**
 * Allenatore
 */
public class Allenatore extends Staff {

    private double stipendio = 2000;

    public Allenatore(String nome) {
        super(nome);
    }

    @Override
    public double calcolaStipendio() {
        // Restituisce lo stipendio dell'allenatore
        return this.stipendio * 2.0;
    }

}
