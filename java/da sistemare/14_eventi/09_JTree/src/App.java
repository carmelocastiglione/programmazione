import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }

    private static void addComponentsToPane(Container contentPane) {
        String[] categorie = { "Lavoro", "Personale", "Altro" };
        Promemoria promemoria = null;

        // pannello opzioni
        JPanel panelOpzioni = new JPanel();
        panelOpzioni.setLayout(new GridLayout(3, 1));
        //categorie
        JPanel panelRiga1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelCategoria = new JLabel("Categoria: ");
        JComboBox<String> comboBoxCategoria = new JComboBox<>();
        for (String categoria : categorie) {
            comboBoxCategoria.addItem(categoria);
        }
        panelRiga1.add(labelCategoria);
        panelRiga1.add(comboBoxCategoria);
        panelOpzioni.add(panelRiga1);
        // importante
        JPanel panelRiga2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelImportante = new JLabel("Importante: ");
        JCheckBox checkBoxImportante = new JCheckBox();
        panelRiga2.add(labelImportante);
        panelRiga2.add(checkBoxImportante); 
        panelOpzioni.add(panelRiga2);
        // titolo   
        JPanel panelRiga3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTitolo = new JLabel("Titolo: ");
        JTextField textFieldTitolo = new JTextField(30);
        panelRiga3.add(labelTitolo);
        panelRiga3.add(textFieldTitolo);
        panelOpzioni.add(panelRiga3);
        // testo
        //JLabel labelTesto = new JLabel("Testo: ");
        JTextArea textAreaTesto = new JTextArea(10, 50);
        JScrollPane scrollPaneTesto = new JScrollPane(textAreaTesto);
        JPanel panelMessaggi = new JPanel(new BorderLayout());
        panelMessaggi.add(panelOpzioni, BorderLayout.PAGE_START);
        panelMessaggi.add(scrollPaneTesto, BorderLayout.CENTER);

        // imposto il pannello destro
        JPanel panelPromemoria = new JPanel(new BorderLayout());
        JButton buttonNuovo = new JButton("Nuovo");
        panelPromemoria.add(buttonNuovo, BorderLayout.PAGE_START);
        panelPromemoria.add(panelMessaggi, BorderLayout.CENTER);
        JButton buttonSalva = new JButton("Salva");
        panelPromemoria.add(buttonSalva, BorderLayout.PAGE_END);

        // pannello sinistro
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Memo");
        DefaultMutableTreeNode nodeImportante = new DefaultMutableTreeNode("Importante"); 
        DefaultMutableTreeNode nodeCategorie = new DefaultMutableTreeNode("Categorie"); 
        DefaultMutableTreeNode nodeSottocategorie;
        for (String categoria : categorie) {
            nodeSottocategorie = new DefaultMutableTreeNode(categoria);
            nodeCategorie.add(nodeSottocategorie);
        }
        root.add(nodeImportante);
        root.add(nodeCategorie);
        JTree treeMemo = new JTree(root);
        JScrollPane scrollPaneMemo = new JScrollPane(treeMemo);
        // indico che posso selezionare solo un nodo alla volta
        treeMemo.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // creo il layout finale
        JPanel panel = new JPanel(new GridLayout(1,2));
        panel.add(scrollPaneMemo);
        panel.add(panelPromemoria);
        contentPane.add(panel);

        // listener pulsante
        GestorePulsante gp = new GestorePulsante(textFieldTitolo, textAreaTesto, comboBoxCategoria, checkBoxImportante, nodeImportante, nodeCategorie, treeMemo, promemoria);
        buttonSalva.addActionListener(gp);
        buttonNuovo.addActionListener(gp);

        // listener albero
        treeMemo.addTreeSelectionListener(new GestoreAlbero(treeMemo, textFieldTitolo, textAreaTesto, comboBoxCategoria, checkBoxImportante));
    }
}
