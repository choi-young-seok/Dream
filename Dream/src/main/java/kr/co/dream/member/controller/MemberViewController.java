package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println("MemberViewController [memberJoinForm() 회원가입 화면 요청 ] ");
		return "member/joinForm";
	}
	
	@RequestMapping("/memberInfoView")
	public String memberInfoView(String member_mail,Model model){
		System.out.println("MemberViewController [memberJoinForm() 사용자 정보 화면 요청 ] ");
		System.out.println("MemberViewController [memberJoinForm() input value ] : " +member_mail);
		model.addAttribute("member",service.memberInfo(member_mail));
		return "member/infoView";
	}
	
	@RequestMapping("/findLoginInfo")
	public String findLoginInfo(){
		return "member/findView";
	}

}
