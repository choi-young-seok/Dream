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

	@Override
	public void memberJoin(MemberVO member) {
		System.out.println("JoinDaoImpl [memberJoin()] : " + member.toStringJoinMember());
		sqlSession.insert("member.memberJoin", member);
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		System.out.println("[memberDAOImpl login() input value] : " +loginDTO.toString());
		MemberVO member = sqlSession.selectOne("member.login", loginDTO);
		System.out.println("[memberDAOImpl login() output value] : " +member.toStringLogin());
		//return sqlSession.selectOne("member.login", loginDTO);
		return member;
	}

	@Override
	public String selectPwd(LoginDTO loginDTO) {
		return sqlSession.selectOne("member.selectPwd", loginDTO);
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberEdit(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public String findId(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPwd(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
