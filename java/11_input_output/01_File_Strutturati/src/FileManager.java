import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

    private String filename = "persone.dat";

    public void save(ArrayList<Persona> lista) {
        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream fOut = new ObjectOutputStream(f);
            for (Persona persona : lista) {
                fOut.writeObject(persona);
            }
            fOut.flush();
            f.close();
            System.out.println("Oggetto salvato con successo");
        } catch (Exception e) {
            System.err.println("Eccezione: " + e.getMessage());
        }
    }

    public void read() {
        Persona p;
        try {
            FileInputStream f = new FileInputStream(filename);
            ObjectInputStream fIn = new ObjectInputStream(f);

            while (true) {
                try {
                    p = (Persona) fIn.readObject();
                    System.out.println(p);
                } catch (Exception e) {
                    // Se viene generata un'eccezione, non ci sono più dati da leggere
                    break;
                }
            }
            f.close();
        } catch (Exception e) {
            System.err.println("Impossibile aprire il file: " + e.getMessage());
        }
    }

}
