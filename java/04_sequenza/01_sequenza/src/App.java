/**
 * Calcola e stampa l'orario a partire da un numero di secondi.
 * Questo è un tipo di programmazione chiamata imperativa.
 * Java in realtà è un linguaggio orientato agli oggetti (OOP).
 * Non utilizzeremo le caratteristiche OOP in questo esempio.
 */

public class App {
    public static void main(String[] args) throws Exception {
        int orario = 41345; // orario in secondi
        int ore, minuti, secondi;

        ore = orario / 3600;
        minuti = (orario % 3600) / 60;
        secondi = orario % 60;

        System.out.println("Orario: " + ore + ":" + minuti + ":" + secondi);
    }
}
