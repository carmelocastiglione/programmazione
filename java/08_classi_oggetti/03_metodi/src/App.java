public class App {
    public static void main(String[] args) throws Exception {
        Interruttore interruttore = new Interruttore();
        interruttore.accendi();
        System.out.println("Interruttore acceso: " + interruttore.getAcceso());
        interruttore.spegni();
        System.out.println("Interruttore acceso: " + interruttore.getAcceso());
        interruttore.luminosita(50);
        System.out.println("Luminosità interruttore: " + interruttore.getLuminosita());
    }
}
