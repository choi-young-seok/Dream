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
	
	//��й�ȣ ���� �� ��й�ȣ ��ġ ���� Ȯ��
	@RequestMapping(value = "/password_check")
	public ResponseEntity<String> password_check(@RequestBody LoginDTO password_check_info){
		System.out.println("��й�ȣ ���� ��û �� ��й�ȣ ��ġ Ȯ��");
		System.out.println("password_check() \tinput value : " +password_check_info.toString());
		ResponseEntity<String> entity = null;
		
		if(service.login(password_check_info) !=null){
			entity = new ResponseEntity<String>("success", HttpStatus.OK);			
		}else{
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);			
		}
		
		return entity;
	}
	
	//��й�ȣ ����
	@RequestMapping(value = "/password_edit")
	public ResponseEntity<String> password_edit(@RequestBody MemberVO member){
		ResponseEntity<String> entity;
		
		if (service.findPass(member) > 0) {
			System.err.println("MypageRestController \tpassword_edit() \t\t[��й�ȣ ���� �Ϸ�]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			System.err.println("MypageRestController \tpassword_edit() \t\t[��й�ȣ ���� ����]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
