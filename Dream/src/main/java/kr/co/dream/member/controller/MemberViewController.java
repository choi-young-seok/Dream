package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.member.domain.MemberVO;
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
		System.err.println("MemberViewController \tmemberJoinForm() \t[회원가입 화면 요청] ");
		return "mypage/member/joinForm";
	}

	@RequestMapping("/findLoginInfo")
	public String findLoginInfo(){
		System.err.println("MemberViewController \tmemberJoinForm() \t[아이디 / 비밀번호 찾기 화면 요청] ");
		return "mypage/member/findView";
	}
}
