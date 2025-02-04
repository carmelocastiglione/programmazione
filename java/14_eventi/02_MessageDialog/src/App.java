import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("My App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        addComponentsToPane(frame.getContentPane());        
        frame.setSize(450, 100);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
    }

    public static void addComponentsToPane(Container container) {

        JPanel panelDati = new JPanel();
        JPanel panelPulsanti = new JPanel();

        JLabel labelCognome = new JLabel("Cognome");
        panelDati.add(labelCognome);
        JTextField campoCognome = new JTextField(10);
        panelDati.add(campoCognome);

        JLabel labelNome = new JLabel("Nome");
        panelDati.add(labelNome);
        JTextField campoNome = new JTextField(10);
        panelDati.add(campoNome);
         
        JButton button1 = new JButton("Ok");
        button1.setActionCommand("ok");
        panelPulsanti.add(button1);

        JButton button2 = new JButton("Annulla");
        button2.setActionCommand("reset");
        panelPulsanti.add(button2);

        button1.addActionListener(new GestoreBottone(container, campoCognome, campoNome));
        button2.addActionListener(new GestoreBottone(container, campoCognome, campoNome));
        
        container.add(panelDati, BorderLayout.CENTER);
        container.add(panelPulsanti, BorderLayout.PAGE_END);
    }
}
