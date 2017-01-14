package kr.co.dream.member.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.common.encryption.EncryptionPwd;
import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	@Inject
	private EncryptionPwd encryptionPwd;

	@Override
	public void memberJoin(MemberVO member) {
		System.out.println("JoinServiceImpl [memberJoin()] : " + member.toStringJoinMember());
		member.setMember_pass(encryptionPwd.bCryptPwd(encryptionPwd.shaPwd(member.getMember_pass())));
		dao.memberJoin(member);
	}

	@Override
	public String authEmail(String member_mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		System.out.println("MemberServiceImpl [login() input value] : " + loginDTO.toString());
		if (encryptionPwd.checkPwd(loginDTO.getLogin_pass(), dao.selectPwd(loginDTO))) {
			MemberVO member = dao.login(loginDTO);
			// return sqlSession.selectOne("member.login", loginDTO);
			System.out.println("MemberServiceImpl [login() output value] : " + member.toStringLogin());
			// return dao.login(loginDTO);
			return member;
		} else {
			return null;
		}
	}

	@Override
	public void keepLogin(String member_email, String sessionId, Date next) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO checkLoginBefore(String value) throws Exception {
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
