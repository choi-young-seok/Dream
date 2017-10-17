package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageMainController {
	
	//마이페이지 : 메인화면 요청
	@RequestMapping(value = "/mypage")
	public String mypageMainView() {
		System.out.println("View_MypageMainController \tmypageMainView");
		return "mypage/mypage_main";
	}

}
