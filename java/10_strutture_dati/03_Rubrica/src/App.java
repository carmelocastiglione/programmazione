public class App {
    public static void main(String[] args) throws Exception {
        Rubrica rubrica = new Rubrica();
        Menu menu = new Menu();
        int scelta;

        do {
            scelta = menu.scelta();
            switch (scelta) {
                case 1:
                    Voce voce = new Voce();
                    rubrica.aggiungiVoce(voce);
                    break;
                case 2:
                    int indice = menu.leggiIndice();
                    rubrica.eliminaVoce(indice);
                    break;
                case 3:
                    rubrica.visualizza();
                    break;
                default:
                    break;
            }
            
        } while ( scelta != 4);
        System.out.println("Fine programma");
    }
}
