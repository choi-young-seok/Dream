package kr.co.dream.mypage.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.co.dream.member.service.MemberService;

@Controller
public class MypageMemeberViewController {

	@Inject
	private MemberService service;
	
	@RequestMapping("/memberInfoView")
	public String memberInfoView(int member_no,Model model){
		System.err.println("MemberViewController \tmemberInfoView() \t[사용자 정보 화면 요청] ");
		System.out.println("MemberViewController \tmemberInfoView() \t[input value] : " +member_no);
		model.addAttribute("member",service.memberInfo(member_no));
		return "mypage/member/infoView";
	}
	
	@RequestMapping(value = "/password_Info_Edit_View")
	public String password_Info_Edit_Tab(int member_no){
		return "mypage/member/password_Edit";
	}
	
	@RequestMapping(value = "address_Info_View")
	public String address_info_view(int member_no, Model model){
//		model.addAttribute("memberAddressInfo",service.get_memberAddress(member_no));
		return "mypage/member/address_Info";
	}
	
	@RequestMapping(value = "address_Info_Insert_View")
	public String address_info_insert_view(int member_no, Model model){
		return "mypage/member/address_Info_Insert_View";
	}
	
	
}
