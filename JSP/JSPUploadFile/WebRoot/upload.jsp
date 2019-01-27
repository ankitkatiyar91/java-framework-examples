<%@ page  
import="java.io.*,javax.servlet.http.HttpServletRequest,javax.servlet.ServletInputStream" %>  
<%@ page import="java.io.FileWriter,java.io.IOException" %>  
<%  
 String savePath = "", filepath = "", filename = "";  
 String contentType = "", fileData = "", strLocalFileName = "";  
 int startPos = 0;  
 int endPos = 0;  
%>  
<%!  
 //copy specified number of bytes from main data buffer to temp data buffer  
 void copyByte(byte[] fromBytes, byte[] toBytes, int start, int len)  
 {  
  for(int i=start;i<(start+len);i++)  
  {  
   //toBytes[i - start] = fromBytes;  
  }  
 }  
%>  
<%  
 int BOF = 0, EOF = 0;  
 contentType = request.getContentType();  
 out.println("<br>Content type is :: " +contentType);  
 if ((contentType != null) && (contentType.indexOf("multipart/form-data") >=  
0))  
 {  
  DataInputStream in = new DataInputStream(request.getInputStream());  
  DataInputStream in1 = in;  
  int formDataLength = request.getContentLength();  
  byte dataBytes[] = new byte[formDataLength];  
  int byteRead = 0;  
  int totalBytesRead = 0;  
  while (totalBytesRead < formDataLength)  
  {  
   byteRead = in1.read(dataBytes, totalBytesRead, formDataLength);  
   totalBytesRead += byteRead;  
  }  
  out.println("<br>totalBytesRead : " + totalBytesRead + "    : formDataLength = " + formDataLength);  
  
  //String file = new String(dataBytes);  
  //out.println("<br>File  
//Contents:<br>////////////////////////////////////<br>" + file +  
//"<br>////////////////////////////////<br>");  
  
  byte[] line = new byte[128];  
  if (totalBytesRead < 3)  
  {  
    return; //exit if file length is not sufficiently large  
  }  
  
  String boundary = "";  
  String s = "";  
  int count = 0;  
  int pos = 0;  
  
  //loop for extracting boundry of file  
  //could also be extracted from request.getContentType()  
  do  
  {  
   copyByte(dataBytes, line, count ,1); //read 1 byte at a time  
   count+=1;  
   s = new String(line, 0, 1);  
   fileData = fileData + s;  
   pos = fileData.indexOf("Content-Disposition: form-data; name=\""); 
   //set the file name  
   if(pos != -1)  
    endPos = pos;  
  }while(pos == -1);  
  boundary = fileData.substring(startPos, endPos);  
  
  //loop for extracting filename  
  startPos = endPos;  
  do  
  {  
   copyByte(dataBytes, line, count ,1); //read 1 byte at a time  
   count+=1;  
   s = new String(line, 0, 1);  
   fileData = fileData + s;  
   pos = fileData.indexOf("filename=\"", startPos); //set the file name  
   if(pos != -1)  
    startPos = pos;  
  }while(pos == -1);  
  do  
  {  
   copyByte(dataBytes, line, count ,1); //read 1 byte at a time  
   count+=1;  
   s = new String(line, 0, 1);  
   fileData = fileData + s;  
   pos = fileData.indexOf("Content-Type: ", startPos);  
   if(pos != -1)  
    endPos = pos;  
  }while(pos == -1);  
  filename = fileData.substring(startPos + 10, endPos - 3); 
  //to eliminate " from start & end  
  strLocalFileName = filename;  
  int index = filename.lastIndexOf("\\");  
  if(index != -1)  
   filename = filename.substring(index + 1);  
  else  
   filename = filename;  
  
  //loop for extracting ContentType  
  boolean blnNewlnFlag = false;  
  startPos = endPos; //added length of "Content-Type: "  
  do  
  {  
   copyByte(dataBytes, line, count ,1); //read 1 byte at a time  
   count+=1;  
   s = new String(line, 0, 1);  
   fileData = fileData + s;  
   pos = fileData.indexOf("\n", startPos);  
   if(pos != -1)  
   {  
    if(blnNewlnFlag == true)  
     endPos = pos;  
    else  
    {  
     blnNewlnFlag = true;  
     pos = -1;  
    }  
   }  
  }while(pos == -1);  
  contentType = fileData.substring(startPos + 14, endPos);  
  
  //loop for extracting actual file data (any type of file)  
  startPos = count + 1;  
  do  
  {  
   copyByte(dataBytes, line, count ,1); //read 1 byte at a time  
   count+=1;  
   s = new String(line, 0, 1);  
   fileData = fileData + s;  
   pos = fileData.indexOf(boundary, startPos); 
   //check for end of file data  i.e boundry value  
  }while(pos == -1);  
  endPos = count - boundary.length();  
  //file data extracted  
  
  out.println("<br><br>0. Local File Name = " + strLocalFileName);  
  out.println("<br><br>1. filename = " + filename);  
  out.println("<br>2. contentType = " + contentType);  
  out.println("<br>3. startPos = " + startPos);  
  out.println("<br>4. endPos = " + endPos);  
  out.println("<br>5. boundary = " + boundary);  
  
  //create destination path & save file there  
  String appPath = application.getRealPath("/");  
  out.println("<br>appPath : " + appPath);  
  String destFolder = appPath + "images/banner/";  
  filename= destFolder + filename;  
  FileOutputStream fileOut = new FileOutputStream(filename);  
  fileOut.write(dataBytes, startPos, (endPos - startPos));  
  fileOut.flush();  
  fileOut.close();  
  out.println("<br>File saved as >> " + filename);  
  //file saved at destination  
  //out.println("<br>File data : <br><br>**************************<br>" +  
//(new String(dataBytes,startPos, (endPos - startPos))) +  "<br><br>**************************");  
 }  
 else  
 {  
  out.println("Error in uploading ");  
 }  
  
%>  