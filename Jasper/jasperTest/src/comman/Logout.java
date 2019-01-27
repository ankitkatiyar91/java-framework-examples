package comman;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.mysql.jdbc.Connection;

public class Logout {
	
	public String execute()
	{
		
		
		
			InputStream input;
			try {
				System.out.println("---------------");
				Class.forName("com.mysql.jdbc.Driver");
				Connection Dbconnection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bsplims","root","mysql");

				input = new FileInputStream(new File("G:/CMS/src/jrxml/Test.jrxml"));
				Map<String,String> countryNames = new HashMap<String, String>(200);
				countryNames.put("first_name", "sachin");
				countryNames.put("last_name", "verma");
				JasperDesign jasperDesign = JRXmlLoader.load(input);
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, countryNames, Dbconnection);
				FileOutputStream output = new FileOutputStream(new File("G:/CMS/src/jrxml/EmployeeReport.pdf"));
				JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("---------------");
			return "success";
		
	}

}
