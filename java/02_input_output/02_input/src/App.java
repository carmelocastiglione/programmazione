/**
 * Esempio di lettura di un numero intero da tastiera in Java.
 * Nella lettura da tastiera si predilige l'uso della classe Scanner rispetto a InputStreamReader o BufferedReader.
 * Scanner ha il vantaggio di fornire metodi comodi per leggere diversi tipi di dati.
 * Ha lo svantaggio di essere meno efficiente in termini di prestazioni rispetto a InputStreamReader o BufferedReader.
 * Gli errori di input possono causare eccezioni, come InputMismatchException.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Creo lo scanner per leggere da tastiera
        Scanner scanner = new Scanner(System.in);

        // Leggo da tastiera un numero intero
        System.out.print("Inserisci un numero intero: ");
        int numero = scanner.nextInt();
        System.out.println("Hai inserito: " + numero);

        // Leggo da tastiera un numero decimale
        System.out.print("Inserisci un numero decimale: ");
        double numeroDecimale = scanner.nextDouble();
        System.out.println("Hai inserito: " + numeroDecimale);

        // Leggo da tastiera una stringa
        System.out.print("Inserisci una stringa: ");
        String testo = scanner.next();
        System.out.println("Hai inserito: " + testo);

        // Leggo da tastiera una riga di testo
        System.out.print("Inserisci una riga di testo: ");
        scanner.nextLine(); // Consumo il newline rimasto
        String riga = scanner.nextLine();
        System.out.println("Hai inserito: " + riga);

        // Chiudo lo scanner
        scanner.close();
    }
}
