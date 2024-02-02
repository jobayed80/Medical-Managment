
package Employee;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


public class Employee_Model extends AbstractTableModel{

    
    
    private String[] columns;
    private Object[][] rows;
    public Employee_Model(){}
    
    public Employee_Model(Object[][] data, String[]  columnName)
    {
       this.columns= columnName;
       this.rows= data;
    }
    
    @Override
    public  Class getColumnClass(int column)
    {
        if(column==4)
        {
            
            return Icon.class;
            
        }
        else
        {
            return getValueAt(0,column).getClass();
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

    
    public String getColumnName(int col)
    {
        return this.columns[col];
    }
    
    
    
    
}
