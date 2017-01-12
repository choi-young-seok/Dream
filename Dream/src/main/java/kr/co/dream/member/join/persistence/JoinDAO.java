package kr.co.dream.member.join.persistence;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface JoinDAO {
	
	public void memberJoin(MemberVO member);
	public LoginDTO login(LoginDTO loginDTO);
	
	//dto형태로 변경 가능한지 확인 할것 
	public void memberEdit(MemberVO member); //회원정보 수정 + 비밀번호 변경
	public String findId(MemberVO member);
	public String findPwd(MemberVO member);
}
