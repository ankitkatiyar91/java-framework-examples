<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>

<h1>Available Users</h1>

<s:actionerror/>
<s:actionmessage/>

<s:url var="addForm" action="addForm" namespace="/"	forceAddSchemeHostAndPort="true"></s:url>
<s:url var="listUsers" action="listUsers" namespace="/"		forceAddSchemeHostAndPort="true"></s:url>
<s:url var="userDeatils" action="userDetails" namespace="/"		forceAddSchemeHostAndPort="true"></s:url>
	<a href="${addForm}">Add User</a>&nbsp; &nbsp;&nbsp;&nbsp;
	<a href="${listUsers}">Refresh List</a><br><br>
	
	
	
<c:if test="${users!=null}">
	<table bgcolor="#E7EFF0"  border="1" style="text-align: left;">
	<tr><th>#</th><th>Name</th><th>Email</th><th>Details</th></tr>
		<c:forEach items="${users}" var="user" >
			<tr><th><c:out value="${user.id}"></c:out></th><td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.email}"></c:out></td>
			<td><a href='<c:out value="${userDeatils}" />?id=${user.id}' ><img alt="i" height="20" title="Deatils" align="right" width="20" src="./images/details.png"> </a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>