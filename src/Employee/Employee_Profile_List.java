/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.misc.BASE64Decoder;

/**
 *
 * @author h
 */
public class Employee_Profile_List extends javax.swing.JFrame implements Runnable{

    int hour,min,sec;
    
    
   
    
    
    
    
    public Employee_Profile_List() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        Thread t = new Thread(this);
        t.start();
        
        
    }
    
      //    Start admin color
    public void setColor(JLabel p) {
        p.setBackground(new Color(0, 0, 55));

    }

    public void resetColor(JLabel p1) {
        p1.setBackground(new Color(211, 219, 226));

    }
    
    
    
    public void populateJtable()
    {
        
//         try {
//             
//              
//              UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteTabbedPaneUI");
//              
//            
//        } catch (Exception e) {
//        }
        
        
        Employee_Query mq = new Employee_Query();
        ArrayList<Employee_Private> list = mq.BindTable();
        String[] columnName = {"Id","Full_Name","Father_Name","Mother_Name","Image","Birthday","Status","Contact 1","Contact 2","Department","Address","Gender"};
        Object[][] rows = new Object[list.size()][12];
        for (int i = 0; i <list.size(); i++) {
            
            rows[i][0] = list.get(i).getEmpId();
            rows[i][1] = list.get(i).getEmpFullName();
            rows[i][2] = list.get(i).getEmpFatherName();
            rows[i][3] = list.get(i).getEmpMotherName();
            rows[i][5] = list.get(i).getBirthday();
            rows[i][6] = list.get(i).getStatus();
            rows[i][7] = list.get(i).getContact1();
            rows[i][8] = list.get(i).getContact2();
            rows[i][9] = list.get(i).getDepartment();
            rows[i][10] = list.get(i).getAddress();
            rows[i][11] = list.get(i).getGender();
            //rows[i][11] = list.get(i).getEmpMotherName();
            
            

            if(list.get(i).getImage()!=null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
                rows[i][4] = image;
            }
            else
            {
                rows[i][4]=null;
            }
            rows[i][5] = list.get(i).getImage();
            
        }
        
        Employee_Model model = new Employee_Model(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
        
    }
    
    
    
    public void populateJtableKeySearch()
    {
        
//         try {
//             
//              
//              UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteTabbedPaneUI");
//              
//            
//        } catch (Exception e) {
//        }
        
        
        Employee_Query_Search mq = new Employee_Query_Search(emp_id.getText());
        ArrayList<Employee_Private> list = mq.BindTable();
        String[] columnName = {"Id","Full_Name","Father_Name","Mother_Name","Image","Birthday","Status","Contact 1","Contact 2","Department","Address","Gender"};
        Object[][] rows = new Object[list.size()][12];
        for (int i = 0; i <list.size(); i++) {
            
            rows[i][0] = list.get(i).getEmpId();
            rows[i][1] = list.get(i).getEmpFullName();
            rows[i][2] = list.get(i).getEmpFatherName();
            rows[i][3] = list.get(i).getEmpMotherName();
            rows[i][5] = list.get(i).getBirthday();
            rows[i][6] = list.get(i).getStatus();
            rows[i][7] = list.get(i).getContact1();
            rows[i][8] = list.get(i).getContact2();
            rows[i][9] = list.get(i).getDepartment();
            rows[i][10] = list.get(i).getAddress();
            rows[i][11] = list.get(i).getGender();
            //rows[i][11] = list.get(i).getEmpMotherName();
            
            

            if(list.get(i).getImage()!=null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
                rows[i][4] = image;
            }
            else
            {
                rows[i][4]=null;
            }
            rows[i][5] = list.get(i).getImage();
            
        }
        
        Employee_Model model = new Employee_Model(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
        
    }
    
    
    public void populateJtableKeyAddressSearch()
    {
        
//         try {
//             
//              
//              UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteTabbedPaneUI");
//              
//            
//        } catch (Exception e) {
//        }
        
        
        Employee_Query_Search mq = new Employee_Query_Search(emp_id.getText());
        ArrayList<Employee_Private> list = mq.BindTable();
        String[] columnName = {"Id","Full_Name","Father_Name","Mother_Name","Image","Birthday","Status","Contact 1","Contact 2","Department","Address","Gender"};
        Object[][] rows = new Object[list.size()][12];
        for (int i = 0; i <list.size(); i++) {
            
            rows[i][0] = list.get(i).getEmpId();
            rows[i][1] = list.get(i).getEmpFullName();
            rows[i][2] = list.get(i).getEmpFatherName();
            rows[i][3] = list.get(i).getEmpMotherName();
            rows[i][5] = list.get(i).getBirthday();
            rows[i][6] = list.get(i).getStatus();
            rows[i][7] = list.get(i).getContact1();
            rows[i][8] = list.get(i).getContact2();
            rows[i][9] = list.get(i).getDepartment();
            rows[i][10] = list.get(i).getAddress();
            rows[i][11] = list.get(i).getGender();
            //rows[i][11] = list.get(i).getEmpMotherName();
            
            

            if(list.get(i).getImage()!=null)
            {
                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage().getScaledInstance(150,120,Image.SCALE_SMOOTH));
                rows[i][4] = image;
            }
            else
            {
                rows[i][4]=null;
            }
            rows[i][5] = list.get(i).getImage();
            
        }
        
        Employee_Model model = new Employee_Model(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(140);
        
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reset = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        table_label = new javax.swing.JLabel();
        download = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 64, 83));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(46, 64, 83));
        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1220, 610));

        jPanel1.setBackground(new java.awt.Color(93, 109, 126));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 1, 222, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 1234, 40));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 40));

        close.setBackground(new java.awt.Color(46, 64, 83));
        close.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("Close");
        close.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        jPanel2.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 110, 40));

        emp_id.setBackground(new java.awt.Color(46, 64, 83));
        emp_id.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emp_id.setForeground(new java.awt.Color(255, 255, 255));
        emp_id.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        emp_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_idKeyReleased(evt);
            }
        });
        jPanel2.add(emp_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 170, 40));

        table_label.setFont(new java.awt.Font("Elephant", 1, 14)); // NOI18N
        table_label.setForeground(new java.awt.Color(255, 255, 255));
        table_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_label.setText("Table");
        table_label.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        table_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_labelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                table_labelMouseExited(evt);
            }
        });
        jPanel2.add(table_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 110, 40));

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downloadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downloadMouseExited(evt);
            }
        });
        jPanel2.add(download, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 110, 40));

        jPanel3.setBackground(new java.awt.Color(46, 64, 83));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Date.setBackground(new java.awt.Color(46, 64, 83));
        Date.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 204, 204));
        Date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Date.setText("jLabel5");
        jPanel3.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, -1));

        Time.setBackground(new java.awt.Color(46, 64, 83));
        Time.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(0, 204, 204));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Time.setText("jLabel5");
        jPanel3.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, 150, 60));

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Search");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 110, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        dispose();
        new Employee_Profile_List().setVisible(true);
    }//GEN-LAST:event_resetMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
         System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void emp_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_idKeyReleased
       
         populateJtableKeySearch();
    }//GEN-LAST:event_emp_idKeyReleased

    private void table_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_labelMouseClicked
      populateJtable();
    }//GEN-LAST:event_table_labelMouseClicked

    
    private void downloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseClicked
//                
//        String Id = emp_id.getText();
//        String path = "D:\\";
//        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
//        try {
//
//            //PdfWriter.getInstance(doc, new FileOutputStream(path +""+txt_emp_full_name.getText()+ " "+Date+".pdf"));
//            PdfWriter.getInstance(doc, new FileOutputStream(path + Id + " " + ".pdf"));
//            doc.open();
////            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("pdfBack/png");
////            doc.add(img);
//           
//
//            String title = "                        Daffodil Medical Systems\n\n";
//            Paragraph paragrph1 = new Paragraph(title);
//            doc.add(paragrph1);
//
////                    String content="Time :- "+Time.getText() +"\nDate  :- "+Date.getText()+"\n\nEmploye Id  :-  "+emp_id.getText() +"Employee Name :- "+txt_emp_full_name.getText()+"Employee Father Name :- "+txt_emp_father_name.getText() +"Employee Mother Name :- "+txt_emp_mother_name.getText()+
////                            "Birthday Date :- "+B_date +"Contact Number1 :- "+txt_emp_contact1.getText() +"Contact Number2 :- "+txt_emp_contact2.getText() +"Age      :-  "+Age +"Address   :-  "+txt_emp_address.getText()  +"Department  :- "+txt_emp_dep.getText()
////                            +"Gender  :- "+txt_emp_gen.getText()  +"Relational Status : -"+txt_emp_status.getText();
//            String Content = "Time  :- " + Time.getText() + "\nDate  :- " + Date.getText() +"\n\n";
//            Paragraph paragrph2 = new Paragraph(Content);
//            doc.add(paragrph2);
//                                        
//                    PdfPTable tbl = new PdfPTable(10);
//                    PdfPCell cell = new PdfPCell(new Paragraph ("Title"));
//                    cell.setColspan(12);
//                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell.setBackgroundColor(BaseColor.GREEN);
//                    cell.setPadding(TOP_ALIGNMENT);
//                    tbl.addCell(cell);
//                    
//                    tbl.addCell("Id"); 
//                    tbl.addCell("Name");
//                    tbl.addCell("Father Name");
//                    tbl.addCell("Mother Name");
//                    //tbl.addCell("Image");
//                    //tbl.addCell("Birthday Date");
//                    tbl.addCell("Status");
//                    tbl.addCell("Contact 1");
//                    tbl.addCell("Contact 2");
//                    tbl.addCell("Department");
//                    tbl.addCell("Address");
//                    tbl.addCell("Gender");
//                    doc.add(tbl);
//                    for(int i =1 ; i<jTable1.getRowCount();i++)
//                    {
//                        String a = jTable1.getValueAt(i, 1).toString();
//                        String b = jTable1.getValueAt(i, 2).toString();
//                        String c = jTable1.getValueAt(i, 3).toString();
//                        //String d = jTable1.getValueAt(i, 4).toString();
//                        //String d2 = jTable1.getValueAt(i, 5).toString();
//                        String d3 = jTable1.getValueAt(i, 6).toString();
//                        String e = jTable1.getValueAt(i, 7).toString();
//                        String f = jTable1.getValueAt(i, 8).toString();
//                        String g = jTable1.getValueAt(i, 9).toString();
//                        String h = jTable1.getValueAt(i, 10).toString();
//                        String k = jTable1.getValueAt(i, 11).toString();
//                        String l = jTable1.getValueAt(i, 12).toString();
//                        
//                        tbl.addCell(a);
//                        tbl.addCell(b);
//                        tbl.addCell(c);
//                        //tbl.addCell(d);
//                        //tbl.addCell(d2);
//                        tbl.addCell(d3);
//                        tbl.addCell(e);
//                        tbl.addCell(f);
//                        tbl.addCell(g);
//                        tbl.addCell(h);
//                        tbl.addCell(k);
//                        tbl.addCell(l);
//                        
//                        doc.add(tbl);
//                    }
//            JOptionPane.showMessageDialog(null, "Done");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        doc.close();
// 

        //Set the properties of the table
        int colNum = 11;	 
	int spacing = 1;
	int padding = 8;
        String path = "D:\\";
	 //pdf file path name
	String outPutFile ="Employee Information.pdf";                   //"user.pdf"; 
	 //Database connection parameters
	String url="jdbc:mysql://localhost:3306/medical";
	String user="root";
	String password="";
    
        




         //Define a document object with a size of 1200*1000 pixels
		Document document = new Document(new Rectangle(1100, 1000), 10, 10, 10, 10);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                
		try {
			 //Create a pdf file in the document
			//PdfWriter.getInstance(document, new FileOutputStream(path +""));
                        PdfWriter.getInstance(document, new FileOutputStream(path +outPutFile));
			document.open();
                        
//                        com.itextpdf.text.Image imgDIu = com.itextpdf.text.Image.getInstance("diuMain.png");
//                        imgDIu.setAlignment(Element.ALIGN_CENTER);
//                        document.add(imgDIu);
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("lovepdf.png");
                        img.setAlignment(Element.ALIGN_CENTER);
                        document.add(img);
                        
                        
                      
                        
                        String title ="\n      Daffodil Medical Systems";
                        document.add(new Paragraph(title,FontFactory.getFont(FontFactory.TIMES_BOLD,40,Font.BOLD,BaseColor.RED)));
                        //String Content = "-: Time" + Time.getText() + "\nDate  :- " + Date.getText() +"\n\n";
                        String name ="\n             Md. Jobayed Hossain (Rabbi)";
                        Paragraph paragrph1 = new Paragraph(name,FontFactory.getFont(FontFactory.TIMES_ROMAN,17,Font.BOLD,BaseColor.RED));
                        document.add(paragrph1);
                        String  ins ="             Daffodil International Univercity";
                        Paragraph paragrph2 = new Paragraph(ins,FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.RED));
                        document.add(paragrph2);
                        String  swe ="              Department of Software Engineering                                                ";
                        Paragraph paragrph3 = new Paragraph(swe,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,BaseColor.RED));
                        document.add(paragrph3);
                        String mail ="              jobayed35-2948@diu.edu.bd";
                        Paragraph paragrph4 = new Paragraph(mail,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,BaseColor.RED));
                        document.add(paragrph4);
                        String Adds ="              Bhagalpur,Bajitpur,Kishoreganj"+"                                                                                                                                                                         Time :  "+Time.getText();
                        Paragraph paragrph5 = new Paragraph(Adds,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,BaseColor.RED));
                        document.add(paragrph5);
                        String Con ="             01643897838,01920795639"+"                                                                                                                                                                      Date :  "+Date.getText() +"\n\n";
                        Paragraph paragrph6 = new Paragraph(Con,FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.RED));
                        document.add(paragrph6);
                        
//                        String contents ="                Time :  "+Time.getText();
//                        Paragraph paragrph13 = new Paragraph(contents,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.RED));
//                        document.add(paragrph13);
//                        String cont = "                Date :  "+Date.getText() +"\n\n";
//                        Paragraph paragrph14 = new Paragraph(cont,FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.RED));
//                        document.add(paragrph14);
                        
                        
                        
                        
			 //Create a table with colNum fields
			PdfPTable table = new PdfPTable(colNum);
                        PdfPCell cell = new PdfPCell(new Paragraph("Employee Information",FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.BOLD,BaseColor.WHITE)));
                        cell.setColspan(11);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBackgroundColor(BaseColor.GRAY);
                        //cell.setPadding(TOP_ALIGNMENT);
                        cell.setPadding(20);
                        table.addCell(cell);
                        
                   
                        
                        
			int[] cellsWidth = {12, 25, 25, 25, 20, 15, 18, 18, 25,30, 15};
			 //Set the relative size of the field cell
			table.setWidths(cellsWidth);
			 //Set the size ratio of the table to the document
			table.setWidthPercentage(90);
			table.getDefaultCell().setPadding(padding);
			table.getDefaultCell().setBorderWidth(spacing);
			 //Set cell text to center
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                        
                        
                        
			//Database Connectivity 
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select Id,FullName,FatherName,MotherName,Birthday,Status,Contact_1,Contact_2,Department,Address,Gender from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
                        
                        
			 //Get field description information of the table
			ResultSetMetaData metaData = rs.getMetaData();
			 //Add field
			for(int i=0;i<colNum;i++){
				table.getDefaultCell().setBackgroundColor(BaseColor.CYAN);
				//table.addCell(new Paragraph(tableHeader[i]));
				 //Get field name dynamically
				table.addCell(new Paragraph(metaData.getColumnLabel(i+1)));
			}
			table.setHeaderRows(1);//The end of the table header setting indicates that the first row belongs to the table header
			table.getDefaultCell().setBorderWidth(1);
			while(rs.next())
                        {
				 //Add each piece of data queried to the pdf file as a separate line
				for(int i=1; i<=colNum; i++)
                                {
					 //Set the background color
					table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(new Paragraph(rs.getString(i)));
				}
			}
                        
                        
			 //Add the table to the document
			document.add(table);
                        
                        String end ="\n\n               A doctor is someone who is experienced and certified to practice medicine to help maintain or restore physical and mental health.\n               A doctor is tasked with interacting with patients, diagnosing medical problems and successfully treating illness or injury.\n               There are many specific areas in the field of medicine that students can study. This article is meant to explain in general terms what a doctor does, common types of doctors,\n               a doctor's earning potential and how to become one.";
                        document.add(new Paragraph(end,FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.BOLD,BaseColor.RED)));
                       
                        com.itextpdf.text.Image imgDIu = com.itextpdf.text.Image.getInstance("diuNew.png");
                        imgDIu.setAlignment(Element.ALIGN_RIGHT);
                        document.add(imgDIu);
                        JOptionPane.showMessageDialog(null,"Done");
                        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
                
                finally 
                {
		    try
                    {
                        rs.close();
                        ps.close();
                        conn.close();
                        document.close();
                       
                    }catch (Exception e) {
                    }
		}
        

    }//GEN-LAST:event_downloadMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
       setColor(reset);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        resetColor(reset);
    }//GEN-LAST:event_resetMouseExited

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
      setColor(close);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
       resetColor(close);
    }//GEN-LAST:event_closeMouseExited

    private void downloadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseEntered
        setColor(download);
    }//GEN-LAST:event_downloadMouseEntered

    private void downloadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseExited
        resetColor(download);
    }//GEN-LAST:event_downloadMouseExited

    private void table_labelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_labelMouseEntered
        setColor(table_label);
    }//GEN-LAST:event_table_labelMouseEntered

    private void table_labelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_labelMouseExited
       resetColor(table_label);
    }//GEN-LAST:event_table_labelMouseExited

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
            java.util.logging.Logger.getLogger(Employee_Profile_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Profile_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Profile_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel close;
    private javax.swing.JLabel download;
    private javax.swing.JTextField emp_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel reset;
    private javax.swing.JLabel table_label;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
         while(true)
        {
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            min = cal.get(Calendar.MINUTE);
            sec = cal.get(Calendar.SECOND);
            
            
            SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ss aa");
           
            java.util.Date dat =  cal.getTime();
            String time12 = sdf12.format(dat);
            Time.setText(time12);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
            
            Date.setText(sdf.format(dat));
            
            
        }
    }
}
