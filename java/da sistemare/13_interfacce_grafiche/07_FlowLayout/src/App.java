import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("App");
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JPanel panel = new JPanel();
        for (int i = 0; i < 4; i++) {
            panel.add(new JButton("Button " + i));
        }        

        Container container = frame.getContentPane();
        container.add(panel);

        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

