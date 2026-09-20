import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Menu {

    private void mostraMenu() {
        System.out.println();
        System.out.println("1) Aggiungi voce");
        System.out.println("2) Elimina voce");
        System.out.println("3) Visualizza rubrica");
        System.out.println("4) Esci");
    }
    
    public int scelta() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        int scelta;
        mostraMenu();
        System.out.println();
        System.out.print("-> ");
        try {
            String numeroLetto = tastiera.readLine();
            scelta = Integer.valueOf(numeroLetto).intValue();
        } catch(Exception e) {
            scelta = 0;
        }
        return scelta;
    }
    
    public int leggiIndice() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        int indice;
        System.out.println();
        System.out.print("Voce da eliminare: ");
        try {
            String numeroLetto = tastiera.readLine();
            indice = Integer.valueOf(numeroLetto).intValue();
        } catch(Exception e) {
            indice = -1;
        } 
        return indice;
    }
}
