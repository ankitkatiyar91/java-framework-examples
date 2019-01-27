<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page  
import="java.io.*,javax.servlet.http.HttpServletRequest,javax.servlet.ServletInputStream, java.awt.*, java.awt.image.*,javax.imageio.ImageIO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>

<%
String path=request.getRealPath("");
out.println("path=-->"+path+"\\img");
String contentType = request.getContentType();
//String f = request.getParameter("uploadfile");
//out.println(f);
//String str = request.getParameter("km");
//out.println(contentType);
//File temp = File.createTempFile(f,""); 
//String st = ""+temp;
String outputPath = path+"\\img\\";
try
{
out.println("Content type is :: " +contentType);
if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
DataInputStream in = new DataInputStream(request.getInputStream());
int formDataLength = request.getContentLength();

byte dataBytes[] = new byte[formDataLength];
int byteRead = 0;
int totalBytesRead = 0;
while (totalBytesRead < formDataLength) {
byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
totalBytesRead += byteRead;
}

String file = new String(dataBytes);
String saveFile = file.substring(file.indexOf("filename=\"") + 10);

saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

//out.print(dataBytes);

int lastIndex = contentType.lastIndexOf("=");
String boundary = contentType.substring(lastIndex + 1,contentType.length());
//out.println(boundary);
int pos;
pos = file.indexOf("filename=\"");

pos = file.indexOf("\n", pos) + 1;

pos = file.indexOf("\n", pos) + 1;

pos = file.indexOf("\n", pos) + 1;


int boundaryLocation = file.indexOf(boundary, pos) - 4;
int startPos = ((file.substring(0, pos)).getBytes()).length;
int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
out.println("<br />"+saveFile);
FileOutputStream fileOut = new FileOutputStream(outputPath+saveFile);


//fileOut.write(dataBytes);
fileOut.write(dataBytes, startPos, (endPos - startPos));
fileOut.flush();
fileOut.close();

out.println("<br />File saved as " +saveFile);

}

	
//	String st = "krishan mohan raj";
	//String imgStr = st.substring(0,st.lastIndexOf("\\")+1)+f;
	//out.println("<img src=\""+imgStr+"\" /> test");
//BufferedImage originalImage = ImageIO.read(new File(""+temp));
//out.println(""+originalImage);
//ImageIO.write(originalImage, "jpg", new File("myr.jpg")); 
//int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
//out.println(" TYPE : "+type);
}
catch(Exception e)
{
	out.println(" ERROR : "+e);
}
//out.println("\nTemp file : "+ temp.getAbsolutePath());
//out.println(""+f);
/*
if ((contentType != null) && (contentType.indexOf("multipart/form-data") >=  
0))  
 {  
  DataInputStream in = new DataInputStream(request.getInputStream());  
  //out.println(""+in);
  int formDataLength = request.getContentLength();
  byte dataBytes[] = new byte[formDataLength];
  int byteRead = 0;
  int totalBytesRead = 0;
  while (totalBytesRead < formDataLength) {
  byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
  totalBytesRead += byteRead;
   
 }*/
%>

</body>
</html>