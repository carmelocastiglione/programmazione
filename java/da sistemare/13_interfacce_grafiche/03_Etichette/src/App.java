import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Mario Rossi");
        JLabel label2 = new JLabel("Nato a Merate (LC)");
        label2.setOpaque(true);
        label2.setBackground(Color.RED);
        label2.setForeground(Color.WHITE);
        panel.add(label1);
        panel.add(label2);

        label1.setText("Nome: Mario Rossi");

        Container container = frame.getContentPane();
        container.add(panel);

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
