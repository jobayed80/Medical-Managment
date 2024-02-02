package Employee;

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.padding;
import javax.swing.JOptionPane;

public class jdbc_pdf_report {

    private static final int spacing = 2;
    private static final int padding = 3;

    public static void main(String[] args) throws Exception {

        String path = "D:\\";
        try {
            /* Create Connection objects */
//                Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
//            Statement st = (Statement) con.createStatement();
//            String query = "select Id,FullName,FatherName,MotherName,Birthday,Status,Contact_1,Contact_2,Department,Address,Gender employee";
//            ResultSet query_set = st.executeQuery(query);

            Document my_pdf_report = new Document(new Rectangle(1300, 1000), 15, 15, 15, 15);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
            Statement stmt = conn.createStatement();
            /* Define the SQL query */
            ResultSet query_set = stmt.executeQuery("select Id,FullName,FatherName,MotherName,Birthday,Status,Contact_1,Contact_2,Department,Address,Gender from employee");
            /* Step-2: Initialize PDF documents - logical objects */
            //Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream(path + "pdf_report_from_sql_using_java.pdf"));
            my_pdf_report.open();
            //we have four columns in our table
            PdfPTable my_report_table = new PdfPTable(11);
            //create a cell object
            PdfPCell table_cell;

//                    my_report_table.addCell("Id"); 
//                    my_report_table.addCell("Name");
//                    my_report_table.addCell("Father Name");
//                    my_report_table.addCell("Mother Name");
//                    //tbl.addCell("Image");
//                    //tbl.addCell("Birthday Date");
//                    my_report_table.addCell("Status");
//                    my_report_table.addCell("Contact 1");
//                    my_report_table.addCell("Contact 2");
//                    my_report_table.addCell("Department");
//                    my_report_table.addCell("Address");
//                    my_report_table.addCell("Gender");
//                    my_pdf_report.add(my_report_table);
            int[] cellsWidth = {12, 20, 20, 20, 20, 20, 17, 17, 17,25, 15};
            my_report_table.setWidths(cellsWidth);
            my_report_table.setWidthPercentage(90);
            my_report_table.getDefaultCell().setPadding(padding);
            my_report_table.getDefaultCell().setBorderWidth(spacing);
            my_report_table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
           

            while (query_set.next()) {
                
                String id = query_set.getString("Id");
                table_cell = new PdfPCell(new Phrase(id));
                my_report_table.addCell(table_cell);

                String Fullname = query_set.getString("FullName");
                table_cell = new PdfPCell(new Phrase(Fullname));
                my_report_table.addCell(table_cell);

                String Fname = query_set.getString("FatherName");
                table_cell = new PdfPCell(new Phrase(Fname));
                my_report_table.addCell(table_cell);

                String Mname = query_set.getString("MotherName");
                table_cell = new PdfPCell(new Phrase(Mname));
                my_report_table.addCell(table_cell);

                String Birth = query_set.getString("Birthday");
                table_cell = new PdfPCell(new Phrase(Birth));
                my_report_table.addCell(table_cell);

                String Sta = query_set.getString("Status");
                table_cell = new PdfPCell(new Phrase(Sta));
                my_report_table.addCell(table_cell);

//                                 String img=query_set.getString("Image");
//                                table_cell=new PdfPCell(new Phrase(img));
//                                my_report_table.addCell(table_cell);
                String Con1 = query_set.getString("Contact_1");
                table_cell = new PdfPCell(new Phrase(Con1));
                my_report_table.addCell(table_cell);

                String Con2 = query_set.getString("Contact_2");
                table_cell = new PdfPCell(new Phrase(Con2));
                my_report_table.addCell(table_cell);

                String dep = query_set.getString("Department");
                table_cell = new PdfPCell(new Phrase(dep));
                my_report_table.addCell(table_cell);

                String address = query_set.getString("Address");
                table_cell = new PdfPCell(new Phrase(address));
                my_report_table.addCell(table_cell);

                String gen = query_set.getString("Gender");
                table_cell = new PdfPCell(new Phrase(gen));
                my_report_table.addCell(table_cell);

            }
            /* Attach report table to PDF */
            my_pdf_report.add(my_report_table);
            JOptionPane.showMessageDialog(null, "Done");
            my_pdf_report.close();

            /* Close all DB related objects */
            query_set.close();
//                stmt.close(); 
//                conn.close();               

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
