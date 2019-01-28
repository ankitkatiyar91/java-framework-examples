<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h2>User Details</h2>
<br>
<s:actionerror/>
<s:actionmessage/>
<br>
<c:if test="${user!=null}">
<table bgcolor="#E7EFF0"  border="1" style="text-align: left;" >
<tr><th>#</th><td><c:out value="${user.id}"></c:out></td></tr>
<tr><th>Name</th><td><c:out value="${user.name}"></c:out></td></tr>
<tr><th>Email</th><td><c:out value="${user.email}"></c:out></td></tr>
<tr><th>Job Description</th><td><c:out value="${user.job}"></c:out></td></tr>
<tr><th>Birthday</th><td><c:out value="${user.dob}"></c:out></td></tr>
<tr><th colspan="2" align="center" >
<s:url action="deleteUser" forceAddSchemeHostAndPort="true" var="deleteUser" >
	<s:param name="id" value="%{user.id}" ></s:param>
</s:url>
<a href="${deleteUser}"  onclick="return confirm('Are you sure.?');" ><img  align="middle" height="30" width="20" alt="Delete" title="Delete" src="./images/delete.png"> </a>
</th></tr>
</table>
</c:if>
<s:url var="listUsers" action="listUsers" forceAddSchemeHostAndPort="true" namespace="/" ></s:url>
<a href="${listUsers}" >Back</a>
</body>
</html>