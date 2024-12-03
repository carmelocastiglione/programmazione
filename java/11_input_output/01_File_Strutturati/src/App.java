import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Persona p1, p2, p3;
        ArrayList<Persona> lista = new ArrayList<Persona>();
        FileManager fm = new FileManager();

        p1 = new Persona("Mario", 31);
        p2 = new Persona("Anna", 25);
        p3 = new Persona("Luigi", 57);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        fm.save(lista);
        fm.read();
    }
}
