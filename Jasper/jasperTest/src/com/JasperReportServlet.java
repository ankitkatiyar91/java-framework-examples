package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.export.*;
 
public class JasperReportServlet extends HttpServlet
{
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{
ServletOutputStream servletOutputStream = response.getOutputStream();
Connection conn = null;
JasperReport jasperReport;
JasperPrint jasperPrint;
JasperDesign jasperDesign;
try
{
// get a database connection
	Class.forName("com.mysql.jdbc.Driver");
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oe","root","mysql");
// create a map of parameters to pass to the report.
Map parameters = new HashMap();
parameters.put("Report_Title", "Salesman Details");
 
// load JasperDesign from XML and compile it into JasperReport
jasperDesign = JRXmlLoader.load("C:/jasperReports/demo.jrxml");
jasperReport = JasperCompileManager.compileReport(jasperDesign);
 
// fill JasperPrint using fillReport() method
jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conn);
 
JasperExportManager.exportReportToPdfFile(jasperPrint,
"C:/jasperReports/demo.pdf");
response.setContentType("application/pdf");
//for creating report in excel format
JRXlsExporter exporterXls = new JRXlsExporter();
exporterXls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporterXls.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
"C:/jasperReports/demo.xls");
exporterXls.exportReport();
JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
 
servletOutputStream.flush();
servletOutputStream.close();
}
catch(SQLException sqle)
{
 System.err.println(sqle.getMessage());
}
catch (ClassNotFoundException e)
{
 System.err.println("No such class found!");
 e.printStackTrace();
}
catch (JRException e)
{
// display stack trace in the browser
StringWriter stringWriter = new StringWriter();
PrintWriter printWriter = new PrintWriter(stringWriter);
e.printStackTrace(printWriter);
response.setContentType("text/plain");
response.getOutputStream().print(stringWriter.toString());
}
finally
{
//close the connection.
if(conn != null)
{
try { conn.close(); }
catch (Exception ignored) {}
}
}
}
}