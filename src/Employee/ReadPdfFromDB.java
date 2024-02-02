/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

 
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;


public class ReadPdfFromDB {

    
    
	private static final int colNum = 11;
	 //Set the properties of the table
	private static final int spacing = 1;
	private static final int padding = 8;
        private static final String path = "D:\\";
	 //pdf file path name
	private static final String outPutFile ="jobayed.pdf";                   //"user.pdf"; 
	 //Database connection parameters
	private static String url="jdbc:mysql://localhost:3306/medical";
	private static String user="root";
	private static String password="";
        
        
        
        
        
	public static void main(String[] args) throws SQLException {
		 //Define a document object with a size of 1200*1000 pixels
		Document document = new Document(new Rectangle(1200, 1000), 10, 10, 10, 10);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 //Create a pdf file in the document
			//PdfWriter.getInstance(document, new FileOutputStream(path +""));
                        PdfWriter.getInstance(document, new FileOutputStream(path + "jobayed.pdf"));
			document.open();
                        
                        
			 //Create a table with colNum fields
			PdfPTable table = new PdfPTable(colNum);
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
				table.getDefaultCell().setBackgroundColor(BaseColor.GREEN);
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
                        JOptionPane.showMessageDialog(null,"Done");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
                
                finally 
                {
			rs.close();
			ps.close();
			conn.close();
			document.close();
		}
	}
}
