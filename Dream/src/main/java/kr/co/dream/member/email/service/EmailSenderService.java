package kr.co.dream.member.email.service;

import kr.co.dream.member.email.domain.EmailForm;

public interface EmailSenderService {

	public int emailSender(EmailForm emailForm);
}
