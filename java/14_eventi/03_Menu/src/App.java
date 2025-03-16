import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        addMenuBar(frame);
        addComponentsToPane(frame.getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addMenuBar(JFrame frame) {
        ActionListener gm = new GestoreMenu(frame);
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        JMenuItem nuovo = new JMenuItem("Nuovo", KeyEvent.VK_N);
        nuovo.addActionListener(gm);
        menu.add(nuovo);
        JMenuItem apri = new JMenuItem("Apri", KeyEvent.VK_A);
        apri.addActionListener(gm);
        menu.add(apri);
        menu.addSeparator();
        JMenuItem esci = new JMenuItem("Esci", KeyEvent.VK_E);
        esci.addActionListener(gm);
        menu.add(esci);
        menuBar.add(menu);

        JMenu altro = new JMenu("Altro");
        altro.setMnemonic(KeyEvent.VK_A);
        JMenuItem info = new JMenuItem("Informazioni", KeyEvent.VK_I);
        info.addActionListener(gm);
        altro.add(info);
        menuBar.add(altro);

        frame.setJMenuBar(menuBar);
    }

    private static void addComponentsToPane(Container contentPane) {
        JPanel panel = new JPanel();
        panel.setName("panel");
        JLabel label = new JLabel("Test");
        label.setName("label");
        panel.add(label);
        contentPane.add(panel);
    }
}
