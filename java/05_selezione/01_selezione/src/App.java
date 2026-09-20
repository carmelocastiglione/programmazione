public class App {
    public static void main(String[] args) throws Exception {
        boolean staPiovendo = true;
        if (staPiovendo) {
            System.out.println("Prendi l'ombrello!");
        } else {
            System.out.println("Non serve l'ombrello.");
        }

        int a = 5, b = 10;
        if (a > b) {
            System.out.println("a è maggiore di b");
        } else {
            System.out.println("a non è maggiore di b");
        }

        // else if
        if (a > b) {
            System.out.println("a è maggiore di b");
        } else if (a == b) {
            System.out.println("a è uguale a b");
        } else {
            System.out.println("a è minore di b");
        }

        // ternary operator
        String risultato = (a > b) ? "a è maggiore di b" : "a non è maggiore di b";
        System.out.println(risultato);

        // operatori logici
        if ((a > b) && staPiovendo) {
            System.out.println("a è maggiore di b e sta piovendo");
        } else {
            System.out.println("La condizione non è soddisfatta");
        }
    }
}
