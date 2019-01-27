package com;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class XLSoutput extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			InputStream input=new FileInputStream(new File("E:/CMS/JasperTest/src/jrxml/enquirydailyreport.jrxml"));
			JasperDesign jasperDesign = JRXmlLoader.load(input);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				Class.forName("com.mysql.jdbc.Driver");
						
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bsplims","root","mysql");
			HashMap parameterMap = new HashMap();
			parameterMap.put("startDate", "2012-09-10 00:00:00");
			parameterMap.put("endDate", "2012-09-10 23:59:59");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, jdbcConnection);
			JasperViewer.viewReport(jasperPrint);
			
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			 OutputStream outputfile= response.getOutputStream();

			        // coding For Excel:
			         JRXlsExporter exporterXLS = new JRXlsExporter();
			         exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
			         exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
			         exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			         exporterXLS.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
			         exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			         exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			         exporterXLS.exportReport();
			         
//byte[] b=JasperExportManager.exportReportToPdf(jasperPrint);
response.setContentType("application/xls");

response.setHeader("Content-disposition", "attachment; filename=\"" +"name" + ".xls\"");
			outputfile .write(output.toByteArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
