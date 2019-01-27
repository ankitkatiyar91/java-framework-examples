package mail;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.util.BCELifier;
import com.sun.swing.internal.plaf.basic.resources.basic;


public class Mail extends HttpServlet {

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


		System.out.println("servlet call");
		
		try {
			EMail e=new EMail();
			e.setTo(request.getParameter("to"));
			e.setSubject(request.getParameter("subject"));
			e.setBody(request.getParameter("body"));
			e.setBcc(request.getParameter("bcc"));
			e.setCc(request.getParameter("cc"));
			System.out.println("bcc in servlet=="+request.getParameter("bcc"));
			System.out.println("cc in servlet=="+request.getParameter("cc"));
			e.sendMail();
			
			response.sendRedirect("success.jsp?msg=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			response.sendRedirect("success.jsp?msg=0");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
