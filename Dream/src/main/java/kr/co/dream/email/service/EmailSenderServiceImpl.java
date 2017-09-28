package kr.co.dream.email.service;


import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.co.dream.email.domain.EmailForm;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

//	@Inject
//	private MailSender mailSender;
//
//	@Inject
//	private SimpleMailMessage message;
	
	@Inject
	private JavaMailSender mimeMailSender;

	@Override
	public int emailSender(EmailForm emailForm) throws MessagingException {

		try {
//			message.setTo(emailForm.getMember_authMail());
//			message.setText(emailForm.mailContent(emailForm.getMember_name()));
//			System.err.println("EamilSenderServiceImpl \temailSender() \t\t[�߱� ������ȣ] : " + emailForm.getAuthNum());
//			this.mailSender.send(message);
			
			MimeMessage message2 = mimeMailSender.createMimeMessage();
			message2.setSubject("DreamUp ȸ������ ���� �����Դϴ�.");
			message2.setText(emailForm.mailContent(emailForm.getMember_name()),"UTF-8","html");
			System.err.println("EamilSenderServiceImpl \temailSender() \t\t[�߱� ������ȣ] : " + emailForm.getAuthNum());
			message2.setFrom(new InternetAddress("mailingAuthTest@gmail.com"));
			message2.addRecipient(RecipientType.TO, new InternetAddress(emailForm.getMember_authMail()));
//			message2.addRecipient(RecipientType.TO, new InternetAddress("rcn115@naver.com"));
			this.mimeMailSender.send(message2);
			
			return emailForm.getAuthNum();
		} catch (MailException e) {
			System.err.println("EamilSenderServiceImpl \temailSender() \t\t[���Ϲ߼� ����] : �ùٸ��� ���� �ּҰ�");
			e.printStackTrace();
			return 0;
		}
	}

}
