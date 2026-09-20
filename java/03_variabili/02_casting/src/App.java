public class App {
    public static void main(String[] args) throws Exception {
        // Problema: divisione tra interi
        int numeratore = 5;
        int denominatore = 2;
        double divisione = numeratore / denominatore; // risultato = 2.0
        System.out.println(divisione);

        // Soluzione: casting per ottenere il risultato corretto
        double divisioneCorretta = (double) numeratore / denominatore;
        System.out.println(divisioneCorretta);

        // Narrow casting: conversione di un tipo di dato in un altro, con perdita di informazioni
        double d = 9.78;
        int i = (int) d; // cast da double a int, perde la parte decimale
        System.out.println(i);

        // Widening casting: conversione di un tipo di dato in un altro, senza perdita di informazioni
        int j = 9;
        double e = j; // cast da int a double, nessuna perdita di informazioni
        System.out.println(e);
    }
}
