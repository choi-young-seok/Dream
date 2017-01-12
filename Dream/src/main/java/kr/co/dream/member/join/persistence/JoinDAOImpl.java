package kr.co.dream.member.join.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

@Repository
public class JoinDAOImpl implements JoinDAO{

	@Inject
	private SqlSession sqlSession;

	@Override
	public void memberJoin(MemberVO member) {
		System.out.println("JoinDaoImpl [memberJoin()] : "+member.toStringJoinMember());
		sqlSession.insert("member.memberJoin",member);
	}

	@Override
	public LoginDTO login(LoginDTO loginDTO) {
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
