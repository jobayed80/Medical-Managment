/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Admin.*;
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
public class Employeee_Menu extends javax.swing.JFrame {
    
    public int z=0;
    public int save_upgrade=0; 
    boolean a= true;
    //958C8C   // C0C9D3   #787E74
    
   
     
    public Employeee_Menu() {
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
        profile.setText("Profile");
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
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
        ticket.setText("Profile Update");

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
        patient.setText("Patient");

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

        main_body.setBackground(new java.awt.Color(46, 64, 83));
        main_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
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
       
        if(this.getExtendedState()!= Employeee_Menu.MAXIMIZED_BOTH)
        {
            
            this.setExtendedState(Employeee_Menu.MAXIMIZED_BOTH);
        }
        else
        {
            this.setExtendedState(Employeee_Menu.NORMAL);
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
        
    }//GEN-LAST:event_LABEL_signup_doctorMouseEntered

    private void LABEL_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseExited
        
    }//GEN-LAST:event_LABEL_signup_doctorMouseExited

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
      
    }//GEN-LAST:event_profileMouseClicked
   

    
    
    
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
            java.util.logging.Logger.getLogger(Employeee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employeee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employeee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employeee_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Employeee_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL_signup_doctor;
    private javax.swing.JPanel Patient;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Ticket;
    private javax.swing.JPanel closeMax_body;
    private javax.swing.JPanel close_panel;
    private javax.swing.JLabel close_white;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JLabel patient;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel settinf_label;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel setting_border;
    private javax.swing.JLabel ticket;
    // End of variables declaration//GEN-END:variables
}
