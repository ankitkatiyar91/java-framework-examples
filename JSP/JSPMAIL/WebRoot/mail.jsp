<%@ page import="java.lang.*,java.util.*,javax.mail.*,javax.mail.internet.*,javax.activation.*" %>
<%@page import="javax.swing.text.PasswordView"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%
String p_to = "ankitkatiyar67@yahoo.com"; // Please fill in your email here
String p_from = "ankitkatiyar67@hotmail.com"; // Please fill in receipient’s email here
String p_subject = "Testing";
String p_message = "This is a test email";
String l_host = "smtp.gmail.com";
// Gets the System properties
Properties properties = new Properties();
// Puts the SMTP server name to properties object
 properties.put("mail.smtp.host", l_host);
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
// Get the default Session using Properties Object
Session l_session = Session.getInstance(properties,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
            return new 
            PasswordAuthentication("ankitkatiyar67@gmail.com","password");
            } 
			});
l_session.setDebug(false); // Enable the debug mode
try {
MimeMessage l_msg = new MimeMessage(l_session); // Create a New message
l_msg.setFrom(new InternetAddress(p_from)); // Set the From address
l_msg.setRecipients( Message.RecipientType.TO
, InternetAddress.parse(p_to, false));
l_msg.setSubject(p_subject); // Sets the Subject
// Create and fill the first message part
MimeBodyPart l_mbp = new MimeBodyPart();
l_mbp.setText(p_message);
// Create the Multipart and its parts to it
Multipart l_mp = new MimeMultipart();
l_mp.addBodyPart(l_mbp);
// Add the Multipart to the message
l_msg.setContent(l_mp);
// Set the Date: header
l_msg.setSentDate(new Date());
// Send the message

Transport.send(l_msg);
// If program reaches this point, then message is successfully sent.
out.print("Success");
} catch (MessagingException mex) { // Trap the MessagingException Error
out.print("Failure: Messaging Exception: " + mex);
} catch (Exception e) {
out.print("Failure: General Exception: " + e);
e.printStackTrace();
}
%>