public class App {
    public static void main(String[] args) throws Exception {
        Cerchio tavolo;
        tavolo = new Cerchio();
        tavolo.setRaggio(0.75);
        double area = tavolo.calcolaArea();
        System.out.println("Area del tavolo: " + area);
    }
}
