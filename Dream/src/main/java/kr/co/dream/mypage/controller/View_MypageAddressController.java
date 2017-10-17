package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageAddressController {

	//마이페이지 : 회원 주소지 목록 화면 출력
	@RequestMapping(value = "/mypage_address")
	public String mypage_address(){
		System.out.println("View_MypageAddressController \tmypage_address");
		return "mypage/address/address_info";
	}
	
	//마이페이지 : 회원 주소지 정보 추가 화면 이동
	@RequestMapping(value = "/mypage_address_insert")
	public String mypage_address_insert(){
		System.out.println("View_MypageAddressController \tmypage_address_insert");
		return "mypage/address/address_info_insert";
	}
}
