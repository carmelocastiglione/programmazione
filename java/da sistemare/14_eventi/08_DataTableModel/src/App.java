import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Container;
 
public class App {
    public static void main(String[] args) {
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
        
        public static void addComponentsToPane(Container c) {
        //panel.setOpaque(true); //content panes must be opaque
 
        ArrayList<Persona> list = new ArrayList<Persona>();
        list.add(new Persona("Kathy", "Smith", "Snowboarding", 5, false));
        list.add(new Persona("John", "Doe", "Rowing", 3, true));
        list.add(new Persona("Sue", "Black", "Knitting", 2, false));
        list.add(new Persona("Jane", "White", "Speed reading", 20, true));
        list.add(new Persona("Joe", "Brown", "Pool", 10, false));
    
        JTable table = new JTable(new DataTableModel(list));

        // Imposto la terza colonna come elenco a discesa
        TableColumn sportColumn = table.getColumnModel().getColumn(2);
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Chasing toddlers");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Teaching high school");
        comboBox.addItem("None");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        // fine
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        printDebugData(table);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        c.add(scrollPane);
    }
 
    private static void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}