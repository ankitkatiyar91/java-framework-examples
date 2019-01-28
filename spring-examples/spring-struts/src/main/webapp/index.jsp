<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<body>
	<h2>Hello World!</h2>
	<s:url var="addForm" action="addForm" namespace="/"
		forceAddSchemeHostAndPort="true"></s:url>
	<s:url var="listUsers" action="listUsers" namespace="/"
		forceAddSchemeHostAndPort="true"></s:url>
	<a href="${addForm}">Add User</a><br>
	<a href="${listUsers}">List Users</a>
</body>
</html>
