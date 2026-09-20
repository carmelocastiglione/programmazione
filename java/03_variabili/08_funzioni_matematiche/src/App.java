public class App {
    public static void main(String[] args) throws Exception {
        // Valore massimo tra due numeri
        int a = 8;
        int b = 12;
        int massimo = Math.max(a, b);
        System.out.println("Massimo tra due numeri: " + massimo);

        // Valore minimo tra due numeri
        int c = 8;
        int d = 12;
        int minimo = Math.min(c, d);
        System.out.println("Minimo tra due numeri: " + minimo);

        // Valore assoluto
        int e = -7;
        int abs = Math.abs(e);
        System.out.println("Valore assoluto: " + abs);

        // Potenza
        int base = 2;
        int esponente = 3;
        int potenza = (int) Math.pow(base, esponente);
        System.out.println("Potenza: " + potenza);

        // Radice quadrata
        int f = 16;
        int radice = (int) Math.sqrt(f);
        System.out.println("Radice quadrata: " + radice);

        // Arrotondamento
        double g = 4.7;
        double arrotondato = Math.round(g); // Valore: 5.0
        System.out.println("Arrotondato: " + arrotondato);
        double h = 4.3;
        arrotondato = Math.round(h); // Valore: 4.0
        System.out.println("Arrotondato: " + arrotondato);
        
        // Troncamento
        double i = 4.7;
        double troncato = Math.floor(i); // Valore: 4.0
        System.out.println("Troncato: " + troncato);

        // Arrotondamento verso l'alto
        double j = 4.3;
        double arrotondatoAlto = Math.ceil(j); // Valore: 5.0
        System.out.println("Arrotondato verso l'alto: " + arrotondatoAlto);

        // Arrotondamento verso il basso
        double k = 4.7;
        double arrotondatoBasso = Math.floor(k); // Valore: 4.0
        System.out.println("Arrotondato verso il basso: " + arrotondatoBasso);

        // Valore casuale (tra 0.0 include e 1.0 escluso)
        double casuale = Math.random();
        System.out.println("Valore casuale: " + casuale);

        // Valore casuale tra 0 e 10 (è un numero con la virgola tra 0.0 e 9.999...)
        double casualeTraZeroeDieci = Math.random() * 10; 
        System.out.println("Valore casuale tra 0 e 10: " + casualeTraZeroeDieci);

        // Valore casuale tra 0 e 10 (numero intero)
        int casualeInteroTraZeroeDieci = (int) (Math.random() * 11);
        System.out.println("Valore casuale intero tra 0 e 10: " + casualeInteroTraZeroeDieci);

        // Valore casuale tra 5 e 15 (intero)
        int casualeTraCinqueeQuindici = (int) (5 + Math.random() * 11);
        System.out.println("Valore casuale tra 5 e 15: " + casualeTraCinqueeQuindici);

        // In alternativa si può usare (int) Math.floor(Math.random() * 11) per ottenere un numero intero casuale tra 0 e 10
    }
}
