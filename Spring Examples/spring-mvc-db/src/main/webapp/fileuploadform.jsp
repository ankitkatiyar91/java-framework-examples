<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File Using Spring</title>
</head>
<body>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Please upload a file</h1>

	<c:url value="/file/upload" var="up"></c:url>
	<form:form method="POST" action="${up}" enctype="multipart/form-data">

		<form:errors path="*" cssClass="errorblock" element="div" />
 
		Please select a file to upload : <input type="file" name="file" />
		<input type="submit" value="upload" />
		<span><form:errors path="file" cssClass="error" /> </span>

	</form:form>
	
	<div>
	Uploaded File <c:out value="${file}"></c:out>
	
	<img height="200" width="200" alt='Unable to get Image' src="<c:url value="/images/${file}" ></c:url>">
	</div>
</body>
</html>