/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Employee.Employee_Private;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author acer
 */
public class Employee_Query {
    
    
    
    
    
    public ArrayList<Employee_Private> BindTable()
    {
        ArrayList<Employee_Private> list = new ArrayList<Employee_Private>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            /////String query = "SELECT 'Name','Contact','Bld','Address','LastDonation','Image' FROM 'don'";
            //String query = "select Id,FullName,FatherName,Image,MotherName,Birthday,Status,Contact,Department,Address,Gender from employee";
             String query = "select *from employee";
            
            ResultSet rs = st.executeQuery(query);
            Employee_Private p;
            while(rs.next())
            {
                p = new Employee_Private(
                
//                        rs.getString(1),
//                        rs.getString("Contact"),
//                        rs.getString("Bld"),
//                        rs.getString("Address"),
//                        
//                        rs.getString("LastDonation"),
//                        rs.getBytes("Image")
                        
                        rs.getString("Id"),
                        rs.getString("FullName"),
                        rs.getString("FatherName"),
                        rs.getString("MotherName"),
                        rs.getBytes("Image"),
                        rs.getString("Birthday"),
                     
                        rs.getString("Status"),
                        rs.getString("Contact_1"),
                        rs.getString("Contact_2"),
                        rs.getString("Department"),
                        rs.getString("Address"),
                        rs.getString("Gender")
                        //rs.getBytes(11)
                        
                        //Date s5 = rs.getDate("Birthday"); // Birthday
                //birthday_employee_date_update.setDate(s5);
 
                        
                        
                
                );
                list.add(p);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return list;
    }
   
}
