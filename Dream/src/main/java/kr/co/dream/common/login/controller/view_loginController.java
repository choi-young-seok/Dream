package kr.co.dream.common.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class view_loginController {

	@RequestMapping("/login_view")
	public String login_view(){
		return "mainView/header";
	}
}
