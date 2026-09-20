import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class GestorePulsante implements ActionListener {

    private JTextField textFieldTitolo;
    private JTextArea textAreaTesto;
    private JComboBox<String> comboBoxCategoria;
    private JCheckBox checkBoxImportante;
    private DefaultMutableTreeNode nodeImportante;
    private DefaultMutableTreeNode nodeCategorie;
    private JTree treeMemo;
    private Promemoria promemoria;

    public GestorePulsante(JTextField textFieldTitolo, JTextArea textAreaTesto, JComboBox<String> comboBoxCategoria,
            JCheckBox checkBoxImportante, DefaultMutableTreeNode nodeImportante, DefaultMutableTreeNode nodeCategorie, JTree treeMemo, Promemoria promemoria) {
        this.textFieldTitolo = textFieldTitolo;
        this.textAreaTesto = textAreaTesto;
        this.comboBoxCategoria = comboBoxCategoria;
        this.checkBoxImportante = checkBoxImportante;
        this.nodeImportante = nodeImportante;
        this.nodeCategorie = nodeCategorie;
        this.treeMemo = treeMemo;
        this.promemoria = promemoria;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Nuovo")) {
            textFieldTitolo.setText("");
            textAreaTesto.setText("");
            comboBoxCategoria.setSelectedIndex(0);
            checkBoxImportante.setSelected(false);
            promemoria = null;
        } else if (e.getActionCommand().equals("Salva")) {
            String titolo = textFieldTitolo.getText();
            String testo = textAreaTesto.getText();
            String categoria = (String) comboBoxCategoria.getSelectedItem();
            boolean importante = checkBoxImportante.isSelected();

            if (promemoria == null) {
                promemoria = new Promemoria(titolo, testo, categoria, importante);
                aggiungiPromemoria(promemoria);
            } else {
                aggiornaPromemoria(promemoria, titolo, testo, categoria, importante);
            }
        }
    }

    private void aggiornaPromemoria(Promemoria promemoria2, String titolo, String testo, String categoria, boolean importante) {
        promemoria.setTitolo(titolo);
        promemoria.setTesto(testo);
        promemoria.setCategoria(categoria);
        promemoria.setImportante(importante);
        // ricarico l'albero
        DefaultTreeModel model = (DefaultTreeModel) treeMemo.getModel();
        model.reload(); 
    }

    private void aggiungiPromemoria(Promemoria promemoria) {
        DefaultMutableTreeNode leafImportante = null;
        DefaultMutableTreeNode leafCategoria = null;
        // se il messaggio è importante lo aggiungo al nodo Importante
        if (promemoria.isImportante()) {
            leafImportante = new DefaultMutableTreeNode(promemoria);
            nodeImportante.add(leafImportante);
        }

        // aggiungo il messaggio alla categoria selezionata
        leafCategoria = new DefaultMutableTreeNode(promemoria);
        DefaultMutableTreeNode nodeSottocategorie = null;
        for (int i = 0; i < nodeCategorie.getChildCount(); i++) {
            nodeSottocategorie = (DefaultMutableTreeNode) nodeCategorie.getChildAt(i);
            if (nodeSottocategorie.toString().equals(promemoria.getCategoria())) {
                nodeSottocategorie.add(leafCategoria);
                break;
            }
        }
        // ricarico l'albero
        DefaultTreeModel model = (DefaultTreeModel) treeMemo.getModel();
        model.reload();
        // rendo visibile i nodi
        if (leafImportante != null) {
            treeMemo.scrollPathToVisible(new TreePath(leafImportante.getPath()));
        }
        if (leafCategoria != null) {
            treeMemo.scrollPathToVisible(new TreePath(leafCategoria.getPath()));
        }
        
    }

}
