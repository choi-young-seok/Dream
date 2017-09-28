package kr.co.dream.board.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.board.domain.LombokTestVO;
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
	public QnaVO qnaRegitster(@RequestBody QnaVO memberQna){
		System.out.println("??");
		System.out.println("QNARestController \tqnaRegitster() \t\t[input value] : "+memberQna.toString());
		memberQna.setMember_mail("rcn115@naver.com");

		return memberQna;
	}
	
	@RequestMapping("/test44")
	public LombokTestVO jsonIncludeTest(@RequestBody LombokTestVO lombokTestVO){
		
		LombokTestVO lombokTestVO2 = new LombokTestVO();
		lombokTestVO2.setName(lombokTestVO.getName());
		lombokTestVO2.setNo(lombokTestVO.getNo());	
		System.out.println("lombokTestVO :" +lombokTestVO2);
		System.out.println("lombokTestVO2 : "+lombokTestVO2.toString());
		return lombokTestVO2;
	}
	
	@RequestMapping("/test45")
	public LombokTestVO jsonIncludeTest2(@RequestBody String name){
		
		LombokTestVO lombokTestVO2 = new LombokTestVO();
		lombokTestVO2.setName(name);
		System.out.println("lombokTestVO :" +lombokTestVO2);
		System.out.println("lombokTestVO2 : "+lombokTestVO2.toString());
		return lombokTestVO2;
	}
	
}