package kr.co.dream.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QNAViewController {

	@RequestMapping("qna")
	public String qna(){
		return "board/qna";
	}
	
	@RequestMapping("qnaRegisterView")
	public String qnaRegister(){
		System.err.println("QNAViewCntroller \tqnaRegisterView() \t[문의하기 작성 화면 요청]");
		return "board/qnaRegisterView";
	}
}
