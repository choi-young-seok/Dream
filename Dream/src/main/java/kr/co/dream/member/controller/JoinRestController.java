package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.service.JoinService;

@RestController
public class JoinRestController {
	
	@Inject
	private JoinService service;
	
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public String memberJoin(@RequestBody MemberVO member){
		System.out.println("JoinRestController [memberJoin() 회원가입 ] : " + member.toStringJoinMember());
		service.memberJoin(member);
		return "success";
	}
}
 