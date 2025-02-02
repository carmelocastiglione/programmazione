import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class App {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton button1 = new JButton("Button 1");
        c.fill = GridBagConstraints.HORIZONTAL; // expand the component horizontally
        c.weightx = 0.5; // weight of the component (same for the same row)
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button1, c);
 
        JButton button2 = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button2, c);
 
        JButton button3 = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button3, c);
 
        JButton button4 = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.weighty = 0.5;
        c.gridwidth = 3;    //3 columns wide
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button4, c);
 
        JButton button5 = new JButton("5");
        c.fill = GridBagConstraints.NONE;
        c.weighty = 0.0;   //reset to the default
        c.ipady = 0;       //reset height to default
        c.anchor = GridBagConstraints.LAST_LINE_END; //bottom of space
        c.insets = new Insets(50,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 1;   //1 columns wide
        c.gridy = 2;       //third row
        pane.add(button5, c);
    }
    
}