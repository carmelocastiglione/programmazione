import java.util.Scanner;

// Programma che divide due numeri
public class App {
    public static void main(String[] args) throws Exception {
        int dividendo,
        divisore,
        risultato = 0; // inizializzo la variabile risultato prima del blocco try
        try {
            // codice che potrebbe generare un'eccezione
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci il dividendo: ");
            dividendo = scanner.nextInt(); // esempio di eccezione: input non valido
            System.out.print("Inserisci un divisore: ");
            divisore = scanner.nextInt(); // esempio di eccezione: input non valido
            risultato = dividendo / divisore; // esempio di eccezione: divisione per zero
            System.out.println("Risultato: " + risultato);
            scanner.close();
        } catch (Exception e) {
            // catturo l'eccezione generata nel blocco try
            System.err.println("Si è verificata un'eccezione: " + e.getMessage());
            return; // esco dal metodo main in caso di eccezione
        } finally {
            // codice che verrà eseguito indipendentemente dal fatto che si verifichi un'eccezione o meno
            System.out.println("Programma eseguito correttamente");
        }
        System.out.println(risultato);
    }
}
