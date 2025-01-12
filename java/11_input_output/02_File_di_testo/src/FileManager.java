import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    private String filename = "persone.txt";

    public void save(ArrayList<Persona> lista) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for (Persona persona : lista) {
                pw.println(persona.writeToFile());
            }
            pw.flush();
            fw.close();
            System.out.println("Oggetto salvato con successo");
        } catch (Exception e) {
            System.err.println("Eccezione: " + e.getMessage());
        }
    }

    public void read() {
        Persona p;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        break;
                    }
                    String[] dati = s.split(";");
                    p = new Persona(dati[0], Integer.parseInt(dati[1]));
                    for (int i = 2; i < dati.length; i++) {
                        String[] voto = dati[i].split(",");
                        p.aggiungiVoto(voto[0], Integer.parseInt(voto[1]));
                    }
                    System.out.println(p);
                } catch (Exception e) {
                    // Se viene generata un'eccezione, non ci sono più dati da leggere
                    break;
                }
            }
            fr.close();
        } catch (Exception e) {
            System.err.println("Impossibile aprire il file: " + e.getMessage());
        }
    }

}
