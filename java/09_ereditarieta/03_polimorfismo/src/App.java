public class App {
    public static void main(String[] args) throws Exception {
        Animale animale = new Animale();
        Gatto gatto = new Gatto();
        Cane cane = new Cane();
        verso(animale);
        verso(gatto);
        verso(cane);
    }

    // Questo è un esempio di polimorfismo: il metodo verso accetta un Animale generico,
    // ma può ricevere anche oggetti delle classi derivate Gatto e Cane (essendo queste classi delle sottoclassi di Animale), 
    // e chiamerà il metodo faiVerso corretto in base al tipo reale dell'oggetto.
    public static void verso(Animale animale) {
        animale.faiVerso();
    }
}
