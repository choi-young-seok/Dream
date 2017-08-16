package kr.co.dream.email.controller;

import javax.inject.Inject;
import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.email.domain.EmailForm;
import kr.co.dream.email.service.EmailSenderService;

@RestController
public class EmailAuthController {
	
	@Inject
	private EmailSenderService service;

	@RequestMapping("/authMailSender")
	public int authMailSender(@RequestBody EmailForm emailForm) throws MessagingException {
		System.err.println("EmailSenderController \tauthMail() \t\t[input value] : " + emailForm.toString());
		int authNum = service.emailSender(emailForm);
		if (authNum != 0) {
			return authNum;
		} else {
			return 0;
		}
	}// authMailSender
	
}
