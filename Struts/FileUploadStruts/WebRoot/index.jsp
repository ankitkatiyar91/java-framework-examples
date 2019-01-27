<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
  	int i=0;
   %>
    This is my JSP page. <br>
    <form action="fileupload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br />
    <input type="text" value="<%=i %>"> 
    <input type="submit" value="Submit">
    </form>
  </body>
</html>
