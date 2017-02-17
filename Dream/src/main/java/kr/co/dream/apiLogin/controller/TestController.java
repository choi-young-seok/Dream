package kr.co.dream.apiLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test")
	public void test(){
		System.out.println("테스트 페이지");
	}
	
}
