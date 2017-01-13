package kr.co.dream.member.join.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import kr.co.dream.member.join.service.JoinService;

@Controller
public class JoinController {
	
	@Inject
	private JoinService service;
	
	@RequestMapping("/")
	public String main(){
		return "mainView/mainBody";
	}
	
	@RequestMapping("/memberJoinForm")
	public String memberJoinForm(){
		System.out.println("JoinController [memberJoinForm() 회원가입 화면 요청 ] ");
		return "member/joinForm";
	}
}
