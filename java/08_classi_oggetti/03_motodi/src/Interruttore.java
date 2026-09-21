/**
 * Interruttore
 */
public class Interruttore {
    private boolean acceso = false;
    private int luminosita = 100;

    private void setAcceso(boolean valore) {
        acceso = valore;
    }

    private void setLuminosita(int valore) {
        luminosita = valore;
    }

    public boolean getAcceso() {
        return acceso;
    }
    
    public int getLuminosita() {
        return luminosita;
    }

    public void accendi() {
        setAcceso(true);
    }

    public void spegni() {
        setAcceso(false);
    }

    public void luminosita(int valore) {
        setLuminosita(valore);
    }
}
