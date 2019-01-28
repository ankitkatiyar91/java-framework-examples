<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User-<c:out value="${user.name}"></c:out></title>
</head>
<body>
	<c:url value="/form/showForm" var="back" ></c:url>
	<c:choose>
		<c:when test="${user!=null}">
			<br>
			<fieldset>
				<legend>User Added</legend>

				Name:-
				<c:out value="${user.name}"></c:out>
				<br> Email:-
				<c:out value="${user.email}"></c:out>
				<br> Does:-
				<c:out value="${user.job}"></c:out>
				<br> Birth Day:-
				<fmt:formatDate value="${user.dob}" pattern="dd-MMMM-yyyy" />
				<br>

			</fieldset>
		</c:when>
		<c:otherwise>
	No User Added
	</c:otherwise>
	</c:choose>
	
	<a href="${back}" >Back</a>
</body>
</html>