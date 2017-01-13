package kr.co.dream.member.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.service.MemberService;

@RestController
public class LoginController {

	@Inject
	private MemberService service;
}
