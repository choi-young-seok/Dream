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
			System.err.println("EamilSenderServiceImpl \temailSender() \t\t[발급 인증번호] : " + emailForm.getAuthNum());
			this.mailSender.send(message);
			return emailForm.getAuthNum();
		} catch (MailException e) {
			System.err.println("EamilSenderServiceImpl \temailSender() \t\t[메일발송 실패] : 올바르지 않은 주소값");
			e.printStackTrace();
			return 0;
		}
	}

}
