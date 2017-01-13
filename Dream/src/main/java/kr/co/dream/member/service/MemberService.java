package kr.co.dream.member.service;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberService {

	public void memberJoin(MemberVO member);
	public String authEmail(String member_mail);
	public LoginDTO login(LoginDTO loginDTO);
	
	//dto���·� ���� �������� Ȯ�� �Ұ� 
	public void memberEdit(MemberVO member); //ȸ������ ���� + ��й�ȣ ����
	public String findId(MemberVO member);
	public String findPwd(MemberVO member);
	
}
