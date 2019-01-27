<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><!--
    value of r<%=request.getParameter("r")%><br>
    value of result<%=request.getAttribute("result") %><br>
    value of result<%=(ResultSet)session.getAttribute("result") %><br>
    --><%
    ResultSet rst=  (ResultSet)request.getAttribute("result") ;
	for(int i=0;i<5;i++)
	{
		rst.next();
		out.println("<br> values--"+rst.getString(1));
	}    
     %>
  </body>
</html>
