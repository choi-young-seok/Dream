package kr.co.dream.email.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.dream.email.domain.EmailForm;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Inject
	private MailSender mailSender;

	@Inject
	private SimpleMailMessage message;

	@Override
	public int emailSender(EmailForm emailForm) {

		try {
			message.setTo(emailForm.getMember_authMail());
			message.setText(emailForm.mailContent(emailForm.getMember_name()));
			System.out.println("EamilSenderServiceImpl [emailSender() authNum] : " + emailForm.getAuthNum());
			this.mailSender.send(message);
			return emailForm.getAuthNum();
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
