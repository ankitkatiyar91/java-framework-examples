package ask;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperDesignViewer;
import ask.bean.BeanFactory;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(new File("resources/beans.jasper").getAbsolutePath());
        
        try {
        	JasperCompileManager.compileReportToFile("resources/beans.jrxml","resources/beans.jasper");
        	JasperPrint jasperPrint=JasperFillManager.fillReport("resources/beans.jasper", new HashMap<String, Object>(),
        			new JRBeanCollectionDataSource(BeanFactory.createBeanCollection()));
        	
			JasperExportManager.exportReportToPdfFile(jasperPrint, new File("resources/export.pdf").getAbsolutePath());
			
			JasperExportManager.exportReportToHtmlFile(jasperPrint, new File("resources/export.html").getAbsolutePath());
			
			/*
			 * View Your Reports
			 */
			//JasperViewer.viewReport(jasperPrint);
			
			JasperExportManager.exportReportToXmlFile(jasperPrint, new File("resources/export.xml").getAbsolutePath(), false);
			
			/*
			 * Print your report
			 */
			//JasperPrintManager.printPage(jasperPrint, 0, true);
			
			String s=JasperRunManager.runReportToHtmlFile("resources/beans.jasper",new HashMap<String, Object>(),new JRBeanCollectionDataSource(BeanFactory.createBeanCollection()));
			System.out.println("JasperRunManager.runReportToHtmlFile->"+s);
			
			/*
			 * View design
			 */
//			JasperDesignViewer.viewReportDesign("resources/beans.jrxml", true);
			
		} catch (JRException e) {
			e.printStackTrace();
		}
    }
}
