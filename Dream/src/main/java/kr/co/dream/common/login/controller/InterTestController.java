package kr.co.dream.common.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterTestController {

	@RequestMapping(value = "/doA", method = RequestMethod.POST)
	public String doA(Model model) {
		System.out.println("DO A");
		model.addAttribute("msg","message");
		return "interTest";
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB(Model model, HttpServletRequest request) {
		System.out.println("DO B");
		System.out.println("ø‰√ª∏Ì : " + request.getRequestURI());
		model.addAttribute("result","DO B");
		return "interTest";
	}
}
