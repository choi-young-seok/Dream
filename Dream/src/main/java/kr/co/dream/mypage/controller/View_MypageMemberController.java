package kr.co.dream.mypage.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.co.dream.member.service.MemberService;

@Controller
public class View_MypageMemberController {

	@Inject
	private MemberService service;
	
	@RequestMapping("/mypage_member_info")
	public String mypage_member_info(int member_no,Model model){
		System.out.println("MemberViewController \tmemberInfoView() \t[input value] : " +member_no);
		model.addAttribute("member",service.memberInfo(member_no));
		return "mypage/member/member_info";
	}
	
	@RequestMapping(value = "/mypage_member_password_update")
	public String mypage_member_password_update(){
		return "mypage/member/member_password_update";
	}
	
	@RequestMapping(value = "/mypage_member_withdraw")
	public String mypage_member_withdraw(){
		return "mypage/member/member_withdraw";
	}
	
}
