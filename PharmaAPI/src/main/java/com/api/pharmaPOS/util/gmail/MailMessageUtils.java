package com.api.pharmaPOS.util.gmail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;

public class MailMessageUtils {

	// Return Multipart Object which holds mail body message and attachment files in
	// BodyParts
	public static Multipart messageMultipart(List<File> listOfFlies) throws MessagingException {

		// BodyPart to hold message body
		BodyPart messageBody = new MimeBodyPart();
		// Now set the actual message
		messageBody.setText("Hola, este es un ejemplo de envio de correo Gmail "
				+ "correo usando JavaMailAPI de GMAIL version 1.5.5 desde.. " + ConfigConsts.SMPT_HOST_NAME);

		// Multipart will hold messageBodyPart and attachments
		Multipart multipart = new MimeMultipart();

		// Add Message BodyPart to Multipart
		multipart.addBodyPart(messageBody);

		// Add Files to multipart
		addFileToMultipart(listOfFlies, multipart);

		return multipart;
	}

	// Adding attachment files to Multipart
	private static void addFileToMultipart(List<File> listOfFlies, Multipart multipart) {

		listOfFlies.stream().filter(file -> file.isFile()).forEach(f -> {
			try {
				multipart.addBodyPart(addAttachment(f));
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		});
	}

	private static MimeBodyPart addAttachment(File file) throws MessagingException {

		MimeBodyPart attachmentBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(file);
		attachmentBodyPart.setDataHandler(new DataHandler(source));
		attachmentBodyPart.setFileName(file.getName());

		return attachmentBodyPart;
	}
}
