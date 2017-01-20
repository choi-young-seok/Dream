package kr.co.dream.board.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.board.domain.QnaVO;

@RestController
public class QNARestController {
	
//	@RequestMapping(value = "qnaRegitster", method = RequestMethod.POST)
//	public ResponseEntity<String> qnaRegitster(@RequestBody QnaVO memberQna){
//		System.out.println("??");
//		System.out.println("QNARestController [qnaRegitster() input value ] : "+memberQna.toString());
//		ResponseEntity<String> entity = null;
//		
//		entity = new ResponseEntity<String>("success",HttpStatus.OK);
//		return entity;
//	}

	@RequestMapping(value = "qnaRegitster", method = RequestMethod.POST)
	public String qnaRegitster(@RequestBody QnaVO memberQna){
		System.out.println("??");
		System.out.println("QNARestController \tqnaRegitster() \t\t[input value] : "+memberQna.toString());

		return "success";
	}
	
}