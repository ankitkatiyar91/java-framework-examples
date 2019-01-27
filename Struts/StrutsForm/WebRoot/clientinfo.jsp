<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  	<NoScript>
JavaScript is disabled. pls use this link (www.watever.com)to access my homepage
</NoScript>
    <title>My JSP 'clientinfo.jsp' starting page</title>
    
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
   String val=request.getHeader("User-Agent");
   System.out.println(val);
   if(val.indexOf("HTTrack")>-1)
   {
   	
   }else
   {
   out.println("</br>remote add---"+request.getRemoteAddr());
   out.println("</br>remote host----"+request.getRemoteHost());
   out.println("</br>remote user----"+request.getRemoteUser());
   out.println("</br>remote port----"+request.getRemotePort());
   out.println("</br>remote locales----"+request.getLocale());
   out.println("</br>header User-Agent---"+request.getHeader("User-Agent"));
   System.out.println("header User-Agent---"+request.getHeader("User-Agent"));
   out.println("</br> get header referer-----"+request.getHeader("Referer"));
   Enumeration e = request.getHeaderNames();
	while (e.hasMoreElements()) {
	String name = (String)e.nextElement();
	String value = request.getHeader(name);
	out.println("</br>"+name + " = " + value);
	}
   }
    %>
  </body>
</html>
