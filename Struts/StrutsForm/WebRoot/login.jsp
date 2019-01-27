<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>    
    <title>Login</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/login-form.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script type="text/javascript">
	
function readCookie(name)
{
  var cookieValue = "";
  var search = name + "=";
  if(document.cookie.length > 0)
  { 
    offset = document.cookie.indexOf(search);
    if (offset != -1)
    { 
      offset += search.length;
      end = document.cookie.indexOf(";", offset);
      if (end == -1) end = document.cookie.length;
      cookieValue = unescape(document.cookie.substring(offset, end))
    }
  }
  //alert(cookieValue);
	document.forms["login"]["login.username"].value=cookieValue;
}
	</script>
  </head>
  <body onload="readCookie('ank')">
  <div id="login">
  <s:form method="POST" name="login" tooltipIconPath="images/info-icon.png" action="userlogin" cssClass="login-form" cssErrorClass="login-from-error">
  	<table>
  	<tr>
  	<td><label for="username" >Username</label> </td>
  	<td><s:textfield id="username"  cssErrorClass="input-error" tooltip="Enter your Username provided during registration" label="Username"  labelposition="left"  name="login.username" required="true" title="Enter Username" placeholder="Username" tooltipDelay="0" ></s:textfield></td>
  	<td>
  	<s:fielderror><s:param>login.username</s:param> </s:fielderror>
  	</td></tr>
  	<tr>
  	<td><label for="password" >Password</label> </td>
  	<td><s:password cssErrorClass="input-error" id="password" tooltip="Enter Password" label="Password" name="login.password" required="true" title="Enter Password" placeholder="Password" ></s:password></td>
  	<td>
  	<s:fielderror><s:param>login.password</s:param> </s:fielderror>
  	</td></tr>
  	<tr>
  	<td><s:checkbox name="login.remember" id="remember"  label="Remember Me" labelposition="right" tooltipIconPath="images/info-icon.png" tooltip="Mark to keep logged in until u logout" ></s:checkbox></td>
  	<td>
  	<label for="remember">Remember me</label>
  	</td>
  	</tr>
  	</table>
	  
	  
	  
	  <s:submit value="Login"  ></s:submit>
  </s:form>
   </div>
  </body>
</html>