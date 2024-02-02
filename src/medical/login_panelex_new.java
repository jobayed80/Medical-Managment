/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class login_panelex_new extends javax.swing.JFrame {

     public Preferences pref = Preferences.userRoot().node("Rememberme");
     public Preferences prefDoctor = Preferences.userRoot().node("Rememberme");
     public Preferences prerfEmployee = Preferences.userRoot().node("Rememberme");
     
     
    public login_panelex_new() {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        //admin_login start
        panel_admin_log.setVisible(false);
        panel_admin_reg.setVisible(false);
        panel_admin_reg.setVisible(false);
        panel_doctor_log.setVisible(false);
        panel_doctor_reg.setVisible(false);
        panel_employee_log.setVisible(false);
        panel_employee_reg.setVisible(false);
        
        
        //error admin
        error.setVisible(false);
        error_panel.setVisible(false);
        //error doctor
        error_doctor.setVisible(false);
        error_panel_doctor.setVisible(false);
        //error emp
        error_emp.setVisible(false);
        error_panel_emp.setVisible(false);
        
        //remember me admin username and password
        String usr = null;
        usr = pref.get("Email", usr);
        //username.setText(usr);
        txt_username_admin.setText(usr);
        String pss = null;
        pss = pref.get("Password",pss);
        txt_password_admin.setText(pss);
        
        //remember me doctor username and password
        String usrD = null;
        usrD = prefDoctor.get("Email", usrD);
        txt_username_doctor.setText(usr);
        String pssD = null;
        pssD = prefDoctor.get("Password",pssD);
        txt_password_doctor.setText(pss);
        
        //remember me demployee username and password
        String usrE = null;
        usrE = prerfEmployee.get("Email", usrE);
        //username.setText(usr);
        txt_username_emp.setText(usrE);
        String pssE = null;
        pssE = pref.get("Password",pssE);
        txt_password_admin.setText(pssE); 
    }

    
    public void saveemailpass(String Email,String Pass)
     {
         if(Email==null || Pass==null)
         {
             JOptionPane.showMessageDialog(null,"Email And PAss null");
         }
         else
         {
             String user = Email;
             pref.put("Email",Email);
             String pass = Pass;
             pref.put("Password",pass);
              System.out.println("Data disimpan");
             
         }
     }
     public final void checked(boolean remember)
     {
         if(remember==true)
         {
             saveemailpass(txt_username_admin.getText(),txt_password_admin.getText());
         }
         else
         {
             System.out.println("Null karakter");
         }
     }
     
     /////doctor remember me password
      public void saveemailpassDoctor(String Email,String Pass)
     {
         if(Email==null || Pass==null)
         {
             JOptionPane.showMessageDialog(null,"Email And Pass null","Sorry!",JOptionPane.ERROR_MESSAGE);
         }
         else
         {
             String user = Email;
             prefDoctor.put("Email",Email);
             String pass = Pass;
             prefDoctor.put("Password",pass);
              System.out.println("Data disimpan");
             
         }
     }
     public final void checkedDoctor(boolean remember)
     {
         if(remember==true)
         {
             saveemailpass(txt_username_doctor.getText(),txt_password_doctor.getText());
         }
         else
         {
             System.out.println("Null karakter");
         }
     }
    
     /////employee remember me password
      public void saveemailpassEmployee(String Email,String Pass)
     {
         if(Email==null || Pass==null)
         {
             JOptionPane.showMessageDialog(null,"Email And Pass null","Sorry!",JOptionPane.ERROR_MESSAGE);
         }
         else
         {
             String user = Email;
             prerfEmployee.put("Email",Email);
             String pass = Pass;
             prerfEmployee.put("Password",pass);
              System.out.println("Data disimpan");
             
         }
     }
     public final void checkedEmployee(boolean remember)
     {
         if(remember==true)
         {
             saveemailpass(txt_username_emp.getText(),txt_password_emp.getText());
         }
         else
         {
             System.out.println("Null karakter");
         }
     }
     

    //    Start close color
    public void setColor(JPanel p) {
        p.setBackground(new Color(210, 43, 43));

    }

    public void resetColor(JPanel p1) {
        p1.setBackground(new Color(211, 219, 226));
    }
    //    mnimize close color
    public void setColorMinimize(JPanel p) {
        p.setBackground(new Color(102,102,102));
    }

    public void resetColorMinimize(JPanel p1) {
        p1.setBackground(new Color(211, 219, 226));
    }
    

    //    Start admin color
    public void setColorlogin(JPanel p) {
        p.setBackground(new Color(0, 0, 55));

    }

    public void resetColorlogin(JPanel p1) {
        p1.setBackground(new Color(211, 219, 226));

    }

    //    Start admin color
    public void setColorsigin(JPanel p) {
        p.setBackground(new Color(0, 0, 55));

    }

    public void resetColorsigin(JPanel p1) {
        p1.setBackground(new Color(204, 201, 197));

    }

    
    // Admin password strong,medium,normal
    
    public void  Password()
    {
        error.setVisible(false);
        error_panel.setVisible(false);
        String PASS = TXT_password.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = PASS.toCharArray();
        for (int index = 0; index < PASS.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (PASS.contains("~") || PASS.contains("!") || PASS.contains("@")
            || PASS.contains("#") || PASS.contains("$") || PASS.contains("%")
            || PASS.contains("^") || PASS.contains("&") || PASS.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (PASS.length() < 8)
        {
           
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Too Short");
            error_panel.setBackground(new Color(102,0,0));
        }
        if(PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error.setVisible(true);
            error_panel.setVisible(true);
            
            error.setText("Weak");
            error_panel.setBackground(new Color(51,0,0));
        }
        if ((PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Medium");
            error_panel.setBackground(new Color(102,0,102));
        }
        if (PASS.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Strong");
            error_panel.setBackground(new Color(0,51,51));
        }     
    }
    
    public void Confirmpassword()
    {
        error.setVisible(false);
        error_panel.setVisible(false);
        
        String PASS = TXT_passwordShow.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = PASS.toCharArray();
        for (int index = 0; index < PASS.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (PASS.contains("~") || PASS.contains("!") || PASS.contains("@")
            || PASS.contains("#") || PASS.contains("$") || PASS.contains("%")
            || PASS.contains("^") || PASS.contains("&") || PASS.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (PASS.length() < 8)
        {
           
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Too Short");
            error_panel.setBackground(new Color(102,0,0));
        }
        if(PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Weak");
            error_panel.setBackground(new Color(51,0,0));
        }
        if ((PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (PASS.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Medium");
            error_panel.setBackground(new Color(102,0,102));
        }
        if (PASS.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error.setVisible(true);
            error_panel.setVisible(true);
            error.setText("Strong");
            error_panel.setBackground(new Color(0,51,51));
        }     
    }
    
    
    
    // Doctor password strong,medium,normal
    
    public void  Doctor_Password()
    {
        error_doctor.setVisible(false);
        error_panel_doctor.setVisible(false);
        String pass = TXT_password_doctor.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = pass.toCharArray();
        for (int index = 0; index < pass.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (pass.contains("~") || pass.contains("!") || pass.contains("@")
            || pass.contains("#") || pass.contains("$") || pass.contains("%")
            || pass.contains("^") || pass.contains("&") || pass.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (pass.length() < 8)
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Too Short");
            error_panel_doctor.setBackground(new Color(102,0,0));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            
            error_doctor.setText("Weak");
            error_panel_doctor.setBackground(new Color(51,0,0));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Medium");
            error_panel_doctor.setBackground(new Color(102,0,102));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Strong");
            error_panel_doctor.setBackground(new Color(0,51,51));
        } 
    }
    
    public void  Doctor_Cpassword()
    {
        error_doctor.setVisible(false);
        error_panel_doctor.setVisible(false);
        String pass = TXT_passwordShow_doctor.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = pass.toCharArray();
        for (int index = 0; index < pass.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (pass.contains("~") || pass.contains("!") || pass.contains("@")
            || pass.contains("#") || pass.contains("$") || pass.contains("%")
            || pass.contains("^") || pass.contains("&") || pass.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (pass.length() < 8)
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Too Short");
            error_panel_doctor.setBackground(new Color(102,0,0));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            
            error_doctor.setText("Weak");
            error_panel_doctor.setBackground(new Color(51,0,0));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Medium");
            error_panel_doctor.setBackground(new Color(102,0,102));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Strong");
            error_panel_doctor.setBackground(new Color(0,51,51));
        } 
    }
    
    ///Employe password
    
    public void  Employee_Password()
    {
        error_emp.setVisible(false);
        error_panel_emp.setVisible(false);
        String pass = TXT_password_emp.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = pass.toCharArray();
        for (int index = 0; index < pass.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (pass.contains("~") || pass.contains("!") || pass.contains("@")
            || pass.contains("#") || pass.contains("$") || pass.contains("%")
            || pass.contains("^") || pass.contains("&") || pass.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (pass.length() < 8)
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Too Short");
            error_panel_emp.setBackground(new Color(102,0,0));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            
            error_emp.setText("Weak");
            error_panel_emp.setBackground(new Color(51,0,0));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Medium");
            error_panel_emp.setBackground(new Color(102,0,102));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Strong");
            error_panel_emp.setBackground(new Color(0,51,51));
        } 
    }
    
    public void  Employee_ConfirmPassword()
    {
        error_emp.setVisible(false);
        error_panel_emp.setVisible(false);
        String pass = TXT_passwordShow_emp.getText();
        int uppercase = 0;
        int lowercase = 0;
        int specialcharacters = 0;
        int digits = 0;
        char[] Password = pass.toCharArray();
        for (int index = 0; index < pass.length(); index++)
        {
            if (Character.isUpperCase(Password[index]))
            {
                uppercase = 1;
            }
            if (Character.isLowerCase(Password[index]))
            {
                lowercase = 1;
            }
            if (Character.isDigit(Password[index]))
            {
                digits = 1;
            }
        }
        if (pass.contains("~") || pass.contains("!") || pass.contains("@")
            || pass.contains("#") || pass.contains("$") || pass.contains("%")
            || pass.contains("^") || pass.contains("&") || pass.contains("*")) ;
        {
            specialcharacters = 1;
        }
        if (pass.length() < 8)
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Too Short");
            error_panel_emp.setBackground(new Color(102,0,0));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            
            error_emp.setText("Weak");
            error_panel_emp.setBackground(new Color(51,0,0));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Medium");
            error_panel_emp.setBackground(new Color(102,0,102));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Strong");
            error_panel_emp.setBackground(new Color(0,51,51));
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login_panelex_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_panelex_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_panelex_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_panelex_new.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_panelex_new().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
