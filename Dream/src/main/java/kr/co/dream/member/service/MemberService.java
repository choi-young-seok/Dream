package kr.co.dream.member.service;

import java.util.Date;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberService {

	//회원가입 관련부
	public void memberJoin(MemberVO member);
	public boolean idDuplicationCheck(String member_authMail);
	
	//로그인 관련부
	public MemberVO login(LoginDTO loginDTO);
	//확인후 네이밍 재정의할것
	public void keepLogin(String member_email, String sessionId, Date next) throws Exception;
	public MemberVO checkLoginBefore(String value) throws Exception;
	
	//회원정보 관련부
	//dto형태로 변경 가능한지 확인 할것 
	public void memberEdit(MemberVO member); //회원정보 수정 + 비밀번호 변경
	public String findId(MemberVO member);
	public String findPwd(MemberVO member);
	
}
