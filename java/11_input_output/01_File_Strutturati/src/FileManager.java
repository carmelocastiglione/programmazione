import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

    private String filename = "persone.dat";

    public void save(ArrayList<Persona> lista) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Persona persona : lista) {
                oos.writeObject(persona);
            }
            oos.flush();
            fos.close();
            System.out.println("Oggetto salvato con successo");
        } catch (Exception e) {
            System.err.println("Eccezione: " + e.getMessage());
        }
    }

    public void read() {
        Persona p;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    p = (Persona) ois.readObject();
                    System.out.println(p);
                } catch (Exception e) {
                    // Se viene generata un'eccezione, non ci sono più dati da leggere
                    break;
                }
            }
            fis.close();
        } catch (Exception e) {
            System.err.println("Impossibile aprire il file: " + e.getMessage());
        }
    }

}
