public class App {
    public static void main(String[] args) throws Exception {
        Libro[] libreria = new Libro[3];
        libreria[0] = new Libro("Promessi Sposi", "Alessandro Manzoni");
        libreria[1] = new Libro("Divina Commedia", "Dante Alighieri");
        libreria[2] = new Libro("Uno, Nessuno, Centomila", "Luigi Pirandello");
        for (int i = 0; i < libreria.length; i++) {
            System.out.println(libreria[i].getTitolo() + " di " + libreria[i].getAutore());
        }
    }
}
