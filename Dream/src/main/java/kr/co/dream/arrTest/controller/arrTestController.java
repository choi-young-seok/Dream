package kr.co.dream.arrTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class arrTestController {

	@RequestMapping("/arrTest")
	public String arrTest(){
		return "z_nonUsing/test";
	}
	
}
