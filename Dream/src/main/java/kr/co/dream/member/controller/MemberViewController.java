package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.member.service.MemberService;

@Controller
public class MemberViewController {

	@Inject
	private MemberService service;
	
	@RequestMapping("/")
	public String main(){
		return "mainView/mainBody";
	}
	
	@RequestMapping("/memberJoinForm")
	public String memberJoinForm(){
		System.out.println("JoinController [memberJoinForm() 회원가입 화면 요청 ] ");
		return "member/joinForm";
	}
}
