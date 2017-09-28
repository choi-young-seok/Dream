package kr.co.dream.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View_MypageSupportController {

	
	@RequestMapping("/mypage_support_info_view")
	public String mypage_support_info_view(int member_no){
		System.out.println(member_no);
		return "mypage/support/mySupport";
	}
}
