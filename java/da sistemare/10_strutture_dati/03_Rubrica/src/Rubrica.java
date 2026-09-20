import java.util.Vector;

public class Rubrica {

    Vector<Voce> elenco;

    public Rubrica() {
        elenco = new Vector<Voce>(1,1); 
    }

    public void aggiungiVoce(Voce voce) {
        elenco.addElement(voce);
    }

    public void eliminaVoce(int indice) {
        try {
            elenco.removeElementAt(indice);
        } catch (Exception e) {
            System.err.println("Errore eliminazione elemento");
            return;
        }
        System.out.println("Elemento eliminato correttamente");
    }

    public void visualizza() {
        Voce v;
        System.out.println("---------");
        System.err.println(" Rubrica");
        System.out.println("---------");
        for (int i = 0; i < elenco.size(); i++) {
            System.out.print("Posizione: " + i + " -> ");
            v = (Voce) elenco.elementAt(i);
            v.stampa();
        }
    }

}
