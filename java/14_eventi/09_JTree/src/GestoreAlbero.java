import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class GestoreAlbero implements TreeSelectionListener {
    private JTree treeMemo;
    private JTextField textFieldTitolo; 
    private JTextArea textAreaTesto;
    private JComboBox<String> comboBoxCategoria;
    private JCheckBox checkBoxImportante;

    public GestoreAlbero(JTree treeMemo, JTextField textFieldTitolo, JTextArea textAreaTesto,
            JComboBox<String> comboBoxCategoria, JCheckBox checkBoxImportante) {
        this.treeMemo = treeMemo;
        this.textFieldTitolo = textFieldTitolo;
        this.textAreaTesto = textAreaTesto;
        this.comboBoxCategoria = comboBoxCategoria;
        this.checkBoxImportante = checkBoxImportante;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeMemo.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if (node.getUserObject() instanceof Promemoria) {
            System.out.println("Selezionato: " + node.getUserObject());
            Promemoria promemoria = (Promemoria) node.getUserObject();
            textFieldTitolo.setText(promemoria.getTitolo());
            textAreaTesto.setText(promemoria.getTesto());
            comboBoxCategoria.setSelectedItem(promemoria.getCategoria());
            checkBoxImportante.setSelected(promemoria.isImportante());
        } 
    }

}
