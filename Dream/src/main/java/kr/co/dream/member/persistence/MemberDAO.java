package kr.co.dream.member.persistence;

import java.util.Date;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberDAO {

	public void memberJoin(MemberVO member);

	public MemberVO login(LoginDTO loginDTO);
	
	public String selectPwd(LoginDTO loginDTO);

	// �ڵ� �α��μ��ý� sessionId�� next(����Ⱓ)�� Ư�� id�� ��������
	public void keepLogin(String id, String sessionId, Date next);

	// DB�� ����� sessionId�� �Ķ���� value�� ��
	// String value = sessionId
	public MemberVO checkUserWithSessionKey(String value);

	// dto���·� ���� �������� Ȯ�� �Ұ�
	public void memberEdit(MemberVO member); // ȸ������ ���� + ��й�ȣ ����

	public String findId(MemberVO member);

	public String findPwd(MemberVO member);
}
