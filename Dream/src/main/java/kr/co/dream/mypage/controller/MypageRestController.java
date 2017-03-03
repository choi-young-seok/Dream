package kr.co.dream.mypage.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.service.MemberService;

@RestController
public class MypageRestController {

	@Inject
	private MemberService service;
	
	//비밀번호 변경 전 비밀번호 일치 여부 확인
	@RequestMapping(value = "/password_check")
	public ResponseEntity<String> password_check(@RequestBody LoginDTO password_check_info){
		System.out.println("비밀번호 변경 요청 전 비밀번호 일치 확인");
		System.out.println("password_check() \tinput value : " +password_check_info.toString());
		ResponseEntity<String> entity = null;
		
		if(service.login(password_check_info) !=null){
			entity = new ResponseEntity<String>("success", HttpStatus.OK);			
		}else{
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);			
		}
		
		return entity;
	}
	
	//비밀번호 변경
	@RequestMapping(value = "/password_edit")
	public ResponseEntity<String> password_edit(@RequestBody MemberVO member){
		ResponseEntity<String> entity;
		
		if (service.findPass(member) > 0) {
			System.err.println("MypageRestController \tpassword_edit() \t\t[비밀번호 변경 완료]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			System.err.println("MypageRestController \tpassword_edit() \t\t[비밀번호 변경 실패]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
