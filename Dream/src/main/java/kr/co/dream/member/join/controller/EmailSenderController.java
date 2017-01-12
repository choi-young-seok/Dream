package kr.co.dream.member.join.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.join.service.EmailSenderService;

@RestController
public class EmailSenderController {

	@Inject
	private EmailSenderService service;
	
	@RequestMapping("/authMail")
	public String authMail(String member_mail){
		System.out.println(member_mail);
		service.EmailSender(member_mail);
		
		return null;	
	}
}
