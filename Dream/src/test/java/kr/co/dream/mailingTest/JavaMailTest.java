package kr.co.dream.mailingTest;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class JavaMailTest {

	@Inject
	private JavaMailSender mailSender;
	
	private String from = "dreamupfunding@gmail.com";
	private String to = "rcn115@naver.com";
	private String subject = "Mailing Test : 메일인증 제목 Test";
	private String content = "Mailing Test : 메일인증 내용 Test";
	
	// @Inject
	// private JoinDAO dao;

	@Test
	public void simpleMailMessageTest() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject+" <SimpleMailMessage>");
		message.setText(content+" <SimpleMailMessage>");

		mailSender.send(message);
	}

	// @Test
	public void mimeMessageTest() {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			message.setFrom(new InternetAddress(from));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setContent(content,"text/html;charset=UTF-8");
			mailSender.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
