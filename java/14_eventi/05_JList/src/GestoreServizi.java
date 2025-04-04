
public class GestoreServizi {
    private Servizio[] listaServizi;

    public GestoreServizi() {
        listaServizi = new Servizio[5];
        listaServizi[0] = new Servizio("1. Esterno", 4.00);
        listaServizi[1] = new Servizio("2. Cerchi", 1.00);
        listaServizi[2] = new Servizio("3. Cera e antialoni", 2.50);
        listaServizi[3] = new Servizio("4. Interno", 5.00);
        listaServizi[4] = new Servizio("5. Lavaggio tappeti", 3.50);
    }

    public Servizio[] getListaServizi() {
        return listaServizi;
    }

    public String[] getListaServiziString() {
        String[] listaServiziString = new String[listaServizi.length];
        for (int i = 0; i < listaServizi.length; i++) {
            listaServiziString[i] = listaServizi[i].getNome() + " - " + String.format("%.2f", listaServizi[i].getPrezzo()) + " €";
        }
        return listaServiziString;
    }    
}
