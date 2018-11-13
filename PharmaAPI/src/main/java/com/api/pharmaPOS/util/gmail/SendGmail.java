package com.api.pharmaPOS.util.gmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGmail {
	final String from = "example@gmail.com";
	final String username = "example@gmail.com";
	final String password = "********";

	public String EnviarCorreoGmail(String to, String subject, String bodyText) {
		String send = "";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ConfigConsts.SMPT_HOST_ADDRESS);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", ConfigConsts.SMPT_HOST_ADDRESS);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
	         Message message = new MimeMessage(session);
	         
	         message.setFrom(new InternetAddress(from));
	         
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));
	         
	         message.setSubject(subject);
	         
	         message.setText(bodyText);
//	         String body="<h1 style=\"background-color: aqua\">Pharma POS</h1>"+
//	        		 	"<h3 style=\"background-color: royalblue\">Confirmaci�n de cuenta</h3>"+
//	        		 	"<p>Estimado usuario, este es su nuevo usuario: 4566365, y su comtrase�a: 45BjkloP. "+
//	        		 	"Puede cambiar su contrase�a para mayor seguridad.</p>";
//	         
//	         message.setContent(body,"text/HTML");
	         
	         Transport.send(message);

	         send="Mensaje enviado satisfactoriamente......desde GMAIL";

	      } catch (MessagingException e) {
	    	  send="ERROR! "+e.getMessage();
	            throw new RuntimeException(e);
	      }

		return send;
	}
}
