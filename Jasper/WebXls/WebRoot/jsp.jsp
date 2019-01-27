<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="java.sql.Connection"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporter"%>
<%@page import="net.sf.jasperreports.engine.export.JRXlsExporterParameter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
InputStream input=new FileInputStream(new File("E:/CMS/JasperTest/src/jrxml/report2.jrxml"));
			JasperDesign jasperDesign = JRXmlLoader.load(input);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				Class.forName("com.mysql.jdbc.Driver");
						
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","mysql");
			HashMap parameterMap = new HashMap();
			parameterMap.put("hp", new Integer(11));
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

%>