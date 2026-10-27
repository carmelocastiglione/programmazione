/**
 * Preparatore
 */
public class Preparatore extends Staff {

    public Preparatore(String nome) {
        super(nome);
    }

    @Override
    public double calcolaStipendio() {
        // Restituisce lo stipendio del preparatore
        return getStipendio() * 1.5;
    }

}
