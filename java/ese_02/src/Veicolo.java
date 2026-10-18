/**
 * Un veicolo che può essere parcheggiato.
 * Attributi: targa (String), modello (String), tariffaOraria (double).
 */
public class Veicolo {

    // TODO: dichiara gli attributi privati

    /** Costruttore completo. */
    public Veicolo(String targa, String modello, double tariffaOraria) {
        // TODO
    }

    /** Costruttore (overloading): applica la tariffa standard di 2.0 euro all'ora. */
    public Veicolo(String targa, String modello) {
        // TODO
    }

    public String getTarga() {
        return null; // TODO
    }

    public String getModello() {
        return null; // TODO
    }

    public double getTariffaOraria() {
        return 0; // TODO
    }

    /** Imposta la tariffa solo se è maggiore di 0, altrimenti non modifica nulla. */
    public void setTariffaOraria(double tariffaOraria) {
        // TODO
    }

    /**
     * Formato richiesto (esempio): [AB123CD] Fiat Panda | tariffa oraria: 2.0
     */
    @Override
    public String toString() {
        return null; // TODO
    }
}
