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
		System.out.println("JoinRestController [memberJoin() 회원가입 ] : " + member.toStringJoinMember());

		ResponseEntity<String> entity = null;

		try {
			service.memberJoin(member);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/idDuplicationCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idDuplicationCheck(String member_authMail) {
		System.out.println("Controller idDuplicationCheck() input value : " + member_authMail);
		ResponseEntity<String> entity = null;
		
		if (member_authMail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_authMail)) {
			System.out.println("Controller [idDuplicationCheck()] : 사용 가능");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("Controller [idDuplicationCheck()] : 사용 불가능");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		}
	}
}
