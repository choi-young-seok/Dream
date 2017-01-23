package kr.co.dream.apiLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APILogin {

	// @RequestMapping(value = "/naverLogin")
	// public String naverLogin(){
	// System.out.println("네이버 로그인 요청");
	// return "naverLogin/naverAPI";
	// }

	@RequestMapping(value = "/dragTest")
	public String naverLogin() {
		System.out.println("네이버 로그인 요청");
		return "member/dragTest";
	}

}
