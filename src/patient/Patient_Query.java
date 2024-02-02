/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import Employee.*;
import Employee.Employee_Private;
//import com.toedter.calendar.JDateChooser;
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
public class Patient_Query {
    
    
    
    
    
    public ArrayList<Patient_Private> BindTable()
    {
        ArrayList<Patient_Private> list = new ArrayList<Patient_Private>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            /////String query = "SELECT 'Name','Contact','Bld','Address','LastDonation','Image' FROM 'don'";
            //String query = "select Id,FullName,FatherName,Image,MotherName,Birthday,Status,Contact,Department,Address,Gender from employee";
             String query = "select *from patient_receipt";
            
            ResultSet rs = st.executeQuery(query);
            Patient_Private p;
            while(rs.next())
            {
                p = new Patient_Private(
                
//                        rs.getString(1),
//                        rs.getString("Contact"),
//                        rs.getString("Bld"),
//                        rs.getString("Address"),
//                        
//                        rs.getString("LastDonation"),
//                        rs.getBytes("Image")
                        
                        rs.getString("Patient_Id"),
                        rs.getString("Full_Name"),
                        rs.getString("Father_Name"),
                        rs.getString("Address"),
                        rs.getString("Contact"),
                        rs.getString("Age"),
                        rs.getString("Gender"),
                        rs.getString("Patient_Illness"),
                        rs.getString("Doctor_Name"),                       
                        rs.getString("Registration_Date")
                        

                        
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getBytes(5),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
                        
                        
                
                );
                list.add(p);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return list;
    }
   
}
