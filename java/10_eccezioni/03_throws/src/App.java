public class App {
    public static void main(String[] args) throws Exception {
        Conto conto = new Conto();

        try {
            conto.effettuaPrelievo();
        } catch (InsufficientFundsException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}
