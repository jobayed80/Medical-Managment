package medical;

import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author h
 */
public class registration_from extends javax.swing.JFrame {
    
    public Preferences pref = Preferences.userRoot().node("Rememberme");
    public Preferences prefDoctor = Preferences.userRoot().node("Rememberme");
    public Preferences prerfEmployee = Preferences.userRoot().node("Rememberme");
    
    public registration_from() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
        // hide panel admin, employee,doctor
        panel_admin_log.setVisible(false);
        panel_doctor_log.setVisible(false);
        panel_employee_log.setVisible(false);

        
         //remember me admin username and password
        String usr = null;
        usr = pref.get("Email", usr);
        //username.setText(usr);
        txt_admin_id.setText(usr);
        String pss = null;
        pss = pref.get("Password",pss);
        txt_password_admin.setText(pss);
        
         //remember me doctor username and password
        String usrD = null;
        usrD = prefDoctor.get("Email", usrD);
        txt_doctor_id.setText(usr);
        String pssD = null;
        pssD = prefDoctor.get("Password",pssD);
        txt_password_doctor.setText(pss);
        
        //remember me demployee username and password
        String usrE = null;
        usrE = prerfEmployee.get("Email", usrE);
        //username.setText(usr);
        txt_emp_id.setText(usrE);
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
             saveemailpass(txt_admin_id.getText(),txt_password_admin.getText());
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
             saveemailpass(txt_doctor_id.getText(),txt_password_doctor.getText());
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
             saveemailpass(txt_emp_id.getText(),txt_password_emp.getText());
         }
         else
         {
             System.out.println("Null karakter");
         }
     }
     
     
    public void ChangeColor(JPanel hover, Color random)
    {
        hover.setBackground(random);
    }

            //    Start close color
    public void setColor(JPanel p)
    {
        p.setBackground(new Color(0,0,55));
        
    }
    
    public void resetColor(JPanel p1)
    {
        p1.setBackground(new Color(211, 219, 226));
    }
             //    end close color
    
    
    
     public void setColorlogin(JPanel p)
    {
        p.setBackground(new Color(255,255,255));
       
    }
    
    public void resetColorlogin(JPanel p1)
    {
        p1.setBackground(new Color(5,10,46));
        
    }
    
    //    Start admin color
    public void setColorsigin(JPanel p) {
        p.setBackground(new Color(5,10,46));

    }

    public void resetColorsigin(JPanel p1) {
        p1.setBackground(new Color(0,51,51));

    }
    
    public void clickMenuRight(JPanel h1, JPanel h2,JPanel h3,int num)
    {
        if(num==1)
        {
            h1.setBackground(new Color (0,60,60)); //25,29,74
            h2.setBackground(new Color (5,10,46)); //25,29,74
            h3.setBackground(new Color (5,10,46)); //25,29,74
        }
        if(num==2)
        {
//            h1.setBackground(new Color (5,10,46)); //25,29,74
//            h2.setBackground(new Color (0,60,60)); //25,29,74
            h1.setBackground(new Color (0,60,60)); //25,29,74
            h2.setBackground(new Color (5,10,46)); //25,29,74
            h3.setBackground(new Color (5,10,46)); //25,29,74
        }
        
        if(num==3)
        {
            h1.setBackground(new Color (0,60,60)); //25,29,74
            h2.setBackground(new Color (5,10,46)); //25,29,74
            h3.setBackground(new Color (5,10,46)); //25,29,74
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

        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panel_admin = new javax.swing.JPanel();
        label_admin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panel_doctor = new javax.swing.JPanel();
        label_doctor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_employee = new javax.swing.JPanel();
        label_employee = new javax.swing.JLabel();
        separator_admin = new javax.swing.JPanel();
        separator_doctor = new javax.swing.JPanel();
        separator_emp = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        closeMax_body = new javax.swing.JPanel();
        close_panel = new javax.swing.JPanel();
        close_white = new javax.swing.JLabel();
        maximise = new javax.swing.JPanel();
        maximise_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel_doctor_log = new javax.swing.JPanel();
        login_here_doctor = new javax.swing.JLabel();
        doctor_login_panel = new javax.swing.JLabel();
        txt_doctor_id = new javax.swing.JTextField();
        txt_password_doctor = new javax.swing.JPasswordField();
        panel_signin_doctor = new javax.swing.JPanel();
        label_signin_doctor = new javax.swing.JLabel();
        CboxRememPassDoctor = new javax.swing.JCheckBox();
        CboxShowPass_doctor = new javax.swing.JCheckBox();
        panel_admin_log = new javax.swing.JPanel();
        login_here_admin = new javax.swing.JLabel();
        admin_login_panel_admin = new javax.swing.JLabel();
        txt_admin_id = new javax.swing.JTextField();
        txt_password_admin = new javax.swing.JPasswordField();
        panel_signin_admin = new javax.swing.JPanel();
        label_signin_admin = new javax.swing.JLabel();
        CboxRememPass = new javax.swing.JCheckBox();
        CboxShowPass_admin = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_employee_log = new javax.swing.JPanel();
        login_here_emp = new javax.swing.JLabel();
        employye_login_emp = new javax.swing.JLabel();
        txt_password_emp = new javax.swing.JPasswordField();
        txt_emp_id = new javax.swing.JTextField();
        panel_signin_emp = new javax.swing.JPanel();
        label_signin_emp = new javax.swing.JLabel();
        CboxRememPassEmployee = new javax.swing.JCheckBox();
        CboxShowPass_emp = new javax.swing.JCheckBox();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(5, 10, 46));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_admin.setBackground(new java.awt.Color(5, 10, 46));
        panel_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        panel_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_admin.setBackground(new java.awt.Color(5, 10, 46));
        label_admin.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_admin.setForeground(new java.awt.Color(255, 255, 255));
        label_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_admin.setText("Admin");
        label_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_adminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_adminMouseExited(evt);
            }
        });
        panel_admin.add(label_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 36));

        jPanel3.add(panel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/admin.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 46, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/doctor.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 70, -1));

        panel_doctor.setBackground(new java.awt.Color(5, 10, 46));
        panel_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        panel_doctor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_doctor.setBackground(new java.awt.Color(5, 10, 46));
        label_doctor.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_doctor.setForeground(new java.awt.Color(255, 255, 255));
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
        panel_doctor.add(label_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 37));

        jPanel3.add(panel_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/employee.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        panel_employee.setBackground(new java.awt.Color(5, 10, 46));
        panel_employee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 102)));
        panel_employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_employee.setBackground(new java.awt.Color(5, 10, 46));
        label_employee.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        label_employee.setForeground(new java.awt.Color(255, 255, 255));
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
        panel_employee.add(label_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 210, 37));

        jPanel3.add(panel_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 210, -1));

        separator_admin.setBackground(new java.awt.Color(5, 10, 46));

        javax.swing.GroupLayout separator_adminLayout = new javax.swing.GroupLayout(separator_admin);
        separator_admin.setLayout(separator_adminLayout);
        separator_adminLayout.setHorizontalGroup(
            separator_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        separator_adminLayout.setVerticalGroup(
            separator_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(separator_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 166, 212, 4));

        separator_doctor.setBackground(new java.awt.Color(5, 10, 46));

        javax.swing.GroupLayout separator_doctorLayout = new javax.swing.GroupLayout(separator_doctor);
        separator_doctor.setLayout(separator_doctorLayout);
        separator_doctorLayout.setHorizontalGroup(
            separator_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        separator_doctorLayout.setVerticalGroup(
            separator_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(separator_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 337, 212, 4));

        separator_emp.setBackground(new java.awt.Color(5, 10, 46));

        javax.swing.GroupLayout separator_empLayout = new javax.swing.GroupLayout(separator_emp);
        separator_emp.setLayout(separator_empLayout);
        separator_empLayout.setHorizontalGroup(
            separator_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        separator_empLayout.setVerticalGroup(
            separator_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(separator_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 497, 210, 4));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 245, 590));

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

        jPanel2.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 975, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(5, 10, 46));
        jLabel2.setFont(new java.awt.Font("Engravers MT", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Daffodil Medical Management");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 690, 60));

        panel_doctor_log.setBackground(new java.awt.Color(0, 51, 51));
        panel_doctor_log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_doctor_log.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_doctor_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_doctor.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_doctor.setForeground(new java.awt.Color(153, 153, 153));
        login_here_doctor.setText("Login Here");
        panel_doctor_log.add(login_here_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 13, -1, -1));

        doctor_login_panel.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        doctor_login_panel.setForeground(new java.awt.Color(153, 153, 153));
        doctor_login_panel.setText("Doctor Login Panel");
        panel_doctor_log.add(doctor_login_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 51, -1, -1));

        txt_doctor_id.setBackground(new java.awt.Color(0, 51, 51));
        txt_doctor_id.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_doctor_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_doctor_id.setText("Doctor Id");
        txt_doctor_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_doctor_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_doctor_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_doctor_idFocusLost(evt);
            }
        });
        panel_doctor_log.add(txt_doctor_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 114, 200, 40));

        txt_password_doctor.setBackground(new java.awt.Color(0, 51, 51));
        txt_password_doctor.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_doctor.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_doctor.setText("**********");
        txt_password_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_password_doctor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_doctorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_doctorFocusLost(evt);
            }
        });
        panel_doctor_log.add(txt_password_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 172, 200, 40));

        panel_signin_doctor.setBackground(new java.awt.Color(0, 51, 51));
        panel_signin_doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signin_doctor.setBackground(new java.awt.Color(0, 51, 51));
        label_signin_doctor.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        label_signin_doctor.setForeground(new java.awt.Color(204, 204, 255));
        label_signin_doctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_doctor.setText("SignIn");
        label_signin_doctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(label_signin_doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        panel_signin_doctorLayout.setVerticalGroup(
            panel_signin_doctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_doctor_log.add(panel_signin_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 260, 40));

        CboxRememPassDoctor.setBackground(new java.awt.Color(0, 51, 51));
        CboxRememPassDoctor.setForeground(new java.awt.Color(255, 255, 255));
        CboxRememPassDoctor.setText("keep me");
        panel_doctor_log.add(CboxRememPassDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        CboxShowPass_doctor.setBackground(new java.awt.Color(0, 51, 51));
        CboxShowPass_doctor.setForeground(new java.awt.Color(255, 255, 255));
        CboxShowPass_doctor.setText("show");
        CboxShowPass_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_doctorActionPerformed(evt);
            }
        });
        panel_doctor_log.add(CboxShowPass_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

        panel_admin_log.setBackground(new java.awt.Color(0, 51, 51));
        panel_admin_log.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(22, 22, 22)));
        panel_admin_log.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_admin_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_admin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_admin.setForeground(new java.awt.Color(153, 153, 153));
        login_here_admin.setText("Login Here");
        panel_admin_log.add(login_here_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 13, -1, -1));

        admin_login_panel_admin.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        admin_login_panel_admin.setForeground(new java.awt.Color(153, 153, 153));
        admin_login_panel_admin.setText("Admin Login Panel");
        panel_admin_log.add(admin_login_panel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txt_admin_id.setBackground(new java.awt.Color(0, 51, 51));
        txt_admin_id.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_admin_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_admin_id.setText("Admin Id");
        txt_admin_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_admin_id.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_admin_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_admin_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_admin_idFocusLost(evt);
            }
        });
        txt_admin_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_admin_idKeyReleased(evt);
            }
        });
        panel_admin_log.add(txt_admin_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 114, 200, 40));

        txt_password_admin.setBackground(new java.awt.Color(0, 51, 51));
        txt_password_admin.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_admin.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_admin.setText("**********");
        txt_password_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_password_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_password_admin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_adminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_adminFocusLost(evt);
            }
        });
        panel_admin_log.add(txt_password_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 172, 200, 40));

        panel_signin_admin.setBackground(new java.awt.Color(0, 51, 51));
        panel_signin_admin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        label_signin_admin.setBackground(new java.awt.Color(0, 51, 51));
        label_signin_admin.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        label_signin_admin.setForeground(new java.awt.Color(204, 204, 255));
        label_signin_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_admin.setText("SignIn");
        label_signin_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(label_signin_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        panel_signin_adminLayout.setVerticalGroup(
            panel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_admin_log.add(panel_signin_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 260, -1));

        CboxRememPass.setBackground(new java.awt.Color(0, 51, 51));
        CboxRememPass.setForeground(new java.awt.Color(255, 255, 255));
        CboxRememPass.setText("keep me");
        panel_admin_log.add(CboxRememPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        CboxShowPass_admin.setBackground(new java.awt.Color(0, 51, 51));
        CboxShowPass_admin.setForeground(new java.awt.Color(255, 255, 255));
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
        panel_admin_log.add(CboxShowPass_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

        panel_doctor_log.add(panel_admin_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 380));

        jPanel1.add(panel_doctor_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 300, 380));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/login_back.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 730, 580));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 730, 592));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        panel_employee_log.setBackground(new java.awt.Color(0, 51, 51));
        panel_employee_log.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_employee_log.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_employee_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_here_emp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        login_here_emp.setForeground(new java.awt.Color(153, 153, 153));
        login_here_emp.setText("Login Here");
        panel_employee_log.add(login_here_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 13, -1, -1));

        employye_login_emp.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        employye_login_emp.setForeground(new java.awt.Color(153, 153, 153));
        employye_login_emp.setText("Employee Login Panel");
        panel_employee_log.add(employye_login_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 51, -1, -1));

        txt_password_emp.setBackground(new java.awt.Color(0, 51, 51));
        txt_password_emp.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_password_emp.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_emp.setText("**********");
        txt_password_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_password_emp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_password_empFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_password_empFocusLost(evt);
            }
        });
        panel_employee_log.add(txt_password_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 172, 200, 40));

        txt_emp_id.setBackground(new java.awt.Color(0, 51, 51));
        txt_emp_id.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txt_emp_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_id.setText("Employee Id");
        txt_emp_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_idFocusLost(evt);
            }
        });
        panel_employee_log.add(txt_emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 114, 200, 40));

        panel_signin_emp.setBackground(new java.awt.Color(0, 51, 51));
        panel_signin_emp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        panel_signin_emp.setPreferredSize(new java.awt.Dimension(130, 40));

        label_signin_emp.setBackground(new java.awt.Color(0, 51, 51));
        label_signin_emp.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        label_signin_emp.setForeground(new java.awt.Color(204, 204, 255));
        label_signin_emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_signin_emp.setText("SignIn");
        label_signin_emp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(label_signin_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        panel_signin_empLayout.setVerticalGroup(
            panel_signin_empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_signin_emp, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panel_employee_log.add(panel_signin_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 260, -1));

        CboxRememPassEmployee.setBackground(new java.awt.Color(0, 51, 51));
        CboxRememPassEmployee.setForeground(new java.awt.Color(255, 255, 255));
        CboxRememPassEmployee.setText("kepp me");
        panel_employee_log.add(CboxRememPassEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        CboxShowPass_emp.setBackground(new java.awt.Color(0, 51, 51));
        CboxShowPass_emp.setForeground(new java.awt.Color(255, 255, 255));
        CboxShowPass_emp.setText("show");
        CboxShowPass_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboxShowPass_empActionPerformed(evt);
            }
        });
        panel_employee_log.add(CboxShowPass_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));

        getContentPane().add(panel_employee_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 300, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_adminMouseExited
        resetColorlogin(separator_admin);
        label_admin.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_adminMouseExited

    private void label_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_adminMouseEntered
        setColorlogin(separator_admin);
        label_admin.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_label_adminMouseEntered

    private void label_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseExited
        resetColorlogin(separator_doctor);
        label_doctor.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_doctorMouseExited

    private void label_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseEntered
        setColorlogin(separator_doctor);
        label_doctor.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_label_doctorMouseEntered

    private void label_employeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseExited
        resetColorlogin(separator_emp);
        label_employee.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_employeeMouseExited

    private void label_employeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseEntered
        setColorlogin(separator_emp);
        label_employee.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_label_employeeMouseEntered

    private void close_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseClicked

        System.exit(0);
    }//GEN-LAST:event_close_panelMouseClicked

    private void close_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseEntered
        ChangeColor(close_panel,new Color(210, 43, 43));
    }//GEN-LAST:event_close_panelMouseEntered

    private void close_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseExited
        ChangeColor(close_panel,new Color(5,10,46));
    }//GEN-LAST:event_close_panelMouseExited

    private void maximiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseExited
        ChangeColor(maximise,new Color(5,10,46));
    }//GEN-LAST:event_maximiseMouseExited

    private void maximiseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseEntered
        ChangeColor(maximise,new Color(102,102,102));
    }//GEN-LAST:event_maximiseMouseEntered

    private void maximiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseClicked

        if(this.getExtendedState()!= Admin_Panels.MAXIMIZED_BOTH)
        {

            this.setExtendedState(Admin_Panels.MAXIMIZED_BOTH);
        }
        else
        {
            this.setExtendedState(Admin_Panels.NORMAL);
        }
    }//GEN-LAST:event_maximiseMouseClicked

    private void CboxShowPass_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_adminActionPerformed
        if (CboxShowPass_admin.isSelected()) {
            txt_password_admin.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_admin.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_adminActionPerformed

    private void CboxShowPass_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CboxShowPass_adminMouseEntered

    }//GEN-LAST:event_CboxShowPass_adminMouseEntered

    private void label_signin_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseExited
        resetColorsigin(panel_signin_admin);
        label_signin_admin.setForeground(new Color(204,204,255));
    }//GEN-LAST:event_label_signin_adminMouseExited

    private void label_signin_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseEntered
        setColorsigin(panel_signin_admin);
        label_signin_admin.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_label_signin_adminMouseEntered

    private void label_signin_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_adminMouseClicked

//        int flag = 1;
//        if (txt_admin_id.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Please Write Username !");
//        } else if (txt_password_admin.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Please Write Password !");
//        } else
//        {
            
            if("22jjJJ@@".equals(txt_password_admin.getText()) && "admin2948".equals(txt_admin_id.getText()))
            {
                new Admin_Panels().setVisible(false);
                new Admin_Panels().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Username and Password","Sorry!", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
            
            
//            try {
//
//                String Driver = "com.mysql.jdbc.Driver";
//                String URL = "jdbc:mysql://localhost:3306/medical";
//                Class.forName(Driver);
//                Connection Conn = DriverManager.getConnection(URL, "root", "");
//                Statement S = Conn.createStatement();
//                ResultSet RS = S.executeQuery(
//                    "SELECT * FROM medical_login where Username ='" + txt_username_admin.getText()
//                    + "' and Password ='" + txt_password_admin.getText() + "'");
//
//                while (RS.next()) {
//                    String user = RS.getString("Username");
//                    String pass = RS.getString("Password");
//                    if (user.equals(txt_username_admin.getText()) & pass.equals(txt_password_admin.getText())) {
//                        flag = 0;
//                        break;
//                    }
//                }
//                if (flag == 0) {
//
//                    if (CboxRememPass.isSelected()) {
//                        checked(true);
//
//                    } else {
//                        checked(false);
//
//                    }
//                    dispose();
//                    //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
//                    panel_admin_log.setVisible(false);
//                    new admin_panel().setVisible(true);
//
//                } else {
//
//                    JOptionPane.showMessageDialog(null, "Invalid Username and Password","Sorry!", JOptionPane.ERROR_MESSAGE);
//                }
//
//            } catch (Exception e) {
//
//                JOptionPane.showMessageDialog(null, e);
//            }
        //}
    }//GEN-LAST:event_label_signin_adminMouseClicked

    private void txt_password_adminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_adminFocusLost
        if (txt_password_admin.getText().equals("")) {
            txt_password_admin.setText("**********");
            txt_password_admin.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_password_adminFocusLost

    private void txt_password_adminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_adminFocusGained
        if (txt_password_admin.getText().equals("**********")) {
            txt_password_admin.setText("");
            txt_password_admin.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_password_adminFocusGained

    private void txt_admin_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_admin_idKeyReleased

    }//GEN-LAST:event_txt_admin_idKeyReleased

    private void txt_admin_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_admin_idFocusLost
        if (txt_admin_id.getText().equals("")) {
            txt_admin_id.setText("Admin Id");
            txt_admin_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_admin_idFocusLost

    private void txt_admin_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_admin_idFocusGained
        if (txt_admin_id.getText().equals("Admin Id")) {
            txt_admin_id.setText("");
            txt_admin_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_admin_idFocusGained

    private void txt_doctor_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_doctor_idFocusGained
        if (txt_doctor_id.getText().equals("Doctor Id")) {
            txt_doctor_id.setText("");
            txt_doctor_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_doctor_idFocusGained

    private void txt_doctor_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_doctor_idFocusLost
        if (txt_doctor_id.getText().equals("")) {
            txt_doctor_id.setText("Doctor Id");
            txt_doctor_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_doctor_idFocusLost

    private void txt_password_doctorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_doctorFocusGained
        if (txt_password_doctor.getText().equals("**********")) {
            txt_password_doctor.setText("");
            txt_password_doctor.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_password_doctorFocusGained

    private void txt_password_doctorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_doctorFocusLost
        if (txt_password_doctor.getText().equals("")) {
            txt_password_doctor.setText("**********");
            txt_password_doctor.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_password_doctorFocusLost

    private void label_signin_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseClicked

        int flag = 1;
        if (txt_doctor_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Write Username !");
        } else if (txt_password_doctor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Write Password !");
        } else {
            try {

                String Driver = "com.mysql.jdbc.Driver";
                String URL = "jdbc:mysql://localhost:3306/medical"; // database name medical
                Class.forName(Driver);
                Connection Conn = DriverManager.getConnection(URL, "root", "");
                Statement S = Conn.createStatement();
                ResultSet RS = S.executeQuery(
                    "SELECT * FROM doctor_login where Doctor_Id ='" + txt_doctor_id.getText()
                    + "' and Password ='" + txt_password_doctor.getText() + "'");

                while (RS.next()) {
                    String user = RS.getString("Doctor_Id");
                    String pass = RS.getString("Password");
                    if (user.equals(txt_doctor_id.getText()) & pass.equals(txt_password_doctor.getText())) {
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
                    new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "Login Success!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
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

    private void label_signin_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseEntered
        setColorsigin(panel_signin_doctor);
        label_signin_doctor.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_label_signin_doctorMouseEntered

    private void label_signin_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_doctorMouseExited
        resetColorsigin(panel_signin_doctor);
        label_signin_doctor.setForeground(new Color(204,204,255));
    }//GEN-LAST:event_label_signin_doctorMouseExited

    private void CboxShowPass_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_doctorActionPerformed
        if (CboxShowPass_doctor.isSelected()) {
            txt_password_doctor.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_doctor.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_doctorActionPerformed

    private void txt_password_empFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_empFocusGained
        if (txt_password_emp.getText().equals("**********")) {
            txt_password_emp.setText("");
            txt_password_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_txt_password_empFocusGained

    private void txt_password_empFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_password_empFocusLost
        if (txt_password_emp.getText().equals("")) {
            txt_password_emp.setText("**********");
            txt_password_emp.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_txt_password_empFocusLost

    private void txt_emp_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_idFocusGained
        if (txt_emp_id.getText().equals("Employee Id")) {
            txt_emp_id.setText("");
            txt_emp_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_idFocusGained

    private void txt_emp_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_idFocusLost
        if (txt_emp_id.getText().equals("")) {
            txt_emp_id.setText("Employee Id");
            txt_emp_id.setForeground(new Color(255, 255, 255));

        }
    }//GEN-LAST:event_txt_emp_idFocusLost

    private void label_signin_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseClicked

        int flag = 1;
        if (txt_emp_id.getText().trim().equals("")) {
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
                    "SELECT * FROM employee_login where Employee_Id ='" + txt_emp_id.getText()
                    + "' and Password ='" + txt_password_emp.getText() + "'");

                while (RS.next()) {
                    String user = RS.getString("Employee_Id");
                    String pass = RS.getString("Password");
                    if (user.equals(txt_emp_id.getText()) & pass.equals(txt_password_emp.getText())) {
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
                    //dispose();
                    new employee_panel1().setVisible(false);
                    new employee_panel1().setVisible(true);
                    new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION,"Congratulations!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                    //panel_employee_log.setVisible(false);
                    //

                } else {

                    //JOptionPane.showMessageDialog(null, "Invalid Username and Password","Sorry!",JOptionPane.ERROR_MESSAGE);
                    NoticeWindow noticeWindow = new NoticeWindow(NoticeType.ERROR_NOTIFICATION, "Sorry! Invalid Username and Password", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_label_signin_empMouseClicked

    private void label_signin_empMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseEntered
        setColorsigin(panel_signin_emp);
        label_signin_emp.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_label_signin_empMouseEntered

    private void label_signin_empMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_signin_empMouseExited
        resetColorsigin(panel_signin_emp);
        label_signin_emp.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_signin_empMouseExited

    private void CboxShowPass_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboxShowPass_empActionPerformed
        if (CboxShowPass_emp.isSelected()) {
            txt_password_emp.setEchoChar((char) 0); //password = JPasswordField
        } else {
            txt_password_emp.setEchoChar('*');
        }
    }//GEN-LAST:event_CboxShowPass_empActionPerformed

    private void label_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_adminMouseClicked
        clickMenuRight(panel_admin,panel_doctor,panel_employee,1);
        panel_admin_log.setVisible(true);
        panel_doctor_log.setVisible(false);
        panel_employee_log.setVisible(false);
    }//GEN-LAST:event_label_adminMouseClicked

    private void label_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_doctorMouseClicked
        clickMenuRight(panel_doctor,panel_admin,panel_employee,2);
        panel_doctor_log.setVisible(true);
        panel_admin_log.setVisible(false);
        panel_employee_log.setVisible(false);
    }//GEN-LAST:event_label_doctorMouseClicked

    private void label_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employeeMouseClicked
        clickMenuRight(panel_employee,panel_doctor,panel_admin,2);
        panel_employee_log.setVisible(true);
        panel_admin_log.setVisible(false);
        panel_doctor_log.setVisible(false);
    }//GEN-LAST:event_label_employeeMouseClicked

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
            java.util.logging.Logger.getLogger(registration_from.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registration_from.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registration_from.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registration_from.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registration_from().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CboxRememPass;
    private javax.swing.JCheckBox CboxRememPassDoctor;
    private javax.swing.JCheckBox CboxRememPassEmployee;
    private javax.swing.JCheckBox CboxShowPass_admin;
    private javax.swing.JCheckBox CboxShowPass_doctor;
    private javax.swing.JCheckBox CboxShowPass_emp;
    private javax.swing.JLabel admin_login_panel_admin;
    private javax.swing.JPanel closeMax_body;
    private javax.swing.JPanel close_panel;
    private javax.swing.JLabel close_white;
    private javax.swing.JLabel doctor_login_panel;
    private javax.swing.JLabel employye_login_emp;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_admin;
    private javax.swing.JLabel label_doctor;
    private javax.swing.JLabel label_employee;
    private javax.swing.JLabel label_signin_admin;
    private javax.swing.JLabel label_signin_doctor;
    private javax.swing.JLabel label_signin_emp;
    private javax.swing.JLabel login_here_admin;
    private javax.swing.JLabel login_here_doctor;
    private javax.swing.JLabel login_here_emp;
    private javax.swing.JPanel maximise;
    private javax.swing.JLabel maximise_label;
    private javax.swing.JPanel panel_admin;
    private javax.swing.JPanel panel_admin_log;
    private javax.swing.JPanel panel_doctor;
    private javax.swing.JPanel panel_doctor_log;
    private javax.swing.JPanel panel_employee;
    private javax.swing.JPanel panel_employee_log;
    private javax.swing.JPanel panel_signin_admin;
    private javax.swing.JPanel panel_signin_doctor;
    private javax.swing.JPanel panel_signin_emp;
    private javax.swing.JPanel separator_admin;
    private javax.swing.JPanel separator_doctor;
    private javax.swing.JPanel separator_emp;
    private javax.swing.JTextField txt_admin_id;
    private javax.swing.JTextField txt_doctor_id;
    private javax.swing.JTextField txt_emp_id;
    private javax.swing.JPasswordField txt_password_admin;
    private javax.swing.JPasswordField txt_password_doctor;
    private javax.swing.JPasswordField txt_password_emp;
    // End of variables declaration//GEN-END:variables
}
