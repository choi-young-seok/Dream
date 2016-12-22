package kr.co.dream.user.join.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.dream.user.join.service.JoinService;

@Controller
public class JoinController {
	
	@Inject
	private JoinService service;
	
	@RequestMapping("/")
	public String main(){
		return "index";
	}

}
