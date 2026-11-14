/**
 * Interfaccia per il calcolo dello stipendio e delle tasse.
 */
public interface Calcolabile {
    /**
     * Calcola lo stipendio del dipendente.
     * @return Lo stipendio
     */
    double calcolaStipendio();

    /**
     * Calcola le tasse sul dipendente.
     * @return Le tasse calcolate
     */
    double calcolaTasse();

    /**
     * Calcola lo stipendio netto (stipendio - tasse).
     * @return Lo stipendio netto
     */
    double getNettoStipendio();
}
