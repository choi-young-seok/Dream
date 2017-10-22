package kr.co.dream.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.service.MemberService;

@RestController
public class Rest_memberController {

	@Inject
	private MemberService service;

	// 회원가입 처리
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ResponseEntity<String> memberJoin(@RequestBody MemberVO member) {
		System.err
				.println("MemberRestController \tmemberJoin() \t\t[회원가입 input value] : " + member.toStringJoinMember());

		ResponseEntity<String> entity = null;

		try {
			service.memberJoin(member);
			System.out.println("MemberRestController \tmebmerJoin() \t\t[회원가입 완료]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberRestController \tmemberJoin() \t\t[회원가입 실패]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 아이디 중복검사 : 회원가입시 중복아이디 검사
	@RequestMapping(value = "/idDuplicationCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idDuplicationCheck(String member_authMail) {
		System.err.println("MemberRestController \tidDuplicationCheck() \t[input value] : " + member_authMail);
		ResponseEntity<String> entity = null;

		if (member_authMail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_authMail)) {
			System.out.println("MemberRestController \tidDuplicationCheck() \t[사용 가능]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("MemberRestController \tidDuplicationCheck() \t[사용 불가능]");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		}
	}

	// 아이디 중복검사 : 비밀번호 변경시 아이디 일치 검사
	@RequestMapping("/checkMemberMail")
	public ResponseEntity<String> checkMemberMail(String member_mail) {
		ResponseEntity<String> entity = null;
		System.err.println("MemberRestController \tcheckMemberMail() \t[input value] : " + member_mail);
		if (member_mail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_mail)) {
			System.out.println("MemberRestController \tcheckMemberMail()] \t[아이디 불일치]");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("MemberRestController \tcheckMemberMail() \t[아이디 일치]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}

	}

	// 비밀번호 변경
	@RequestMapping("/findPass")
	public ResponseEntity<String> findPass(@RequestBody MemberVO member) {
		System.err.println("MemberRestController \tfindPass() \t\t[input value] : " + member.toStringFindInfo());
		ResponseEntity<String> entity = null;

		if (service.findPass(member) > 0) {
			System.err.println("MemberRestController \tfindPass() \t\t[비밀번호 변경 완료]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.err.println("MemberRestController \tcheckMemberMail() \t\t[비밀번호 변경 실패]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 아이디 찾기
	@RequestMapping("/findMail")
	public ResponseEntity<List<MemberVO>> findMail(@RequestBody MemberVO member) {
		System.err.println("MemberRestController \tfindMail() \t\t[input value] : " + member.toStringFindInfo());
		ResponseEntity<List<MemberVO>> entity = null;
		entity = new ResponseEntity<List<MemberVO>>(service.findMail(member), HttpStatus.OK);

		for (int i = 0; i < entity.getBody().size(); i++) {
			MemberVO memberList = entity.getBody().get(i);
			System.out.println("MemberRestController \tfindMail() \t\t[output value] : " + memberList);
		}

		return entity;
	}

	// 회원 프로필 사진 등록
	@RequestMapping("/memberProfileUpload")
	public ResponseEntity<String> memberProfileUpload(MemberVO memberProfileInfo) {
		System.out.println("MemberRestController \tmemberProfileUpload \t[input value] : " + memberProfileInfo.toStringProfile());
		ResponseEntity<String> entity = null;

		return entity;
	}

	// 회원정보 수정
	@RequestMapping(value = "/memberInfoEdit", method = RequestMethod.POST)
	public ResponseEntity<String> memberInfoEdit(@RequestBody MemberVO member) {
		ResponseEntity<String> entity = null;
		System.out.println(member.toStringProfile());
		service.memberInfoEdit(member);
		return entity;
	}
}
