package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.member.service.MemberService;

@Controller
public class MemberViewController {

	@RequestMapping("/")
	public String main() {
		return "mainView/mainBody";
	}
	
	@RequestMapping("/memberJoinForm")
	public String memberJoinForm(){
		System.err.println("MemberViewController \tmemberJoinForm() \t[ȸ������ ȭ�� ��û] ");
		System.out.println("������?");
		return "member/joinForm";
	}

	@RequestMapping("/findLoginInfo")
	public String findLoginInfo(){
		System.err.println("MemberViewController \tmemberJoinForm() \t[���̵� / ��й�ȣ ã�� ȭ�� ��û] ");
		return "member/findView";
	}
}
