package kr.co.dream.common.login;

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
	public void login(@RequestBody LoginDTO loginDto, Model model, HttpSession session, HttpServletRequest request) {
		System.out.println("LoginController [login()] : " + loginDto.toString());
		System.out.println("LoginController [login() ����� ��û URI] : " + request.getRequestURI());

		MemberVO member = service.login(loginDto);
		System.out.println("session / member.toString " + member.toStringLogin());

		if (member == null) {
			return;
		}
		model.addAttribute(member);
		session.setAttribute("session", member);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		//���ͼ��͸� ���� session����
	}
}
