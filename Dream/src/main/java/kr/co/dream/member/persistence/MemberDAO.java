package kr.co.dream.member.persistence;

import java.util.Date;
import java.util.List;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

public interface MemberDAO {

	// ȸ������ ���ú�
	public void memberJoin(MemberVO member);

	public boolean idDuplicationCheck(String member_authMail);

	// �α��� ���ú�
	public MemberVO login(LoginDTO loginDTO);

	public String selectPwd(LoginDTO loginDTO);

	// �ڵ� �α��μ��ý� sessionId�� next(����Ⱓ)�� Ư�� id�� ��������
	public void keepLogin(String id, String sessionId, Date next);

	// DB�� ����� sessionId�� �Ķ���� value�� ��
	// String value = sessionId
	public MemberVO checkUserWithSessionKey(String value);

	// ȸ������ ���ú�
	// dto���·� ���� �������� Ȯ�� �Ұ�
	public MemberVO memberInfo(String session_mail);
	public void memberEdit(MemberVO member); // ȸ������ ���� + ��й�ȣ ����

	public List<MemberVO> findMail(MemberVO member);

	public int findPass(MemberVO member);
}
