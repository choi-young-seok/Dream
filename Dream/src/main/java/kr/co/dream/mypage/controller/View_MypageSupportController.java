package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageSupportController {

	@RequestMapping("/mypage_support")
	public String mypage_support(){
		System.out.println("View_MypageSupportController \tsupport");
		return "mypage/support/support_info";
	}
}
