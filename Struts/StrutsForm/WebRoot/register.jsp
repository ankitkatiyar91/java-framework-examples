<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<%@page errorPage="error.jsp" %>
<%@taglib uri="http://code.google.com/p/jcaptcha4struts2/taglib/2.0" prefix="captcha" %>
<%@taglib uri="/struts-dojo-tags"  prefix="sd"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/registration-form.css">
	<SCRIPT type="text/javascript">
	function resetCaptcha()
	{
	document.forms["registration"]["jCaptchaResponse"].value='';
	}
	</SCRIPT>

  </head>
  <body onload="resetCaptcha();">
  <fieldset>  <legend>Registration</legend>
   <s:form method="POST" cssClass="form" cssErrorClass="form-error" action="userregister"  name="registration">
   <table border="0">
   <tr>
   		<td><label for="firstname">First Name</label><SPAN>*</SPAN></td><td>:</td>
   		<td><s:textfield cssErrorClass="input-error" name="register.firstname" id="firstname" label="First Name" labelposition="left"  javascriptTooltip="First Name" placeholder="First Name"  required="true" ></s:textfield></td>
   		<td><s:fielderror><s:param>register.firstname</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="middlename" >Middle Name</label></td><td>:</td>
   		<td><s:textfield cssErrorClass="input-error" name="register.middlename" id="middlename" label="Middle Name" labelposition="left"  javascriptTooltip="Middle Name" placeholder="Middle Name"  ></s:textfield></td>
   		<td><s:fielderror><s:param>register.middlename</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="lastname" >Last Name</label></td><td>:</td>
   		<td><s:textfield cssErrorClass="input-error" name="register.lastname" id="lastname" label="Last Name" labelposition="left"  javascriptTooltip="Last Name" placeholder="Last Name"  required="true" ></s:textfield></td>
   		<td><s:fielderror><s:param>register.lastname</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="gender" >Gender<span>*</span></label></td><td>:</td>
   		<td><s:select cssErrorClass="input-error" list="#{ 'M':'Male','F':'Female','O':'Other'}" id="gender" headerKey="" headerValue="I am.." name="register.gender" label="Gender" required="true" ></s:select></td>
   		<td><s:fielderror><s:param>register.gender</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="email" >Email<span>*</span></label></td><td>:</td>
   		<td><s:textfield name="register.email" cssErrorClass="input-error" id="email" label="Email" labelposition="left"  javascriptTooltip="Email" placeholder="example@yousite.com"  required="true" ></s:textfield></td>
   		<td><s:fielderror><s:param>register.email</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="country" >Country<span>*</span></label></td><td>:</td>
   		<td><s:select  list="country" id="country"  listKey="id" cssErrorClass="input-error" listValue="name" headerKey="" headerValue="I Live.." name="register.country" label="Country"></s:select></td>
   		<td><s:fielderror><s:param>register.country</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td><label for="state" >State</label></td><td>:</td>
   		<td><s:textfield id="state" name="register.state" cssErrorClass="input-error" label="State" labelposition="left" ></s:textfield></td>
   		<td><s:fielderror><s:param>register.state</s:param> </s:fielderror></td>
   </tr>
   <tr>
   		<td colspan="3"><captcha:image label="Captcha"   /></td>
   </tr>
     <tr>
   		<td colspan="3"><s:fielderror><s:param>jCaptchaResponse</s:param> </s:fielderror></td>
   </tr>
   <tr><td>&nbsp;</td></tr>
   <tr>
   		<td colspan="3"><s:submit value="Register"></s:submit></td>
   </tr>
 
   </table>   
   </s:form>
   </fieldset>
  </body>
</html>