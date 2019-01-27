<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="data" class="bean.Data"></jsp:useBean>
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
    This is my JSP page. <br>
  
    <h1>From Map</h1><br>
    <table border="1">
    
    <%
    Map<Integer, ArrayList<String>> map=data.getDataInMap();
    out.print("Size of map-"+map.size());
    ArrayList<String> ar1= null;
    for(int j=0;j<map.size();j++)
    {
    out.print("<tr>");
    ar1=map.get(0);
    out.print("Size of list-"+ar1.size());
    for(int i=0;i<ar1.size();i++)
    {
    %>
    <td><%=ar1.get(i) %></td>
    <%} %>
    </tr>
    <%} %></table>
  </body>
</html>
