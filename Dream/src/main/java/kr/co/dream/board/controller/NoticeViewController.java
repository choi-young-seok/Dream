package kr.co.dream.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeViewController {

	@RequestMapping("/notice")
	public String noticeView(){
		return "board/notice";
	}
}
