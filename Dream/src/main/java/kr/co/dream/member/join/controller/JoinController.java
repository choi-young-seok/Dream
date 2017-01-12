package kr.co.dream.member.join.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.member.join.service.JoinService;

@Controller
public class JoinController {
	
	@Inject
	private JoinService service;
	
	@RequestMapping("/")
	public String main(){
		return "mainView/mainBody";
	}
	
	@RequestMapping("/memberJoinForm")
	public String memberJoinForm(){
		System.out.println("ȸ������ ȭ�� ��û");
		return "member/joinForm";
	}
}
