public class App {
    public static void main(String[] args) throws Exception {
        Libro l1 = new Libro();
        System.out.println(l1);
        Libro l2 = new Libro("Il nome della rosa", "Umberto Eco", 1980);
        System.out.println(l2);
    }
}
