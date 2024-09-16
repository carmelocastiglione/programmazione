public class _01_Vettore {
    public static void main(String[] args) {
        // Dichiarazione
        int numeri[];
        String nomi[];
        // Allocazione
        numeri = new int[5];
        nomi = new String[3];
        // Inizializzazione
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = (int) (Math.random() * 10);
        }
        for (int i = 0; i < numeri.length; i++) {
            System.out.println(numeri[i]);
        }
        nomi[0] = "Luca";
        nomi[1] = "Mario";
        nomi[2] = "Giuseppe";
        for (int i = 0; i < nomi.length; i++) {
            System.out.println(nomi[i]);
        }
        // Insieme 
        int vettore[] = {3, 6, 3, 8, 1, 6};
        for (int i = 0; i < vettore.length; i++) {
            System.out.println(vettore[i]);
        }
    }
}
