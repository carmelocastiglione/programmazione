import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("My first GUI app");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Hello World");
        JButton button = new JButton("Click me");
        panel.add(label);
        panel.add(button);

        Container contentPane = frame.getContentPane();
        contentPane.add(panel);

        // Imposto l'altezza
        frame.setSize(300, 200);
        // Posiziono la finestra al centro del monitor
        frame.setLocationRelativeTo(null);
        // Imposto l'azione alla chiusura
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Rendo visibile la finestra
        frame.setVisible(true);
    }
}
