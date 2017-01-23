package kr.co.dream.member.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	//회원가입
	@Override
	public void memberJoin(MemberVO member) {
		System.err.println("MemberDaoImpl \t\tmemberJoin() \t\t[input value] : " + member.toStringJoinMember());
		sqlSession.insert("member.memberJoin", member);
	}

	//아이디 중복확인
	@Override
	public boolean idDuplicationCheck(String member_authMail) {
		System.err.println("MemberDAOImpl \t\tidDuplicationCheck() \t[input value] : " + member_authMail);
		//일치하는 아이디가 DB에 없을시 
		if((Integer)sqlSession.selectOne("member.idDuplicationCheck", member_authMail) == 0){
			return true;	
		}
		//일치하는 아이디가 존재할시
		else{
			return false;
		}
	}

	//로그인
	@Override
	public MemberVO login(LoginDTO loginDTO) {
		System.err.println("MemberDAOImpl \t\tlogin() \t\t[input value] : " + loginDTO.toString());
		MemberVO member = sqlSession.selectOne("member.login", loginDTO);
		System.out.println("MemberDAOImpl \t\tlogin() \t\t[output value] : " + member.toStringLogin());
		// return sqlSession.selectOne("member.login", loginDTO);
		return member;
	}

	//비밀번호 일치여부 확인
	@Override
	public String selectPwd(LoginDTO loginDTO) {
		System.err.println("MemberDAOImpl \t\tselectPwd() \t\t[input value] : " + loginDTO.toString());
		String dbPwd = sqlSession.selectOne("member.selectPwd", loginDTO);
		System.out.println("MemberDAOImpl \t\tselectPwd() \t\t[output value] : " + dbPwd);
		return dbPwd;
	}

	//자동로그인 체크
	@Override
	public void keepLogin(String id, String sessionId, Date next) {
		// TODO Auto-generated method stub

	}

	//세션확인
	@Override
	public MemberVO checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//회원정보 조회 
	@Override
	public MemberVO memberInfo(int member_no) {
		System.err.println("MemberDAOImpl \t\tmemberInfo() \t\t[input value] : " + member_no);
		 MemberVO memberInfo = sqlSession.selectOne("member.memberInfo", member_no);
		System.out.println("MemberDAOImpl \t\tmemberInfo() \t\t[output value] : " + memberInfo.toStringJoinMember());
		return memberInfo;
	}
	
	//회원정보 수정
	@Override
	public int memberInfoEdit(MemberVO member) {
		return sqlSession.update("member.memberInfoEdit",member);
	}

	//아이디 찾기
	@Override
	public List<MemberVO> findMail(MemberVO member) {
		System.err.println("MemberDAOImpl \t\tmemberInfo() \t\t[input value] : " + member.toStringFindInfo());
		return sqlSession.selectList("member.findMail", member);
	}

	//비밀번호 찾기(메일인증+재설정)
	@Override
	public int findPass(MemberVO member) {
		System.err.println("MemberDAOImpl \t\tmemberInfo() \t\t[input value] : " + member.toStringFindInfo());
		return sqlSession.update("member.findPass", member);
	}


}
