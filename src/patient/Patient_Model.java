package patient;

import Employee.*;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class Patient_Model extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public Patient_Model() {
    }

    public Patient_Model(Object[][] data, String[] columnName) {
        this.columns = columnName;
        this.rows = data;
    }

    @Override
    public Class getColumnClass(int column) {
        if (column == 4) {

            return JTextField.class;

        } else {
            return getValueAt(0, column).getClass();
        }
    }

    @Override
    public int getRowCount() {

        return this.rows.length;

    }

    @Override
    public int getColumnCount() {
        return this.columns.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];

    }

    @Override
    public String getColumnName(int col) {
        return this.columns[col];
    }

}
