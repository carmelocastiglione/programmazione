import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGui();
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("App");
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container contentPane) {
        JPanel panel1 = new JPanel();
        JTextArea area = new JTextArea(20, 20);
        panel1.add(area);
        contentPane.add(panel1, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        JButton button1 = new JButton("Apri file");
        button1.setActionCommand("apri");
        JButton button2 = new JButton("Salva file");
        button2.setActionCommand("salva");
        panel2.add(button1);
        panel2.add(button2);
        contentPane.add(panel2, BorderLayout.PAGE_END);

        button1.addActionListener(new GestoreBottoni(contentPane, area));
        button2.addActionListener(new GestoreBottoni(contentPane, area));
    }
}
