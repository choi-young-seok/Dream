package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.service.MemberService;

@RestController
public class MemberRestController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ResponseEntity<String> memberJoin(@RequestBody MemberVO member) {
		System.out.println("MemberRestController [memberJoin() ȸ������ ] : " + member.toStringJoinMember());

		ResponseEntity<String> entity = null;

		try {
			service.memberJoin(member);
			System.err.println("MemberRestController [mebmerJoin()] : ȸ������ �Ϸ�");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("MemberRestController [memberJoin()] : ȸ������ ����");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/idDuplicationCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idDuplicationCheck(String member_authMail) {
		System.out.println("MemberRestController [idDuplicationCheck() input value] : " + member_authMail);
		ResponseEntity<String> entity = null;
		
		if (member_authMail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_authMail)) {
			System.err.println("MemberRestController [idDuplicationCheck()] : ��� ����");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.err.println("MemberRestController [idDuplicationCheck()] : ��� �Ұ���");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		}
	}
	
	@RequestMapping("/checkMemberMail")
	public ResponseEntity<String> checkMemberMail(String member_mail){
		ResponseEntity<String> entity = null;
		System.out.println("Controller checkMemberMail() input value : " + member_mail);
		if (member_mail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_mail)) {
			System.err.println("MemberRestController [checkMemberMail()] : ���̵� ����ġ");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		} else {
			System.err.println("MemberRestController [checkMemberMail()] : ���̵� ��ġ");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}
		
	}
	
	@RequestMapping("/findPass")
	public ResponseEntity<String> findPass(@RequestBody MemberVO member){
		System.out.println("MemberRestController findPass() input value : " + member.toStringLogin());
		ResponseEntity<String> entity = null;
		
		if(service.findPass(member) > 0){
			System.err.println("MemberRestController [findPass()] : ��й�ȣ ���� �Ϸ�");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}else{
			System.err.println("MemberRestController [checkMemberMail()] : ��й�ȣ ���� ����");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);			
		}
		
		return entity;
	}
	
}
