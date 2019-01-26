<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new User</title>
</head>
<body>
	<h2>Add a new User</h2>


	<s:form action="addUser" namespace="/" name="user" labelSeparator=":-" >
		<s:actionerror />
		<s:actionmessage />
		<s:textfield name="user.name" label="Name"></s:textfield>
		<s:textfield name="user.email" label="Email"></s:textfield>
		<s:textfield name="user.job" label="Job Description"></s:textfield>
		<sx:datetimepicker name="user.dob" label="Birthday"
			formatLength="medium" displayFormat="dd-MM-yyyy" type="date"></sx:datetimepicker>
		<s:submit value="Add User"></s:submit>
	</s:form>
	
	<s:url var="listUsers" action="listUsers" namespace="/"
		forceAddSchemeHostAndPort="true"></s:url>
		<br><a href="${listUsers}" >Back</a>
</body>
</html>