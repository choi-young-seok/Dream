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

	// ȸ������ ó��
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ResponseEntity<String> memberJoin(@RequestBody MemberVO member) {
		System.err
				.println("MemberRestController \tmemberJoin() \t\t[ȸ������ input value] : " + member.toStringJoinMember());

		ResponseEntity<String> entity = null;

		try {
			service.memberJoin(member);
			System.out.println("MemberRestController \tmebmerJoin() \t\t[ȸ������ �Ϸ�]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberRestController \tmemberJoin() \t\t[ȸ������ ����]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// ���̵� �ߺ��˻� : ȸ�����Խ� �ߺ����̵� �˻�
	@RequestMapping(value = "/idDuplicationCheck", method = RequestMethod.POST)
	public ResponseEntity<String> idDuplicationCheck(String member_authMail) {
		System.err.println("MemberRestController \tidDuplicationCheck() \t[input value] : " + member_authMail);
		ResponseEntity<String> entity = null;

		if (member_authMail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_authMail)) {
			System.out.println("MemberRestController \tidDuplicationCheck() \t[��� ����]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("MemberRestController \tidDuplicationCheck() \t[��� �Ұ���]");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		}
	}

	// ���̵� �ߺ��˻� : ��й�ȣ ����� ���̵� ��ġ �˻�
	@RequestMapping("/checkMemberMail")
	public ResponseEntity<String> checkMemberMail(String member_mail) {
		ResponseEntity<String> entity = null;
		System.err.println("MemberRestController \tcheckMemberMail() \t[input value] : " + member_mail);
		if (member_mail.equals("")) {
			entity = new ResponseEntity<String>("noResult", HttpStatus.OK);
			return entity;
		} else if (service.idDuplicationCheck(member_mail)) {
			System.out.println("MemberRestController \tcheckMemberMail()] \t[���̵� ����ġ]");
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		} else {
			System.out.println("MemberRestController \tcheckMemberMail() \t[���̵� ��ġ]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		}

	}

	// ��й�ȣ ����
	@RequestMapping("/findPass")
	public ResponseEntity<String> findPass(@RequestBody MemberVO member) {
		System.err.println("MemberRestController \tfindPass() \t\t[input value] : " + member.toStringFindInfo());
		ResponseEntity<String> entity = null;

		if (service.findPass(member) > 0) {
			System.err.println("MemberRestController \tfindPass() \t\t[��й�ȣ ���� �Ϸ�]");
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			return entity;
		} else {
			System.err.println("MemberRestController \tcheckMemberMail() \t\t[��й�ȣ ���� ����]");
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// ���̵� ã��
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

	// ȸ�� ������ ���� ���
	@RequestMapping("/memberProfileUpload")
	public ResponseEntity<String> memberProfileUpload(MemberVO memberProfileInfo) {
		System.out.println("MemberRestController \tmemberProfileUpload \t[input value] : " + memberProfileInfo.toStringProfile());
		ResponseEntity<String> entity = null;

		return entity;
	}

	// ȸ������ ����
	@RequestMapping(value = "/memberInfoEdit", method = RequestMethod.POST)
	public ResponseEntity<String> memberInfoEdit(@RequestBody MemberVO member) {
		ResponseEntity<String> entity = null;
		System.out.println(member.toStringProfile());
		service.memberInfoEdit(member);
		return entity;
	}
}
