<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error in Application </title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1>Error Page</h1>
	<p>Application has encountered an error. Please contact support on
		...</p>


	Failed URL: ${url} Exception: ${exception.message}
	<c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>

</body>
</html>