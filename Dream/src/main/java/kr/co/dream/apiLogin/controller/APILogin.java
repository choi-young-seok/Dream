package kr.co.dream.apiLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APILogin {

	// @RequestMapping(value = "/naverLogin")
	// public String naverLogin(){
	// System.out.println("���̹� �α��� ��û");
	// return "naverLogin/naverAPI";
	// }

	@RequestMapping(value = "/dragTest")
	public String naverLogin() {
		System.out.println("���̹� �α��� ��û");
		return "member/dragTest";
	}

}
