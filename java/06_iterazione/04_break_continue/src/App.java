/**
 * This is a simple Java program demonstrating the use of
 * 'continue' and 'break' statements within a for loop.
 * continue: skips the current iteration of the loop.
 * break: exits the loop immediately.
 */

public class App {
    public static void main(String[] args) throws Exception {
        // Questo ciclo for stampa i numeri 0, 1, 3 
        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                continue;
            }
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
    }
}
