package com.api.pharmaPOS.util.gmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SendEmailWithAttachmentsTest {
	/*

	public static void main(String[] args) {
		
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", ConfigConsts.SMPT_HOST_ADDRESS);
	      props.put("mail.smtp.port", "587");
	      props.put("mail.smtp.ssl.trust", ConfigConsts.SMPT_HOST_ADDRESS);

	    
	      Session session = Session.getInstance(props,
	      new Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(ConfigConsts.USER_NAME_EMAIL, ConfigConsts.USER_PASSWORD);
	         }
	      });

	      
	      File filesInPath = new File(ConfigConsts.FILE_PATH);
	      List<File> listOfFlies = Arrays.asList(filesInPath.listFiles());

	      try {
	        
	         Message message = new MimeMessage(session);

	         message.setFrom(new InternetAddress(ConfigConsts.FROM_EMAIL_ADDRESS));

	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(ConfigConsts.TO_EMAIL_ADDRESS));

	         message.setSubject(ConfigConsts.SMPT_HOST_NAME + " - Prueba Email");

	         Multipart multipart = MailMessageUtils.messageMultipart(listOfFlies);

	         message.setContent(multipart );

	         Transport.send(message);

	         System.out.println("Mensaje enviado satisfactoriamente...desde "+ ConfigConsts.SMPT_HOST_NAME);

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	}
	*/

}
