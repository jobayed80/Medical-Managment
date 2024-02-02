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
import java.util.Properties;
import java.util.prefs.Preferences;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author h
 */
public class employee_panel1 extends javax.swing.JFrame {
    
    public int z=0;
    public int save_upgrade=0; 
    boolean a= true;
    private String gender;
    //958C8C   // C0C9D3   #787E74
    
    int patient_ID;
    
   
     
    public employee_panel1() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        getPatient_Id();

       menuList.setVisible(false);
       Profile.setVisible(false);
       profile.setVisible(false);
       Ticket.setVisible(false);
       ticket.setVisible(false);
       Patient_list.setVisible(false);
       patientList.setVisible(false);
       
       panel_save.setVisible(false);
       label_save.setVisible(false);
       panel_update.setVisible(false);
       label_update.setVisible(false);
      
       //update employee profile
      
       ErrorId.setVisible(false);
       txt_employee_full_name_update.setEditable(false);
       txt_employee_father_name_update.setEditable(false);
       txt_employee_mother_name_update.setEditable(false);
       birthday_employee_date_update.setEnabled(false);
       txt_employee_gender_update.setEditable(false);
       txt_employee_contact_update.setEditable(false);
       txt_employee_status_update.setEditable(false);
       //lbl_employee_image_update.setEnabled(false);
       txt_employee_department_update.setEditable(false);
       txt_employee_address_update.setEditable(false);
       BROWSE.setVisible(false);
       
       Emp_Profile.setVisible(false);
       Emp_Profile_Update.setVisible(false);
       ticket_profile.setVisible(false);
       patient_list_panel.setVisible(false);
        
        //error admin    #B5D8C7   #84C085
        
        
//         JTable table;
//     
//                
//        Object[][] data = {
//        {1, "FN1","LN1",10},
//        {2, "FN1","LN1",15},
//        {3, "FN1","LN1",20},
//        {4, "FN1","LN1",25},
//        {5, "FN1","LN1",30},
//        {6, "FN1","LN1",35},
//        {7, "FN1","LN1",40},
//        {8, "FN1","LN1",45},
//        {9, "FN1","LN1",50},
//        {10, "FN1","LN1",60}
//        };
//    
//
//        table = new JTable(data, new Object[]{"Patient Id","Full Name","Father Name","Age", "Gender","Contact","Doctor Name","Address","Registration Date","Patient Illness"});
//         
       
    }
    
    //increase patient id from database
    public void getPatient_Id()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            String query = "select max(Patient_Id) from employee_ticket";
            ResultSet rs = st.executeQuery(query); 
            
            if(rs.next())
            {
                patient_ID = rs.getInt(1);
                patient_ID =patient_ID+1000;
                //String str = String.valueOf(id);
                patient_id.setText(Integer.toString(patient_ID));
                txtContent.setText(patient_id.getText());
                
            }
            else
            {
                patient_id.setText("1000");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //button hover
    //    Start admin color
    public void setColorlogin(JPanel p) {
        p.setBackground(new Color(5,10,46));
        

    }

    public void resetColorlogin(JPanel p1) {
        p1.setBackground(new Color(0,51,51));

    }
    
    // send color
    public void setColorSend(JLabel p) {
        p.setBackground(new Color(5,10,46));
        send.setForeground(new Color(0,204,204));
    }
    public void resetColorSend(JLabel p) {
        p.setBackground(new Color(5,10,46));
        send.setForeground(new Color(255,255,255));
    }
    
    
    //ImagePath
    String ImgPath = null;
    
    //Resize Image 
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
    
    public void clickMenu(JPanel h1, JPanel h2, JPanel h3, JPanel h4,  int numberbool)
    {
        switch (numberbool) {
            case 1:
                h1.setBackground(new Color (0,102,102)); //25,29,74
                h2.setBackground(new Color (25,29,76));
                h3.setBackground(new Color (25,29,76));//25,29,76
                h4.setBackground(new Color (25,29,76));//25,29,76
                break;
            case 2:
                h1.setBackground(new Color(25, 29, 76)); //25,29,74
                h2.setBackground(new Color(0, 102, 102));
                h3.setBackground(new Color(25, 29, 76));//25,29,76
                h4.setBackground(new Color(25, 29, 76));//25,29,76
                break;
            case 3:
                h1.setBackground(new Color (25,29,76)); //25,29,74
                h2.setBackground(new Color (25,29,76));
                h3.setBackground(new Color (0,102,102));//25,29,76
                h4.setBackground(new Color (25,29,76));//25,29,76
                break;
            default:
                h1.setBackground(new Color (25,29,76)); //25,29,74
                h2.setBackground(new Color (25,29,76));
                h3.setBackground(new Color (25,29,76));//25,29,76
                h4.setBackground(new Color (0,102,102));//25,29,76
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
        else
        {
            h1.setBackground(new Color (5,10,46)); //25,29,74
            h2.setBackground(new Color (25,29,74)); //25,29,74
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

    public boolean checkInputs()
    {
                String Id= txt_id.getText();
                String Name= txt_full_name.getText();
                String Fname= txt_father_name.getText();
                String Mname= txt_mother_name.getText();
                SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
                String Bdate = dFormat.format(birthday_date.getDate());
                String contact= txt_contact.getText();
                String gender = (String) combo_gender.getSelectedItem();
                String status = (String) combo_status.getSelectedItem();
                String dep= txt_department.getText();
                String address= txt_address.getText();
                
        
        if(Id==null || Name==null || Fname==null || Mname==null || Bdate==null || contact==null ||
        gender==null || status==null || dep==null || address==null || ImgPath==null)
            
        {
            return false;
        }
        else
        {
            try {
                 txt_id.getText();
                 txt_full_name.getText();
                 txt_father_name.getText();
                 txt_mother_name.getText();
                 dFormat.format(birthday_date.getDate());
                 txt_contact.getText();
                 combo_gender.getSelectedItem();
                 combo_status.getSelectedItem();
                 txt_department.getText();
                 txt_address.getText();
                
                
                
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        
    }
    
   
     
    public boolean Updated()
    {
        String search = txt_employee_update_id.getText();

        String Full = txt_employee_full_name_update.getText();
        String F_Name = txt_employee_father_name_update.getText();
        String M_Name = txt_employee_mother_name_update.getText();
        String sta = (String) combo_status.getSelectedItem();
        String Con = txt_employee_contact_update.getText();
        //lbl_employee_image_update.setIcon(ResizeImage(null, rs.getBytes(8)));
        String Dep = txt_employee_department_update.getText();
        String Add = txt_employee_address_update.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement) con.createStatement();
            String query = "update employee set FullName='" + Full + "', FatherName='" + F_Name + "', MotherName='" + M_Name + "', Status='" + sta + "', Contact='" + Con + "', Department='" + Dep + "', Address='" + Add + "' where Id='" + search + "'";
            st.executeUpdate(query);

        } catch (Exception e) {

        }
        return true;
    }
    
    public Connection getConnection() {
        Connection con = null;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");

            return con;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void Patient_Text_Null()
    {
        
    }
    
     public boolean checkInputsTicket()
    {
                String P_id= patient_id.getText();
                String P_Name= txt_patient_full_name.getText();
                String P_Fname= txt_patient_father_name.getText();
                SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
                String Reg_date = dFormat.format(patient_registration_date.getDate());
                String P_contact= txt_patient_contact.getText();
                String Age = (String) combo_patiebt_age.getSelectedItem();
                String P_Doctor_name = (String) combo_patient_doctor_name.getSelectedItem();
                String P_address= txt_patient_address.getText();
                
        
        if(P_id==null || P_Name==null || P_Fname==null || Reg_date==null || P_contact==null || Age==null ||
        P_Doctor_name==null || P_address==null)
            
        {
            return false;
        }
        else
        {
            try {
                patient_id.getText();
                txt_patient_full_name.getText();
                txt_patient_father_name.getText();
                dFormat.format(patient_registration_date.getDate());
                txt_patient_contact.getText();
                //combo_patient_gender.getSelectedItem();
                combo_patient_doctor_name.getSelectedItem();
                txt_patient_address.getText();
                
                
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        
    }
    public void Patient_Infor_Insert()
    {
         try {

            Date date = new Date(patient_registration_date.getDate().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement) con.createStatement();
            if (checkInputsTicket()) {
                try {

                    //Class.forName("com.mysql.jdbc.Driver");
                    //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "***###botki143JN");
                    //Statement st = (Statement) con.createStatement();
                    //String P_gen = (String) combo_patient_gender.getSelectedItem();
                    String P_doc = (String) combo_patient_doctor_name.getSelectedItem();
                    String P_age = (String) combo_patiebt_age.getSelectedItem();
                    String illness = (String) combo_patient_illness.getSelectedItem();

                    PreparedStatement ps = con.prepareStatement("INSERT INTO employee_ticket(Patient_Id,Full_Name,Father_Name,Age,Gender,Contact,Doctor_Name,Address,Registration_Date,Patient_Illness)" + "values(?,?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, patient_id.getText());
                    ps.setString(2, txt_patient_full_name.getText());
                    ps.setString(3, txt_patient_father_name.getText());
                    ps.setString(4, P_age);
                    ps.setString(5, gender);
                    ps.setString(6, txt_patient_contact.getText());
                    ps.setString(7, P_doc);
                    ps.setString(8, txt_patient_address.getText());
                    ps.setDate(9, (java.sql.Date) date);
                    ps.setString(10, illness);

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
        jLabel7 = new javax.swing.JLabel();
        Frame_new = new javax.swing.JPanel();
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
        Patient_list = new javax.swing.JPanel();
        patientList = new javax.swing.JLabel();
        lineticket = new javax.swing.JPanel();
        lineprofile = new javax.swing.JPanel();
        linepatient = new javax.swing.JPanel();
        Prodile_Update = new javax.swing.JPanel();
        profile_update = new javax.swing.JLabel();
        lineUpdate = new javax.swing.JPanel();
        ticket_profile = new javax.swing.JPanel();
        txt_patient_full_name = new javax.swing.JTextField();
        txt_patient_father_name = new javax.swing.JTextField();
        patient_registration_date = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_patient_address = new javax.swing.JTextArea();
        txt_patient_contact = new javax.swing.JTextField();
        combo_patient_doctor_name = new javax.swing.JComboBox<>();
        Email = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JComboBox<>();
        Email_Header = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSubject = new javax.swing.JTextField();
        send = new javax.swing.JLabel();
        patient_id = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        combo_patient_illness = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        combo_patiebt_age = new javax.swing.JComboBox<>();
        header = new javax.swing.JPanel();
        closeMax_body = new javax.swing.JPanel();
        close_panel = new javax.swing.JPanel();
        close_white = new javax.swing.JLabel();
        maximise = new javax.swing.JPanel();
        maximise_label = new javax.swing.JLabel();
        patient_list_panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_ticket_list = new javax.swing.JTable();
        body = new javax.swing.JPanel();
        Emp_Profile = new javax.swing.JPanel();
        txt_full_name = new javax.swing.JTextField();
        txt_father_name = new javax.swing.JTextField();
        txt_mother_name = new javax.swing.JTextField();
        birthday_date = new com.toedter.calendar.JDateChooser();
        combo_status = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();
        lbl_image = new javax.swing.JLabel();
        txt_contact = new javax.swing.JTextField();
        panel_save = new javax.swing.JPanel();
        label_save = new javax.swing.JLabel();
        next_save_upgrade = new javax.swing.JLabel();
        panel_update = new javax.swing.JPanel();
        label_update = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_department = new javax.swing.JTextField();
        combo_gender = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Emp_Profile_Update = new javax.swing.JPanel();
        txt_employee_full_name_update = new javax.swing.JTextField();
        txt_employee_father_name_update = new javax.swing.JTextField();
        txt_employee_mother_name_update = new javax.swing.JTextField();
        birthday_employee_date_update = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_employee_address_update = new javax.swing.JTextArea();
        lbl_employee_image_update = new javax.swing.JLabel();
        txt_employee_contact_update = new javax.swing.JTextField();
        next_save_upgrade2 = new javax.swing.JLabel();
        panel_update2 = new javax.swing.JPanel();
        label_employee_update = new javax.swing.JLabel();
        txt_employee_update_id = new javax.swing.JTextField();
        txt_employee_department_update = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ErrorId = new javax.swing.JLabel();
        BROWSE = new javax.swing.JLabel();
        txt_employee_gender_update = new javax.swing.JTextField();
        txt_employee_status_update = new javax.swing.JTextField();

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

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Frame_new.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));
        Frame_new.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 255)));
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
        menu_first_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        menu.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 698));

        menuList.setBackground(new java.awt.Color(5, 10, 46));
        menuList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuList.setPreferredSize(new java.awt.Dimension(220, 23));
        menuList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Profile.setBackground(new java.awt.Color(25, 29, 76));
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
        Profile.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 41));

        menuList.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 81, 186, 40));

        Ticket.setBackground(new java.awt.Color(25, 29, 76));
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
        ticket.setText("Patient Ticket");

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

        menuList.add(Ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 260, 190, -1));

        Patient_list.setBackground(new java.awt.Color(25, 29, 76));
        Patient_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Patient_listMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Patient_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Patient_listMouseExited(evt);
            }
        });

        patientList.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        patientList.setForeground(new java.awt.Color(255, 255, 255));
        patientList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientList.setText("Patient Ticket List");

        javax.swing.GroupLayout Patient_listLayout = new javax.swing.GroupLayout(Patient_list);
        Patient_list.setLayout(Patient_listLayout);
        Patient_listLayout.setHorizontalGroup(
            Patient_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Patient_listLayout.createSequentialGroup()
                .addComponent(patientList, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Patient_listLayout.setVerticalGroup(
            Patient_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(patientList, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        menuList.add(Patient_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 340, -1, -1));

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

        menuList.add(lineticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 299, 188, 4));

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

        menuList.add(linepatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 380, 188, 4));

        Prodile_Update.setBackground(new java.awt.Color(25, 29, 76));
        Prodile_Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Prodile_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prodile_UpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Prodile_UpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Prodile_UpdateMouseExited(evt);
            }
        });

        profile_update.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        profile_update.setForeground(new java.awt.Color(255, 255, 255));
        profile_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile_update.setText("Profile Update");

        javax.swing.GroupLayout Prodile_UpdateLayout = new javax.swing.GroupLayout(Prodile_Update);
        Prodile_Update.setLayout(Prodile_UpdateLayout);
        Prodile_UpdateLayout.setHorizontalGroup(
            Prodile_UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_update, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        Prodile_UpdateLayout.setVerticalGroup(
            Prodile_UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profile_update, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        menuList.add(Prodile_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 150, 190, 41));

        lineUpdate.setBackground(new java.awt.Color(5, 10, 46));

        javax.swing.GroupLayout lineUpdateLayout = new javax.swing.GroupLayout(lineUpdate);
        lineUpdate.setLayout(lineUpdateLayout);
        lineUpdateLayout.setHorizontalGroup(
            lineUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        lineUpdateLayout.setVerticalGroup(
            lineUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        menuList.add(lineUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 190, 188, 4));

        ticket_profile.setBackground(new java.awt.Color(0, 51, 51));
        ticket_profile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ticket_profileComponentShown(evt);
            }
        });
        ticket_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_patient_full_name.setBackground(new java.awt.Color(0, 51, 51));
        txt_patient_full_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_patient_full_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_patient_full_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_patient_full_name.setText("Full Name");
        txt_patient_full_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_patient_full_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_patient_full_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_patient_full_nameFocusLost(evt);
            }
        });
        txt_patient_full_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_patient_full_nameKeyReleased(evt);
            }
        });
        ticket_profile.add(txt_patient_full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 200, 36));

        txt_patient_father_name.setBackground(new java.awt.Color(0, 51, 51));
        txt_patient_father_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_patient_father_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_patient_father_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_patient_father_name.setText("Father Name");
        txt_patient_father_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_patient_father_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_patient_father_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_patient_father_nameFocusLost(evt);
            }
        });
        txt_patient_father_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_patient_father_nameKeyReleased(evt);
            }
        });
        ticket_profile.add(txt_patient_father_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, 36));

        patient_registration_date.setBackground(new java.awt.Color(0, 51, 51));
        patient_registration_date.setForeground(new java.awt.Color(255, 255, 255));
        patient_registration_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        patient_registration_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_registration_dateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patient_registration_dateMouseEntered(evt);
            }
        });
        ticket_profile.add(patient_registration_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 200, 36));

        txt_patient_address.setBackground(new java.awt.Color(0, 51, 51));
        txt_patient_address.setColumns(20);
        txt_patient_address.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_patient_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_patient_address.setRows(5);
        txt_patient_address.setText("                \n               \n                  Address");
        txt_patient_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_patient_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_patient_addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_patient_addressFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txt_patient_address);

        ticket_profile.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 250, 80));

        txt_patient_contact.setBackground(new java.awt.Color(0, 51, 51));
        txt_patient_contact.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_patient_contact.setForeground(new java.awt.Color(255, 255, 255));
        txt_patient_contact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_patient_contact.setText("Contact");
        txt_patient_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_patient_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_patient_contactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_patient_contactFocusLost(evt);
            }
        });
        ticket_profile.add(txt_patient_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 200, 36));

        combo_patient_doctor_name.setBackground(new java.awt.Color(0, 51, 51));
        combo_patient_doctor_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patient_doctor_name.setForeground(new java.awt.Color(255, 255, 255));
        combo_patient_doctor_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Doctor Select-", "Maj. Gen. Dr. H.R. Harun (Urologist)", "Dr. Md. Faruk Hossain Mounshi (Urologist)", "Dr. Tanvir Ahmed Chowdhury (Urologist)", "Prof. Dr. Salahuddin Kowser Biplob (Psychiatrists)", "Dr. Ahasan Uddin Ahmed (Psychiatrists)", "Dr. Liton Chandra Saha (Pediatrics) ", "Dr. Farhana Rahman (Pediatrics) ", "Dr. M. A. Afzal Bhuiyan (Pediatrics) ", "Prof. Dr. Zahid Hossain (Pediatrics) " }));
        combo_patient_doctor_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        ticket_profile.add(combo_patient_doctor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 250, 40));

        Email.setBackground(new java.awt.Color(0, 51, 51));
        Email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Email.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContent.setBackground(new java.awt.Color(0, 51, 51));
        txtContent.setColumns(20);
        txtContent.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtContent.setForeground(new java.awt.Color(255, 255, 255));
        txtContent.setRows(5);
        txtContent.setText("Hello! World\n");
        jScrollPane4.setViewportView(txtContent);

        Email.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 290, 170));

        txtFrom.setBackground(new java.awt.Color(0, 51, 51));
        txtFrom.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFrom.setForeground(new java.awt.Color(255, 255, 255));
        txtFrom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom.setText("jobayedhossain79@gmail.com");
        Email.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 290, 30));

        txtTo.setBackground(new java.awt.Color(0, 51, 51));
        txtTo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTo.setForeground(new java.awt.Color(255, 255, 255));
        txtTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                         --Email--", "jobayedhossain145@gmail.com", "jobayed364@gmail.com", "jobayed35-2948@diu.edu.bd", "sakib35-3080@diu.edu.bd", "jannatul35-1615@diu.edu.bd" }));
        Email.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 290, -1));

        Email_Header.setBackground(new java.awt.Color(5, 10, 46));
        Email_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("New Message");
        Email_Header.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/close_white1.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        Email_Header.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 7, -1, -1));

        Email.add(Email_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 369, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("To");
        Email.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, 30, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("From");
        Email.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 100, -1, 30));

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Subject");
        Email.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 160, -1, -1));

        txtSubject.setBackground(new java.awt.Color(0, 51, 51));
        txtSubject.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSubject.setForeground(new java.awt.Color(255, 255, 255));
        Email.add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 152, 290, 30));

        send.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        send.setForeground(new java.awt.Color(255, 255, 255));
        send.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        send.setText("send");
        send.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        send.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sendAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendMouseExited(evt);
            }
        });
        Email.add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 70, 30));

        ticket_profile.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 370, 440));

        patient_id.setBackground(new java.awt.Color(0, 204, 204));
        patient_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        patient_id.setForeground(new java.awt.Color(0, 204, 204));
        patient_id.setText("1000");
        ticket_profile.add(patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 70, 20));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Patient Id  :-");
        ticket_profile.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        ticket_profile.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 140, -1));

        jLabel11.setText("jLabel11");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        ticket_profile.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 70, 30));

        jLabel12.setText("reset");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        ticket_profile.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/header_back.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        ticket_profile.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 877, 50));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gender");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        ticket_profile.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 278, 70, 20));

        male.setBackground(new java.awt.Color(0, 51, 51));
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        ticket_profile.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        other.setBackground(new java.awt.Color(0, 51, 51));
        other.setForeground(new java.awt.Color(255, 255, 255));
        other.setText("Other");
        other.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherActionPerformed(evt);
            }
        });
        ticket_profile.add(other, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        female.setBackground(new java.awt.Color(0, 51, 51));
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        ticket_profile.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        combo_patient_illness.setBackground(new java.awt.Color(0, 51, 51));
        combo_patient_illness.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patient_illness.setForeground(new java.awt.Color(255, 255, 255));
        combo_patient_illness.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------Patient Illness---------", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Blood Pressure", "Cancer", "Cholesterol", "Chronic Pain", "Cold & Flu", "Depression", "Diabetes", "Dictionary", "Digestion", "Eyesight", "Health & Living", "Healthy Kids", "Hearing & Ear", "Heart", "HIV/AIDS", "Infectious Disease", "Lung Conditions", "Medications", "Menopause", "Men's Health", "Mental Health", "Migraine", "Neurology", "Oral Health", "Pregnancy", "Senior Health", "Sexual Health", "Skin", "Sleep", "Thyroid", "Travel Health", "Women's Health", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Cancer", "Cholesterol", "Chronic Pain", "Cold & Flu", "Depression", "Diabetes", "Digestion", "Disease Prevention", "Eyesight", "Heart", "Hepatitis", "High Blood Pressure", "HIV", "Infectious Disease", "Liver", "Lungs", "Menopause", "Men's Health", "Mental Health", "Migraine", "Osteoporosis", "Pediatrics / Healthy Kids", "Rheumatoid Arthritis", "Senior Health", "Skin", "Sleep", "Thyroid", "Urology", "Weight Loss & Management", "Women's Health" }));
        combo_patient_illness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_patient_illnessActionPerformed(evt);
            }
        });
        ticket_profile.add(combo_patient_illness, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 250, 40));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reg Date");
        ticket_profile.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 80, -1));

        combo_patiebt_age.setBackground(new java.awt.Color(0, 51, 51));
        combo_patiebt_age.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patiebt_age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Age----", "10 Day", "1 Month", "2 Month", "3 Month", "4 Month", "5 Month", "6 Month", "7 Month", "8 Month", "9 Month", "10 Month", "01 Year", "02 Year", "03Year", "04 Year", "05 Year", "06 Year", "07 Year", "08 Year", "09 Year", "10 Year", "12 Year", "13 Year", "14 Year", "15 Year", "16 Year", "17 Year", "18 Year", "19 Year", "20 Year", "21 Year", "22 Year", "23 Year", "24 Year", "25 Year", "26 Year", "27 Year", "28 Year", "29 Year", "30 Year", "31 Year", "32 Year", "33 Year", "34 Year", "35 Year", "36 Year", "37 Year", "38 Year", "39 Year", "40 Year", "41 Year", "42 Year", "43 Year", "44 Year", "45 Year", "46 Year", "47 Year", "48 Year", "49 Year", "50 Year", "51 Year", "52 Year", "53 Year", "54 Year", "55 Year", "56 Year", "57 Year", "58 Year", "59 Year", "60 Year", "61 Year", "62 Year", "63 Year", "64 Year", "65 Year", "66 Year", "67 Year", "68 Year", "69 Year", "70 Year", "71 Year", "72 Year", "73 Year", "74 Year", "75 Year", "76 Year", "77 Year", "78 Year", "79 Year", "80 Year" }));
        ticket_profile.add(combo_patiebt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 200, 40));

        menuList.add(ticket_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 130));

        menu.add(menuList, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -2, 190, 700));

        Frame_new.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 49, 240, 685));

        header.setBackground(new java.awt.Color(5, 10, 46));
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        header.setPreferredSize(new java.awt.Dimension(875, 43));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(closeMax_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maximise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        header.add(closeMax_body, new org.netbeans.lib.awtextra.AbsoluteConstraints(1036, 0, -1, 41));

        patient_list_panel.setBackground(new java.awt.Color(0, 51, 51));
        patient_list_panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                patient_list_panelComponentShown(evt);
            }
        });
        patient_list_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_ticket_list.setBackground(new java.awt.Color(0, 51, 51));
        table_ticket_list.setForeground(new java.awt.Color(102, 102, 102));
        table_ticket_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Full Name", "Father Name", "Age", "Gender", "Contact", "Doctor Name", "Address", "Registration Date", "Patient Illness"
            }
        ));
        jScrollPane6.setViewportView(table_ticket_list);

        patient_list_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 870, 620));

        header.add(patient_list_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 180, 40));

        Frame_new.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 1120, -1));

        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Emp_Profile.setBackground(new java.awt.Color(0, 51, 51));
        Emp_Profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_full_name.setBackground(new java.awt.Color(0, 51, 51));
        txt_full_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_full_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_full_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_full_name.setText("Full Name");
        txt_full_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_full_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_full_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_full_nameFocusLost(evt);
            }
        });
        Emp_Profile.add(txt_full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 36));

        txt_father_name.setBackground(new java.awt.Color(0, 51, 51));
        txt_father_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_father_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_father_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_father_name.setText("Father Name");
        txt_father_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_father_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_father_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_father_nameFocusLost(evt);
            }
        });
        Emp_Profile.add(txt_father_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, 36));

        txt_mother_name.setBackground(new java.awt.Color(0, 51, 51));
        txt_mother_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_mother_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_mother_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_mother_name.setText("Mother Name");
        txt_mother_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_mother_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_mother_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_mother_nameFocusLost(evt);
            }
        });
        txt_mother_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mother_nameActionPerformed(evt);
            }
        });
        Emp_Profile.add(txt_mother_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 37));

        birthday_date.setBackground(new java.awt.Color(0, 51, 51));
        birthday_date.setForeground(new java.awt.Color(255, 255, 255));
        birthday_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        birthday_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthday_dateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                birthday_dateMouseEntered(evt);
            }
        });
        Emp_Profile.add(birthday_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 200, 36));

        combo_status.setBackground(new java.awt.Color(0, 51, 51));
        combo_status.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_status.setForeground(new java.awt.Color(255, 255, 255));
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-status-", "married", "unmarried", "others" }));
        Emp_Profile.add(combo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 200, 36));

        txt_address.setBackground(new java.awt.Color(0, 51, 51));
        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_address.setRows(5);
        txt_address.setText("                \n               \n                  Address");
        txt_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_addressFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txt_address);

        Emp_Profile.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 220, -1));

        lbl_image.setBackground(new java.awt.Color(0, 51, 51));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/insert.png"))); // NOI18N
        lbl_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });
        Emp_Profile.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 220, 190));

        txt_contact.setBackground(new java.awt.Color(0, 51, 51));
        txt_contact.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_contact.setForeground(new java.awt.Color(255, 255, 255));
        txt_contact.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_contact.setText("Contact");
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_contactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_contactFocusLost(evt);
            }
        });
        Emp_Profile.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 200, 36));

        panel_save.setBackground(new java.awt.Color(0, 51, 51));
        panel_save.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                panel_saveComponentMoved(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panel_saveComponentShown(evt);
            }
        });

        label_save.setBackground(new java.awt.Color(0, 51, 51));
        label_save.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        label_save.setForeground(new java.awt.Color(255, 255, 255));
        label_save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/save_icon.png"))); // NOI18N
        label_save.setText("Save");
        label_save.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        label_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_saveMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_saveLayout = new javax.swing.GroupLayout(panel_save);
        panel_save.setLayout(panel_saveLayout);
        panel_saveLayout.setHorizontalGroup(
            panel_saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_save, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        panel_saveLayout.setVerticalGroup(
            panel_saveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_save, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Emp_Profile.add(panel_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 240, 40));

        next_save_upgrade.setBackground(new java.awt.Color(0, 51, 51));
        next_save_upgrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next_save_upgrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/next-button.png"))); // NOI18N
        next_save_upgrade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next_save_upgrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_save_upgradeMouseClicked(evt);
            }
        });
        Emp_Profile.add(next_save_upgrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        panel_update.setBackground(new java.awt.Color(0, 51, 51));
        panel_update.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panel_updateComponentShown(evt);
            }
        });

        label_update.setBackground(new java.awt.Color(0, 51, 51));
        label_update.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        label_update.setForeground(new java.awt.Color(255, 255, 255));
        label_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/upgrade_icon.png"))); // NOI18N
        label_update.setText("Upgrade");
        label_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        label_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_updateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_updateLayout = new javax.swing.GroupLayout(panel_update);
        panel_update.setLayout(panel_updateLayout);
        panel_updateLayout.setHorizontalGroup(
            panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_update, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panel_updateLayout.setVerticalGroup(
            panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_update, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Emp_Profile.add(panel_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 250, -1));

        txt_id.setBackground(new java.awt.Color(0, 51, 51));
        txt_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_id.setText("Employee Id");
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idFocusLost(evt);
            }
        });
        Emp_Profile.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 200, 36));

        txt_department.setBackground(new java.awt.Color(0, 51, 51));
        txt_department.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_department.setForeground(new java.awt.Color(255, 255, 255));
        txt_department.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_department.setText("Department");
        txt_department.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_department.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_departmentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_departmentFocusLost(evt);
            }
        });
        Emp_Profile.add(txt_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 200, 36));

        combo_gender.setBackground(new java.awt.Color(0, 51, 51));
        combo_gender.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_gender.setForeground(new java.awt.Color(255, 255, 255));
        combo_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-gender-", "male", "female", "others" }));
        Emp_Profile.add(combo_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 200, 36));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/text_employee.gif"))); // NOI18N
        Emp_Profile.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 80));

        body.add(Emp_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        Emp_Profile_Update.setBackground(new java.awt.Color(0, 51, 51));
        Emp_Profile_Update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_employee_full_name_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_full_name_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_full_name_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_full_name_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_full_name_update.setText("Full Name");
        txt_employee_full_name_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_full_name_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_full_name_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_full_name_updateFocusLost(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_full_name_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 200, 36));

        txt_employee_father_name_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_father_name_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_father_name_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_father_name_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_father_name_update.setText("Father Name");
        txt_employee_father_name_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_father_name_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_father_name_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_father_name_updateFocusLost(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_father_name_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, 36));

        txt_employee_mother_name_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_mother_name_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_mother_name_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_mother_name_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_mother_name_update.setText("Mother Name");
        txt_employee_mother_name_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_mother_name_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_mother_name_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_mother_name_updateFocusLost(evt);
            }
        });
        txt_employee_mother_name_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_employee_mother_name_updateActionPerformed(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_mother_name_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 37));

        birthday_employee_date_update.setBackground(new java.awt.Color(0, 51, 51));
        birthday_employee_date_update.setForeground(new java.awt.Color(255, 255, 255));
        birthday_employee_date_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        birthday_employee_date_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthday_employee_date_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                birthday_employee_date_updateMouseEntered(evt);
            }
        });
        Emp_Profile_Update.add(birthday_employee_date_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 200, 36));

        txt_employee_address_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_address_update.setColumns(20);
        txt_employee_address_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_address_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_address_update.setRows(5);
        txt_employee_address_update.setText("                \n               \n                  Address");
        txt_employee_address_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_address_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_address_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_address_updateFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(txt_employee_address_update);

        Emp_Profile_Update.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 220, -1));

        lbl_employee_image_update.setBackground(new java.awt.Color(0, 51, 51));
        lbl_employee_image_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_employee_image_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/insert.png"))); // NOI18N
        lbl_employee_image_update.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_employee_image_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_employee_image_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_employee_image_updateMouseClicked(evt);
            }
        });
        Emp_Profile_Update.add(lbl_employee_image_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 220, 190));

        txt_employee_contact_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_contact_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_contact_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_contact_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_contact_update.setText("Contact");
        txt_employee_contact_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_contact_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_contact_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_contact_updateFocusLost(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_contact_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 200, 36));

        next_save_upgrade2.setBackground(new java.awt.Color(0, 51, 51));
        next_save_upgrade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next_save_upgrade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/next-button.png"))); // NOI18N
        next_save_upgrade2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next_save_upgrade2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next_save_upgrade2MouseClicked(evt);
            }
        });
        Emp_Profile_Update.add(next_save_upgrade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        panel_update2.setBackground(new java.awt.Color(0, 51, 51));
        panel_update2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panel_update2ComponentShown(evt);
            }
        });

        label_employee_update.setBackground(new java.awt.Color(0, 51, 51));
        label_employee_update.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        label_employee_update.setForeground(new java.awt.Color(255, 255, 255));
        label_employee_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_employee_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/upgrade_icon.png"))); // NOI18N
        label_employee_update.setText("Upgrade");
        label_employee_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        label_employee_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_employee_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_employee_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_employee_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_employee_updateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_update2Layout = new javax.swing.GroupLayout(panel_update2);
        panel_update2.setLayout(panel_update2Layout);
        panel_update2Layout.setHorizontalGroup(
            panel_update2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee_update, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panel_update2Layout.setVerticalGroup(
            panel_update2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_employee_update, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Emp_Profile_Update.add(panel_update2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 250, -1));

        txt_employee_update_id.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_update_id.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_employee_update_id.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_update_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_employee_update_id.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(5, 10, 46)));
        txt_employee_update_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_update_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_update_idFocusLost(evt);
            }
        });
        txt_employee_update_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_employee_update_idKeyReleased(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_update_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 140, 36));

        txt_employee_department_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_department_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_department_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_department_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_department_update.setText("Department");
        txt_employee_department_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_employee_department_update.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_employee_department_updateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_employee_department_updateFocusLost(evt);
            }
        });
        Emp_Profile_Update.add(txt_employee_department_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 200, 36));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/text_employee.gif"))); // NOI18N
        Emp_Profile_Update.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 80));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(5, 10, 46)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Id");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 38));

        Emp_Profile_Update.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, 37));

        ErrorId.setBackground(new java.awt.Color(5, 10, 46));
        ErrorId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ErrorId.setForeground(new java.awt.Color(204, 0, 0));
        ErrorId.setText("jLabel6");
        Emp_Profile_Update.add(ErrorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 210, 30));

        BROWSE.setForeground(new java.awt.Color(255, 255, 255));
        BROWSE.setText("Browse");
        BROWSE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(204, 204, 255), new java.awt.Color(0, 102, 102), new java.awt.Color(51, 0, 51)));
        BROWSE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BROWSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BROWSEMouseClicked(evt);
            }
        });
        Emp_Profile_Update.add(BROWSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 50, 20));

        txt_employee_gender_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_gender_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_gender_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_gender_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_gender_update.setText("Gender");
        txt_employee_gender_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        Emp_Profile_Update.add(txt_employee_gender_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 200, 36));

        txt_employee_status_update.setBackground(new java.awt.Color(0, 51, 51));
        txt_employee_status_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_employee_status_update.setForeground(new java.awt.Color(255, 255, 255));
        txt_employee_status_update.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_employee_status_update.setText("Relational Status");
        txt_employee_status_update.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        Emp_Profile_Update.add(txt_employee_status_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 200, 36));

        body.add(Emp_Profile_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 910, 590));

        Frame_new.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 50, 990, 684));

        getContentPane().add(Frame_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseClicked
      
        System.exit(0);
    }//GEN-LAST:event_close_panelMouseClicked

    private void close_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseEntered
      ChangeColor(close_panel,new Color(210, 43, 43));
    }//GEN-LAST:event_close_panelMouseEntered

    private void close_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_panelMouseExited
       ChangeColor(close_panel,new Color(5,10,46));
    }//GEN-LAST:event_close_panelMouseExited

    
    // start maximise-----------
    private void maximiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximiseMouseClicked
       
        if(this.getExtendedState()!= employee_panel1.MAXIMIZED_BOTH)
        {
            
            this.setExtendedState(employee_panel1.MAXIMIZED_BOTH);
        }
        else
        {
            this.setExtendedState(employee_panel1.NORMAL);
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
            Patient_list.setVisible(false);
            patientList.setVisible(false);
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
      
        //clickMenu(Profile,Ticket,Patient_list,Prodile_Update,2);
        new Patient_Ticket().setVisible(true);
        Emp_Profile.setVisible(false);
       Emp_Profile_Update.setVisible(false);
       ticket_profile.setVisible(true);
        
    }//GEN-LAST:event_TicketMouseClicked

    private void Patient_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_listMouseEntered
        //ChangeColor(Patient,new Color(25,25,112));
        ChangeColor(linepatient,new Color(253,155,253));
    }//GEN-LAST:event_Patient_listMouseEntered

    private void Patient_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_listMouseExited
        //ChangeColor(Patient,new Color(25,29,76));
        ChangeColor(linepatient,new Color(5,10,46));
    }//GEN-LAST:event_Patient_listMouseExited

    private void Patient_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_listMouseClicked
      clickMenu(Profile,Ticket,Patient_list,Prodile_Update,3);
      //dispose();
      new PAtient_Ticket_List().setVisible(false);
      new PAtient_Ticket_List().setVisible(true);
//      patient_list_panel.setVisible(true);
//      try {
//            String Driver = "com.mysql.jdbc.Driver";
//            String URL = "jdbc:mysql://localhost:3306/medical";
//            Class.forName(Driver);
//            Connection Conn = DriverManager.getConnection(URL, "root", "");
//            //Statement S = Conn.createStatement();
//          
//            String query = "select *from employee_ticket";
//            PreparedStatement pst = Conn.prepareStatement(query);
//            ResultSet rs = pst.executeQuery();
//
//            DefaultTableModel model = (DefaultTableModel) table_ticket_list.getModel();
//            //model.setRowCount(0);
//            while(rs.next())
//            {
//                model.addRow(new String[]
//                    {
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10)
//
//                    });
//                }
//            } catch (Exception e) {
//            }
    }//GEN-LAST:event_Patient_listMouseClicked

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
                Patient_list.setVisible(true);
                patientList.setVisible(true);
                
            } catch (Exception e) {
            }
        z=1;
        
    }//GEN-LAST:event_TicketComponentShown

    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        clickMenu(Profile,Ticket,Patient_list,Prodile_Update,1);
        //Profile.setBackground(Color.yellow);
        Emp_Profile.setVisible(true);
        Emp_Profile_Update.setVisible(false);
        ticket_profile.setVisible(false);
    }//GEN-LAST:event_ProfileMouseClicked

    private void txt_mother_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mother_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mother_nameActionPerformed

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

    private void label_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_saveMouseEntered

        setColorlogin(panel_save);
        label_save.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_label_saveMouseEntered

    private void label_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_saveMouseExited

        resetColorlogin(panel_save);
        label_save.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_saveMouseExited

    private void next_save_upgradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_save_upgradeMouseClicked
       
        
        if(save_upgrade==0)
        {
            try {
                
                Thread.sleep(50);
                panel_save.setVisible(true);
                label_save.setVisible(true);
                
            } catch (Exception e) {
            }
        }
        else
        {
            panel_save.setVisible(false);
            label_save.setVisible(false);
            panel_update.setVisible(false);
            label_update.setVisible(false);
           
        }
    }//GEN-LAST:event_next_save_upgradeMouseClicked

    private void panel_saveComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_saveComponentMoved
       
        
    }//GEN-LAST:event_panel_saveComponentMoved

    private void label_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_updateMouseClicked

    }//GEN-LAST:event_label_updateMouseClicked

    private void label_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_updateMouseEntered
        setColorlogin(panel_update);
        label_update.setForeground(new Color(0,204,204));
    }//GEN-LAST:event_label_updateMouseEntered

    private void label_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_updateMouseExited

        resetColorlogin(panel_update);
        label_update.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_label_updateMouseExited

    private void panel_updateComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_updateComponentShown
       
    }//GEN-LAST:event_panel_updateComponentShown

    private void panel_saveComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_saveComponentShown
       
        try {
                
                Thread.sleep(50);
                panel_update.setVisible(true);
                label_update.setVisible(true);
                
            } catch (Exception e) {
            }
        
    }//GEN-LAST:event_panel_saveComponentShown

    private void txt_full_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_full_nameFocusGained
        if (txt_full_name.getText().equals("Full Name")) {
            txt_full_name.setText("");
            txt_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_full_nameFocusGained

    private void txt_full_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_full_nameFocusLost
        if (txt_full_name.getText().equals("")) {
            txt_full_name.setText("Full Name");
            txt_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_full_nameFocusLost

    private void txt_father_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_father_nameFocusGained
       if (txt_father_name.getText().equals("Father Name")) {
            txt_father_name.setText("");
            txt_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_father_nameFocusGained

    private void txt_father_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_father_nameFocusLost
        if (txt_father_name.getText().equals("")) {
            txt_father_name.setText("Father Name");
            txt_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_father_nameFocusLost

    private void txt_mother_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mother_nameFocusGained
        if (txt_mother_name.getText().equals("Mother Name")) {
            txt_mother_name.setText("");
            txt_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_mother_nameFocusGained

    private void txt_mother_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_mother_nameFocusLost
       if (txt_mother_name.getText().equals("")) {
            txt_mother_name.setText("Mother Name");
            txt_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_mother_nameFocusLost

    private void txt_contactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_contactFocusGained
        if (txt_contact.getText().equals("Contact")) {
            txt_contact.setText("");
            txt_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_contactFocusGained

    private void txt_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_contactFocusLost
        if (txt_contact.getText().equals("")) {
            txt_contact.setText("Contact");
            txt_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_contactFocusLost

    private void txt_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusGained
        if (txt_address.getText().equals("                \n" +
"               \n" +
"                  Address")) {
            txt_address.setText("");
            txt_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_addressFocusGained

    private void txt_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusLost
        if (txt_address.getText().equals("")) {
            txt_address.setText("                \n" +
"               \n" +
"                  Address");
            txt_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_addressFocusLost

    private void txt_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusGained
       if (txt_id.getText().equals("Employee Id")) {
            txt_id.setText("");
            txt_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_idFocusGained

    private void txt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idFocusLost
        if (txt_id.getText().equals("")) {
            txt_id.setText("Employee Id");
            txt_id.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_idFocusLost

    private void txt_departmentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departmentFocusGained
       if (txt_department.getText().equals("Department")) {
            txt_department.setText("");
            txt_department.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_departmentFocusGained

    private void txt_departmentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_departmentFocusLost
       if (txt_department.getText().equals("")) {
            txt_department.setText("Department");
            txt_department.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_departmentFocusLost

    private void label_saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_saveMouseClicked
        
        try {
            Date date = new Date(birthday_date.getDate().getTime());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement) con.createStatement();
            if(checkInputs() && ImgPath!= null)
                    {
                        try 
                        {
                
                            //Class.forName("com.mysql.jdbc.Driver");
                            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "***###botki143JN");
                            //Statement st = (Statement) con.createStatement();
                            String sta = (String) combo_status.getSelectedItem();
                            String gen = (String) combo_gender.getSelectedItem();

                            PreparedStatement ps = con.prepareStatement("INSERT INTO employee(Id,FullName,FatherName,MotherName,Birthday,Address,Department,Contact,Status,Gender,Image)" + "values(?,?,?,?,?,?,?,?,?,?,?)");                           
                            ps.setString(1, txt_id.getText());
                            ps.setString(2, txt_full_name.getText());
                            ps.setString(3, txt_father_name.getText());
                            ps.setString(4, txt_mother_name.getText());
                            ps.setDate(5, (java.sql.Date) date);
                            ps.setString(6, txt_address.getText());
                            ps.setString(7, txt_department.getText());
                            ps.setString(8, txt_contact.getText());
                            ps.setString(9, sta);
                            ps.setString(10, gen);                            
                            InputStream img = new FileInputStream(new File(ImgPath));
                            ps.setBlob(11, img);

                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Your Data Inserted!");
                           // dispose();
             
                        }catch (Exception e) 
                            {
                                JOptionPane.showMessageDialog(null,e);
                            }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Sorry! One or More Field are Empty");
                    }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_label_saveMouseClicked

    private void birthday_dateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthday_dateMouseEntered

    }//GEN-LAST:event_birthday_dateMouseEntered

    private void birthday_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthday_dateMouseClicked

    }//GEN-LAST:event_birthday_dateMouseClicked

    private void txt_patient_full_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_full_nameFocusGained
        if (txt_patient_full_name.getText().equals("Full Name")) {
            txt_patient_full_name.setText("");
            txt_patient_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_full_nameFocusGained

    private void txt_patient_full_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_full_nameFocusLost
        if (txt_patient_full_name.getText().equals("")) {
            txt_patient_full_name.setText("Full Name");
            txt_patient_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_full_nameFocusLost

    private void txt_patient_father_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_father_nameFocusGained
       if (txt_patient_father_name.getText().equals("Father Name")) {
            txt_patient_father_name.setText("");
            txt_patient_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_father_nameFocusGained

    private void txt_patient_father_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_father_nameFocusLost
       if (txt_patient_father_name.getText().equals("")) {
            txt_patient_father_name.setText("Father Name");
            txt_patient_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_father_nameFocusLost

    private void patient_registration_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_registration_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_registration_dateMouseClicked

    private void patient_registration_dateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_registration_dateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_registration_dateMouseEntered

    private void txt_patient_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_addressFocusGained
         if (txt_patient_address.getText().equals("                \n" +
"               \n" +
"                  Address")) {
            txt_patient_address.setText("");
            txt_patient_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_addressFocusGained

    private void txt_patient_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_addressFocusLost
        if (txt_patient_address.getText().equals("")) {
            txt_patient_address.setText("                \n" +
"               \n" +
"                  Address");
            txt_patient_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_addressFocusLost

    private void txt_patient_contactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_contactFocusGained
       if (txt_patient_contact.getText().equals("Contact")) {
            txt_patient_contact.setText("");
            txt_patient_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_contactFocusGained

    private void txt_patient_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_contactFocusLost
        if (txt_patient_contact.getText().equals("")) {
            txt_patient_contact.setText("Contact");
            txt_patient_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_contactFocusLost

    private void txt_employee_full_name_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_full_name_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_full_name_updateFocusGained

    private void txt_employee_full_name_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_full_name_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_full_name_updateFocusLost

    private void txt_employee_father_name_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_father_name_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_father_name_updateFocusGained

    private void txt_employee_father_name_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_father_name_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_father_name_updateFocusLost

    private void txt_employee_mother_name_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_mother_name_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_mother_name_updateFocusGained

    private void txt_employee_mother_name_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_mother_name_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_mother_name_updateFocusLost

    private void txt_employee_mother_name_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_employee_mother_name_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_mother_name_updateActionPerformed

    private void birthday_employee_date_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthday_employee_date_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_birthday_employee_date_updateMouseClicked

    private void birthday_employee_date_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthday_employee_date_updateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_birthday_employee_date_updateMouseEntered

    private void txt_employee_address_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_address_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_address_updateFocusGained

    private void txt_employee_address_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_address_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_address_updateFocusLost

    private void lbl_employee_image_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_employee_image_updateMouseClicked
       
        
    }//GEN-LAST:event_lbl_employee_image_updateMouseClicked

    private void txt_employee_contact_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_contact_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_contact_updateFocusGained

    private void txt_employee_contact_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_contact_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_contact_updateFocusLost

    private void next_save_upgrade2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next_save_upgrade2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_next_save_upgrade2MouseClicked

    private void label_employee_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employee_updateMouseClicked

       String search = txt_employee_update_id.getText();
        
        
        
        
        try {
            
            if(ImgPath==null)
            {
                Updated();
                JOptionPane.showMessageDialog(null, "Updated Your Data");
            }
            else
            {
                Updated();
                
                String query = null;
                PreparedStatement ps = null;
                Connection con = getConnection();
                InputStream img = new FileInputStream(new File(ImgPath));
                //query="update don set Name=?,Occupation=?,Contact=?,Address=?,LastDonation=? Image=? where Id='"+search+"'";
                query = "update employee set Image=? where Id='" + search + "'";

                ps = con.prepareStatement(query);
                ps.setBlob(1, img);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated Your Data");
            
            }
                
            
            
            
            

           

              
            
            
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        
    }//GEN-LAST:event_label_employee_updateMouseClicked

    private void label_employee_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employee_updateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_label_employee_updateMouseEntered

    private void label_employee_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_employee_updateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_label_employee_updateMouseExited

    private void panel_update2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_update2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_update2ComponentShown

    private void txt_employee_update_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_update_idFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_update_idFocusGained

    private void txt_employee_update_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_update_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_update_idFocusLost

    private void txt_employee_department_updateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_department_updateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_department_updateFocusGained

    private void txt_employee_department_updateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_employee_department_updateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_employee_department_updateFocusLost

    private void txt_employee_update_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employee_update_idKeyReleased
        
        
        String search = txt_employee_update_id.getText();
        
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
                txt_employee_full_name_update.setText(s2);
                
                String s3 = rs.getString("FatherName"); //F Name
                txt_employee_father_name_update.setText(s3);
                
                String s4 = rs.getString("MotherName"); //Mother Name
                txt_employee_mother_name_update.setText(s4);
                
                Date s5 = rs.getDate("Birthday"); // Birthday
                birthday_employee_date_update.setDate(s5);
                 
                String s6 = rs.getString("Status"); //status
                txt_employee_status_update.setText(s6);
                 
                String s7 = rs.getString("Contact"); //contact
                txt_employee_contact_update.setText(s7);
                
                lbl_employee_image_update.setIcon(ResizeImage(null, rs.getBytes(8)));
                                
                String s9 = rs.getString("Department"); // Department
                txt_employee_department_update.setText(s9);
                
                String s10 = rs.getString("Address");// address
                txt_employee_address_update.setText(s10);
                
                String s12 = rs.getString("Gender"); //gendwer
                txt_employee_gender_update.setText(s12);
                //String s11 = rs.getString(10);
               
                
                
                
                
               
               
                
                
                
                ErrorId.setText("*Id match");
                ErrorId.setForeground(Color.GREEN);
               
                txt_employee_full_name_update.setEditable(true);
                txt_employee_father_name_update.setEditable(true);
                txt_employee_mother_name_update.setEditable(true);
                birthday_employee_date_update.setEnabled(false);
                txt_employee_status_update.setEditable(true);
                txt_employee_contact_update.setEditable(true);
                txt_employee_gender_update.setEditable(false);
                lbl_employee_image_update.setEnabled(true);
                txt_employee_department_update.setEditable(true);
                txt_employee_address_update.setEditable(true);
                BROWSE.setVisible(true);
               
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
               
                ErrorId.setVisible(true);
                ErrorId.setText("*Sorry! Id doesn't match");
            }
          
           con.close();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_txt_employee_update_idKeyReleased

    private void BROWSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BROWSEMouseClicked
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
        }
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_employee_image_update.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            JOptionPane.showMessageDialog(null, "Sorry! No File Selected");
        }
    }//GEN-LAST:event_BROWSEMouseClicked

    private void Prodile_UpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prodile_UpdateMouseEntered
       ChangeColor(lineUpdate,new Color(253,155,253));
    }//GEN-LAST:event_Prodile_UpdateMouseEntered

    private void Prodile_UpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prodile_UpdateMouseExited
        ChangeColor(lineUpdate,new Color(5,10,46));
    }//GEN-LAST:event_Prodile_UpdateMouseExited

    private void Prodile_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prodile_UpdateMouseClicked
        clickMenu(Profile,Ticket,Patient_list,Prodile_Update,4);
        Emp_Profile.setVisible(false);
        Emp_Profile_Update.setVisible(true);
        ticket_profile.setVisible(false);
    }//GEN-LAST:event_Prodile_UpdateMouseClicked

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked

        send.setBackground(new Color (255,255,255));
        
        String ToEmail = (String) txtTo.getSelectedItem();
        String FromEmail = txtFrom.getText();
        String FromEmailPassword = "jobayed80";
        String Subjects = txtSubject.getText();
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
         properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
        });
        
        try {
            
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
            msg.setSubject(Subjects);
            
            Date date = new Date(patient_registration_date.getDate().getTime());
            //String gender = (String) combo_patient_gender.getSelectedItem();
            String doctorNAME = (String) combo_patient_doctor_name.getSelectedItem();
            String Age = (String) combo_patiebt_age.getSelectedItem();
            String illness = (String) combo_patient_illness.getSelectedItem();
            
            msg.setText("'Daffodil Medical College & Hospital'\n\nAs-salamu alaykum '"+ doctorNAME +"'. Sir, welcome to our Daffodil Medical. '" +txt_patient_full_name.getText()+"' is one of your new patients.A huge appeal to you to solve all his/her problems.\n\n" 
            +"Patiend Id        :-  "+patient_id.getText() +"\nFull Name        :-  "+txt_patient_full_name.getText()  +"\nFather Name   :-  "+txt_patient_father_name.getText()
            
            +"\nRegistration Date :-  "+date  +"\nPatient Illness    :-  "+illness +"\nGender            :-  "+gender +"\nContact           :-  "+txt_patient_contact.getText() +"\nDoctor Name  :-  "+doctorNAME  +"\nAddress           :-  "+txt_patient_address.getText()+"Age              :-  "+Age);

            Transport.send(msg);
            //JOptionPane.showMessageDialog(null, "success");
            new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "send message successfully!!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //inserted patient
       Patient_Infor_Insert();
    }//GEN-LAST:event_sendMouseClicked

    private void txt_patient_full_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_patient_full_nameKeyReleased
        
        //txtSubject.setText(txt_patient_full_name.getText());
    }//GEN-LAST:event_txt_patient_full_nameKeyReleased

    private void txt_patient_father_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_patient_father_nameKeyReleased
      
    }//GEN-LAST:event_txt_patient_father_nameKeyReleased

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Email.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void ticket_profileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ticket_profileComponentShown
        
        
    }//GEN-LAST:event_ticket_profileComponentShown

    private void sendAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sendAncestorAdded
    
    }//GEN-LAST:event_sendAncestorAdded

    private void sendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseEntered
       setColorSend(send);
    }//GEN-LAST:event_sendMouseEntered

    private void sendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseExited
       resetColorSend(send);
    }//GEN-LAST:event_sendMouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       Patient_Infor_Insert();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        dispose();
        new employee_panel1().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

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

    private void combo_patient_illnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_patient_illnessActionPerformed
        String illness = (String) combo_patient_illness.getSelectedItem();
        txtSubject.setText(illness);
    }//GEN-LAST:event_combo_patient_illnessActionPerformed

    private void patient_list_panelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_patient_list_panelComponentShown
        
       
    }//GEN-LAST:event_patient_list_panelComponentShown
   

    
    
    
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
            java.util.logging.Logger.getLogger(employee_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee_panel1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee_panel1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BROWSE;
    private javax.swing.JPanel Email;
    private javax.swing.JPanel Email_Header;
    private javax.swing.JPanel Emp_Profile;
    private javax.swing.JPanel Emp_Profile_Update;
    private javax.swing.JLabel ErrorId;
    private javax.swing.JPanel Frame_new;
    private javax.swing.JPanel Patient_list;
    private javax.swing.JPanel Prodile_Update;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Ticket;
    private com.toedter.calendar.JDateChooser birthday_date;
    private com.toedter.calendar.JDateChooser birthday_employee_date_update;
    private javax.swing.JPanel body;
    private javax.swing.JPanel closeMax_body;
    private javax.swing.JPanel close_panel;
    private javax.swing.JLabel close_white;
    private javax.swing.JComboBox<String> combo_gender;
    private javax.swing.JComboBox<String> combo_patiebt_age;
    private javax.swing.JComboBox<String> combo_patient_doctor_name;
    private javax.swing.JComboBox<String> combo_patient_illness;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_employee_update;
    private javax.swing.JLabel label_save;
    private javax.swing.JLabel label_update;
    private javax.swing.JLabel lbl_employee_image_update;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JPanel lineUpdate;
    private javax.swing.JPanel linepatient;
    private javax.swing.JPanel lineprofile;
    private javax.swing.JPanel lineticket;
    private javax.swing.JRadioButton male;
    private javax.swing.JPanel maximise;
    private javax.swing.JLabel maximise_label;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuIcon;
    private javax.swing.JPanel menuList;
    private javax.swing.JPanel menu_first;
    private javax.swing.JPanel menu_first_border;
    private javax.swing.JLabel menu_first_label;
    private javax.swing.JLabel next_save_upgrade;
    private javax.swing.JLabel next_save_upgrade2;
    private javax.swing.JRadioButton other;
    private javax.swing.JPanel panel_save;
    private javax.swing.JPanel panel_update;
    private javax.swing.JPanel panel_update2;
    private javax.swing.JLabel patientList;
    private javax.swing.JLabel patient_id;
    private javax.swing.JPanel patient_list_panel;
    private com.toedter.calendar.JDateChooser patient_registration_date;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profile_update;
    private javax.swing.JLabel send;
    private javax.swing.JLabel settinf_label;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel setting_border;
    private javax.swing.JTable table_ticket_list;
    private javax.swing.JLabel ticket;
    private javax.swing.JPanel ticket_profile;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JComboBox<String> txtTo;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_department;
    private javax.swing.JTextArea txt_employee_address_update;
    private javax.swing.JTextField txt_employee_contact_update;
    private javax.swing.JTextField txt_employee_department_update;
    private javax.swing.JTextField txt_employee_father_name_update;
    private javax.swing.JTextField txt_employee_full_name_update;
    private javax.swing.JTextField txt_employee_gender_update;
    private javax.swing.JTextField txt_employee_mother_name_update;
    private javax.swing.JTextField txt_employee_status_update;
    private javax.swing.JTextField txt_employee_update_id;
    private javax.swing.JTextField txt_father_name;
    private javax.swing.JTextField txt_full_name;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mother_name;
    private javax.swing.JTextArea txt_patient_address;
    private javax.swing.JTextField txt_patient_contact;
    private javax.swing.JTextField txt_patient_father_name;
    private javax.swing.JTextField txt_patient_full_name;
    // End of variables declaration//GEN-END:variables
}
