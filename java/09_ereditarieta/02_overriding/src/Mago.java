/**
 * Mago
 */
public class Mago extends Personaggio {
    private int danno = 30;

    @Override
    public void attacca() {
        System.out.println("Il danno inflitto dal mago è: " + danno);
    }

}
