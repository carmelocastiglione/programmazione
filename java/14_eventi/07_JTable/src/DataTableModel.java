import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class DataTableModel extends AbstractTableModel {

    // Object[][] data = {
    //     {"Kathy", "Smith", "Snowboarding", 5, false},
    //     {"John", "Doe", "Rowing", 3, true},
    //     {"Sue", "Black", "Knitting", 2, false},
    //     {"Jane", "White", "Speed reading", 20, true},
    //     {"Joe", "Brown", "Pool", 10, false}
    // };
    
    ArrayList<Persona> data;

    // String[] columnNames = {"First Name",
    //                         "Last Name",
    //                         "Sport",
    //                         "# of Years",
    //                         "Vegetarian"};

    String[] columnNames = {"Nome", "Cognome", "Hobby", "Anni", "Check"};

    public DataTableModel(ArrayList<Persona> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (columnIndex < 2) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (Object) data.get(rowIndex).getNome();
            case 1:
                return (Object) data.get(rowIndex).getCognome();
            case 2:
                return (Object) data.get(rowIndex).getHobby();
            case 3:
                return (Object) data.get(rowIndex).getAnni();
            case 4:
                return (Object) data.get(rowIndex).isCheck();
            default:
                return null;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                data.get(rowIndex).setNome((String) aValue);
                break;
            case 1:
                data.get(rowIndex).setCognome((String) aValue);
                break;
            case 2:
                data.get(rowIndex).setHobby((String) aValue);
                break;
            case 3:
                data.get(rowIndex).setAnni((int) aValue);
                break;
            case 4: 
                data.get(rowIndex).setCheck((boolean) aValue);
                break;
            default:
                break;
        }
        System.out.println(data);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
