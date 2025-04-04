import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGui();
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("App");
        addComponentsToPane(frame.getContentPane());
        frame.setSize(300, 200);;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container contentPane) {
        JPanel panelTitolo = new JPanel();
        JLabel labelTitolo = new JLabel("Scegli il servizio");
        panelTitolo.add(labelTitolo);

        GestoreServizi gs = new GestoreServizi();
        Servizio[] listaServizi = gs.getListaServizi();
        //String[] listaServiziString = gs.getListaServiziString();
        //JList<String> list = new JList<String>(listaServiziString);
        JList<Servizio> list = new JList<Servizio>(listaServizi);
        JScrollPane scrollPane = new JScrollPane(list); 

        JPanel panelTotale = new JPanel();
        JLabel labelTotale = new JLabel("Totale");
        JTextField textFieldTotale = new JTextField(10);
        textFieldTotale.setEditable(false);
        textFieldTotale.setText("0.00");
        panelTotale.add(labelTotale);
        panelTotale.add(textFieldTotale);

        contentPane.add(panelTitolo, BorderLayout.PAGE_START);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(panelTotale, BorderLayout.PAGE_END);

        list.addListSelectionListener(new GestoreLista(textFieldTotale, listaServizi));
    }
}
