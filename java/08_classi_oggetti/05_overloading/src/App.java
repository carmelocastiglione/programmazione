public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro();
        libro.presta();
        System.out.println(libro);
        libro.presta("Mario Rossi");
        System.out.println(libro);
    }
}
