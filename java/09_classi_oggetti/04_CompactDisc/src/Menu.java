import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private InputStreamReader input = new InputStreamReader(System.in);
    private BufferedReader tastiera = new BufferedReader(input);
    private final int MAX_CD = 10;
    private CompactDisc[] cd = new CompactDisc[MAX_CD];

    public void mostra() {
        System.out.println("                                      _         _ _         ");
        System.out.println("                                     | |       | (_)         ");
        System.out.println("  ___ ___  _ __ ___  _ __   __ _  ___| |_    __| |_ ___  ___");
        System.out.println("/ __/ _ \\| '_ ` _ \\| '_ \\ / _` |/ __| __|  / _` | / __|/ __|");
        System.out.println("| (_| (_) | | | | | | |_) | (_| | (__| |_  | (_| | \\__ \\ (__ ");
        System.out.println(" \\___\\___/|_| |_| |_| .__/ \\__,_|\\___|\\__|  \\__,_|_|___/\\___|");
        System.out.println("                    | |                                      ");
        System.out.println("                    |_|                                      ");
        System.out.println();
        System.out.println("1) Inserisci tutte le tracce");
        System.out.println("2) Visualizza tracce");
        System.out.println("3) Modifica il titolo di una traccia");
        System.out.println("4) Modifica la durata di una traccia");
        System.out.println("5) Cerca il titolo di una traccia");
        System.out.println("0) Esci");                          

    }

    public int scelta() throws NumberFormatException, IOException {
        return Integer.valueOf(tastiera.readLine());
    }

    public void inserisci() throws IOException {
        for (int i = 0; i < cd.length; i++) {
            System.out.println("### Canzone " + (i+1) + " ###");
            System.out.print("Titolo: ");
            String titolo = tastiera.readLine();
            System.out.print("Durata: ");
            int durata = Integer.valueOf(tastiera.readLine());
            cd[i] = new CompactDisc(titolo, durata);
        }
    }

    public void visualizza() {
        for (int i = 0; i < cd.length; i++) {
            CompactDisc canzone = cd[i];
            if (canzone != null) {
                System.out.println("#" + (i+1) + " - " + canzone.getTitolo() + " (" + canzone.getDurata() + ")");
            }
        }
    }

    public void modificaTitolo() throws IOException {
        visualizza();
        System.out.print("Inserisci il numero della traccia da modificare: ");
        int traccia = Integer.valueOf(tastiera.readLine());
        System.out.print("Inserisci il nuovo titolo: ");
        String titolo = tastiera.readLine();
        cd[traccia-1].setTitolo(titolo);
    }

    public void modificaDurata() throws IOException {
        visualizza();
        System.out.print("Inserisci il numero della traccia da modificare: ");
        int traccia = Integer.valueOf(tastiera.readLine());
        System.out.print("Inserisci la nuova durata: ");
        int durata = Integer.valueOf(tastiera.readLine());
        cd[traccia-1].setDurata(durata);
    }

    public void cerca() throws IOException {
        visualizza();
        System.out.print("Inserisci il titolo della traccia da cercare: ");
        String titolo = tastiera.readLine();
        for (int i = 0; i < cd.length; i++) {
            CompactDisc canzone = cd[i];
            if (titolo.equals(canzone.getTitolo())) {
                System.out.println("La canzone " + canzone.getTitolo() + " ha una durata di " + canzone.getDurata() + " secondi");
                break;
            }
        }
        System.out.println("Canzone non trovata");
    }

}
