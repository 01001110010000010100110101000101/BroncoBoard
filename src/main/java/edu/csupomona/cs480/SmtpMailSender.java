package edu.csupomona.cs480;

import java.security.NoSuchAlgorithmException;
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
	
	//to subject and link
	public void sendMail(String to,String subject,String text) throws MessagingException, NoSuchAlgorithmException{
		String link = "http://www.broncoboard.me/success/";
		String hash = MD5.hash(to);// This need to be stored in DB for verification purpose
		MimeMessage message =mailsender.createMimeMessage();
		link += MD5.hash(to);
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		link +=hash;
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText("Click here to activate your account\n" + link  );

		mailsender.send(message);
	}
	
}
