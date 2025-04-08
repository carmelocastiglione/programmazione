import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
        frame.setSize(500, 200);;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container contentPane) {
        JPanel panelTitolo = new JPanel();
        JLabel labelTitolo = new JLabel("Scegli il servizio");
        panelTitolo.add(labelTitolo);

        DefaultListModel<Servizio> listModel = new DefaultListModel<Servizio>();
        JList<Servizio> list = new JList<Servizio>(listModel);
        JScrollPane scrollPane = new JScrollPane(list); 

        JPanel panelTotale = new JPanel();
        JLabel labelServizio = new JLabel("Servizio");
        JTextField textFieldServizio = new JTextField(10);
        JLabel labelCosto = new JLabel("Costo");
        JTextField textFieldCosto = new JTextField(4);
        JButton buttonAggiungi = new JButton("Aggiungi");
        panelTotale.add(labelServizio);
        panelTotale.add(textFieldServizio);
        panelTotale.add(labelCosto);
        panelTotale.add(textFieldCosto);
        panelTotale.add(buttonAggiungi);

        contentPane.add(panelTitolo, BorderLayout.PAGE_START);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(panelTotale, BorderLayout.PAGE_END);

        buttonAggiungi.addActionListener(new GestoreBottone(listModel, textFieldServizio, textFieldCosto));
        list.addListSelectionListener(new GestoreLista(listModel));
    }
}
