import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("App");
        JPanel panel = new JPanel();
        JLabel etichettaNome = new JLabel("Inserisci il tuo nome:");
        panel.add(etichettaNome);
        JTextField nome = new JTextField(20);
        panel.add(nome);
        JLabel etichettaPrezzo = new JLabel("Inserisci il prezzo:");
        panel.add(etichettaPrezzo);
        JTextField prezzo = new JTextField("0.00€", 20);
        panel.add(prezzo);
        JTextField commento = new JTextField("Questa casella di testo non è editabile");
        commento.setEditable(false);
        panel.add(commento);
        String testo = commento.getText();
        System.out.println(testo);
        JTextArea area = new JTextArea("Questa è un'area di testo", 10, 20);
        area.append(" e questa stringa sarà aggiunta alla fine");
        // Imposto l'area di testo in modo che vada a capo e aggiungo le scrollbar
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(area);
        panel.add(scrollPane);

        Container container = frame.getContentPane();
        container.add(panel);

        frame.setSize(250,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
