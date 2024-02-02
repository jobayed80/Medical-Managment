/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import medical.*;
import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author h
 */
public class Admin_All_Access extends javax.swing.JFrame {
    
    public int z=0;
    public int save_upgrade=0; 
    boolean a= true;
    //958C8C   // C0C9D3   #787E74
    
   
     
    public Admin_All_Access() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

       menuList.setVisible(false);
       Profile.setVisible(false);
       profile.setVisible(false);
       Ticket.setVisible(false);
       ticket.setVisible(false);
       Patient.setVisible(false);
       patient.setVisible(false);
       error_emp.setVisible(false);
       error_panel_emp.setVisible(false);
       error_doctor.setVisible(false);
       error_panel_doctor.setVisible(false);
       panel_employee_reg.setVisible(false);
       panel_doctor_reg.setVisible(false);
      
        
        //error admin    #B5D8C7   #84C085  971, 635
       
    }
    //button hover
    //    Start admin color
    public void setColorMenu(JPanel p) {
        p.setBackground(new Color(5,10,46));
        

    }

    public void resetColorMenu(JPanel p1) {
        p1.setBackground(new Color(255,255,255));

    }
    
    //    Start admin color
    public void setColorsigin(JPanel p) {
        p.setBackground(new Color(33, 47, 61  ));

    }

    public void resetColorsigin(JPanel p1) {
        p1.setBackground(new Color(46,64,83));

    }
    
    
    //ImagePath
    String ImgPath = null;
    
    //Resize Image 
//    public ImageIcon ResizeImage(String imagePath, byte[] pic)
//    {
//        ImageIcon myImage = null;
//        if(imagePath !=null)
//        {
//            myImage = new ImageIcon(imagePath);
//        }
//        else
//        {
//            myImage = new ImageIcon(pic);
//        }
//        Image img = myImage.getImage();
//        Image img2 = img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH);
//        ImageIcon image = new ImageIcon(img2);
//        return image;
//        
//    }
//    
    
    
    public void ChangeColor(JPanel hover, Color random)
    {
        hover.setBackground(random);
    }
    public void clickMenu(JPanel h1, JPanel h2, JPanel h3, int numberbool)
    {
        switch (numberbool) {
            case 1:
                h1.setBackground(new Color (0,60,60)); //25,29,74
                h2.setBackground(new Color (5,23,56));
                h3.setBackground(new Color (5,23,56));//25,29,76  [5,23,56]
                break;
            case 2:
                h1.setBackground(new Color (5,23,56)); //25,29,74
                h2.setBackground(new Color (0,60,60));
                h3.setBackground(new Color (5,23,56));//25,29,76
                break;
            default:
                h1.setBackground(new Color (5,23,56)); //25,29,74
                h2.setBackground(new Color (5,23,56));
                h3.setBackground(new Color (0,60,60));//25,29,76
                break;
        }
    }
    
   
    public void clickMenuLeft(JPanel h1, JPanel h2,int num)
    {
        if(num==1)
        {
            h1.setBackground(new Color (25,29,74)); //25,29,74
            h2.setBackground(new Color (5,10,46)); //25,29,74
        }
         if(num==2)
        {
            h1.setBackground(new Color (5,10,46)); //25,29,74
            h2.setBackground(new Color (25,29,74)); //25,29,74
        }
    }
    public void clickMenuRight(JPanel h1, JPanel h2,int num)
    {
        if(num==1)
        {
            h1.setBackground(new Color (33, 47, 61)); //25,29,74
            h2.setBackground(new Color (46,64,83)); //25,29,74
            
        }
        else
        {
            h1.setBackground(new Color (46,64,83)); //25,29,74
            h2.setBackground(new Color (33, 47, 61)); //25,29,74
        }
    }
    public void MenuHideShow(JPanel menuHideShow, boolean body)
    {
        if(body==true)
        {
            menuHideShow.setPreferredSize(new Dimension(50, menuHideShow.getHeight()));
        }
        else
        {
            menuHideShow.setPreferredSize(new Dimension(270, menuHideShow.getHeight()));
        }
    }

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
            error_emp.setForeground(new Color(0,204,204));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            
            error_emp.setText("Weak");
            error_emp.setForeground(new Color(0,102,255));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Medium");
            error_emp.setForeground(new Color(255,0,255));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Strong");
            error_emp.setForeground(new Color(0,255,255));
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
            error_emp.setForeground(new Color(0,204,204));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            
            error_emp.setText("Weak");
            error_emp.setForeground(new Color(0,102,255));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Medium");
            error_emp.setForeground(new Color(255,0,255));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_emp.setVisible(true);
            error_panel_emp.setVisible(true);
            error_emp.setText("Strong");
            error_emp.setForeground(new Color(0,255,255));
        } 
    }
    
    public void  Doc_Password()
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
            error_doctor.setForeground(new Color(0,204,204));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            
            error_doctor.setText("Weak");
            error_doctor.setForeground(new Color(0,102,255));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Medium");
            error_doctor.setForeground(new Color(255,0,255));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Strong");
            error_doctor.setForeground(new Color(0,255,255));
        } 
    }
    
    public void  Doc_ConfirmPassword()
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
            error_doctor.setForeground(new Color(0,204,204));
        }
        if(pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) || (specialcharacters == 1)))
        {
          
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            
            error_doctor.setText("Weak");
            error_doctor.setForeground(new Color(0,102,255));
        }
        if ((pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) || (digits == 1) && (specialcharacters == 1)))
            &&
            (pass.length() >= 8 && (((uppercase == 1) && (lowercase == 1)) && (digits == 1) || (specialcharacters == 1))))
        {
        
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Medium");
            error_doctor.setForeground(new Color(255,0,255));
        }
        if (pass.length() >= 8 && (uppercase == 1) && (lowercase == 1) && (digits == 1) && (specialcharacters == 1))
        {
           
            error_doctor.setVisible(true);
            error_panel_doctor.setVisible(true);
            error_doctor.setText("Strong");
            error_doctor.setForeground(new Color(0,255,255));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LABEL_signup_doctor = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        menuIcon = new javax.swing.JPanel();
        menu_first_border = new javax.swing.JPanel();
        menu_first = new javax.swing.JPanel();
        menu_first_label = new javax.swing.JLabel();
        setting_border = new javax.swing.JPanel();
        setting = new javax.swing.JPanel();
        settinf_label = new javax.swing.JLabel();
        menuList = new javax.swing.JPanel();
        Profile = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        Ticket = new javax.swing.JPanel();
        ticket = new javax.swing.JLabel();
        Patient = new javax.swing.JPanel();
        patient = new javax.swing.JLabel();
        lineticket = new javax.swing.JPanel();
        lineprofile = new javax.swing.JPanel();
        linepatient = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        closeMax_body = new javax.swing.JPanel();
        close_panel = new javax.swing.JPanel();
        close_white = new javax.swing.JLabel();
        maximise = new javax.swing.JPanel();
        maximise_label = new javax.swing.JLabel();
        main_body = new javax.swing.JPanel();
        body = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panel_employee = new javax.swing.JPanel();
        label_employee = new javax.swing.JLabel();
        panel_doctor = new javax.swing.JPanel();
        label_doctor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panel_employee_seperator = new javax.swing.JPanel();
        panel_doctor_seperator = new javax.swing.JPanel();
        panel_doctor_reg = new javax.swing.JPanel();
        doctor_registration_doctor = new javax.swing.JLabel();
        registration_doctor = new javax.swing.JLabel();
        TXT_doctor_Id = new javax.swing.JTextField();
        TXT_password_doctor = new javax.swing.JPasswordField();
        TXT_passwordShow_doctor = new javax.swing.JPasswordField();
        PANEL_signup_doctor = new javax.swing.JPanel();
        LABBEL_signup_doctor = new javax.swing.JLabel();
        show_panelk = new javax.swing.JPanel();
        CboxShowPass_DOCTOR = new javax.swing.JCheckBox();
        error_panel_doctor = new javax.swing.JPanel();
        error_doctor = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        LABEL_signup_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABEL_signup_doctor.setForeground(new java.awt.Color(5, 10, 46));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setPreferredSize(new java.awt.Dimension(240, 557));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuIcon.setBackground(new java.awt.Color(5, 10, 46));
        menuIcon.setPreferredSize(new java.awt.Dimension(50, 557));
        menuIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_first_border.setBackground(new java.awt.Color(5, 10, 46));
        menu_first_border.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuIcon.add(menu_first_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 6));

        menu_first.setBackground(new java.awt.Color(5, 10, 46));
        menu_first.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_firstMouseEntered(evt);
            }
        });
        menu_first.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_first_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_first_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/menu.png"))); // NOI18N
        menu_first_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_first_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_first_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_first_labelMouseExited(evt);
            }
        });
        menu_first.add(menu_first_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 51, 40));

        menuIcon.add(menu_first, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 51, 40));

        setting_border.setBackground(new java.awt.Color(5, 10, 46));
        setting_border.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        menuIcon.add(setting_border, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 50, 6));

        setting.setBackground(new java.awt.Color(5, 10, 46));
        setting.setLayout(new java.awt.BorderLayout());

        settinf_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settinf_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/settings.png"))); // NOI18N
        settinf_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settinf_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settinf_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settinf_labelMouseExited(evt);
            }
        });
        setting.add(settinf_label, java.awt.BorderLayout.CENTER);

        menuIcon.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 50, 40));

        menu.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 735));

        menuList.setBackground(new java.awt.Color(5, 10, 46));
        menuList.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(255, 255, 255)));
        menuList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuList.setPreferredSize(new java.awt.Dimension(220, 23));
        menuList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Profile.setBackground(new java.awt.Color(5, 23, 56));
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfileMouseExited(evt);
            }
        });
        Profile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ProfileComponentShown(evt);
            }
        });
        Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setText("Account");
        Profile.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 41));

        menuList.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 81, 188, 40));

        Ticket.setBackground(new java.awt.Color(5, 23, 56));
        Ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TicketMouseExited(evt);
            }
        });
        Ticket.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TicketComponentShown(evt);
            }
        });

        ticket.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ticket.setForeground(new java.awt.Color(255, 255, 255));
        ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ticket.setText("Employee");

        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        menuList.add(Ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 140, 190, -1));

        Patient.setBackground(new java.awt.Color(5, 23, 56));
        Patient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PatientMouseExited(evt);
            }
        });

        patient.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        patient.setForeground(new java.awt.Color(255, 255, 255));
        patient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient.setText("Doctor");

        javax.swing.GroupLayout PatientLayout = new javax.swing.GroupLayout(Patient);
        Patient.setLayout(PatientLayout);
        PatientLayout.setHorizontalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientLayout.createSequentialGroup()
                .addComponent(patient, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        PatientLayout.setVerticalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(patient, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        menuList.add(Patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 230, 190, -1));

        lineticket.setBackground(new java.awt.Color(5, 10, 46));
        lineticket.setPreferredSize(new java.awt.Dimension(0, 4));

        javax.swing.GroupLayout lineticketLayout = new javax.swing.GroupLayout(lineticket);
        lineticket.setLayout(lineticketLayout);
        lineticketLayout.setHorizontalGroup(
            lineticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        lineticketLayout.setVerticalGroup(
            lineticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        menuList.add(lineticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 180, 188, 4));

        lineprofile.setBackground(new java.awt.Color(5, 10, 46));
        lineprofile.setPreferredSize(new java.awt.Dimension(0, 4));

        javax.swing.GroupLayout lineprofileLayout = new javax.swing.GroupLayout(lineprofile);
        lineprofile.setLayout(lineprofileLayout);
        lineprofileLayout.setHorizontalGroup(
            lineprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        lineprofileLayout.setVerticalGroup(
            lineprofileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        menuList.add(lineprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 120, 188, 4));

        linepatient.setBackground(new java.awt.Color(5, 10, 46));
        linepatient.setPreferredSize(new java.awt.Dimension(0, 4));

        javax.swing.GroupLayout linepatientLayout = new javax.swing.GroupLayout(linepatient);
        linepatient.setLayout(linepatientLayout);
        linepatientLayout.setHorizontalGroup(
            linepatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        linepatientLayout.setVerticalGroup(
            linepatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        menuList.add(linepatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 270, 188, 4));

        menu.add(menuList, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 735));

        jPanel4.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 45, -1, 735));

        header.setBackground(new java.awt.Color(5, 10, 46));
        header.setPreferredSize(new java.awt.Dimension(875, 43));
        header.setLayout(new java.awt.BorderLayout());

        closeMax_body.setBackground(new java.awt.Color(5, 10, 46));
        closeMax_body.setPreferredSize(new java.awt.Dimension(84, 54));

        close_panel.setBackground(new java.awt.Color(5, 10, 46));
        close_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_panelMouseExited(evt);
            }
        });
        close_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close_white.setBackground(new java.awt.Color(5, 10, 46));
        close_white.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_white.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/close_white1.png"))); // NOI18N
        close_white.setPreferredSize(new java.awt.Dimension(16, 20));
        close_panel.add(close_white, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 39, 42));

        maximise.setBackground(new java.awt.Color(5, 10, 46));
        maximise.setPreferredSize(new java.awt.Dimension(100, 42));
        maximise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximiseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maximiseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maximiseMouseExited(evt);
            }
        });
        maximise.setLayout(new java.awt.BorderLayout());

        maximise_label.setBackground(new java.awt.Color(5, 10, 46));
        maximise_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maximise_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/maximize.png"))); // NOI18N
        maximise.add(maximise_label, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout closeMax_bodyLayout = new javax.swing.GroupLayout(closeMax_body);
        closeMax_body.setLayout(closeMax_bodyLayout);
        closeMax_bodyLayout.setHorizontalGroup(
            closeMax_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closeMax_bodyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(maximise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(close_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closeMax_bodyLayout.setVerticalGroup(
            closeMax_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closeMax_bodyLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(closeMax_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maximise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        header.add(closeMax_body, java.awt.BorderLayout.LINE_END);

        jPanel4.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1236, -1));

        main_body.setBackground(new java.awt.Color(0, 51, 51));
        main_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(46, 64, 83));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(46, 64, 83));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_employee.setBackground(new java.awt.Color(46, 64, 83));
        panel_employee.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        label_employee.setBackground(new java.awt.Color(46, 64, 83));
        label_employee.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        label_employee.setForeground(new java.awt.Color(214, 234, 248));
        label_employee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_employee.setText("Employee");
        label_employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_employeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_employeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_employeeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_employeeLayout = new javax.swing.GroupLayout(panel_employee);
        panel_employee.setLayout(panel_employeeLayout);
        panel_employeeLayout.setHorizontalGroup(
            panel_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );
        panel_employeeLayout.setVerticalGroup(
            panel_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel3.add(panel_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 150, 170, 40));

        panel_doctor.setBackground(new java.awt.Color(46, 64, 83));
        panel_doctor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        label_doctor.setBackground(new java.awt.Color(46, 64, 83));
        label_doctor.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        label_doctor.setForeground(new java.awt.Color(214, 234, 248));
        label_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_doctor.setText("Doctor");
        label_doctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_doctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_doctorMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_doctorLayout = new javax.swing.GroupLayout(panel_doctor);
        panel_doctor.setLayout(panel_doctorLayout);
        panel_doctorLayout.setHorizontalGroup(
            panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );
        panel_doctorLayout.setVerticalGroup(
            panel_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel3.add(panel_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 290, 170, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/doctor.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/employee.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        panel_employee_seperator.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panel_employee_seperatorLayout = new javax.swing.GroupLayout(panel_employee_seperator);
        panel_employee_seperator.setLayout(panel_employee_seperatorLayout);
        panel_employee_seperatorLayout.setHorizontalGroup(
            panel_employee_seperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        panel_employee_seperatorLayout.setVerticalGroup(
            panel_employee_seperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(panel_employee_seperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 190, 164, 2));

        panel_doctor_seperator.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panel_doctor_seperatorLayout = new javax.swing.GroupLayout(panel_doctor_seperator);
        panel_doctor_seperator.setLayout(panel_doctor_seperatorLayout);
        panel_doctor_seperatorLayout.setHorizontalGroup(
            panel_doctor_seperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        panel_doctor_seperatorLayout.setVerticalGroup(
            panel_doctor_seperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(panel_doctor_seperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 330, 164, 2));

        body.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 180, 440));

        panel_doctor_reg.setBackground(new java.awt.Color(46, 64, 83));
        panel_doctor_reg.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panel_doctor_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_doctor_reg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctor_registration_doctor.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        doctor_registration_doctor.setText("Doctor Registration Panel");
        panel_doctor_reg.add(doctor_registration_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 51, -1, -1));

        registration_doctor.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registration_doctor.setText("Registration Here");
        panel_doctor_reg.add(registration_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 13, -1, -1));

        TXT_doctor_Id.setBackground(new java.awt.Color(46, 64, 83));
        TXT_doctor_Id.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_doctor_Id.setForeground(new java.awt.Color(255, 255, 255));
        TXT_doctor_Id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_doctor_Id.setText("Doctor Id");
        TXT_doctor_Id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        TXT_doctor_Id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_doctor_IdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_doctor_IdFocusLost(evt);
            }
        });
        TXT_doctor_Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_doctor_IdKeyReleased(evt);
            }
        });
        panel_doctor_reg.add(TXT_doctor_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 95, 180, 40));

        TXT_password_doctor.setBackground(new java.awt.Color(46, 64, 83));
        TXT_password_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_password_doctor.setForeground(new java.awt.Color(255, 255, 255));
        TXT_password_doctor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_password_doctor.setText("**********");
        TXT_password_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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

        TXT_passwordShow_doctor.setBackground(new java.awt.Color(46, 64, 83));
        TXT_passwordShow_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_passwordShow_doctor.setForeground(new java.awt.Color(255, 255, 255));
        TXT_passwordShow_doctor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_passwordShow_doctor.setText("**********");
        TXT_passwordShow_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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

        PANEL_signup_doctor.setBackground(new java.awt.Color(46, 64, 83));
        PANEL_signup_doctor.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PANEL_signup_doctor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LABBEL_signup_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABBEL_signup_doctor.setForeground(new java.awt.Color(234, 242, 248));
        LABBEL_signup_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABBEL_signup_doctor.setText("SignUp");
        LABBEL_signup_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LABBEL_signup_doctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LABBEL_signup_doctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LABBEL_signup_doctorMouseExited(evt);
            }
        });
        PANEL_signup_doctor.add(LABBEL_signup_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        panel_doctor_reg.add(PANEL_signup_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 260, 50));

        show_panelk.setBackground(new java.awt.Color(46, 64, 83));

        CboxShowPass_DOCTOR.setBackground(new java.awt.Color(46, 64, 83));
        CboxShowPass_DOCTOR.setForeground(new java.awt.Color(255, 255, 255));
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

        panel_doctor_reg.add(show_panelk, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 65, -1));

        error_panel_doctor.setBackground(new java.awt.Color(46, 64, 83));

        error_doctor.setBackground(new java.awt.Color(46, 64, 83));
        error_doctor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
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

        panel_employee_reg.setBackground(new java.awt.Color(46, 64, 83));
        panel_employee_reg.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panel_employee_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_employee_reg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_registration_emp.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        employee_registration_emp.setText("Employee Registration Panel");
        panel_employee_reg.add(employee_registration_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 51, -1, -1));

        registration_here_emp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        registration_here_emp.setText("Registration Here");
        panel_employee_reg.add(registration_here_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 13, -1, -1));

        TXT_username_emp.setBackground(new java.awt.Color(46, 64, 83));
        TXT_username_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_username_emp.setForeground(new java.awt.Color(255, 255, 255));
        TXT_username_emp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_username_emp.setText("Employee Id");
        TXT_username_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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
        panel_employee_reg.add(TXT_username_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 95, 180, 40));

        TXT_password_emp.setBackground(new java.awt.Color(46, 64, 83));
        TXT_password_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_password_emp.setForeground(new java.awt.Color(255, 255, 255));
        TXT_password_emp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_password_emp.setText("**********");
        TXT_password_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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
        panel_employee_reg.add(TXT_password_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 153, 180, 40));

        TXT_passwordShow_emp.setBackground(new java.awt.Color(46, 64, 83));
        TXT_passwordShow_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        TXT_passwordShow_emp.setForeground(new java.awt.Color(255, 255, 255));
        TXT_passwordShow_emp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_passwordShow_emp.setText("**********");
        TXT_passwordShow_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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
        panel_employee_reg.add(TXT_passwordShow_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 211, 180, 40));

        PANEL_signup_emp.setBackground(new java.awt.Color(46, 64, 83));
        PANEL_signup_emp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PANEL_signup_emp.setForeground(new java.awt.Color(5, 10, 46));
        PANEL_signup_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PANEL_signup_empMouseClicked(evt);
            }
        });
        PANEL_signup_emp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LABEL_signup_emp.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        LABEL_signup_emp.setForeground(new java.awt.Color(234, 242, 248));
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
        PANEL_signup_emp.add(LABEL_signup_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 258, 50));

        panel_employee_reg.add(PANEL_signup_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 260, 50));

        error_panel_emp.setBackground(new java.awt.Color(46, 64, 83));

        error_emp.setBackground(new java.awt.Color(46, 64, 83));
        error_emp.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
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

        panel_employee_reg.add(error_panel_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 260, 180, -1));

        jPanel5.setBackground(new java.awt.Color(46, 64, 83));

        CboxShowPass_EMP.setBackground(new java.awt.Color(46, 64, 83));
        CboxShowPass_EMP.setForeground(new java.awt.Color(255, 255, 255));
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
            .addComponent(CboxShowPass_EMP, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CboxShowPass_EMP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        panel_employee_reg.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 65, -1));

        panel_doctor_reg.add(panel_employee_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 380));

        body.add(panel_doctor_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 300, 380));

        jLabel2.setBackground(new java.awt.Color(5, 10, 46));
        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Remote Control Doctor");
        body.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 690, 60));

        jLabel3.setText("jLabel3");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        main_body.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 998, 735));

        jPanel4.add(main_body, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 45, 998, 735));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 782));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseClicked
      int permission = JOptionPane.showConfirmDialog(null,"Do you realy! want to exit?","Select", JOptionPane.OK_CANCEL_OPTION);
      if(permission==0)
      {
          System.exit(0);
      }
    }//GEN-LAST:event_close_panelMouseClicked

    private void close_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseEntered
      ChangeColor(close_panel,new Color(210, 43, 43));
    }//GEN-LAST:event_close_panelMouseEntered

    private void close_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseExited
       ChangeColor(close_panel,new Color(5,10,46));
    }//GEN-LAST:event_close_panelMouseExited

    
    // start maximise-----------
    private void maximiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseClicked
       
        if(this.getExtendedState()!= Admin_All_Access.MAXIMIZED_BOTH)
        {
            
            this.setExtendedState(Admin_All_Access.MAXIMIZED_BOTH);
        }
        else
        {
            this.setExtendedState(Admin_All_Access.NORMAL);
        }
    }//GEN-LAST:event_maximiseMouseClicked

    private void maximiseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseEntered
       ChangeColor(maximise,new Color(102,102,102));
    }//GEN-LAST:event_maximiseMouseEntered

    private void maximiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseExited
        ChangeColor(maximise,new Color(5,10,46));
    }//GEN-LAST:event_maximiseMouseExited
    // end maximise-----------
    
    
    private void menu_firstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_firstMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_firstMouseEntered
    // menu hidding start -------------
    
     // setting start --------------------------------
    
    private void settinf_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settinf_labelMouseEntered
         ChangeColor(setting_border,new Color(204,204,255));
    }//GEN-LAST:event_settinf_labelMouseEntered

    private void settinf_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settinf_labelMouseExited
        ChangeColor(setting_border,new Color(5,10,46));
    }//GEN-LAST:event_settinf_labelMouseExited

    private void settinf_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settinf_labelMouseClicked
        clickMenuLeft(setting,menu_first,1);
        menuList.setVisible(false);
    }//GEN-LAST:event_settinf_labelMouseClicked

    private void menu_first_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_first_labelMouseExited
        ChangeColor(menu_first_border,new Color(5,10,46));
    }//GEN-LAST:event_menu_first_labelMouseExited

    private void menu_first_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_first_labelMouseEntered
        ChangeColor(menu_first_border,new Color(0,204,204));
    }//GEN-LAST:event_menu_first_labelMouseEntered

    private void menu_first_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_first_labelMouseClicked
//
        
        if(z==0)
        {
            try {
                
                Thread.sleep(50);
                menuList.setVisible(true);
                clickMenuLeft(menu_first,setting,1);
                Profile.setVisible(true);
                profile.setVisible(true);
                
            } catch (Exception e) {
            }
        }
        else
        {
            Profile.setVisible(false);
            profile.setVisible(false);
            Ticket.setVisible(false);
            ticket.setVisible(false);
            Patient.setVisible(false);
            patient.setVisible(false);
            menuList.setVisible(false);
            z=0;
        }
//        if(a==true)
//        {
//             menuList.setVisible(true);
//            MenuHideShow(menu,a);
//            SwingUtilities.updateComponentTreeUI(this);
//            a=false;
//            
//        }
//        else
//        {
//            menuList.setVisible(true);
//            MenuHideShow(menu,a);
//            SwingUtilities.updateComponentTreeUI(this);
//            a=true;
//            
//        }
    }//GEN-LAST:event_menu_first_labelMouseClicked

    private void ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseEntered
        //ChangeColor(Profile,new Color(25,25,112));
        ChangeColor(lineprofile,new Color(253,155,253));
    }//GEN-LAST:event_ProfileMouseEntered

    private void ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseExited
        //ChangeColor(Profile,new Color(25,29,76));
        ChangeColor(lineprofile,new Color(5,10,46));
    }//GEN-LAST:event_ProfileMouseExited

    private void TicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketMouseEntered
        //ChangeColor(Ticket,new Color(25,25,112));
        ChangeColor(lineticket,new Color(253,155,253));
    }//GEN-LAST:event_TicketMouseEntered

    private void TicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketMouseExited
        //ChangeColor(Ticket,new Color(25,29,76));
        ChangeColor(lineticket,new Color(5,10,46));
    }//GEN-LAST:event_TicketMouseExited

    private void TicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketMouseClicked
      
        clickMenu(Profile,Ticket,Patient,2);
        
    }//GEN-LAST:event_TicketMouseClicked

    private void PatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientMouseEntered
        //ChangeColor(Patient,new Color(25,25,112));
        ChangeColor(linepatient,new Color(253,155,253));
    }//GEN-LAST:event_PatientMouseEntered

    private void PatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientMouseExited
        //ChangeColor(Patient,new Color(25,29,76));
        ChangeColor(linepatient,new Color(5,10,46));
    }//GEN-LAST:event_PatientMouseExited

    private void PatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientMouseClicked
       clickMenu(Profile,Ticket,Patient,3);
    }//GEN-LAST:event_PatientMouseClicked

    private void ProfileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ProfileComponentShown
       
            
            try {
                
                Thread.sleep(50);
                Ticket.setVisible(true);
                ticket.setVisible(true);
                
            } catch (Exception e) {
                
            }
    }//GEN-LAST:event_ProfileComponentShown

    private void TicketComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TicketComponentShown
       
        try {
                
                Thread.sleep(50);
                Patient.setVisible(true);
                patient.setVisible(true);
                
            } catch (Exception e) {
            }
        z=1;
        
    }//GEN-LAST:event_TicketComponentShown

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        clickMenu(Profile,Ticket,Patient,1);
        //Profile.setBackground(Color.yellow);
    }//GEN-LAST:event_ProfileMouseClicked

    private void TXT_username_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_empFocusGained
        if (TXT_username_emp.getText().equals("Employee Id")) {
            TXT_username_emp.setText("");
            TXT_username_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_username_empFocusGained

    private void TXT_username_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_username_empFocusLost
        if (TXT_username_emp.getText().equals("")) {
            TXT_username_emp.setText("Employee Id");
            TXT_username_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_username_empFocusLost

    private void TXT_username_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_username_empKeyReleased

        error_emp.setVisible(true);
        error_panel_emp.setVisible(true);
        String PATTERN = "^[a-z]{3,15}[0-9]{4,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(TXT_username_emp.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            
            error_emp.setText("Example: aaa1111");
            error_emp.setForeground(Color.red);
        } else if (match.matches()) {
           
            error_emp.setText("complete");
            error_emp.setForeground(new Color(0,204,204));
           
        }
    }//GEN-LAST:event_TXT_username_empKeyReleased

    private void TXT_password_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_empFocusGained
        if (TXT_password_emp.getText().equals("**********")) {
            TXT_password_emp.setText("");
            TXT_password_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_password_empFocusGained

    private void TXT_password_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_empFocusLost
        if (TXT_password_emp.getText().equals("")) {
            TXT_password_emp.setText("**********");
            TXT_password_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_password_empFocusLost

    private void TXT_password_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_password_empKeyReleased
        Employee_Password();
    }//GEN-LAST:event_TXT_password_empKeyReleased

    private void TXT_passwordShow_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empFocusGained
        if (TXT_passwordShow_emp.getText().equals("**********")) {
            TXT_passwordShow_emp.setText("");
            TXT_passwordShow_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_passwordShow_empFocusGained

    private void TXT_passwordShow_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empFocusLost
        if (TXT_passwordShow_emp.getText().equals("")) {
            TXT_passwordShow_emp.setText("**********");
            TXT_passwordShow_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_passwordShow_empFocusLost

    private void TXT_passwordShow_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordShow_empKeyReleased
        Employee_ConfirmPassword();
    }//GEN-LAST:event_TXT_passwordShow_empKeyReleased

    private void LABEL_signup_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseClicked

        try {

            if (TXT_password_emp.getText().equals(TXT_passwordShow_emp.getText())) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
                Statement st = (Statement) con.createStatement();
                PreparedStatement ps = con.prepareStatement("INSERT INTO employee_login(Employee_Id,Password,ConfirmPass)" + "values(?,?,?)");
                ps.setString(1, TXT_username_emp.getText());
                ps.setString(2, TXT_password_emp.getText());
                ps.setString(3, TXT_passwordShow_emp.getText());
                ps.executeUpdate();
                dispose();                   
                new registration_from().setVisible(true);
                NoticeWindow noticeWindow = new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);          
            } else {
                //JOptionPane.showMessageDialog(null, "dont match");
                NoticeWindow noticeWindow = new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Password don't match", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Sorry! Username allready uses");
            NoticeWindow noticeWindow = new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Username allready uses", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
        }
    }//GEN-LAST:event_LABEL_signup_empMouseClicked

    private void LABEL_signup_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseEntered
        setColorsigin(PANEL_signup_emp);
        LABEL_signup_emp.setForeground(new Color(250, 219, 216 ));
    }//GEN-LAST:event_LABEL_signup_empMouseEntered

    private void LABEL_signup_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_empMouseExited
        resetColorsigin(PANEL_signup_emp);
        LABEL_signup_emp.setForeground(new Color(234,242,248));
    }//GEN-LAST:event_LABEL_signup_empMouseExited

    private void PANEL_signup_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANEL_signup_empMouseClicked

    }//GEN-LAST:event_PANEL_signup_empMouseClicked

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

    private void label_employeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseEntered
        setColorMenu(panel_employee_seperator);
        label_employee.setForeground(new Color(149, 165, 166));
    }//GEN-LAST:event_label_employeeMouseEntered

    private void label_employeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseExited
       resetColorMenu(panel_employee_seperator);
       label_employee.setForeground(new Color(214,234,248));
    }//GEN-LAST:event_label_employeeMouseExited

    private void label_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseEntered
        setColorMenu(panel_doctor_seperator);
        label_doctor.setForeground(new Color(149, 165, 166));
    }//GEN-LAST:event_label_doctorMouseEntered

    private void label_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseExited
        resetColorMenu(panel_doctor_seperator);
        label_doctor.setForeground(new Color(214,234,248));
    }//GEN-LAST:event_label_doctorMouseExited

    private void label_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseClicked

        clickMenuRight(panel_employee,panel_doctor,1);
        label_employee.setForeground(new Color (214, 234, 248));
        panel_employee_reg.setVisible(true);
        panel_doctor_reg.setVisible(false);
    }//GEN-LAST:event_label_employeeMouseClicked

    private void label_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseClicked
        clickMenuRight(panel_employee,panel_doctor,2);
        panel_doctor_reg.setVisible(true);
        panel_employee_reg.setVisible(false);
        
    }//GEN-LAST:event_label_doctorMouseClicked

    private void TXT_doctor_IdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_doctor_IdFocusGained
        if (TXT_doctor_Id.getText().equals("Doctor Id")) {
            TXT_doctor_Id.setText("");
            TXT_doctor_Id.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_doctor_IdFocusGained

    private void TXT_doctor_IdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_doctor_IdFocusLost

        if (TXT_doctor_Id.getText().equals("")) {
            TXT_doctor_Id.setText("Doctor Id");
            TXT_doctor_Id.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_doctor_IdFocusLost

    private void TXT_doctor_IdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_doctor_IdKeyReleased

        error_doctor.setVisible(true);
        error_panel_doctor.setVisible(true);
        String PATTERN = "^[a-z]{3,15}[0-9]{4,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(TXT_doctor_Id.getText());
        if (!match.matches()) {
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Warning", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            
            error_doctor.setText("Example: aaa1111");
            error_doctor.setForeground(Color.red);
        } else if (match.matches()) {
           
            error_doctor.setText("complete");
            error_doctor.setForeground(new Color(0,204,204));
           
        }
    }//GEN-LAST:event_TXT_doctor_IdKeyReleased

    private void TXT_password_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_doctorFocusGained
        if (TXT_password_doctor.getText().equals("**********")) {
            TXT_password_doctor.setText("");
            TXT_password_doctor.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_password_doctorFocusGained

    private void TXT_password_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_password_doctorFocusLost
        if (TXT_password_doctor.getText().equals("")) {
            TXT_password_doctor.setText("**********");
            TXT_password_doctor.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_password_doctorFocusLost

    private void TXT_password_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_password_doctorKeyReleased
        Doc_Password();

    }//GEN-LAST:event_TXT_password_doctorKeyReleased

    private void TXT_passwordShow_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorFocusGained

        if (TXT_passwordShow_doctor.getText().equals("**********")) {
            TXT_passwordShow_doctor.setText("");
            TXT_passwordShow_doctor.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_passwordShow_doctorFocusGained

    private void TXT_passwordShow_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorFocusLost

        if (TXT_passwordShow_doctor.getText().equals("")) {
            TXT_passwordShow_doctor.setText("**********");
            TXT_passwordShow_doctor.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_TXT_passwordShow_doctorFocusLost

    private void TXT_passwordShow_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_passwordShow_doctorKeyReleased
        Doc_ConfirmPassword();

    }//GEN-LAST:event_TXT_passwordShow_doctorKeyReleased

    private void LABEL_signup_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseClicked

        if (TXT_doctor_Id.getText().trim().equals("")) {
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
                    PreparedStatement ps = con.prepareStatement("INSERT INTO doctor_login(Doctor_Id,Password,ConfirmPass)" + "values(?,?,?)");
                    ps.setString(1, TXT_doctor_Id.getText());
                    ps.setString(2, TXT_password_doctor.getText());
                    ps.setString(3, TXT_passwordShow_doctor.getText());
                    ps.executeUpdate();
                    dispose();
                    new registration_from().setVisible(true);
                    NoticeWindow noticeWindow = new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    
                    

                } else {
                    //JOptionPane.showMessageDialog(null, "dont match");
                   NoticeWindow noticeWindow = new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Password don't match", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Sorry! Username allready uses");
                NoticeWindow noticeWindow = new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Username allready uses", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            }
        }

    }//GEN-LAST:event_LABEL_signup_doctorMouseClicked

    private void LABEL_signup_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseEntered
        setColorsigin(PANEL_signup_doctor);
        LABEL_signup_doctor.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_LABEL_signup_doctorMouseEntered

    private void LABEL_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseExited
        resetColorsigin(PANEL_signup_doctor);
        LABEL_signup_doctor.setForeground(new Color(5,10,46));
    }//GEN-LAST:event_LABEL_signup_doctorMouseExited

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

    private void LABBEL_signup_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABBEL_signup_doctorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LABBEL_signup_doctorMouseClicked

    private void LABBEL_signup_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABBEL_signup_doctorMouseEntered
        setColorsigin(PANEL_signup_doctor);
        LABBEL_signup_doctor.setForeground(new Color(250, 219, 216 ));
  
    }//GEN-LAST:event_LABBEL_signup_doctorMouseEntered

    private void LABBEL_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABBEL_signup_doctorMouseExited
        resetColorsigin(PANEL_signup_doctor);
        LABBEL_signup_doctor.setForeground(new Color(234,242,248));
    }//GEN-LAST:event_LABBEL_signup_doctorMouseExited
   

    
    
    
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
            java.util.logging.Logger.getLogger(Admin_All_Access.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_All_Access.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_All_Access.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_All_Access.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_All_Access().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CboxShowPass_DOCTOR;
    private javax.swing.JCheckBox CboxShowPass_EMP;
    private javax.swing.JLabel LABBEL_signup_doctor;
    private javax.swing.JLabel LABEL_signup_doctor;
    private javax.swing.JLabel LABEL_signup_emp;
    private javax.swing.JPanel PANEL_signup_doctor;
    private javax.swing.JPanel PANEL_signup_emp;
    private javax.swing.JPanel Patient;
    private javax.swing.JPanel Profile;
    private javax.swing.JTextField TXT_doctor_Id;
    private javax.swing.JPasswordField TXT_passwordShow_doctor;
    private javax.swing.JPasswordField TXT_passwordShow_emp;
    private javax.swing.JPasswordField TXT_password_doctor;
    private javax.swing.JPasswordField TXT_password_emp;
    private javax.swing.JTextField TXT_username_emp;
    private javax.swing.JPanel Ticket;
    private javax.swing.JPanel body;
    private javax.swing.JPanel closeMax_body;
    private javax.swing.JPanel close_panel;
    private javax.swing.JLabel close_white;
    private javax.swing.JLabel doctor_registration_doctor;
    private javax.swing.JLabel employee_registration_emp;
    private javax.swing.JLabel error_doctor;
    private javax.swing.JLabel error_emp;
    private javax.swing.JPanel error_panel_doctor;
    private javax.swing.JPanel error_panel_emp;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_doctor;
    private javax.swing.JLabel label_employee;
    private javax.swing.JPanel linepatient;
    private javax.swing.JPanel lineprofile;
    private javax.swing.JPanel lineticket;
    private javax.swing.JPanel main_body;
    private javax.swing.JPanel maximise;
    private javax.swing.JLabel maximise_label;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuIcon;
    private javax.swing.JPanel menuList;
    private javax.swing.JPanel menu_first;
    private javax.swing.JPanel menu_first_border;
    private javax.swing.JLabel menu_first_label;
    private javax.swing.JPanel panel_doctor;
    private javax.swing.JPanel panel_doctor_reg;
    private javax.swing.JPanel panel_doctor_seperator;
    private javax.swing.JPanel panel_employee;
    private javax.swing.JPanel panel_employee_reg;
    private javax.swing.JPanel panel_employee_seperator;
    private javax.swing.JLabel patient;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel registration_doctor;
    private javax.swing.JLabel registration_here_emp;
    private javax.swing.JLabel settinf_label;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel setting_border;
    private javax.swing.JPanel show_panelk;
    private javax.swing.JLabel ticket;
    // End of variables declaration//GEN-END:variables
}
