import java.util.Vector;

public class Poligono {

    private Vector<Punto> poligono;

    public Poligono() {
        poligono = new Vector<Punto>(1,1);
    }

    public void aggiungi(Punto p) {
        poligono.addElement(p);
    }

    public void stampa() {
        Punto p;
        System.out.println("Elenco punti");
        for (int i = 0; i < poligono.size(); i++) {
            p = (Punto) poligono.elementAt(i);
            System.out.println(p);
        }
    }

    public void togli(int i) {
        if ((i >= 0) && (i < poligono.size())) {
            poligono.removeElementAt(i);
        }
    }
}
