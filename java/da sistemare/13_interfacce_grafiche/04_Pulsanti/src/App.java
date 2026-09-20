import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        JButton button1 = new JButton("Cliccami");
        button1.setEnabled(false);
        panel.add(button1);
        JButton button2 = new JButton("Ehhh volevi");
        button2.setBackground(Color.RED);
        panel.add(button2);

        Container container = frame.getContentPane();
        container.add(panel);

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
