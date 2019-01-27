<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":/";
%>
    <base href="<%=basePath %>">

   <% 
   if(request.getParameter("msg").equalsIgnoreCase("1")){
   response.sendRedirect(basePath+"indocorp/send_ack.php?msg=1");
   }else
   {
    response.sendRedirect(basePath+"indocorp/send_ack.php?msg=0");
   }
    %>
 