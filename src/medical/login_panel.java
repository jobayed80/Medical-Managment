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

/**
 *
 * @author h
 */
public class login_panel extends javax.swing.JFrame {

     public Preferences pref = Preferences.userRoot().node("Rememberme");
     public Preferences prefDoctor = Preferences.userRoot().node("Rememberme");
     public Preferences prerfEmployee = Preferences.userRoot().node("Rememberme");

    /**
     * Creates new form sample1111
     */
    public login_panel() {
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

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        panel_close = new javax.swing.JPanel();
        label_close = new javax.swing.JLabel();
        label_close_white = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panel_admin = new javax.swing.JPanel();
        label_admin_menu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel_doctor = new javax.swing.JPanel();
        label_doctor_menu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        panel_employee = new javax.swing.JPanel();
        label_employee_menu = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        panel_employee_reg = new javax.swing.JPanel();
        employee_registration_emp = new javax.swing.JLabel();
        registration_here_emp = new javax.swing.JLabel();
        TXT_username_emp = new javax.swing.JTextField();
        TXT_password_emp = new javax.swing.JPasswordField();
        TXT_passwordShow_emp = new javax.swing.JPasswordField();
        PANEL_signup_emp = new javax.swing.JPanel();
        LABEL_signup_emp = new javax.swing.JLabel();
        error_panel_emp = new javax.swing.JPanel();
        error_emp = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CboxShowPass_EMP = new javax.swing.JCheckBox();
        panel_admin_reg = new javax.swing.JPanel();
        admin_registration_admin = new javax.swing.JLabel();
        registration_admin = new javax.swing.JLabel();
        TXT_username = new javax.swing.JTextField();
        TXT_password = new javax.swing.JPasswordField();
        TXT_passwordShow = new javax.swing.JPasswordField();
        PANEL_signup_admin = new javax.swing.JPanel();
        LABEL_signup_admin = new javax.swing.JLabel();
        CboxShowPass_ADMIN = new javax.swing.JCheckBox();
        error_panel = new javax.swing.JPanel();
        error = new javax.swing.JLabel();
        panel_doctor_reg = new javax.swing.JPanel();
        doctor_registration_doctor = new javax.swing.JLabel();
        registration_doctor = new javax.swing.JLabel();
        TXT_username_doctor = new javax.swing.JTextField();
        TXT_password_doctor = new javax.swing.JPasswordField();
        TXT_passwordShow_doctor = new javax.swing.JPasswordField();
        PANEL_signup_doctor = new javax.swing.JPanel();
        LABEL_signup_doctor = new javax.swing.JLabel();
        show_panelk = new javax.swing.JPanel();
        CboxShowPass_DOCTOR = new javax.swing.JCheckBox();
        error_panel_doctor = new javax.swing.JPanel();
        error_doctor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        panel_minimize = new javax.swing.JPanel();
        label_minimize = new javax.swing.JLabel();
        panel_employee_log = new javax.swing.JPanel();
        login_here_emp = new javax.swing.JLabel();
        employye_login_emp = new javax.swing.JLabel();
        txt_password_emp = new javax.swing.JPasswordField();
        txt_username_emp = new javax.swing.JTextField();
        panel_signin_emp = new javax.swing.JPanel();
        label_signin_emp = new javax.swing.JLabel();
        panel_signup_emp = new javax.swing.JPanel();
        label_signup_emp = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CboxShowPass_emp = new javax.swing.JCheckBox();
        CboxRememPassEmployee = new javax.swing.JCheckBox();
        panel_admin_log = new javax.swing.JPanel();
        login_here_admin = new javax.swing.JLabel();
        admin_login_panel_admin = new javax.swing.JLabel();
        txt_username_admin = new javax.swing.JTextField();
        txt_password_admin = new javax.swing.JPasswordField();
        panel_signin_admin = new javax.swing.JPanel();
        label_signin_admin = new javax.swing.JLabel();
        panel_signup_admin = new javax.swing.JPanel();
        label_signup_admin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CboxShowPass_admin = new javax.swing.JCheckBox();
        CboxRememPass = new javax.swing.JCheckBox();
        panel_doctor_log = new javax.swing.JPanel();
        login_here_doctor = new javax.swing.JLabel();
        doctor_login_panel = new javax.swing.JLabel();
        txt_username_doctor = new javax.swing.JTextField();
        txt_password_doctor = new javax.swing.JPasswordField();
        panel_signin_doctor = new javax.swing.JPanel();
        label_signin_doctor = new javax.swing.JLabel();
        panel_signup_doctor = new javax.swing.JPanel();
        label_signup_doctor = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CboxRememPassDoctor = new javax.swing.JCheckBox();
        CboxShowPass_doctor = new javax.swing.JCheckBox();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_close.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_closeMouseExited(evt);
            }
        });
        panel_close.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/close_blue1.png"))); // NOI18N
        panel_close.add(label_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        label_close_white.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_close_white.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/close_white1.png"))); // NOI18N
        panel_close.add(label_close_white, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(panel_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 30, 30));

        jPanel3.setBackground(new java.awt.Color(51, 0, 0,80));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Engravers MT", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Daffodil Medical Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 820, 60));

        jPanel4.setBackground(new java.awt.Color(211, 219, 226,80));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/admin.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 33, -1, -1));

        label_admin_menu.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        label_admin_menu.setForeground(new java.awt.Color(1, 4, 239));
        label_admin_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_admin_menu.setText("Admin");
        label_admin_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_admin_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_admin_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_admin_menuMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label_admin_menuMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_adminLayout = new javax.swing.GroupLayout(panel_admin);
        panel_admin.setLayout(panel_adminLayout);
        panel_adminLayout.setHorizontalGroup(
            panel_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_admin_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_adminLayout.setVerticalGroup(
            panel_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_admin_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel4.add(panel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 109, 185, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 151, 185, 11));

        label_doctor_menu.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        label_doctor_menu.setForeground(new java.awt.Color(1, 4, 239));
        label_doctor_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_doctor_menu.setText("Doctor");
        label_doctor_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_doctor_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_doctor_menuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_doctorLayout = new javax.swing.GroupLayout(panel_doctor);
        panel_doctor.setLayout(panel_doctorLayout);
        panel_doctorLayout.setHorizontalGroup(
            panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_doctor_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_doctorLayout.setVerticalGroup(
            panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_doctor_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel4.add(panel_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 247, 185, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/doctor.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 168, -1, -1));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 289, 185, 10));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/employee.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 305, -1, -1));

        label_employee_menu.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        label_employee_menu.setForeground(new java.awt.Color(1, 4, 239));
        label_employee_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_employee_menu.setText("Employee");
        label_employee_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_employee_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_employee_menuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_employeeLayout = new javax.swing.GroupLayout(panel_employee);
        panel_employee.setLayout(panel_employeeLayout);
        panel_employeeLayout.setHorizontalGroup(
            panel_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_employeeLayout.setVerticalGroup(
            panel_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel4.add(panel_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 381, 185, -1));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 423, 185, 15));

        panel_employee_reg.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_employee_reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_employee_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_employee_reg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_registration_emp.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        employee_registration_emp.setText("Employee Registration Panel");
        panel_employee_reg.add(employee_registration_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 51, -1, -1));

        registration_here_emp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registration_here_emp.setText("Registration Here");
        panel_employee_reg.add(registration_here_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, -1, -1));

        TXT_username_emp.setBackground(new java.awt.Color(204, 201, 197));
        TXT_username_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_username_emp.setForeground(new java.awt.Color(0, 0, 0));
        TXT_username_emp.setText("Username");
        TXT_username_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_username_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_username_empFocusLost(evt);
            }
        });
        TXT_username_emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_username_empKeyReleased(evt);
            }
        });
        panel_employee_reg.add(TXT_username_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 180, 40));

        TXT_password_emp.setBackground(new java.awt.Color(204, 201, 197));
        TXT_password_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_password_emp.setForeground(new java.awt.Color(0, 0, 0));
        TXT_password_emp.setText("**********");
        TXT_password_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_password_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_password_empFocusLost(evt);
            }
        });
        TXT_password_emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_password_empKeyReleased(evt);
            }
        });
        panel_employee_reg.add(TXT_password_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 158, 180, 40));

        TXT_passwordShow_emp.setBackground(new java.awt.Color(204, 201, 197));
        TXT_passwordShow_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_passwordShow_emp.setForeground(new java.awt.Color(0, 0, 0));
        TXT_passwordShow_emp.setText("**********");
        TXT_passwordShow_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_passwordShow_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_passwordShow_empFocusLost(evt);
            }
        });
        TXT_passwordShow_emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_passwordShow_empKeyReleased(evt);
            }
        });
        panel_employee_reg.add(TXT_passwordShow_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, 40));

        PANEL_signup_emp.setBackground(new java.awt.Color(204, 201, 197));
        PANEL_signup_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        PANEL_signup_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANEL_signup_empMouseClicked(evt);
            }
        });

        LABEL_signup_emp.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABEL_signup_emp.setForeground(new java.awt.Color(1, 4, 239));
        LABEL_signup_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABEL_signup_emp.setText("SignUp");
        LABEL_signup_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LABEL_signup_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LABEL_signup_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LABEL_signup_empMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PANEL_signup_empLayout = new javax.swing.GroupLayout(PANEL_signup_emp);
        PANEL_signup_emp.setLayout(PANEL_signup_empLayout);
        PANEL_signup_empLayout.setHorizontalGroup(
            PANEL_signup_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LABEL_signup_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        PANEL_signup_empLayout.setVerticalGroup(
            PANEL_signup_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LABEL_signup_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panel_employee_reg.add(PANEL_signup_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 313, -1, -1));

        error_panel_emp.setBackground(new java.awt.Color(102, 0, 0));

        error_emp.setBackground(new java.awt.Color(102, 0, 0));
        error_emp.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        error_emp.setForeground(new java.awt.Color(255, 255, 255));
        error_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout error_panel_empLayout = new javax.swing.GroupLayout(error_panel_emp);
        error_panel_emp.setLayout(error_panel_empLayout);
        error_panel_empLayout.setHorizontalGroup(
            error_panel_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(error_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        error_panel_empLayout.setVerticalGroup(
            error_panel_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, error_panel_empLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(error_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_employee_reg.add(error_panel_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 180, -1));

        CboxShowPass_EMP.setText("show");
        CboxShowPass_EMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_EMPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CboxShowPass_EMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CboxShowPass_EMP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panel_employee_reg.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 60, 20));

        jPanel4.add(panel_employee_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 40));

        panel_admin_reg.setBackground(new java.awt.Color(201, 204, 197,80));
        panel_admin_reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_admin_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_admin_reg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_registration_admin.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        admin_registration_admin.setText("Admin Registration Panel");
        panel_admin_reg.add(admin_registration_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 51, -1, -1));

        registration_admin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registration_admin.setText("Registration Here");
        panel_admin_reg.add(registration_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        TXT_username.setBackground(new java.awt.Color(204, 201, 197));
        TXT_username.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_username.setForeground(new java.awt.Color(0, 0, 0));
        TXT_username.setText("Username");
        TXT_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_usernameFocusLost(evt);
            }
        });
        TXT_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_usernameKeyReleased(evt);
            }
        });
        panel_admin_reg.add(TXT_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 180, 40));

        TXT_password.setBackground(new java.awt.Color(204, 201, 197));
        TXT_password.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_password.setForeground(new java.awt.Color(0, 0, 0));
        TXT_password.setText("**********");
        TXT_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_passwordFocusLost(evt);
            }
        });
        TXT_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_passwordKeyReleased(evt);
            }
        });
        panel_admin_reg.add(TXT_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 150, 180, 42));

        TXT_passwordShow.setBackground(new java.awt.Color(204, 201, 197));
        TXT_passwordShow.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_passwordShow.setForeground(new java.awt.Color(0, 0, 0));
        TXT_passwordShow.setText("**********");
        TXT_passwordShow.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_passwordShowFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_passwordShowFocusLost(evt);
            }
        });
        TXT_passwordShow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_passwordShowKeyReleased(evt);
            }
        });
        panel_admin_reg.add(TXT_passwordShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 210, 183, 42));

        PANEL_signup_admin.setBackground(new java.awt.Color(204, 201, 197));
        PANEL_signup_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        PANEL_signup_admin.setPreferredSize(new java.awt.Dimension(130, 40));

        LABEL_signup_admin.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABEL_signup_admin.setForeground(new java.awt.Color(1, 4, 239));
        LABEL_signup_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABEL_signup_admin.setText("SignUp");
        LABEL_signup_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LABEL_signup_adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LABEL_signup_adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LABEL_signup_adminMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PANEL_signup_adminLayout = new javax.swing.GroupLayout(PANEL_signup_admin);
        PANEL_signup_admin.setLayout(PANEL_signup_adminLayout);
        PANEL_signup_adminLayout.setHorizontalGroup(
            PANEL_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_signup_adminLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LABEL_signup_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PANEL_signup_adminLayout.setVerticalGroup(
            PANEL_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_signup_adminLayout.createSequentialGroup()
                .addComponent(LABEL_signup_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panel_admin_reg.add(PANEL_signup_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        CboxShowPass_ADMIN.setText("show");
        CboxShowPass_ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_ADMINActionPerformed(evt);
            }
        });
        panel_admin_reg.add(CboxShowPass_ADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 194, 70, 12));

        error_panel.setBackground(new java.awt.Color(102, 0, 0));

        error.setBackground(new java.awt.Color(102, 0, 0));
        error.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        error.setForeground(new java.awt.Color(255, 255, 255));
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout error_panelLayout = new javax.swing.GroupLayout(error_panel);
        error_panel.setLayout(error_panelLayout);
        error_panelLayout.setHorizontalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, error_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        error_panelLayout.setVerticalGroup(
            error_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, error_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_admin_reg.add(error_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 260, 178, -1));

        jPanel4.add(panel_admin_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 70, 50));

        panel_doctor_reg.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_doctor_reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_doctor_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_doctor_reg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctor_registration_doctor.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        doctor_registration_doctor.setText("Doctor Registration Panel");
        panel_doctor_reg.add(doctor_registration_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 51, -1, -1));

        registration_doctor.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registration_doctor.setText("Registration Here");
        panel_doctor_reg.add(registration_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 13, -1, -1));

        TXT_username_doctor.setBackground(new java.awt.Color(204, 201, 197));
        TXT_username_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_username_doctor.setForeground(new java.awt.Color(0, 0, 0));
        TXT_username_doctor.setText("Username");
        TXT_username_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_username_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_username_doctorFocusLost(evt);
            }
        });
        TXT_username_doctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_username_doctorKeyReleased(evt);
            }
        });
        panel_doctor_reg.add(TXT_username_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 95, 180, 40));

        TXT_password_doctor.setBackground(new java.awt.Color(204, 201, 197));
        TXT_password_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_password_doctor.setForeground(new java.awt.Color(0, 0, 0));
        TXT_password_doctor.setText("**********");
        TXT_password_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_password_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_password_doctorFocusLost(evt);
            }
        });
        TXT_password_doctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_password_doctorKeyReleased(evt);
            }
        });
        panel_doctor_reg.add(TXT_password_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 153, 180, 40));

        TXT_passwordShow_doctor.setBackground(new java.awt.Color(204, 201, 197));
        TXT_passwordShow_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_passwordShow_doctor.setForeground(new java.awt.Color(0, 0, 0));
        TXT_passwordShow_doctor.setText("**********");
        TXT_passwordShow_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_passwordShow_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_passwordShow_doctorFocusLost(evt);
            }
        });
        TXT_passwordShow_doctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_passwordShow_doctorKeyReleased(evt);
            }
        });
        panel_doctor_reg.add(TXT_passwordShow_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 211, 180, 40));

        PANEL_signup_doctor.setBackground(new java.awt.Color(204, 201, 197));
        PANEL_signup_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        LABEL_signup_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABEL_signup_doctor.setForeground(new java.awt.Color(1, 4, 239));
        LABEL_signup_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABEL_signup_doctor.setText("SignUp");
        LABEL_signup_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LABEL_signup_doctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LABEL_signup_doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LABEL_signup_doctorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PANEL_signup_doctorLayout = new javax.swing.GroupLayout(PANEL_signup_doctor);
        PANEL_signup_doctor.setLayout(PANEL_signup_doctorLayout);
        PANEL_signup_doctorLayout.setHorizontalGroup(
            PANEL_signup_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LABEL_signup_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        PANEL_signup_doctorLayout.setVerticalGroup(
            PANEL_signup_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LABEL_signup_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_doctor_reg.add(PANEL_signup_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 317, -1, -1));

        CboxShowPass_DOCTOR.setText("show");
        CboxShowPass_DOCTOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_DOCTORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout show_panelkLayout = new javax.swing.GroupLayout(show_panelk);
        show_panelk.setLayout(show_panelkLayout);
        show_panelkLayout.setHorizontalGroup(
            show_panelkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CboxShowPass_DOCTOR, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        show_panelkLayout.setVerticalGroup(
            show_panelkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(show_panelkLayout.createSequentialGroup()
                .addComponent(CboxShowPass_DOCTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_doctor_reg.add(show_panelk, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 191, 65, -1));

        error_panel_doctor.setBackground(new java.awt.Color(102, 0, 0));

        error_doctor.setBackground(new java.awt.Color(102, 0, 0));
        error_doctor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        error_doctor.setForeground(new java.awt.Color(255, 255, 255));
        error_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout error_panel_doctorLayout = new javax.swing.GroupLayout(error_panel_doctor);
        error_panel_doctor.setLayout(error_panel_doctorLayout);
        error_panel_doctorLayout.setHorizontalGroup(
            error_panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, error_panel_doctorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(error_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        error_panel_doctorLayout.setVerticalGroup(
            error_panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, error_panel_doctorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(error_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_doctor_reg.add(error_panel_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 260, -1, -1));

        jPanel4.add(panel_doctor_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 90, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 290, 460));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/refresh.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 40, 30, 30));

        panel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_minimizeMouseExited(evt);
            }
        });

        label_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/minimize1.png"))); // NOI18N

        javax.swing.GroupLayout panel_minimizeLayout = new javax.swing.GroupLayout(panel_minimize);
        panel_minimize.setLayout(panel_minimizeLayout);
        panel_minimizeLayout.setHorizontalGroup(
            panel_minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_minimizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_minimizeLayout.setVerticalGroup(
            panel_minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_minimizeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panel_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 30, 30));

        panel_employee_log.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_employee_log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_employee_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_employee_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_emp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_emp.setText("Login Here");
        panel_employee_log.add(login_here_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 13, -1, -1));

        employye_login_emp.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        employye_login_emp.setText("Employee Login Panel");
        panel_employee_log.add(employye_login_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 51, -1, -1));

        txt_password_emp.setBackground(new java.awt.Color(204, 201, 197));
        txt_password_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_emp.setForeground(new java.awt.Color(0, 0, 0));
        txt_password_emp.setText("**********");
        txt_password_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_empFocusLost(evt);
            }
        });
        panel_employee_log.add(txt_password_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 172, 200, 40));

        txt_username_emp.setBackground(new java.awt.Color(204, 201, 197));
        txt_username_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_username_emp.setForeground(new java.awt.Color(0, 0, 0));
        txt_username_emp.setText("Username");
        txt_username_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_username_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username_empFocusLost(evt);
            }
        });
        panel_employee_log.add(txt_username_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 114, 200, 40));

        panel_signin_emp.setBackground(new java.awt.Color(204, 201, 197));
        panel_signin_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panel_signin_emp.setPreferredSize(new java.awt.Dimension(130, 40));

        label_signin_emp.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_signin_emp.setForeground(new java.awt.Color(1, 4, 239));
        label_signin_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_emp.setText("SignIn");
        label_signin_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signin_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signin_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signin_empMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signin_empLayout = new javax.swing.GroupLayout(panel_signin_emp);
        panel_signin_emp.setLayout(panel_signin_empLayout);
        panel_signin_empLayout.setHorizontalGroup(
            panel_signin_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signin_empLayout.setVerticalGroup(
            panel_signin_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_employee_log.add(panel_signin_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 279, -1, -1));

        panel_signup_emp.setBackground(new java.awt.Color(204, 201, 197));
        panel_signup_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panel_signup_emp.setPreferredSize(new java.awt.Dimension(130, 40));

        label_signup_emp.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_signup_emp.setForeground(new java.awt.Color(1, 4, 239));
        label_signup_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signup_emp.setText("SignUp");
        label_signup_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signup_empMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signup_empMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signup_empMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signup_empLayout = new javax.swing.GroupLayout(panel_signup_emp);
        panel_signup_emp.setLayout(panel_signup_empLayout);
        panel_signup_empLayout.setHorizontalGroup(
            panel_signup_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signup_empLayout.setVerticalGroup(
            panel_signup_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_employee_log.add(panel_signup_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 279, -1, -1));

        jPanel7.setBackground(new java.awt.Color(201, 204, 197));

        CboxShowPass_emp.setText("show");
        CboxShowPass_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_empActionPerformed(evt);
            }
        });

        CboxRememPassEmployee.setText("kepp me");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CboxShowPass_emp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(CboxRememPassEmployee))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboxShowPass_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CboxRememPassEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panel_employee_log.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 220, 197, -1));

        jPanel1.add(panel_employee_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 300, 380));

        panel_admin_log.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_admin_log.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(22, 22, 22)));
        panel_admin_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_admin_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_admin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_admin.setText("Login Here");
        panel_admin_log.add(login_here_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        admin_login_panel_admin.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        admin_login_panel_admin.setText("Admin Login Panel");
        panel_admin_log.add(admin_login_panel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txt_username_admin.setBackground(new java.awt.Color(204, 201, 197));
        txt_username_admin.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_username_admin.setForeground(new java.awt.Color(0, 0, 0));
        txt_username_admin.setText("Username");
        txt_username_admin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_username_adminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username_adminFocusLost(evt);
            }
        });
        txt_username_admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_username_adminKeyReleased(evt);
            }
        });
        panel_admin_log.add(txt_username_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, 40));

        txt_password_admin.setBackground(new java.awt.Color(204, 201, 197));
        txt_password_admin.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_admin.setText("**********");
        txt_password_admin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_adminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_adminFocusLost(evt);
            }
        });
        panel_admin_log.add(txt_password_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, 40));

        panel_signin_admin.setBackground(new java.awt.Color(204, 201, 197));
        panel_signin_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signin_admin.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label_signin_admin.setForeground(new java.awt.Color(1, 4, 239));
        label_signin_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_admin.setText("SignIn");
        label_signin_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signin_adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signin_adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signin_adminMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signin_adminLayout = new javax.swing.GroupLayout(panel_signin_admin);
        panel_signin_admin.setLayout(panel_signin_adminLayout);
        panel_signin_adminLayout.setHorizontalGroup(
            panel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signin_adminLayout.setVerticalGroup(
            panel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_admin_log.add(panel_signin_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 130, 40));

        panel_signup_admin.setBackground(new java.awt.Color(204, 201, 197));
        panel_signup_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signup_admin.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_signup_admin.setForeground(new java.awt.Color(1, 4, 239));
        label_signup_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signup_admin.setText("SignUp");
        label_signup_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signup_adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signup_adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signup_adminMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signup_adminLayout = new javax.swing.GroupLayout(panel_signup_admin);
        panel_signup_admin.setLayout(panel_signup_adminLayout);
        panel_signup_adminLayout.setHorizontalGroup(
            panel_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signup_adminLayout.setVerticalGroup(
            panel_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_admin_log.add(panel_signup_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 40));

        jPanel2.setBackground(new java.awt.Color(201, 204, 197));

        CboxShowPass_admin.setText("show");
        CboxShowPass_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CboxShowPass_adminMouseEntered(evt);
            }
        });
        CboxShowPass_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_adminActionPerformed(evt);
            }
        });

        CboxRememPass.setText("keep me");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(CboxShowPass_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(CboxRememPass))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboxRememPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CboxShowPass_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_admin_log.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 20));

        jPanel1.add(panel_admin_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 410, 300, 380));

        panel_doctor_log.setBackground(new java.awt.Color(211, 219, 226,80));
        panel_doctor_log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_doctor_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_doctor_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_doctor.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_doctor.setText("Login Here");
        panel_doctor_log.add(login_here_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        doctor_login_panel.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        doctor_login_panel.setText("Doctor Login Panel");
        panel_doctor_log.add(doctor_login_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txt_username_doctor.setBackground(new java.awt.Color(204, 201, 197));
        txt_username_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_username_doctor.setForeground(new java.awt.Color(0, 0, 0));
        txt_username_doctor.setText("Username");
        txt_username_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_username_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username_doctorFocusLost(evt);
            }
        });
        panel_doctor_log.add(txt_username_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, 40));

        txt_password_doctor.setBackground(new java.awt.Color(204, 201, 197));
        txt_password_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_doctor.setForeground(new java.awt.Color(0, 0, 0));
        txt_password_doctor.setText("**********");
        txt_password_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_doctorFocusLost(evt);
            }
        });
        panel_doctor_log.add(txt_password_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 200, 40));

        panel_signin_doctor.setBackground(new java.awt.Color(204, 201, 197));
        panel_signin_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signin_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_signin_doctor.setForeground(new java.awt.Color(1, 4, 239));
        label_signin_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_doctor.setText("SignIn");
        label_signin_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signin_doctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signin_doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signin_doctorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signin_doctorLayout = new javax.swing.GroupLayout(panel_signin_doctor);
        panel_signin_doctor.setLayout(panel_signin_doctorLayout);
        panel_signin_doctorLayout.setHorizontalGroup(
            panel_signin_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signin_doctorLayout.setVerticalGroup(
            panel_signin_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_doctor_log.add(panel_signin_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 130, 40));

        panel_signup_doctor.setBackground(new java.awt.Color(204, 201, 197));
        panel_signup_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signup_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_signup_doctor.setForeground(new java.awt.Color(1, 4, 239));
        label_signup_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signup_doctor.setText("SignUp");
        label_signup_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_signup_doctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_signup_doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_signup_doctorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_signup_doctorLayout = new javax.swing.GroupLayout(panel_signup_doctor);
        panel_signup_doctor.setLayout(panel_signup_doctorLayout);
        panel_signup_doctorLayout.setHorizontalGroup(
            panel_signup_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        panel_signup_doctorLayout.setVerticalGroup(
            panel_signup_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signup_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_doctor_log.add(panel_signup_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 40));

        jPanel6.setBackground(new java.awt.Color(201, 204, 197));

        CboxRememPassDoctor.setText("keep me");

        CboxShowPass_doctor.setText("show");
        CboxShowPass_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_doctorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(CboxShowPass_doctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(CboxRememPassDoctor))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CboxRememPassDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CboxShowPass_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_doctor_log.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 200, 20));

        jPanel1.add(panel_doctor_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 300, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_admin_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_admin_menuMouseEntered
        setColorlogin(panel_admin);
        label_admin_menu.setForeground(new Color(255, 255, 255));
        //admin_login(panel_admin_log);
        panel_admin_log.setVisible(true);
        panel_admin_reg.setVisible(false);
        panel_doctor_log.setVisible(false);
        panel_employee_log.setVisible(false);

        panel_doctor_reg.setVisible(false);
        panel_employee_reg.setVisible(false);

    }//GEN-LAST:event_label_admin_menuMouseEntered

    private void label_admin_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_admin_menuMouseExited
        resetColorlogin(panel_admin);
        label_admin_menu.setForeground(new Color(1, 4, 239));
        // reset_admin_login(panel_admin_log);

    }//GEN-LAST:event_label_admin_menuMouseExited

    private void panel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_panel_closeMouseClicked

    private void label_doctor_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctor_menuMouseEntered
        setColorlogin(panel_doctor);
        label_doctor_menu.setForeground(new Color(255, 255, 255));

        panel_doctor_log.setVisible(true);
        panel_doctor_reg.setVisible(false);
        panel_admin_log.setVisible(false);
        panel_employee_log.setVisible(false);

        panel_admin_reg.setVisible(false);
        panel_employee_reg.setVisible(false);
    }//GEN-LAST:event_label_doctor_menuMouseEntered

    private void label_doctor_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctor_menuMouseExited
        resetColorlogin(panel_doctor);
        label_doctor_menu.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_doctor_menuMouseExited

    private void label_employee_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employee_menuMouseEntered
        setColorlogin(panel_employee);
        label_employee_menu.setForeground(new Color(255, 255, 255));

        panel_employee_log.setVisible(true);
        panel_employee_reg.setVisible(false);
        panel_admin_log.setVisible(false);
        panel_doctor_log.setVisible(false);

        panel_admin_reg.setVisible(false);
        panel_doctor_reg.setVisible(false);
    }//GEN-LAST:event_label_employee_menuMouseEntered

    private void label_employee_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employee_menuMouseExited
        resetColorlogin(panel_employee);
        label_employee_menu.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_employee_menuMouseExited

    private void label_signin_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseEntered
        setColorsigin(panel_signin_admin);
        label_signin_admin.setForeground(new Color(204, 201, 197));
    }//GEN-LAST:event_label_signin_adminMouseEntered

    private void label_signin_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseExited
        resetColorsigin(panel_signin_admin);
        label_signin_admin.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signin_adminMouseExited

    private void label_signup_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_adminMouseEntered
        setColorsigin(panel_signup_admin);
        label_signup_admin.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_label_signup_adminMouseEntered

    private void label_signup_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_adminMouseExited
        resetColorsigin(panel_signup_admin);
        label_signup_admin.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signup_adminMouseExited

    private void txt_username_adminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_adminFocusGained
        if (txt_username_admin.getText().equals("Username")) {
            txt_username_admin.setText("");
            txt_username_admin.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_adminFocusGained

    private void txt_username_adminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_adminFocusLost
        if (txt_username_admin.getText().equals("")) {
            txt_username_admin.setText("Username");
            txt_username_admin.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_adminFocusLost

    private void txt_password_adminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_adminFocusGained
        if (txt_password_admin.getText().equals("**********")) {
            txt_password_admin.setText("");
            txt_password_admin.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_adminFocusGained

    private void txt_password_adminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_adminFocusLost
        if (txt_password_admin.getText().equals("")) {
            txt_password_admin.setText("**********");
            txt_password_admin.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_adminFocusLost

    private void CboxShowPass_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CboxShowPass_adminMouseEntered

    }//GEN-LAST:event_CboxShowPass_adminMouseEntered

    private void CboxShowPass_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_adminActionPerformed
        if (CboxShowPass_admin.isSelected()) {
            txt_password_admin.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_admin.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_adminActionPerformed

    private void CboxShowPass_ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_ADMINActionPerformed
        if (CboxShowPass_ADMIN.isSelected()) {
            TXT_password.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_password.setEchoChar('*');
        }

        if (CboxShowPass_ADMIN.isSelected()) {
            TXT_passwordShow.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_passwordShow.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_ADMINActionPerformed

    private void label_signup_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_doctorMouseEntered
        setColorsigin(panel_signup_doctor);
        label_signup_doctor.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_label_signup_doctorMouseEntered

    private void label_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_doctorMouseExited
        resetColorsigin(panel_signup_doctor);
        label_signup_doctor.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signup_doctorMouseExited

    private void label_signin_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseEntered
        setColorsigin(panel_signin_doctor);
        label_signin_doctor.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_label_signin_doctorMouseEntered

    private void label_signin_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseExited
        resetColorsigin(panel_signin_doctor);
        label_signin_doctor.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signin_doctorMouseExited

    private void txt_username_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_doctorFocusGained
        if (txt_username_doctor.getText().equals("Username")) {
            txt_username_doctor.setText("");
            txt_username_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_doctorFocusGained

    private void txt_username_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_doctorFocusLost
        if (txt_username_doctor.getText().equals("")) {
            txt_username_doctor.setText("Username");
            txt_username_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_doctorFocusLost

    private void txt_password_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_doctorFocusGained
        if (txt_password_doctor.getText().equals("**********")) {
            txt_password_doctor.setText("");
            txt_password_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_doctorFocusGained

    private void txt_password_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_doctorFocusLost
        if (txt_password_doctor.getText().equals("")) {
            txt_password_doctor.setText("**********");
            txt_password_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_doctorFocusLost

    private void CboxShowPass_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_doctorActionPerformed
        if (CboxShowPass_doctor.isSelected()) {
            txt_password_doctor.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_doctor.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_doctorActionPerformed

    private void TXT_username_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_doctorFocusGained
        if (TXT_username_doctor.getText().equals("Username")) {
            TXT_username_doctor.setText("");
            TXT_username_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_username_doctorFocusGained

    private void TXT_username_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_doctorFocusLost

        if (TXT_username_doctor.getText().equals("")) {
            TXT_username_doctor.setText("Username");
            TXT_username_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_username_doctorFocusLost

    private void TXT_password_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_doctorFocusGained
        if (TXT_password_doctor.getText().equals("**********")) {
            TXT_password_doctor.setText("");
            TXT_password_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_password_doctorFocusGained

    private void TXT_password_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_doctorFocusLost
        if (TXT_password_doctor.getText().equals("")) {
            TXT_password_doctor.setText("**********");
            TXT_password_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_password_doctorFocusLost

    private void TXT_passwordShow_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorFocusGained

        if (TXT_passwordShow_doctor.getText().equals("**********")) {
            TXT_passwordShow_doctor.setText("");
            TXT_passwordShow_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShow_doctorFocusGained

    private void TXT_passwordShow_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorFocusLost

        if (TXT_passwordShow_doctor.getText().equals("")) {
            TXT_passwordShow_doctor.setText("**********");
            TXT_passwordShow_doctor.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShow_doctorFocusLost

    private void LABEL_signup_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseEntered
        setColorsigin(PANEL_signup_doctor);
        LABEL_signup_doctor.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_LABEL_signup_doctorMouseEntered

    private void LABEL_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseExited
        resetColorsigin(PANEL_signup_doctor);
        LABEL_signup_doctor.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_LABEL_signup_doctorMouseExited

    private void label_signin_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseEntered
        setColorsigin(panel_signin_emp);
        label_signin_emp.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_label_signin_empMouseEntered

    private void label_signin_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseExited
        resetColorsigin(panel_signin_emp);
        label_signin_emp.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signin_empMouseExited

    private void label_signup_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_empMouseEntered
        setColorsigin(panel_signup_emp);
        label_signup_emp.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_label_signup_empMouseEntered

    private void label_signup_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_empMouseExited
        resetColorsigin(panel_signup_emp);
        label_signup_emp.setForeground(new Color(1, 4, 239));
    }//GEN-LAST:event_label_signup_empMouseExited

    private void txt_username_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_empFocusGained
        if (txt_username_emp.getText().equals("Username")) {
            txt_username_emp.setText("");
            txt_username_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_empFocusGained

    private void txt_username_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username_empFocusLost
        if (txt_username_emp.getText().equals("")) {
            txt_username_emp.setText("Username");
            txt_username_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_username_empFocusLost

    private void txt_password_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_empFocusGained
        if (txt_password_emp.getText().equals("**********")) {
            txt_password_emp.setText("");
            txt_password_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_empFocusGained

    private void txt_password_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_empFocusLost
        if (txt_password_emp.getText().equals("")) {
            txt_password_emp.setText("**********");
            txt_password_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_txt_password_empFocusLost

    private void LABEL_signup_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseEntered
        setColorsigin(PANEL_signup_emp);
        LABEL_signup_emp.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_LABEL_signup_empMouseEntered

    private void LABEL_signup_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseExited
        resetColorsigin(PANEL_signup_emp);
        LABEL_signup_emp.setForeground(new Color(1, 4, 239));

    }//GEN-LAST:event_LABEL_signup_empMouseExited

    private void TXT_username_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_empFocusGained
        if (TXT_username_emp.getText().equals("Username")) {
            TXT_username_emp.setText("");
            TXT_username_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_username_empFocusGained

    private void TXT_username_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_empFocusLost
        if (TXT_username_emp.getText().equals("")) {
            TXT_username_emp.setText("Username");
            TXT_username_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_username_empFocusLost

    private void TXT_password_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_empFocusGained
        if (TXT_password_emp.getText().equals("**********")) {
            TXT_password_emp.setText("");
            TXT_password_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_password_empFocusGained

    private void TXT_password_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_empFocusLost
        if (TXT_password_emp.getText().equals("")) {
            TXT_password_emp.setText("**********");
            TXT_password_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_password_empFocusLost

    private void TXT_passwordShow_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empFocusGained
        if (TXT_passwordShow_emp.getText().equals("**********")) {
            TXT_passwordShow_emp.setText("");
            TXT_passwordShow_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShow_empFocusGained

    private void TXT_passwordShow_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empFocusLost
        if (TXT_passwordShow_emp.getText().equals("")) {
            TXT_passwordShow_emp.setText("**********");
            TXT_passwordShow_emp.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShow_empFocusLost

    //************************************//////////////////////////////////////Extra------------------------------
    private void label_admin_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_admin_menuMouseClicked

    }//GEN-LAST:event_label_admin_menuMouseClicked

    private void label_admin_menuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_admin_menuMouseReleased

    }//GEN-LAST:event_label_admin_menuMouseReleased
    //************************************//////////////////////////////////////Extra------------------------------


    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();
        new login_panel().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void label_signup_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_adminMouseClicked
        panel_admin_log.setVisible(false);
        panel_admin_reg.setVisible(true);
    }//GEN-LAST:event_label_signup_adminMouseClicked



    private void CboxShowPass_DOCTORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_DOCTORActionPerformed

        if (CboxShowPass_DOCTOR.isSelected()) {
            TXT_password_doctor.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_password_doctor.setEchoChar('*');
        }

        if (CboxShowPass_DOCTOR.isSelected()) {
            TXT_passwordShow_doctor.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_passwordShow_doctor.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_DOCTORActionPerformed

    private void label_signup_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_doctorMouseClicked
        
        panel_doctor_log.setVisible(false);
        panel_doctor_reg.setVisible(true);
    }//GEN-LAST:event_label_signup_doctorMouseClicked

    private void LABEL_signup_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseClicked
        
        if (TXT_username_doctor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Write Username !","Sorry!",JOptionPane.ERROR_MESSAGE);
        } else if (TXT_password_doctor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Password !","Sorry!",JOptionPane.ERROR_MESSAGE);
        }
        else if (TXT_passwordShow_doctor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Confirm Password !","Sorry!",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try {

                if (TXT_password_doctor.getText().equals(TXT_passwordShow_doctor.getText())) {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
                    Statement st = (Statement) con.createStatement();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO doctor_login(Username,Password,ConfirmPass)" + "values(?,?,?)");
                    ps.setString(1, TXT_username_doctor.getText());
                    ps.setString(2, TXT_password_doctor.getText());
                    ps.setString(3, TXT_passwordShow_doctor.getText());
                    ps.executeUpdate();
                     new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    panel_doctor_log.setVisible(true);
                    panel_doctor_reg.setVisible(false);
                    
                } else {
                    //JOptionPane.showMessageDialog(null, "dont match");
                    new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Password don't match", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Sorry! Username allready uses");
                new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Username allready uses", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            }
        }
        
    }//GEN-LAST:event_LABEL_signup_doctorMouseClicked

    private void CboxShowPass_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_empActionPerformed
        if (CboxShowPass_emp.isSelected()) {
            txt_password_emp.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_emp.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_empActionPerformed

    private void label_signup_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signup_empMouseClicked

        panel_employee_reg.setVisible(true);
        panel_employee_log.setVisible(false);
    }//GEN-LAST:event_label_signup_empMouseClicked

    private void panel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_closeMouseEntered
        setColor(panel_close);
        label_close_white.setVisible(true);
        label_close.setVisible(false);

    }//GEN-LAST:event_panel_closeMouseEntered

    private void panel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_closeMouseExited
        resetColor(panel_close);
        label_close_white.setVisible(false);
        label_close.setVisible(true);
    }//GEN-LAST:event_panel_closeMouseExited

    private void PANEL_signup_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANEL_signup_empMouseClicked

    }//GEN-LAST:event_PANEL_signup_empMouseClicked

    private void LABEL_signup_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseClicked
  
        try {

            if (TXT_password_emp.getText().equals(TXT_passwordShow_emp.getText())) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
                Statement st = (Statement) con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO employee_login(Username,Password,ConfirmPass)" + "values(?,?,?)");
                ps.setString(1, TXT_username_emp.getText());
                ps.setString(2, TXT_password_emp.getText());
                ps.setString(3, TXT_passwordShow_emp.getText());
                ps.executeUpdate();
                 new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                panel_employee_reg.setVisible(false);
                panel_employee_log.setVisible(true);
            } else {
               //JOptionPane.showMessageDialog(null, "dont match");
               new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Password don't match", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Sorry! Username allready uses");
            new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Username allready uses", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
        }
    }//GEN-LAST:event_LABEL_signup_empMouseClicked

    private void label_signin_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseClicked

        int flag = 1;
        if (txt_username_admin.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Write Username !");
        } else if (txt_password_admin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Password !");
        } else {
            try {

                String Driver = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/medical";
                Class.forName(Driver);
                Connection Conn = DriverManager.getConnection(URL, "root", "");
                Statement S = Conn.createStatement();
                ResultSet RS = S.executeQuery(
                        "SELECT * FROM medical_login where Username ='" + txt_username_admin.getText()
                        + "' and Password ='" + txt_password_admin.getText() + "'");

                while (RS.next()) {
                    String user = RS.getString("Username");
                    String pass = RS.getString("Password");
                    if (user.equals(txt_username_admin.getText()) & pass.equals(txt_password_admin.getText())) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) {

                    if (CboxRememPass.isSelected()) {
                        checked(true);

                    } else {
                        checked(false);

                    }
                    dispose();
                    //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    panel_admin_log.setVisible(false);
                    new admin_panel().setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username and Password","Sorry!", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_label_signin_adminMouseClicked

    private void txt_username_adminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_username_adminKeyReleased

        //String PATTERN = "^[a-z0-9---,.]{3,30}$";
        String PATTERN = "^[a-z]{3,15}[0-9]{2,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txt_username_admin.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            error.setText("*example: abc45");
        } else if (match.matches()) {
            error.setForeground(new Color(0,51,51));
            error.setText("complete");
        }
        else
        {
          error.setText(null);
        }
    }//GEN-LAST:event_txt_username_adminKeyReleased

    private void TXT_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_usernameFocusGained
         if (TXT_username.getText().equals("Username")) {
            TXT_username.setText("");
            TXT_username.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_usernameFocusGained

    private void TXT_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_usernameFocusLost
        if (TXT_username.getText().equals("")) {
            TXT_username.setText("Username");
            TXT_username.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_usernameFocusLost

    private void TXT_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_usernameKeyReleased
     
         
        String PATTERN = "^[a-z]{3,15}[0-9]{2,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(TXT_username.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            error.setText("*example: abc45");
        } else if (match.matches()) {
            error.setForeground(new Color(0,51,51));
            error.setText("complete");
        }
        else
        {
          error.setText(null);
        }
    }//GEN-LAST:event_TXT_usernameKeyReleased

    private void TXT_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordFocusGained
       if (TXT_password.getText().equals("**********")) {
            TXT_password.setText("");
            TXT_password.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordFocusGained

    private void TXT_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordFocusLost
        if (TXT_password.getText().equals("")) {
            TXT_password.setText("**********");
            TXT_password.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordFocusLost

    private void TXT_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordKeyReleased
      
        Password();
    }//GEN-LAST:event_TXT_passwordKeyReleased

    private void TXT_passwordShowFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShowFocusGained
       if (TXT_passwordShow.getText().equals("**********")) {
            TXT_passwordShow.setText("");
            TXT_passwordShow.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShowFocusGained

    private void TXT_passwordShowFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShowFocusLost
        if (TXT_passwordShow.getText().equals("")) {
            TXT_passwordShow.setText("**********");
            TXT_passwordShow.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_TXT_passwordShowFocusLost

    private void TXT_passwordShowKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordShowKeyReleased
        Confirmpassword();
    }//GEN-LAST:event_TXT_passwordShowKeyReleased

    private void LABEL_signup_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_adminMouseClicked
      
        
        try {

            if (TXT_password.getText().equals(TXT_passwordShow.getText())) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
                Statement st = (Statement) con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO medical_login(Username,Password,ConfirmPass)" + "values(?,?,?)");
                ps.setString(1, TXT_username.getText());
                ps.setString(2, TXT_password.getText());
                ps.setString(3, TXT_passwordShow.getText());
                ps.executeUpdate();
                new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                panel_admin_log.setVisible(true);
                panel_admin_reg.setVisible(false);
            } else {
               //JOptionPane.showMessageDialog(null, "dont match");
               new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Password don't match", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Sorry! Username allready uses");
            new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Username allready uses", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
        }
    }//GEN-LAST:event_LABEL_signup_adminMouseClicked

    private void LABEL_signup_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_adminMouseEntered
        setColorsigin(PANEL_signup_admin);
        LABEL_signup_admin.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_LABEL_signup_adminMouseEntered

    private void LABEL_signup_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_adminMouseExited
        resetColorsigin(PANEL_signup_admin);
        LABEL_signup_admin.setForeground(new Color(1, 4, 239));
        
    }//GEN-LAST:event_LABEL_signup_adminMouseExited

    private void TXT_username_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_username_doctorKeyReleased
        
        error_doctor.setVisible(true);
        error_panel_doctor.setVisible(true);
        String PATTERN = "^[a-z]{3,15}[0-9]{2,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(TXT_username_doctor.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            error_panel_doctor.setBackground(new Color(152,0,0));
            error_doctor.setText("Example: aaa11");
        } else if (match.matches()) {
            error_panel_doctor.setBackground(new Color(0,51,51));
            error_doctor.setText("complete");
  
        }

    }//GEN-LAST:event_TXT_username_doctorKeyReleased

    private void TXT_password_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_password_doctorKeyReleased
        Doctor_Password();
        
    }//GEN-LAST:event_TXT_password_doctorKeyReleased

    private void TXT_passwordShow_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorKeyReleased
       Doctor_Cpassword();
        
    }//GEN-LAST:event_TXT_passwordShow_doctorKeyReleased

    private void label_signin_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseClicked
       
        int flag = 1;
        if (txt_username_doctor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Write Username !");
        } else if (txt_password_doctor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Password !");
        } else {
            try {

                String Driver = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/medical";
                Class.forName(Driver);
                Connection Conn = DriverManager.getConnection(URL, "root", "");
                Statement S = Conn.createStatement();
                ResultSet RS = S.executeQuery(
                        "SELECT * FROM doctor_login where Username ='" + txt_username_doctor.getText()
                        + "' and Password ='" + txt_password_doctor.getText() + "'");

                while (RS.next()) {
                    String user = RS.getString("Username");
                    String pass = RS.getString("Password");
                    if (user.equals(txt_username_doctor.getText()) & pass.equals(txt_password_doctor.getText())) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) {

                    if (CboxRememPassDoctor.isSelected()) {
                        checkedDoctor(true);

                    } else {
                        checkedDoctor(false);

                    }
                    dispose();
                    new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    panel_doctor_log.setVisible(false);
                    new doctor_panel().setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_label_signin_doctorMouseClicked

    private void TXT_username_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_username_empKeyReleased
       
        error_emp.setVisible(true);
        error_panel_emp.setVisible(true);
        String PATTERN = "^[a-z]{3,15}[0-9]{2,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(TXT_username_emp.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            error_panel_emp.setBackground(new Color(152,0,0));
            error_emp.setText("Example: aaa11");
        } else if (match.matches()) {
            error_panel_emp.setBackground(new Color(0,51,51));
            error_emp.setText("complete");
  
        }
    }//GEN-LAST:event_TXT_username_empKeyReleased

    private void TXT_password_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_password_empKeyReleased
      Employee_Password();
    }//GEN-LAST:event_TXT_password_empKeyReleased

    private void CboxShowPass_EMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_EMPActionPerformed
        
        if (CboxShowPass_EMP.isSelected()) {
            TXT_password_emp.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_password_emp.setEchoChar('*');
        }
        if (CboxShowPass_EMP.isSelected()) {
            TXT_passwordShow_emp.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TXT_passwordShow_emp.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_EMPActionPerformed

    private void TXT_passwordShow_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empKeyReleased
       Employee_ConfirmPassword();
    }//GEN-LAST:event_TXT_passwordShow_empKeyReleased

    private void label_signin_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseClicked
       
        int flag = 1;
        if (txt_username_emp.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Write Username !","Sorry!",JOptionPane.ERROR_MESSAGE);
        } else if (txt_password_emp.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Password !","Sorry!",JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                String Driver = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/medical";
                Class.forName(Driver);
                Connection Conn = DriverManager.getConnection(URL, "root", "");
                Statement S = Conn.createStatement();
                ResultSet RS = S.executeQuery(
                        "SELECT * FROM employee_login where Username ='" + txt_username_emp.getText()
                        + "' and Password ='" + txt_password_emp.getText() + "'");

                while (RS.next()) {
                    String user = RS.getString("Username");
                    String pass = RS.getString("Password");
                    if (user.equals(txt_username_emp.getText()) & pass.equals(txt_password_emp.getText())) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) {

                    if (CboxRememPass.isSelected()) {
                        checkedEmployee(true);

                    } else {
                       checkedEmployee(false);

                    }
                    dispose();
                    //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION,"Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    panel_employee_log.setVisible(false);
                    new employee_panel().setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Username and Password","Sorry!",JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_label_signin_empMouseClicked

    private void panel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_minimizeMouseEntered
        setColorMinimize(panel_minimize);
    }//GEN-LAST:event_panel_minimizeMouseEntered

    private void panel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_minimizeMouseExited
        resetColorMinimize(panel_minimize);
    }//GEN-LAST:event_panel_minimizeMouseExited

    private void panel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_minimizeMouseClicked
       this.setState(login_panel.ICONIFIED);
    }//GEN-LAST:event_panel_minimizeMouseClicked

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
            java.util.logging.Logger.getLogger(login_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CboxRememPass;
    private javax.swing.JCheckBox CboxRememPassDoctor;
    private javax.swing.JCheckBox CboxRememPassEmployee;
    private javax.swing.JCheckBox CboxShowPass_ADMIN;
    private javax.swing.JCheckBox CboxShowPass_DOCTOR;
    private javax.swing.JCheckBox CboxShowPass_EMP;
    private javax.swing.JCheckBox CboxShowPass_admin;
    private javax.swing.JCheckBox CboxShowPass_doctor;
    private javax.swing.JCheckBox CboxShowPass_emp;
    private javax.swing.JLabel LABEL_signup_admin;
    private javax.swing.JLabel LABEL_signup_doctor;
    private javax.swing.JLabel LABEL_signup_emp;
    private javax.swing.JPanel PANEL_signup_admin;
    private javax.swing.JPanel PANEL_signup_doctor;
    private javax.swing.JPanel PANEL_signup_emp;
    private javax.swing.JPasswordField TXT_password;
    private javax.swing.JPasswordField TXT_passwordShow;
    private javax.swing.JPasswordField TXT_passwordShow_doctor;
    private javax.swing.JPasswordField TXT_passwordShow_emp;
    private javax.swing.JPasswordField TXT_password_doctor;
    private javax.swing.JPasswordField TXT_password_emp;
    private javax.swing.JTextField TXT_username;
    private javax.swing.JTextField TXT_username_doctor;
    private javax.swing.JTextField TXT_username_emp;
    private javax.swing.JLabel admin_login_panel_admin;
    private javax.swing.JLabel admin_registration_admin;
    private javax.swing.JLabel doctor_login_panel;
    private javax.swing.JLabel doctor_registration_doctor;
    private javax.swing.JLabel employee_registration_emp;
    private javax.swing.JLabel employye_login_emp;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error_doctor;
    private javax.swing.JLabel error_emp;
    private javax.swing.JPanel error_panel;
    private javax.swing.JPanel error_panel_doctor;
    private javax.swing.JPanel error_panel_emp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_admin_menu;
    private javax.swing.JLabel label_close;
    private javax.swing.JLabel label_close_white;
    private javax.swing.JLabel label_doctor_menu;
    private javax.swing.JLabel label_employee_menu;
    private javax.swing.JLabel label_minimize;
    private javax.swing.JLabel label_signin_admin;
    private javax.swing.JLabel label_signin_doctor;
    private javax.swing.JLabel label_signin_emp;
    private javax.swing.JLabel label_signup_admin;
    private javax.swing.JLabel label_signup_doctor;
    private javax.swing.JLabel label_signup_emp;
    private javax.swing.JLabel login_here_admin;
    private javax.swing.JLabel login_here_doctor;
    private javax.swing.JLabel login_here_emp;
    private javax.swing.JPanel panel_admin;
    private javax.swing.JPanel panel_admin_log;
    private javax.swing.JPanel panel_admin_reg;
    private javax.swing.JPanel panel_close;
    private javax.swing.JPanel panel_doctor;
    private javax.swing.JPanel panel_doctor_log;
    private javax.swing.JPanel panel_doctor_reg;
    private javax.swing.JPanel panel_employee;
    private javax.swing.JPanel panel_employee_log;
    private javax.swing.JPanel panel_employee_reg;
    private javax.swing.JPanel panel_minimize;
    private javax.swing.JPanel panel_signin_admin;
    private javax.swing.JPanel panel_signin_doctor;
    private javax.swing.JPanel panel_signin_emp;
    private javax.swing.JPanel panel_signup_admin;
    private javax.swing.JPanel panel_signup_doctor;
    private javax.swing.JPanel panel_signup_emp;
    private javax.swing.JLabel registration_admin;
    private javax.swing.JLabel registration_doctor;
    private javax.swing.JLabel registration_here_emp;
    private javax.swing.JPanel show_panelk;
    private javax.swing.JPasswordField txt_password_admin;
    private javax.swing.JPasswordField txt_password_doctor;
    private javax.swing.JPasswordField txt_password_emp;
    private javax.swing.JTextField txt_username_admin;
    private javax.swing.JTextField txt_username_doctor;
    private javax.swing.JTextField txt_username_emp;
    // End of variables declaration//GEN-END:variables
}
