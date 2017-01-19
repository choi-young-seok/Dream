package kr.co.dream.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FAQViewController {

	@RequestMapping("/faq")
	public String faq(){
		return "board/faq";
	}
}
