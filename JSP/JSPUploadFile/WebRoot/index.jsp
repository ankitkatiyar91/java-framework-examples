<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page  
import="java.io.*,javax.servlet.http.HttpServletRequest,javax.servlet.ServletInputStream" %>
<html><head></head><body>
<form method="post" action="upload1.jsp" name="upform"  
enctype="multipart/form-data">  
  <table width="60%" border="0" cellspacing="1" cellpadding="1"  
align="center" class="style1">  
    <tr>  
      <td align="left"><b>Select a file to upload :</b></td>  
    </tr>  
    <tr>  
      <td align="left">  
        <input type="file" name="uploadfile" size="50">
        <input type="text" name="km" id="km" value="K.M.Raj">  
        </td>  
    </tr>  
    <tr>  
      <td align="left">  
  <input type="hidden" name="todo" value="upload">  
        <input type="submit" name="Submit" value="Upload">  
        <input type="reset" name="Reset" value="Cancel">  
        </td>  
    </tr>  
  </table>  
</form>  
</body>  
</html>  