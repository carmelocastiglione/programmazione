/**
 * Guerriero
 */
public class Guerriero extends Personaggio {

    private int danno = 20;
    @Override
    public void attacca() {
        System.out.println("Il danno inflitto dal guerriero è: " + danno);
    }
    
}
