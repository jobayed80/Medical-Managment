/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

//import com.sbix.jnotify.NPosition;
//import com.sbix.jnotify.NoticeType;
//import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author h
 */
public class Patient_Ticket extends javax.swing.JFrame {

    /**
     * Creates new form Patient_Ticket
     */
    int patient_ID;
    private String gender;
    public Patient_Ticket() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        txtExtra.requestFocus();
        getPatient_Id();
    }
    
    //patient increase id
    public void getPatient_Id()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement st = (Statement)con.createStatement();
            String query = "select max(Patient_Id) from patient_receipt";
            ResultSet rs = st.executeQuery(query); 
            
            if(rs.next())
            {
                patient_ID = rs.getInt(1);
                patient_ID=patient_ID+1;
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
    
    // send color
    public void setColorSend(JLabel p) {
        p.setBackground(new Color(5,10,46));
        send.setForeground(new Color(0,204,204));
    }
    public void resetColorSend(JLabel p) {
        p.setBackground(new Color(5,10,46));
        send.setForeground(new Color(255,255,255));
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

                    PreparedStatement ps = con.prepareStatement("INSERT INTO patient_receipt(Patient_Id,Full_Name,Father_Name,Age,Gender,Contact,Doctor_Name,Address,Registration_Date,Patient_Illness)" + "values(?,?,?,?,?,?,?,?,?,?)");
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
                    //JOptionPane.showMessageDialog(null, "Your Data Inserted!");
                    
                    
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
        ticket_profile = new javax.swing.JPanel();
        txt_patient_full_name = new javax.swing.JTextField();
        txt_patient_father_name = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        combo_patient_illness = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        combo_patiebt_age = new javax.swing.JComboBox<>();
        txt_patient_address = new javax.swing.JTextField();
        txtExtra = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        patient_id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        patient_registration_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ticket_profile.setBackground(new java.awt.Color(46, 64, 83));
        ticket_profile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ticket_profileComponentShown(evt);
            }
        });
        ticket_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_patient_full_name.setBackground(new java.awt.Color(46, 64, 83));
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
        ticket_profile.add(txt_patient_full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 200, 36));

        txt_patient_father_name.setBackground(new java.awt.Color(46, 64, 83));
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
        ticket_profile.add(txt_patient_father_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 200, 36));

        txt_patient_contact.setBackground(new java.awt.Color(46, 64, 83));
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
        ticket_profile.add(txt_patient_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 200, 36));

        combo_patient_doctor_name.setBackground(new java.awt.Color(46, 64, 83));
        combo_patient_doctor_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patient_doctor_name.setForeground(new java.awt.Color(255, 255, 255));
        combo_patient_doctor_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                  Doctor Select              ", "Maj. Gen. Dr. H.R. Harun", "Dr. Md. Faruk Hossain Mounshi", "Dr. Tanvir Ahmed Chowdhury", "Prof. Dr. Salahuddin Kowser Biplob", "Dr. Ahasan Uddin Ahmed", "Dr. Liton Chandra Saha", "Dr. Farhana Rahman", "Dr. M. A. Afzal Bhuiyan", "Prof. Dr. Zahid Hossain" }));
        combo_patient_doctor_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        combo_patient_doctor_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_patient_doctor_nameActionPerformed(evt);
            }
        });
        ticket_profile.add(combo_patient_doctor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 250, 40));

        Email.setBackground(new java.awt.Color(33, 47, 60));
        Email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Email.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContent.setBackground(new java.awt.Color(33, 47, 60));
        txtContent.setColumns(20);
        txtContent.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtContent.setForeground(new java.awt.Color(255, 255, 255));
        txtContent.setRows(5);
        txtContent.setText("\n\n\n\n                                typing...");
        jScrollPane4.setViewportView(txtContent);

        Email.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 290, 170));

        txtFrom.setBackground(new java.awt.Color(33, 47, 60));
        txtFrom.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFrom.setForeground(new java.awt.Color(255, 255, 255));
        txtFrom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFrom.setText("jobayedhossain79@gmail.com");
        Email.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 290, 30));

        txtTo.setBackground(new java.awt.Color(33, 47, 60));
        txtTo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTo.setForeground(new java.awt.Color(255, 255, 255));
        txtTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                              Email", "jobayedhossain145@gmail.com", "jobayed364@gmail.com", "jobayed35-2948@diu.edu.bd", "sakib35-3080@diu.edu.bd", "jannatul35-1615@diu.edu.bd", "sathilamia2004@gmail.com" }));
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

        txtSubject.setBackground(new java.awt.Color(33, 47, 60));
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
        Email.add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, 30));

        ticket_profile.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 370, 450));

        jPanel3.setBackground(new java.awt.Color(93, 109, 126));

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel1.setText("Patient Ticket");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(803, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        ticket_profile.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gender     :");
        ticket_profile.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, 20));

        male.setBackground(new java.awt.Color(46, 64, 83));
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        ticket_profile.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        other.setBackground(new java.awt.Color(46, 64, 83));
        other.setForeground(new java.awt.Color(255, 255, 255));
        other.setText("Other");
        other.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherActionPerformed(evt);
            }
        });
        ticket_profile.add(other, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 60, -1));

        female.setBackground(new java.awt.Color(46, 64, 83));
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        ticket_profile.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 70, -1));

        combo_patient_illness.setBackground(new java.awt.Color(46, 64, 83));
        combo_patient_illness.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patient_illness.setForeground(new java.awt.Color(255, 255, 255));
        combo_patient_illness.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                  Patient Illness", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Blood Pressure", "Cancer", "Cholesterol", "Chronic Pain", "Cold & Flu", "Depression", "Diabetes", "Dictionary", "Digestion", "Eyesight", "Health & Living", "Healthy Kids", "Hearing & Ear", "Heart", "HIV/AIDS", "Infectious Disease", "Lung Conditions", "Medications", "Menopause", "Men's Health", "Mental Health", "Migraine", "Neurology", "Oral Health", "Pregnancy", "Senior Health", "Sexual Health", "Skin", "Sleep", "Thyroid", "Travel Health", "Women's Health", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Cancer", "Cholesterol", "Chronic Pain", "Cold & Flu", "Depression", "Diabetes", "Digestion", "Disease Prevention", "Eyesight", "Heart", "Hepatitis", "High Blood Pressure", "HIV", "Infectious Disease", "Liver", "Lungs", "Menopause", "Men's Health", "Mental Health", "Migraine", "Osteoporosis", "Pediatrics / Healthy Kids", "Rheumatoid Arthritis", "Senior Health", "Skin", "Sleep", "Thyroid", "Urology", "Weight Loss & Management", "Women's Health" }));
        combo_patient_illness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_patient_illnessActionPerformed(evt);
            }
        });
        ticket_profile.add(combo_patient_illness, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 250, 40));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reg Date  :");
        ticket_profile.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 80, -1));

        combo_patiebt_age.setBackground(new java.awt.Color(46, 64, 83));
        combo_patiebt_age.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_patiebt_age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                         Age                 ", "10 Day", "1 Month", "2 Month", "3 Month", "4 Month", "5 Month", "6 Month", "7 Month", "8 Month", "9 Month", "10 Month", "01 Year", "02 Year", "03Year", "04 Year", "05 Year", "06 Year", "07 Year", "08 Year", "09 Year", "10 Year", "12 Year", "13 Year", "14 Year", "15 Year", "16 Year", "17 Year", "18 Year", "19 Year", "20 Year", "21 Year", "22 Year", "23 Year", "24 Year", "25 Year", "26 Year", "27 Year", "28 Year", "29 Year", "30 Year", "31 Year", "32 Year", "33 Year", "34 Year", "35 Year", "36 Year", "37 Year", "38 Year", "39 Year", "40 Year", "41 Year", "42 Year", "43 Year", "44 Year", "45 Year", "46 Year", "47 Year", "48 Year", "49 Year", "50 Year", "51 Year", "52 Year", "53 Year", "54 Year", "55 Year", "56 Year", "57 Year", "58 Year", "59 Year", "60 Year", "61 Year", "62 Year", "63 Year", "64 Year", "65 Year", "66 Year", "67 Year", "68 Year", "69 Year", "70 Year", "71 Year", "72 Year", "73 Year", "74 Year", "75 Year", "76 Year", "77 Year", "78 Year", "79 Year", "80 Year" }));
        combo_patiebt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_patiebt_ageActionPerformed(evt);
            }
        });
        ticket_profile.add(combo_patiebt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 250, 40));

        txt_patient_address.setBackground(new java.awt.Color(46, 64, 83));
        txt_patient_address.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_patient_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_patient_address.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_patient_address.setText("Address");
        txt_patient_address.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_patient_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_patient_addressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_patient_addressFocusLost(evt);
            }
        });
        ticket_profile.add(txt_patient_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 200, 36));

        txtExtra.setBackground(new java.awt.Color(46, 64, 83));
        txtExtra.setBorder(null);
        ticket_profile.add(txtExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 20, -1));
        ticket_profile.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 990, 10));

        jPanel2.setBackground(new java.awt.Color(46, 64, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Patient Id  :-");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 30));

        patient_id.setBackground(new java.awt.Color(0, 204, 204));
        patient_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        patient_id.setForeground(new java.awt.Color(0, 204, 204));
        patient_id.setText("1000");
        jPanel2.add(patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, 30));

        ticket_profile.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, 50));

        jButton1.setBackground(new java.awt.Color(46, 64, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medical/close button.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ticket_profile.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 110, 40));

        jButton2.setBackground(new java.awt.Color(46, 64, 83));
        jButton2.setText("Reset");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ticket_profile.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 110, 40));

        patient_registration_date.setBackground(new java.awt.Color(46, 64, 83));
        patient_registration_date.setForeground(new java.awt.Color(255, 255, 255));
        ticket_profile.add(patient_registration_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 229, 240, 40));

        jPanel1.add(ticket_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 684));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 684));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticket_profileComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ticket_profileComponentShown

    }//GEN-LAST:event_ticket_profileComponentShown

    private void txt_patient_addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_addressFocusLost
        if (txt_patient_address.getText().equals("")) {
            txt_patient_address.setText("Address");
            txt_patient_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_addressFocusLost

    private void txt_patient_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_addressFocusGained
        if (txt_patient_address.getText().equals("Address")) {
            txt_patient_address.setText("");
            txt_patient_address.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_addressFocusGained

    private void combo_patiebt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_patiebt_ageActionPerformed

        String age = (String) combo_patiebt_age.getSelectedItem();
        if("                         Age                 ".equals(age))
        {
            //JOptionPane.showMessageDialog(null,"Sorry! This is not selecte!");
            JOptionPane.showMessageDialog(null, "Sorry! This is not select!",
                "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_combo_patiebt_ageActionPerformed

    private void combo_patient_illnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_patient_illnessActionPerformed
        String illness = (String) combo_patient_illness.getSelectedItem();
        txtSubject.setText(illness);

        String ill = (String) combo_patient_illness.getSelectedItem();
        if("                  Patient Illness".equals(ill))
        {
            //JOptionPane.showMessageDialog(null,"Sorry! This is not selecte!");
            JOptionPane.showMessageDialog(null, "Sorry! This is not select!",
                "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_combo_patient_illnessActionPerformed

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

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        gender="male";
        if(male.isSelected())
        {
            female.setSelected(false);
            other.setSelected(false);
        }
    }//GEN-LAST:event_maleActionPerformed

    private void sendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseExited
        resetColorSend(send);
    }//GEN-LAST:event_sendMouseExited

    private void sendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseEntered
        setColorSend(send);
    }//GEN-LAST:event_sendMouseEntered

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
            //new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "send message successfully!!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
            Patient_Infor_Insert();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
//
//        String ToEmail = (String) txtTo.getSelectedItem();
//        String FromEmail = txtFrom.getText();
//        String FromEmailPassword = "jobayed80";
//        String Subjects = txtSubject.getText();
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host","smtp.gmail.com");
//        properties.put("mail.smtp.port","587");
//
//        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator()
//            {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication()
//                {
//                    return new PasswordAuthentication(FromEmail, FromEmailPassword);
//                }
//            });
//
//            try {
//
//                MimeMessage msg = new MimeMessage(session);
//                msg.setFrom(new InternetAddress(FromEmail));
//                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
//                msg.setSubject(Subjects);
//
//                Date date = new Date(patient_registration_date.getDate().getTime());
//                //String gender = (String) combo_patient_gender.getSelectedItem();
//                String doctorNAME = (String) combo_patient_doctor_name.getSelectedItem();
//                String Age = (String) combo_patiebt_age.getSelectedItem();
//                String illness = (String) combo_patient_illness.getSelectedItem();
//
//                msg.setText("'Daffodil Medical College & Hospital'\n\nAs-salamu alaykum '"+ doctorNAME +"'. Sir, welcome to our Daffodil Medical. '" +txt_patient_full_name.getText()+"' is one of your new patients.A huge appeal to you to solve all his/her problems.\n\n"
//                    +"Patiend Id        :-  "+patient_id.getText() +"\nFull Name        :-  "+txt_patient_full_name.getText()  +"\nFather Name   :-  "+txt_patient_father_name.getText()
//
//                    +"\nRegistration Date :-  "+date  +"\nPatient Illness    :-  "+illness +"\nGender            :-  "+gender +"\nContact           :-  "+txt_patient_contact.getText() +"\nDoctor Name  :-  "+doctorNAME  +"\nAddress           :-  "+txt_patient_address.getText()+"Age              :-  "+Age);
//
//                Transport.send(msg);
//                //JOptionPane.showMessageDialog(null, "success");
//                new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, "send message successfully!!", NoticeWindow.SHORT_DELAY, NPosition.CENTER);
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }

            //inserted patient            
           // Patient_Infor_Insert();
    }//GEN-LAST:event_sendMouseClicked

    private void sendAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sendAncestorAdded

    }//GEN-LAST:event_sendAncestorAdded

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Email.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void combo_patient_doctor_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_patient_doctor_nameActionPerformed
        String Dname = (String) combo_patient_doctor_name.getSelectedItem();
        if("                  Doctor Select              ".equals(Dname))
        {
            //JOptionPane.showMessageDialog(null,"Sorry! This is not selecte!");
            JOptionPane.showMessageDialog(null, "Sorry! This is not select!",
                "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_combo_patient_doctor_nameActionPerformed

    private void txt_patient_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_contactFocusLost
        if (txt_patient_contact.getText().equals("")) {
            txt_patient_contact.setText("Contact");
            txt_patient_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_contactFocusLost

    private void txt_patient_contactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_contactFocusGained
        if (txt_patient_contact.getText().equals("Contact")) {
            txt_patient_contact.setText("");
            txt_patient_contact.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_contactFocusGained

    private void patient_registration_dateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_registration_dateMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_registration_dateMouseEntered

    private void patient_registration_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_registration_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_registration_dateMouseClicked

    private void txt_patient_father_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_patient_father_nameKeyReleased

    }//GEN-LAST:event_txt_patient_father_nameKeyReleased

    private void txt_patient_father_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_father_nameFocusLost
        if (txt_patient_father_name.getText().equals("")) {
            txt_patient_father_name.setText("Father Name");
            txt_patient_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_father_nameFocusLost

    private void txt_patient_father_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_father_nameFocusGained
        if (txt_patient_father_name.getText().equals("Father Name")) {
            txt_patient_father_name.setText("");
            txt_patient_father_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_father_nameFocusGained

    private void txt_patient_full_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_patient_full_nameKeyReleased

        //txtSubject.setText(txt_patient_full_name.getText());
    }//GEN-LAST:event_txt_patient_full_nameKeyReleased

    private void txt_patient_full_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_full_nameFocusLost
        if (txt_patient_full_name.getText().equals("")) {
            txt_patient_full_name.setText("Full Name");
            txt_patient_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_full_nameFocusLost

    private void txt_patient_full_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_patient_full_nameFocusGained
        if (txt_patient_full_name.getText().equals("Full Name")) {
            txt_patient_full_name.setText("");
            txt_patient_full_name.setForeground(new Color(255,255,255));

        }
    }//GEN-LAST:event_txt_patient_full_nameFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new Patient_Ticket().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Patient_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Email;
    private javax.swing.JPanel Email_Header;
    private javax.swing.JComboBox<String> combo_patiebt_age;
    private javax.swing.JComboBox<String> combo_patient_doctor_name;
    private javax.swing.JComboBox<String> combo_patient_illness;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton other;
    private javax.swing.JLabel patient_id;
    private com.toedter.calendar.JDateChooser patient_registration_date;
    private javax.swing.JLabel send;
    private javax.swing.JPanel ticket_profile;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextField txtExtra;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JComboBox<String> txtTo;
    private javax.swing.JTextField txt_patient_address;
    private javax.swing.JTextField txt_patient_contact;
    private javax.swing.JTextField txt_patient_father_name;
    private javax.swing.JTextField txt_patient_full_name;
    // End of variables declaration//GEN-END:variables
}
