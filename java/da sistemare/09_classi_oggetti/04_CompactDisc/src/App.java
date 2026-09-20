public class App {
    public static void main(String[] args) throws Exception {
        
        Menu menu = new Menu();
        int scelta;
        do {
            menu.mostra();
            scelta = menu.scelta();
            switch (scelta) {
                case 1:
                    menu.inserisci();
                    break; 
                case 2:
                    menu.visualizza();
                    break;   
                case 3:
                    menu.modificaTitolo();
                    break; 
                case 4:
                    menu.modificaDurata();
                    break; 
                case 5:
                    menu.cerca();
                    break; 
                case 0:
                    break;    
                default:
                    System.out.println("Scelta errata");
                    break;
            }
        } while (scelta != 0);

    }
}
