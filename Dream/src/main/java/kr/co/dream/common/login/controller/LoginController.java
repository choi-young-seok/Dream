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
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDto, Model model, HttpSession session,
			HttpServletRequest request) {
		System.out.println("LoginController [login()] : " + loginDto.toString());
		System.out.println("LoginController [login() 사용자 요청 URI] : " + request.getRequestURI());

		MemberVO member = service.login(loginDto);
		ResponseEntity<String> entity = null;

		if (member == null ){
			System.out.println("비밀번호 불일치로 인한 로그인 실패");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		} else {
			model.addAttribute(member);
			System.out.println("LoginController [login() session] : " + member.toStringLogin());
			session.setAttribute("session", member);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		// 인터셉터를 통한 session제거
	}
}
