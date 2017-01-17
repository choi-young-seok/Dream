package kr.co.dream.member.persistence;

import java.util.Date;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	//ȸ������
	@Override
	public void memberJoin(MemberVO member) {
		System.out.println("JoinDaoImpl [memberJoin()] : " + member.toStringJoinMember());
		sqlSession.insert("member.memberJoin", member);
	}

	//���̵� �ߺ�Ȯ��
	@Override
	public boolean idDuplicationCheck(String member_authMail) {
		System.out.println("[memberDAOImpl idDuplicationCheck() input value] : " + member_authMail);
		//��ġ�ϴ� ���̵� DB�� ������ 
		if((Integer)sqlSession.selectOne("member.idDuplicationCheck", member_authMail) == 0){
			return true;	
		}
		//��ġ�ϴ� ���̵� �����ҽ�
		else{
			return false;
		}
	}

	//�α���
	@Override
	public MemberVO login(LoginDTO loginDTO) {
		System.out.println("[memberDAOImpl login() input value] : " + loginDTO.toString());
		MemberVO member = sqlSession.selectOne("member.login", loginDTO);
		System.out.println("[memberDAOImpl login() output value] : " + member.toStringLogin());
		// return sqlSession.selectOne("member.login", loginDTO);
		return member;
	}

	//��й�ȣ ��ġ���� Ȯ��
	@Override
	public String selectPwd(LoginDTO loginDTO) {
		System.out.println("[memberDAOImpl selectPwd() input value] : " + loginDTO.toString());
		String dbPwd = sqlSession.selectOne("member.selectPwd", loginDTO);
		System.out.println("[memberDAOImpl selectPwd() output value] : " + dbPwd);
		return dbPwd;
	}

	//�ڵ��α��� üũ
	@Override
	public void keepLogin(String id, String sessionId, Date next) {
		// TODO Auto-generated method stub

	}

	//����Ȯ��
	@Override
	public MemberVO checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//ȸ������ ��ȸ 
	@Override
	public MemberVO memberInfo(String session_mail) {
		System.out.println("[memberDAOImpl memberInfo() input value] : " + session_mail);
		 MemberVO member = sqlSession.selectOne("member.memberInfo", session_mail);
		System.out.println("[memberDAOImpl memberInfo() output value] : " + member.toStringJoinMember());
		return member;
	}
	
	//ȸ������ ����
	@Override
	public void memberEdit(MemberVO member) {
		// TODO Auto-generated method stub

	}

	//���̵� ã��
	@Override
	public String findId(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	//��й�ȣ ã��(��������+�缳��)
	@Override
	public int findPass(MemberVO member) {
		System.out.println("[memberDAOImpl memberInfo() input value] : " + member.toStringLogin());
		return sqlSession.update("member.findPass", member);
	}


}
