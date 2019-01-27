package mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;

public class EMail implements Runnable {
	
	private String to,bcc,cc;
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}

	private String subject;
	private String body;
	
	
	public static Properties getProperties() {
		return properties;
	}
	public static void setProperties(Properties properties) {
		EMail.properties = properties;
	}
	public static Session getSession() {
		return session;
	}
	public static void setSession(Session session) {
		EMail.session = session;
	}

	static Properties properties = new Properties();
	static Session session;
	   static
	   {
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	      session = Session.getDefaultInstance(properties,  
		          new javax.mail.Authenticator() {
		          protected PasswordAuthentication 
		          getPasswordAuthentication() {
		          return new 
		          PasswordAuthentication("ksindocorp@gmail.com", "ks@123456");
		          }}); 
	   }
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}


	public void sendMail()
	{
		Thread t=new Thread(this);
		System.out.println("sendmail calll");
		t.start();
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		try
		{
			
		       Message message = new MimeMessage(session);
		      
		       BodyPart messageBodyPart = new MimeBodyPart();
		       messageBodyPart.setContent(body, "text/html");
		       MimeMultipart multipart = new MimeMultipart("related");
		       multipart.addBodyPart(messageBodyPart);
		       message.setHeader("KS INFO CORP", "KS INFO System");
		       message.setDescription("KS Info System");
		       message.setFrom(new InternetAddress("ksindocorp@gmail.com"));
		       System.out.println("bcc---"+bcc);
		       if(bcc!=null && !bcc.equalsIgnoreCase(" ") && bcc.length()<=0)
		       {
		    	   message.setRecipients(Message.RecipientType.BCC, 
		 		          InternetAddress.parse(bcc));
		       System.out.println("bcc set");
		       }
		       System.out.println("cc"+cc);
		       if(cc!=null && !cc.equalsIgnoreCase(" ") &&cc.length()<=0)
		       {
		    	   message.setRecipients(Message.RecipientType.CC, 
		 		          InternetAddress.parse(cc));
		       System.out.println("cc set");
		       }
		       message.setRecipients(Message.RecipientType.TO, 
		          InternetAddress.parse(to));
		       message.setSubject(subject);
		       message.setContent(multipart);
		       Transport.send(message);
		      System.out.println("transported successfully");
		    }
		    catch(Exception e)
		    {
		       
		       e.printStackTrace();
		    }
		
	}
	}
