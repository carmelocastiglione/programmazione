public class _01_Eccezione {
    public static void main(String[] args) {
        int numeratore = 10;
        int denominatore = 0;

        try {
            int risultato = numeratore / denominatore;
            System.out.println(risultato);
        } catch (Exception e) {
            System.err.println("Divisione per zero");
            return;
        } finally {
            System.out.println("Fine del programma");
        }
    }
}
