package edu.csupomona.cs480;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	@Autowired
	private JavaMailSender mailsender;
	
	
	public void sendMail(String to,String subject,String text) throws MessagingException{
		MimeMessage message =mailsender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(text);
		
		mailsender.send(message);
	}
	
}
