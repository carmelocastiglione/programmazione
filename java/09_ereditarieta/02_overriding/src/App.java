public class App {
    public static void main(String[] args) throws Exception {
        Personaggio personaggio = new Personaggio();
        Guerriero guerriero = new Guerriero();
        Mago mago = new Mago();
        personaggio.attacca();
        guerriero.attacca();
        mago.attacca();
    }
}
