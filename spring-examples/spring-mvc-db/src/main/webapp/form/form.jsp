<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<c:url value="/form/sayHello" var="hello"></c:url>
	<c:out value="${name}"></c:out>
	<form action="${hello}" method="get">
	Name:-	<input type="text" name="name"> <input type="submit">
	</form>
	
	<br>
	<br>
	<fieldset>
	<c:url value="/form/addUser" var="addUser"></c:url>
	<%-- <form:errors></form:errors>
		<form action="addUser" method="post" >
		Name:-<input type="text" name="name" ><br>
		<form:errors  path="name" ></form:errors>
		<form:errors path="name" cssclass="error"></form:errors>
		Email:-<input type="text" name="email" ><br>
		Job:-<input type="text" name="job" ><br>
		DOB:	<input type="submit" value="Save User" >
	</form> --%>
	
	<form:form action="addUser" commandName="user" >
		Name:-<form:input path="name"  /><form:errors path="name" cssclass="error"></form:errors><br/>
		Email:-<form:input path="email"  /><form:errors path="email" cssclass="error"></form:errors><br/>
		JOB:-<form:input path="job"  /><form:errors path="job" cssclass="error"></form:errors><br/>
		DOB:-<form:input path="dob" placeholder="MM-DD-YYYY"  /><form:errors path="dob" cssclass="error"></form:errors><br/>
			<input type="submit" value="Save User" />
	</form:form>
	
	</fieldset>
</body>
</html>