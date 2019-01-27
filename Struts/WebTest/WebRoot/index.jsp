<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
    Class.forName("com.mysql.jdbc.Driver");
			Connection Dbconnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bsplims","root","mysql");
			PreparedStatement stm=Dbconnection.prepareStatement("Select * from enquiry");
			ResultSet rst=stm.executeQuery();
			request.setAttribute("result",rst);
			for(int i=0;i<5;i++)
			{
				rst.next();
			
				out.println("value=="+rst.getString(1));
			}
    	
    	//session.setAttribute("result",rst);
    	 System.out.println("real path-- "+request.getRealPath(""));
     System.out.println("real path-- "+request.getContextPath());
     
     %>
     
     <jsp:forward page="page2.jsp"></jsp:forward>
     
     <%
    
      %>
  </body>
</html>
