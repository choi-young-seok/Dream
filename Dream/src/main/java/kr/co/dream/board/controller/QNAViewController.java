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
		System.err.println("QNAViewCntroller \tqnaRegisterView() \t[�����ϱ� �ۼ� ȭ�� ��û]");
		return "board/qnaRegisterView";
	}
}
