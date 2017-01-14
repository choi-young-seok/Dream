package kr.co.dream.member.persistence;

import java.util.Date;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberDAO {

	public void memberJoin(MemberVO member);

	public MemberVO login(LoginDTO loginDTO);
	
	public String selectPwd(LoginDTO loginDTO);

	// 자동 로그인선택시 sessionId와 next(만료기간)을 특정 id에 갱신저장
	public void keepLogin(String id, String sessionId, Date next);

	// DB에 저장된 sessionId를 파라미터 value와 비교
	// String value = sessionId
	public MemberVO checkUserWithSessionKey(String value);

	// dto형태로 변경 가능한지 확인 할것
	public void memberEdit(MemberVO member); // 회원정보 수정 + 비밀번호 변경

	public String findId(MemberVO member);

	public String findPwd(MemberVO member);
}
