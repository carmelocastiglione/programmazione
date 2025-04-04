import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GestoreLista implements ListSelectionListener {

    private JTextField textFieldTotale;
    private Servizio[] listaServizi;

    public GestoreLista(JTextField textFieldTotale, Servizio[] listaServizi) {
        this.textFieldTotale = textFieldTotale;
        this.listaServizi = listaServizi;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            JList<Servizio> list = (JList<Servizio>) e.getSource();
            int selezionati[] = list.getSelectedIndices();
            //int selezionato = list.getSelectedIndex();
            double totale  = 0.00;
            for (int i = 0; i < selezionati.length; i++) {
                int indice = selezionati[i];
                double prezzo = listaServizi[indice].getPrezzo();
                totale = totale + prezzo;
            }
            textFieldTotale.setText(String.valueOf(totale));
        }
    }

}
