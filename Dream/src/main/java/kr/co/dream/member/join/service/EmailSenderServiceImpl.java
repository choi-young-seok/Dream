package kr.co.dream.member.join.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	@Inject
	private MailSender mailSender;
	
	@Inject
	private SimpleMailMessage message;
	
	private String mailSubject = "DreamUp 회원가입 인증 메일입니다.";
	
	public String mailContent(int authRanNum){
		return "회원가입 인증번호는["+authRanNum+"]입니다";
	}
	@Override
	public void EmailSender(String member_mail) {
		
		message.setTo("rcn115@naver.com");
		int authRanNum = new Random().nextInt(5);
		message.setText(mailContent(authRanNum));
		this.mailSender.send(message);
		
		
//		MimeMessage message = mailSender.createMimeMessage();
//		try {
//			message.setFrom(new InternetAddress("dreamupfunding@gmail.com"));
//			message.addRecipient(RecipientType.TO, new InternetAddress("rcn115@naver.com"));
//			message.setSubject(mailSubject);
//			
//			Random authRanNum = new Random(5);
//			message.setText(mailContent(authRanNum),"utf-8","html");
//			
//			mailSender.send(message);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
