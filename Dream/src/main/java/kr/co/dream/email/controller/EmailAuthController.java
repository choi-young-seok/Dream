package kr.co.dream.email.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.email.domain.EmailForm;
import kr.co.dream.email.service.EmailSenderService;

@RestController
public class EmailAuthController {
	
	@Inject
	private EmailSenderService service;

	@RequestMapping("/authMailSender")
	public int authMailSender(@RequestBody EmailForm emailForm) {
		System.err.println("EmailSenderController \tauthMail() \t\t[input value] : " + emailForm.toString());
		int authNum = service.emailSender(emailForm);
		if (authNum != 0) {
			return authNum;
		} else {
			return 0;
		}
	}// authMailSender
	
	//사용하지 않음
//	@RequestMapping(value = "authMailSuccess/{authOk}", method = RequestMethod.POST)
//	public ResponseEntity<String> authMailSuccess(@PathVariable("authOk") String authOk ){
//		
//		ResponseEntity<String> entity = null;
//		if(!authOk.equals("OK")){
//			entity = new ResponseEntity<>("OK",HttpStatus.OK);
//			return entity;
//		}else{
//			entity = new ResponseEntity<>("OK",HttpStatus.BAD_REQUEST);
//			return entity;
//		}
//	}
}
