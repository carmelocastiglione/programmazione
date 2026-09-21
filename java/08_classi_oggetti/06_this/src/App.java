public class App {
    public static void main(String[] args) throws Exception {
        Rettangolo r = new Rettangolo();
        r.setBase(10);
        r.setAltezza(5);
        System.out.println("Area: " + r.area());
        System.out.println("Perimetro: " + r.perimetro());
    }
}
