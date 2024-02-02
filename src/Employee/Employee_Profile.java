/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author h
 */
public class Employee_Profile extends javax.swing.JFrame {

    /**
     * Creates new form Patient_Ticket
     */
    int Emp_ID;
    private String gender;
    private String status;
    public Employee_Profile() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        txtExtra.requestFocus();
        getEmp_Id();
    }
    
    //patient increase id
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ticket_profile = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ticket_profile.setBackground(new java.awt.Color(46, 64, 83));
        ticket_profile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ticket_profileComponentShown(evt);
            }
        });
        ticket_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(93, 109, 126));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employye Profile");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 250, 40));

        ticket_profile.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        jPanel4.setBackground(new java.awt.Color(46, 64, 83));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 190, 60));

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
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 190, 60));

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
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 190, 60));

        ticket_profile.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 230, 450));

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
                    .addGap(0, 0, Short.MAX_VALUE)
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
                    .addGap(0, 0, Short.MAX_VALUE)))
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

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 380, 110));

        ticket_profile.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 670, 450));

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
            .addGap(0, 948, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
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
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
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

        ticket_profile.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 50, 950, 150));

        jPanel1.add(ticket_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 986, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 684));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emp_full_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_full_nameKeyReleased

        //txtSubject.setText(txt_patient_full_name.getText());
    }//GEN-LAST:event_txt_emp_full_nameKeyReleased

    private void txt_emp_full_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameFocusLost
        if (txt_emp_full_name.getText().equals("")) {
            txt_emp_full_name.setText("Full Name");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameFocusLost

    private void txt_emp_full_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_full_nameFocusGained
        if (txt_emp_full_name.getText().equals("Full Name")) {
            txt_emp_full_name.setText("");
            txt_emp_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_full_nameFocusGained

    private void txt_emp_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressFocusLost
        if (txt_emp_address.getText().equals("")) {
            txt_emp_address.setText("Address");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressFocusLost

    private void txt_emp_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_addressFocusGained
        if (txt_emp_address.getText().equals("Address")) {
            txt_emp_address.setText("");
            txt_emp_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_addressFocusGained

    private void txt_emp_mother_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameFocusLost
        if (txt_emp_mother_name.getText().equals("")) {
            txt_emp_mother_name.setText("Mother Name");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameFocusLost

    private void txt_emp_mother_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_mother_nameFocusGained
        if (txt_emp_mother_name.getText().equals("Mother Name")) {
            txt_emp_mother_name.setText("");
            txt_emp_mother_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_mother_nameFocusGained

    private void txt_emp_father_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emp_father_nameKeyReleased

    }//GEN-LAST:event_txt_emp_father_nameKeyReleased

    private void txt_emp_father_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameFocusLost
        if (txt_emp_father_name.getText().equals("")) {
            txt_emp_father_name.setText("Father Name");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameFocusLost

    private void txt_emp_father_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_father_nameFocusGained
        if (txt_emp_father_name.getText().equals("Father Name")) {
            txt_emp_father_name.setText("");
            txt_emp_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_father_nameFocusGained

    private void othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersActionPerformed
        status="others";
        if(others.isSelected())
        {
            married.setSelected(false);
            single.setSelected(false);
        }
    }//GEN-LAST:event_othersActionPerformed

    private void singleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleActionPerformed

        status="single";
        if(single.isSelected())
        {
            married.setSelected(false);
            others.setSelected(false);
        }
    }//GEN-LAST:event_singleActionPerformed

    private void otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherActionPerformed
        gender="other";
        if(other.isSelected())
        {
            female.setSelected(false);
            male.setSelected(false);
        }
    }//GEN-LAST:event_otherActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        gender="female";
        if(female.isSelected())
        {
            male.setSelected(false);
            other.setSelected(false);
        }
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        gender="male";
        if(male.isSelected())
        {
            female.setSelected(false);
            other.setSelected(false);
        }
    }//GEN-LAST:event_maleActionPerformed

    private void marriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedActionPerformed
        status="married";
        if(married.isSelected())
        {
            single.setSelected(false);
            others.setSelected(false);
        }
    }//GEN-LAST:event_marriedActionPerformed

    private void txt_emp_contact1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact1FocusLost
        if (txt_emp_contact1.getText().equals("")) {
            txt_emp_contact1.setText("Contact 1");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact1FocusLost

    private void txt_emp_contact1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact1FocusGained
        if (txt_emp_contact1.getText().equals("Contact 1")) {
            txt_emp_contact1.setText("");
            txt_emp_contact1.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact1FocusGained

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

    private void combo_emp_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_emp_ageActionPerformed

        String age = (String) combo_emp_age.getSelectedItem();
        if("                   Age".equals(age))
        {
            //JOptionPane.showMessageDialog(null,"Sorry! This is not selecte!");
            JOptionPane.showMessageDialog(null, "Sorry! This is not select!",
                "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_combo_emp_ageActionPerformed

    private void emp_bdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdMouseEntered

    private void emp_bdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_bdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_bdMouseClicked

    private void txt_emp_depFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depFocusLost
        if (txt_emp_dep.getText().equals("")) {
            txt_emp_dep.setText("Department");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depFocusLost

    private void txt_emp_depFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_depFocusGained
        if (txt_emp_dep.getText().equals("Department")) {
            txt_emp_dep.setText("");
            txt_emp_dep.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_depFocusGained

    private void txt_emp_contact2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact2FocusLost
        if (txt_emp_contact2.getText().equals("")) {
            txt_emp_contact2.setText("Contact 2");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact2FocusLost

    private void txt_emp_contact2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emp_contact2FocusGained
        if (txt_emp_contact2.getText().equals("Contact 2")) {
            txt_emp_contact2.setText("");
            txt_emp_contact2.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_emp_contact2FocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Employee_Inform_Insert();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new Employee_Profile().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ticket_profileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ticket_profileComponentShown

    }//GEN-LAST:event_ticket_profileComponentShown

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
            java.util.logging.Logger.getLogger(Employee_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_emp_age;
    private com.toedter.calendar.JDateChooser emp_bd;
    private javax.swing.JLabel emp_id;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton married;
    private javax.swing.JRadioButton other;
    private javax.swing.JRadioButton others;
    private javax.swing.JRadioButton single;
    private javax.swing.JPanel ticket_profile;
    private javax.swing.JTextField txtExtra;
    private javax.swing.JTextField txt_emp_address;
    private javax.swing.JTextField txt_emp_contact1;
    private javax.swing.JTextField txt_emp_contact2;
    private javax.swing.JTextField txt_emp_dep;
    private javax.swing.JTextField txt_emp_father_name;
    private javax.swing.JTextField txt_emp_full_name;
    private javax.swing.JTextField txt_emp_mother_name;
    // End of variables declaration//GEN-END:variables
}
