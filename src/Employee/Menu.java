/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Admin.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import medical.*;
import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class Menu extends javax.swing.JFrame {
    
    int Emp_ID;
    public int z=0;
    public int save_upgrade=0; 
    boolean a= true;
    private String gender;
    private String status;
    //958C8C   // C0C9D3   #787E74
    
   
     
    public Menu() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

//       menuList.setVisible(false);
//       Profile.setVisible(false);
//       profile.setVisible(false);
//       Ticket.setVisible(false);
//       ticket.setVisible(false);
//       Patient.setVisible(false);
//       patient.setVisible(false);
//       
      
        
        //error admin    #B5D8C7   #84C085  971, 635              1240, 783
        
        employee_profile.setVisible(false);
        employee_view.setVisible(false);
        getEmp_Id();
       
    }
    
    
    public boolean checkInputsEmp()
    {
                String E_id= emp_id.getText();
                String E_Name= txt_emp_full_name.getText();
                String E_Fname= txt_emp_father_name.getText();
                String E_Mname= txt_emp_mother_name.getText();
                SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
                String B_date = dFormat.format(emp_bd.getDate());
                String E_contact1= txt_emp_contact1.getText();
                String E_contact2= txt_emp_contact2.getText();
                String Age = (String) combo_emp_age.getSelectedItem();
                //String P_Doctor_name = (String) combo_patient_doctor_name.getSelectedItem();
                String E_address= txt_emp_address.getText();
                
        
        if(E_id==null || E_Name==null || E_Fname==null || E_Mname==null || B_date==null || E_contact1==null || E_contact2==null || Age==null ||
         E_address==null)
            
        {
            return false;
        }
        else
        {
            try {
                emp_id.getText();
                txt_emp_full_name.getText();
                txt_emp_father_name.getText();
                dFormat.format(emp_bd.getDate());
                txt_emp_mother_name.getText();
                //combo_patient_gender.getSelectedItem();
                //combo_patient_doctor_name.getSelectedItem();
                txt_emp_address.getText();
                txt_emp_contact1.getText();
                txt_emp_contact2.getText();
                
                
                
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        
    }
    public void Employee_Inform_Insert()
    {
        
        try {
            Date date = new Date(emp_bd.getDate().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement) con.createStatement();
            if (checkInputsEmp() && ImgPath != null) {
                try {

                    //Class.forName("com.mysql.jdbc.Driver");
                    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "***###botki143JN");
                    //Statement st = (Statement) con.createStatement();
                    String age = (String) combo_emp_age.getSelectedItem();
                    //String gen = (String) combo_gender.getSelectedItem();

                    PreparedStatement ps = con.prepareStatement("INSERT INTO employee(Id,FullName,FatherName,MotherName,Birthday,Status,Contact_1,Contact_2,Image,Department,Address,Gender)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, emp_id.getText());
                    ps.setString(2, txt_emp_full_name.getText());
                    ps.setString(3, txt_emp_father_name.getText());
                    ps.setString(4, txt_emp_mother_name.getText());
                    ps.setDate(5, (java.sql.Date) date);
                    ps.setString(6, status);
                    ps.setString(7, txt_emp_contact1.getText());
                    ps.setString(8, txt_emp_contact2.getText());
                    InputStream img = new FileInputStream(new File(ImgPath));
                    ps.setBlob(9, img);

                    ps.setString(10, txt_emp_dep.getText());
                    ps.setString(11, txt_emp_address.getText());
                    ps.setString(12, gender);
                    

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Your Data Inserted!");
                    // dispose();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry! One or More Field are Empty");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
    public void getEmp_Id()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            String query = "select max(Id) from employee";
            ResultSet rs = st.executeQuery(query); 
            
            if(rs.next())
            {
                Emp_ID = rs.getInt(1);
                Emp_ID=Emp_ID+1;
                //String str = String.valueOf(id);
                emp_id.setText(Integer.toString(Emp_ID));
                
                
            }
            else
            {
                emp_id.setText("100");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

    public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
        ImageIcon myImage = null;
        if(imagePath !=null)
        {
            myImage = new ImageIcon(imagePath);
        }
        else
        {
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
        
    }
    
    
    
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
        employee_profile = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txt_emp_contact2 = new javax.swing.JTextField();
        txt_emp_dep = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        emp_bd = new com.toedter.calendar.JDateChooser();
        combo_emp_age = new javax.swing.JComboBox<>();
        lbl_image = new javax.swing.JLabel();
        txt_emp_contact1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        married = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        single = new javax.swing.JRadioButton();
        others = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        txtExtra = new javax.swing.JTextField();
        txt_emp_father_name = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        emp_id = new javax.swing.JLabel();
        txt_emp_mother_name = new javax.swing.JTextField();
        txt_emp_address = new javax.swing.JTextField();
        txt_emp_full_name = new javax.swing.JTextField();
        employee_view = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txt_emp_addressU = new javax.swing.JTextField();
        txt_emp_full_nameU = new javax.swing.JTextField();
        txtExtra1 = new javax.swing.JTextField();
        txt_emp_father_nameU = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        emp_idU = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_emp_mother_nameU = new javax.swing.JTextField();
        Error_Id = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        txt_emp_contact_2U = new javax.swing.JTextField();
        txt_emp_depU = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        emp_bdU = new com.toedter.calendar.JDateChooser();
        lbl_imageU = new javax.swing.JLabel();
        txt_emp_contactU = new javax.swing.JTextField();
        txt_emp_genU = new javax.swing.JTextField();
        txt_emp_statusU = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        download = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

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
        ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ticketMouseClicked(evt);
            }
        });

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

        main_body.setBackground(new java.awt.Color(0, 51, 51));
        main_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(46, 64, 83));
        body.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_profile.setBackground(new java.awt.Color(46, 64, 83));
        employee_profile.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        employee_profile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                employee_profileComponentShown(evt);
            }
        });
        employee_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(46, 64, 83));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employye Profile");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 250, 40));

        employee_profile.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 40));

        jPanel10.setBackground(new java.awt.Color(46, 64, 83));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(46, 64, 83));
        jButton2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 200, 50));

        jButton1.setBackground(new java.awt.Color(46, 64, 83));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Close");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 200, 50));

        jButton3.setBackground(new java.awt.Color(46, 64, 83));
        jButton3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Save");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 50));

        employee_profile.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 220, 450));

        jPanel6.setBackground(new java.awt.Color(46, 64, 83));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_emp_contact2.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_contact2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_contact2.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_contact2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_contact2.setText("Contact 2");
        txt_emp_contact2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_contact2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_contact2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_contact2FocusLost(evt);
            }
        });
        jPanel6.add(txt_emp_contact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 200, 36));

        txt_emp_dep.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_dep.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_dep.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_dep.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_dep.setText("Department");
        txt_emp_dep.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_dep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_depFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_depFocusLost(evt);
            }
        });
        jPanel6.add(txt_emp_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 200, 36));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reg  Date  :");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        emp_bd.setBackground(new java.awt.Color(46, 64, 83));
        emp_bd.setForeground(new java.awt.Color(255, 255, 255));
        emp_bd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emp_bd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_bdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_bdMouseEntered(evt);
            }
        });
        jPanel6.add(emp_bd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 200, 40));

        combo_emp_age.setBackground(new java.awt.Color(46, 64, 83));
        combo_emp_age.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_emp_age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                   Age", "10 Day", "1 Month", "2 Month", "3 Month", "4 Month", "5 Month", "6 Month", "7 Month", "8 Month", "9 Month", "10 Month", "01 Year", "02 Year", "03Year", "04 Year", "05 Year", "06 Year", "07 Year", "08 Year", "09 Year", "10 Year", "12 Year", "13 Year", "14 Year", "15 Year", "16 Year", "17 Year", "18 Year", "19 Year", "20 Year", "21 Year", "22 Year", "23 Year", "24 Year", "25 Year", "26 Year", "27 Year", "28 Year", "29 Year", "30 Year", "31 Year", "32 Year", "33 Year", "34 Year", "35 Year", "36 Year", "37 Year", "38 Year", "39 Year", "40 Year", "41 Year", "42 Year", "43 Year", "44 Year", "45 Year", "46 Year", "47 Year", "48 Year", "49 Year", "50 Year", "51 Year", "52 Year", "53 Year", "54 Year", "55 Year", "56 Year", "57 Year", "58 Year", "59 Year", "60 Year", "61 Year", "62 Year", "63 Year", "64 Year", "65 Year", "66 Year", "67 Year", "68 Year", "69 Year", "70 Year", "71 Year", "72 Year", "73 Year", "74 Year", "75 Year", "76 Year", "77 Year", "78 Year", "79 Year", "80 Year" }));
        combo_emp_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_emp_ageActionPerformed(evt);
            }
        });
        jPanel6.add(combo_emp_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 200, 40));

        lbl_image.setBackground(new java.awt.Color(0, 51, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/insert.png"))); // NOI18N
        lbl_image.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbl_image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });
        jPanel6.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 220, 230));

        txt_emp_contact1.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_contact1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_contact1.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_contact1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_contact1.setText("Contact 1");
        txt_emp_contact1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_contact1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_contact1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_contact1FocusLost(evt);
            }
        });
        jPanel6.add(txt_emp_contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 200, 36));

        jPanel7.setBackground(new java.awt.Color(46, 64, 83));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        married.setBackground(new java.awt.Color(46, 64, 83));
        married.setForeground(new java.awt.Color(255, 255, 255));
        married.setText("Married");
        married.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriedActionPerformed(evt);
            }
        });

        male.setBackground(new java.awt.Color(46, 64, 83));
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Gender     :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Status     :");

        female.setBackground(new java.awt.Color(46, 64, 83));
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        other.setBackground(new java.awt.Color(46, 64, 83));
        other.setForeground(new java.awt.Color(255, 255, 255));
        other.setText("Other");
        other.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherActionPerformed(evt);
            }
        });

        single.setBackground(new java.awt.Color(46, 64, 83));
        single.setForeground(new java.awt.Color(255, 255, 255));
        single.setText("Single");
        single.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleActionPerformed(evt);
            }
        });

        others.setBackground(new java.awt.Color(46, 64, 83));
        others.setForeground(new java.awt.Color(255, 255, 255));
        others.setText("Others");
        others.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 19, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(male)
                            .addGap(23, 23, 23)
                            .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(other, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(single)
                            .addGap(16, 16, 16)
                            .addComponent(married)
                            .addGap(19, 19, 19)
                            .addComponent(others)))
                    .addGap(0, 19, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(male)
                        .addComponent(female)
                        .addComponent(other))
                    .addGap(27, 27, 27)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(single)
                        .addComponent(married)
                        .addComponent(others))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 380, 110));

        employee_profile.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 670, 450));

        jPanel5.setBackground(new java.awt.Color(46, 64, 83));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtExtra.setBackground(new java.awt.Color(46, 64, 83));
        txtExtra.setBorder(null);

        txt_emp_father_name.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_father_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_father_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_father_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_father_name.setText("Father Name");
        txt_emp_father_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_father_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_father_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_father_nameFocusLost(evt);
            }
        });
        txt_emp_father_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emp_father_nameKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(46, 64, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Employee Id  :-");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 30));

        emp_id.setBackground(new java.awt.Color(0, 204, 204));
        emp_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        emp_id.setForeground(new java.awt.Color(0, 204, 204));
        emp_id.setText("1");
        jPanel2.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, 30));

        txt_emp_mother_name.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_mother_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_mother_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_mother_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_mother_name.setText("Mother Name");
        txt_emp_mother_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_mother_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_mother_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_mother_nameFocusLost(evt);
            }
        });

        txt_emp_address.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_address.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_address.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_address.setText("Address");
        txt_emp_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_addressFocusLost(evt);
            }
        });

        txt_emp_full_name.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_full_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_emp_full_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_full_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_full_name.setText("Full Name");
        txt_emp_full_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_emp_full_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_full_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_full_nameFocusLost(evt);
            }
        });
        txt_emp_full_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emp_full_nameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 44, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(txtExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txt_emp_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170)
                            .addComponent(txt_emp_father_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(txt_emp_mother_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170)
                            .addComponent(txt_emp_address, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 44, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_emp_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_emp_father_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_emp_mother_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_emp_address, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        employee_profile.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 920, 140));

        employee_view.setBackground(new java.awt.Color(46, 64, 83));
        employee_view.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        employee_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(46, 64, 83));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_emp_addressU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_addressU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_addressU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_addressU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_addressU.setText("Address");
        txt_emp_addressU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_addressU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_addressUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_addressUFocusLost(evt);
            }
        });
        jPanel9.add(txt_emp_addressU, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 93, 180, 36));

        txt_emp_full_nameU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_full_nameU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_full_nameU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_full_nameU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_full_nameU.setText("Full Name");
        txt_emp_full_nameU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_full_nameU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_full_nameUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_full_nameUFocusLost(evt);
            }
        });
        txt_emp_full_nameU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emp_full_nameUKeyReleased(evt);
            }
        });
        jPanel9.add(txt_emp_full_nameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 13, 180, 36));

        txtExtra1.setBackground(new java.awt.Color(46, 64, 83));
        txtExtra1.setBorder(null);
        jPanel9.add(txtExtra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 97, 20, -1));

        txt_emp_father_nameU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_father_nameU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_father_nameU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_father_nameU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_father_nameU.setText("Father Name");
        txt_emp_father_nameU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_father_nameU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_father_nameUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_father_nameUFocusLost(evt);
            }
        });
        txt_emp_father_nameU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emp_father_nameUKeyReleased(evt);
            }
        });
        jPanel9.add(txt_emp_father_nameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 13, 180, 36));

        jPanel11.setBackground(new java.awt.Color(46, 64, 88));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/search icon.png"))); // NOI18N
        jPanel11.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 12, -1, 40));

        emp_idU.setBackground(new java.awt.Color(46, 64, 83));
        emp_idU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        emp_idU.setForeground(new java.awt.Color(204, 204, 255));
        emp_idU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_idUKeyReleased(evt);
            }
        });
        jPanel11.add(emp_idU, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Id");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, -1, -1));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 280, 70));

        txt_emp_mother_nameU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_mother_nameU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_mother_nameU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_mother_nameU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_mother_nameU.setText("Mother Name");
        txt_emp_mother_nameU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_mother_nameU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_mother_nameUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_mother_nameUFocusLost(evt);
            }
        });
        jPanel9.add(txt_emp_mother_nameU, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 93, 180, 36));
        jPanel9.add(Error_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 142, 27));

        Time.setBackground(new java.awt.Color(46, 64, 83));
        Time.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(0, 204, 204));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Time.setText("jLabel5");
        jPanel9.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 150, 30));

        Date.setBackground(new java.awt.Color(46, 64, 83));
        Date.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 204, 204));
        Date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Date.setText("jLabel5");
        jPanel9.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 150, 30));

        jButton4.setText("download");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        employee_view.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 920, 140));

        jPanel12.setBackground(new java.awt.Color(46, 64, 83));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_emp_contact_2U.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_contact_2U.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_contact_2U.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_contact_2U.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_contact_2U.setText("Contact 2");
        txt_emp_contact_2U.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_contact_2U.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_contact_2UFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_contact_2UFocusLost(evt);
            }
        });
        jPanel12.add(txt_emp_contact_2U, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 200, 36));

        txt_emp_depU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_depU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_depU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_depU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_depU.setText("Department");
        txt_emp_depU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_depU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_depUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_depUFocusLost(evt);
            }
        });
        jPanel12.add(txt_emp_depU, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 36));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Birthday Date  :");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, -1));

        emp_bdU.setBackground(new java.awt.Color(46, 64, 83));
        emp_bdU.setForeground(new java.awt.Color(255, 255, 255));
        emp_bdU.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emp_bdU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_bdUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emp_bdUMouseEntered(evt);
            }
        });
        jPanel12.add(emp_bdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 200, 40));

        lbl_imageU.setBackground(new java.awt.Color(0, 51, 51));
        lbl_imageU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imageU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/insert.png"))); // NOI18N
        lbl_imageU.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        lbl_imageU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_imageU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageUMouseClicked(evt);
            }
        });
        jPanel12.add(lbl_imageU, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 220, 230));

        txt_emp_contactU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_contactU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_contactU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_contactU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_contactU.setText("Contact 1");
        txt_emp_contactU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_contactU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_contactUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_contactUFocusLost(evt);
            }
        });
        jPanel12.add(txt_emp_contactU, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 200, 36));

        txt_emp_genU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_genU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_genU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_genU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_genU.setText("Gender");
        txt_emp_genU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_genU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_genUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_genUFocusLost(evt);
            }
        });
        jPanel12.add(txt_emp_genU, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 36));

        txt_emp_statusU.setBackground(new java.awt.Color(46, 64, 83));
        txt_emp_statusU.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_emp_statusU.setForeground(new java.awt.Color(255, 255, 255));
        txt_emp_statusU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_emp_statusU.setText("Relational Status");
        txt_emp_statusU.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 255)));
        txt_emp_statusU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emp_statusUFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emp_statusUFocusLost(evt);
            }
        });
        jPanel12.add(txt_emp_statusU, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 200, 36));

        employee_view.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 670, 450));

        jPanel13.setBackground(new java.awt.Color(46, 64, 83));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        download.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        download.setForeground(new java.awt.Color(255, 255, 255));
        download.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        download.setText("Download");
        download.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        download.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        download.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadMouseClicked(evt);
            }
        });
        jPanel13.add(download, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, 40));

        reset.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reset.setText("Reset");
        reset.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });
        jPanel13.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 50));

        jLabel5.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Closwe");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 170, 50));

        employee_view.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 220, 450));

        jPanel14.setBackground(new java.awt.Color(46, 64, 83));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Employye View");
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 321, 40));

        employee_view.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 920, 40));

        employee_profile.add(employee_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 700));

        body.add(employee_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 15, 960, 700));

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
       
        if(this.getExtendedState()!= Menu.MAXIMIZED_BOTH)
        {
            
            this.setExtendedState(Menu.MAXIMIZED_BOTH);
        }
        else
        {
            this.setExtendedState(Menu.NORMAL);
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

       
    }//GEN-LAST:event_LABEL_signup_doctorMouseClicked

    private void LABEL_signup_doctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseEntered
       
    }//GEN-LAST:event_LABEL_signup_doctorMouseEntered

    private void LABEL_signup_doctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LABEL_signup_doctorMouseExited
       
    }//GEN-LAST:event_LABEL_signup_doctorMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new Employee_Profile().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Employee_Inform_Insert();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_emp_contact2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact2FocusGained
        if (txt_emp_contact2.getText().equals("Contact 2")) {
            txt_emp_contact2.setText("");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact2FocusGained

    private void txt_emp_contact2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact2FocusLost
        if (txt_emp_contact2.getText().equals("")) {
            txt_emp_contact2.setText("Contact 2");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact2FocusLost

    private void txt_emp_depFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depFocusGained
        if (txt_emp_dep.getText().equals("Department")) {
            txt_emp_dep.setText("");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depFocusGained

    private void txt_emp_depFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depFocusLost
        if (txt_emp_dep.getText().equals("")) {
            txt_emp_dep.setText("Department");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depFocusLost

    private void emp_bdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdMouseClicked

    private void emp_bdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdMouseEntered

    private void combo_emp_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_emp_ageActionPerformed

        String age = (String) combo_emp_age.getSelectedItem();
        if("                   Age".equals(age))
        {
            //JOptionPane.showMessageDialog(null,"Sorry! This is not selecte!");
            JOptionPane.showMessageDialog(null, "Sorry! This is not select!",
                "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_combo_emp_ageActionPerformed

    private void lbl_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageMouseClicked

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
        }
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path,null));
            ImgPath=path;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sorry! No File Selected");
        }
    }//GEN-LAST:event_lbl_imageMouseClicked

    private void txt_emp_contact1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact1FocusGained
        if (txt_emp_contact1.getText().equals("Contact 1")) {
            txt_emp_contact1.setText("");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact1FocusGained

    private void txt_emp_contact1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact1FocusLost
        if (txt_emp_contact1.getText().equals("")) {
            txt_emp_contact1.setText("Contact 1");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact1FocusLost

    private void marriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedActionPerformed
        status="married";
        if(married.isSelected())
        {
            single.setSelected(false);
            others.setSelected(false);
        }
    }//GEN-LAST:event_marriedActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        gender="male";
        if(male.isSelected())
        {
            female.setSelected(false);
            other.setSelected(false);
        }
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        gender="female";
        if(female.isSelected())
        {
            male.setSelected(false);
            other.setSelected(false);
        }
    }//GEN-LAST:event_femaleActionPerformed

    private void otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherActionPerformed
        gender="other";
        if(other.isSelected())
        {
            female.setSelected(false);
            male.setSelected(false);
        }
    }//GEN-LAST:event_otherActionPerformed

    private void singleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleActionPerformed

        status="single";
        if(single.isSelected())
        {
            married.setSelected(false);
            others.setSelected(false);
        }
    }//GEN-LAST:event_singleActionPerformed

    private void othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersActionPerformed
        status="others";
        if(others.isSelected())
        {
            married.setSelected(false);
            single.setSelected(false);
        }
    }//GEN-LAST:event_othersActionPerformed

    private void txt_emp_father_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameFocusGained
        if (txt_emp_father_name.getText().equals("Father Name")) {
            txt_emp_father_name.setText("");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameFocusGained

    private void txt_emp_father_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameFocusLost
        if (txt_emp_father_name.getText().equals("")) {
            txt_emp_father_name.setText("Father Name");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameFocusLost

    private void txt_emp_father_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_father_nameKeyReleased

    }//GEN-LAST:event_txt_emp_father_nameKeyReleased

    private void txt_emp_mother_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameFocusGained
        if (txt_emp_mother_name.getText().equals("Mother Name")) {
            txt_emp_mother_name.setText("");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameFocusGained

    private void txt_emp_mother_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameFocusLost
        if (txt_emp_mother_name.getText().equals("")) {
            txt_emp_mother_name.setText("Mother Name");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameFocusLost

    private void txt_emp_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressFocusGained
        if (txt_emp_address.getText().equals("Address")) {
            txt_emp_address.setText("");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressFocusGained

    private void txt_emp_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressFocusLost
        if (txt_emp_address.getText().equals("")) {
            txt_emp_address.setText("Address");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressFocusLost

    private void txt_emp_full_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameFocusGained
        if (txt_emp_full_name.getText().equals("Full Name")) {
            txt_emp_full_name.setText("");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameFocusGained

    private void txt_emp_full_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameFocusLost
        if (txt_emp_full_name.getText().equals("")) {
            txt_emp_full_name.setText("Full Name");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameFocusLost

    private void txt_emp_full_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_full_nameKeyReleased

        //txtSubject.setText(txt_patient_full_name.getText());
    }//GEN-LAST:event_txt_emp_full_nameKeyReleased

    private void employee_profileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_employee_profileComponentShown

    }//GEN-LAST:event_employee_profileComponentShown

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
       employee_profile.setVisible(true);
    }//GEN-LAST:event_profileMouseClicked

    private void txt_emp_addressUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressUFocusGained
        if (txt_emp_address.getText().equals("Address")) {
            txt_emp_address.setText("");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressUFocusGained

    private void txt_emp_addressUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressUFocusLost
        if (txt_emp_address.getText().equals("")) {
            txt_emp_address.setText("Address");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressUFocusLost

    private void txt_emp_full_nameUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameUFocusGained
        if (txt_emp_full_name.getText().equals("Full Name")) {
            txt_emp_full_name.setText("");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameUFocusGained

    private void txt_emp_full_nameUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameUFocusLost
        if (txt_emp_full_name.getText().equals("")) {
            txt_emp_full_name.setText("Full Name");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameUFocusLost

    private void txt_emp_full_nameUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_full_nameUKeyReleased

        //txtSubject.setText(txt_patient_full_name.getText());
    }//GEN-LAST:event_txt_emp_full_nameUKeyReleased

    private void txt_emp_father_nameUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameUFocusGained
        if (txt_emp_father_name.getText().equals("Father Name")) {
            txt_emp_father_name.setText("");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameUFocusGained

    private void txt_emp_father_nameUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameUFocusLost
        if (txt_emp_father_name.getText().equals("")) {
            txt_emp_father_name.setText("Father Name");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameUFocusLost

    private void txt_emp_father_nameUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_father_nameUKeyReleased

    }//GEN-LAST:event_txt_emp_father_nameUKeyReleased

    private void emp_idUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_idUKeyReleased
        String search = emp_idU.getText();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            String query = "select *from employee where Id='"+search+"'";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
//                String s1 = rs.getString(1); //id 
//                String s2 = rs.getString(2); //Full NAme
//                String s3 = rs.getString(3); //F Name
//                String s4 = rs.getString(4); //Mother Name
//                Date s5 = rs.getDate(5); // Birthday
//                String s6 = rs.getString(6); //status              
//                String s7 = rs.getString(7); //contact
//                String s9 = rs.getString(9); // Department
//                String s10 = rs.getString(10);// address
//                String s12 = rs.getString(11); //gendwer
//                //String s11 = rs.getString(10);
                
               
                String s2 = rs.getString("FullName"); //Full NAme
                txt_emp_full_nameU.setText(s2);
                
                String s3 = rs.getString("FatherName"); //F Name
                txt_emp_father_nameU.setText(s3);
                
                String s4 = rs.getString("MotherName"); //Mother Name
                txt_emp_mother_nameU.setText(s4);
                
                Date s5 = rs.getDate("Birthday"); // Birthday
                emp_bdU.setDate(s5);
                 
                String s6 = rs.getString("Status"); //status
                txt_emp_statusU.setText(s6);
                 
                String s7 = rs.getString("Contact_1"); //contact
                txt_emp_contactU.setText(s7);
                
                String s8 = rs.getString("Contact_2"); //contact
                txt_emp_contact_2U.setText(s8);
                
                lbl_imageU.setIcon(ResizeImage(null, rs.getBytes(8)));
                                
                String s10 = rs.getString("Department"); // Department
                txt_emp_depU.setText(s10);
                
                String s11 = rs.getString("Address");// address
                txt_emp_addressU.setText(s11);
                
                String s12 = rs.getString("Gender"); //gendwer
                txt_emp_genU.setText(s12);
                //String s11 = rs.getString(10);
               
                
                
                
                
               
               
                
                
                
                Error_Id.setText("*Id match");
                Error_Id.setForeground(Color.GREEN);
               
                txt_emp_full_name.setEditable(true);
                txt_emp_father_name.setEditable(true);
                txt_emp_mother_name.setEditable(true);
                emp_bd.setEnabled(false);
                txt_emp_statusU.setEditable(true);
                txt_emp_contact1.setEditable(true);
                txt_emp_contact2.setEditable(true);
                txt_emp_genU.setEditable(false);
                lbl_image.setEnabled(true);
                txt_emp_dep.setEditable(true);
                txt_emp_address.setEditable(true);
                
               
//               txtId.setEditable(false);
//               txtFname.setEditable(true);
//               txtYear.setEditable(false);
//               txtMonth.setEditable(false);
//               txtDate.setEditable(false);
//               txtOcuu.setEditable(true);
//               txtContact.setEditable(true);
//               txtBlood.setEditable(false);
//               txtAddress.setEditable(true);
//               txtLastDate.setEditable(true);
//               
//               Browse.setVisible(true);
//               ErrorId.setText(null);
               
            }
            else
            {
               
                Error_Id.setVisible(true);
                Error_Id.setText("*Sorry! Id doesn't match");
            }
          
           con.close();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        

    }//GEN-LAST:event_emp_idUKeyReleased

    private void txt_emp_mother_nameUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameUFocusGained
        if (txt_emp_mother_name.getText().equals("Mother Name")) {
            txt_emp_mother_name.setText("");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameUFocusGained

    private void txt_emp_mother_nameUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameUFocusLost
        if (txt_emp_mother_name.getText().equals("")) {
            txt_emp_mother_name.setText("Mother Name");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameUFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            //String path="D:\\Pdf";
            String id=emp_id.getText();
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(""+id +".pdf"));

            document.open();

            String title="Daffodil Medical System";
            document.add(new Paragraph(title,FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.RED)));
            document.add(new Paragraph("--------------------------------------------------------------"));

            String time_date="Time   :-  "+Time  +"Date  :-  "+Date;
            document.add(new Paragraph(time_date));

            JOptionPane.showMessageDialog(null, "Done");
            document.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_emp_contact_2UFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact_2UFocusGained
        if (txt_emp_contact2.getText().equals("Contact 2")) {
            txt_emp_contact2.setText("");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact_2UFocusGained

    private void txt_emp_contact_2UFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact_2UFocusLost
        if (txt_emp_contact2.getText().equals("")) {
            txt_emp_contact2.setText("Contact 2");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact_2UFocusLost

    private void txt_emp_depUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depUFocusGained
        if (txt_emp_dep.getText().equals("Department")) {
            txt_emp_dep.setText("");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depUFocusGained

    private void txt_emp_depUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depUFocusLost
        if (txt_emp_dep.getText().equals("")) {
            txt_emp_dep.setText("Department");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depUFocusLost

    private void emp_bdUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdUMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdUMouseClicked

    private void emp_bdUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdUMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdUMouseEntered

    private void lbl_imageUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageUMouseClicked

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
        }
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path,null));
            ImgPath=path;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sorry! No File Selected");
        }
    }//GEN-LAST:event_lbl_imageUMouseClicked

    private void txt_emp_contactUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contactUFocusGained
        if (txt_emp_contact1.getText().equals("Contact 1")) {
            txt_emp_contact1.setText("");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contactUFocusGained

    private void txt_emp_contactUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contactUFocusLost
        if (txt_emp_contact1.getText().equals("")) {
            txt_emp_contact1.setText("Contact 1");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contactUFocusLost

    private void txt_emp_genUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_genUFocusGained
        if (txt_emp_genU.getText().equals("Gender")) {
            txt_emp_genU.setText("");
            txt_emp_genU.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_genUFocusGained

    private void txt_emp_genUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_genUFocusLost
        if (txt_emp_genU.getText().equals("")) {
            txt_emp_genU.setText("Gender");
            txt_emp_genU.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_genUFocusLost

    private void txt_emp_statusUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_statusUFocusGained
        if (txt_emp_statusU.getText().equals("Relational Status")) {
            txt_emp_statusU.setText("");
            txt_emp_statusU.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_statusUFocusGained

    private void txt_emp_statusUFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_statusUFocusLost
        if (txt_emp_statusU.getText().equals("")) {
            txt_emp_statusU.setText("Relational Status");
            txt_emp_statusU.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_statusUFocusLost

    private void downloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseClicked

        String E_id= emp_id.getText();
        String E_FullName= txt_emp_full_name.getText();
        String E_Fname= txt_emp_father_name.getText();
        String E_Mname= txt_emp_mother_name.getText();

        String E_contact1= txt_emp_contact1.getText();
        String E_contact2= txt_emp_contact2.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String B_date = dFormat.format(emp_bd.getDate());
        //String P_Doctor_name = (String) combo_patient_doctor_name.getSelectedItem();
        String E_address= txt_emp_address.getText();
        String E_dep= txt_emp_dep.getText();
        String E_gen = txt_emp_genU.getText();
        String E_sta = txt_emp_statusU.getText();
        String Age = (String) combo_emp_age.getSelectedItem();
        String path="D:\\";

        try {
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();

            //                    SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            //                    String B_date = dFormat.format(emp_bd.getDate());
            //                    String Age = (String) combo_emp_age.getSelectedItem();

            PdfWriter.getInstance(doc, new FileOutputStream(path +""+E_FullName+ " "+".pdf"));
            doc.open();

            String title="                        Daffodil Medical Systems\n\n";
            Paragraph paragrph1 = new Paragraph(title);
            doc.add(paragrph1);

            String Content = "Time  :- " + Time.getText() + "\nDate  :- " + Date.getText();
            Paragraph paragrph2 = new Paragraph(Content);
            doc.add(paragrph2);

            String Employee_Id = "Employee Id  :- "+emp_id.getText();
            Paragraph paragrph3 = new Paragraph(Employee_Id);
            doc.add(paragrph3);

            //                    String content="Time :- "+Time.getText() +"\nDate  :- "+Date_label.getText()+"\n\nEmploye Id  :-  "+emp_id+"Employee Name :- "+E_FullName+"Employee Father Name :- "+E_Fname +"Employee Mother Name :- "+E_Mname+
            //                            "Birthday Date :- "+B_date +"Contact Number1 :- "+E_contact1 +"Contact Number2 :- "+E_contact2 +"Age      :-  "+Age +"Address   :-  "+E_address +"Department  :- "+E_dep
            //                            +"Gender  :- "+E_gen  +"Relational Status : -"+E_sta;
            //
            //                    Paragraph paragrph2 = new Paragraph(content);
            //                    doc.add(paragrph2);

            JOptionPane.showMessageDialog(null,"Done");
            doc.close();
            //PdfPTable tbl = new PdfPTable(3);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_downloadMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        dispose();
        new Employee_View().setVisible(true);
    }//GEN-LAST:event_resetMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void ticketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ticketMouseClicked
       employee_view.setVisible(true);
    }//GEN-LAST:event_ticketMouseClicked
   

    
    
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Error_Id;
    private javax.swing.JLabel LABEL_signup_doctor;
    private javax.swing.JPanel Patient;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Ticket;
    private javax.swing.JLabel Time;
    private javax.swing.JPanel body;
    private javax.swing.JPanel closeMax_body;
    private javax.swing.JPanel close_panel;
    private javax.swing.JLabel close_white;
    private javax.swing.JComboBox<String> combo_emp_age;
    private javax.swing.JLabel download;
    private com.toedter.calendar.JDateChooser emp_bd;
    private com.toedter.calendar.JDateChooser emp_bdU;
    private javax.swing.JLabel emp_id;
    private javax.swing.JTextField emp_idU;
    private javax.swing.JPanel employee_profile;
    private javax.swing.JPanel employee_view;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_imageU;
    private javax.swing.JPanel linepatient;
    private javax.swing.JPanel lineprofile;
    private javax.swing.JPanel lineticket;
    private javax.swing.JPanel main_body;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton married;
    private javax.swing.JPanel maximise;
    private javax.swing.JLabel maximise_label;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuIcon;
    private javax.swing.JPanel menuList;
    private javax.swing.JPanel menu_first;
    private javax.swing.JPanel menu_first_border;
    private javax.swing.JLabel menu_first_label;
    private javax.swing.JRadioButton other;
    private javax.swing.JRadioButton others;
    private javax.swing.JLabel patient;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel reset;
    private javax.swing.JLabel settinf_label;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel setting_border;
    private javax.swing.JRadioButton single;
    private javax.swing.JLabel ticket;
    private javax.swing.JTextField txtExtra;
    private javax.swing.JTextField txtExtra1;
    private javax.swing.JTextField txt_emp_address;
    private javax.swing.JTextField txt_emp_addressU;
    private javax.swing.JTextField txt_emp_contact1;
    private javax.swing.JTextField txt_emp_contact2;
    private javax.swing.JTextField txt_emp_contactU;
    private javax.swing.JTextField txt_emp_contact_2U;
    private javax.swing.JTextField txt_emp_dep;
    private javax.swing.JTextField txt_emp_depU;
    private javax.swing.JTextField txt_emp_father_name;
    private javax.swing.JTextField txt_emp_father_nameU;
    private javax.swing.JTextField txt_emp_full_name;
    private javax.swing.JTextField txt_emp_full_nameU;
    private javax.swing.JTextField txt_emp_genU;
    private javax.swing.JTextField txt_emp_mother_name;
    private javax.swing.JTextField txt_emp_mother_nameU;
    private javax.swing.JTextField txt_emp_statusU;
    // End of variables declaration//GEN-END:variables
}
