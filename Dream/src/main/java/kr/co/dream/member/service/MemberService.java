package kr.co.dream.member.service;

import java.util.Date;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberService {

	//ȸ������ ���ú�
	public void memberJoin(MemberVO member);
	public boolean idDuplicationCheck(String member_authMail);
	
	//�α��� ���ú�
	public MemberVO login(LoginDTO loginDTO);
	//Ȯ���� ���̹� �������Ұ�
	public void keepLogin(String member_email, String sessionId, Date next) throws Exception;
	public MemberVO checkLoginBefore(String value) throws Exception;
	
	//ȸ������ ���ú�
	//dto���·� ���� �������� Ȯ�� �Ұ� 
	public void memberEdit(MemberVO member); //ȸ������ ���� + ��й�ȣ ����
	public String findId(MemberVO member);
	public String findPwd(MemberVO member);
	
}
