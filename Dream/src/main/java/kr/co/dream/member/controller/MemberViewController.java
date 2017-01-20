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
		System.err.println("MemberViewController \tmemberJoinForm() \t[ȸ������ ȭ�� ��û] ");
		return "member/joinForm";
	}
	
	@RequestMapping("/memberInfoView")
	public String memberInfoView(int member_no,Model model){
		System.err.println("MemberViewController \tmemberInfoView() \t[����� ���� ȭ�� ��û] ");
		System.out.println("MemberViewController \tmemberInfoView() \t[input value] : " +member_no);
		model.addAttribute("member",service.memberInfo(member_no));
		return "member/infoView";
	}
	
	@RequestMapping("/findLoginInfo")
	public String findLoginInfo(){
		System.err.println("MemberViewController \tmemberJoinForm() \t[���̵� / ��й�ȣ ã�� ȭ�� ��û] ");
		return "member/findView";
	}

}
