package kr.co.dream.common.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.service.MemberService;

@RestController
public class LoginController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDto, HttpSession session) {
		System.err.println("LoginController \tlogout() \t\t[�α��� ��û]");
		System.out.println("LoginController \tlogin() \t\t[����� ����] : " + loginDto.toString());

		MemberVO member = service.login(loginDto);
		ResponseEntity<String> entity = null;

		if (member == null ){
			System.out.println("LoginController \tlogin() \t\t[�α��� ����]");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("LoginController \tlogin() \t\t[�α��� ���� ����]");
			session.setAttribute("session", member);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		System.out.println("LoginController \tlogout() \t\t[�α׾ƿ� ��û]");
		// ���ͼ��͸� ���� session����
	}
}
