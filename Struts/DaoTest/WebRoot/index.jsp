<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
    <s:form method="get" action="log">
    <s:textfield name="user.uName" label="Name"></s:textfield>
    <s:textfield name="user.uSirname" label="Sir Name"></s:textfield>
    <s:submit value="Submit"></s:submit>
    </s:form>
  </body>
</html>
