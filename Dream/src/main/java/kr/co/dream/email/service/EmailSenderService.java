package kr.co.dream.email.service;

import javax.mail.MessagingException;

import kr.co.dream.email.domain.EmailForm;

public interface EmailSenderService {

	public int emailSender(EmailForm emailForm) throws MessagingException;
}
