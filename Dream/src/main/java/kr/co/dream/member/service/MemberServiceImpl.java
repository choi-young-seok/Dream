package kr.co.dream.member.service;

import java.util.Date;
import java.util.List;

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
		System.err.println("MemberServiceImpl \tmemberJoin() \t\t[input value] : " + member.toStringJoinMember());
		member.setMember_pass(encryptionPwd.bCryptPwd(encryptionPwd.shaPwd(member.getMember_pass())));
		dao.memberJoin(member);
	}

	@Override
	public boolean idDuplicationCheck(String member_authMail) {
		System.err.println("MemberServiceImpl \tidDuplicationCheck() \t[input value] : " + member_authMail);
		return dao.idDuplicationCheck(member_authMail);
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		System.err.println("MemberServiceImpl \tlogin() \t\t[input value] : " + loginDTO.toString());
		if (encryptionPwd.checkPwd(loginDTO.getLogin_pass(), dao.selectPwd(loginDTO))) {
			MemberVO member = dao.login(loginDTO);
			// return sqlSession.selectOne("member.login", loginDTO);
			System.out.println("MemberServiceImpl \tlogin() \t\t[output value] : " + member.toStringLogin());
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
	public MemberVO memberInfo(int member_no) {
		System.err.println("MemberServiceImpl \tmemberInfo() \t\t[input value] : " + member_no);
		return dao.memberInfo(member_no);
	}

	@Override
	public int memberInfoEdit(MemberVO member) {
		int updateSuccess = dao.memberInfoEdit(member);
		return updateSuccess;
	}

	@Override
	public List<MemberVO> findMail(MemberVO member) {
		System.err.println("MemberServiceImpl \tfindMail() \t\t[input value] : " + member.toStringLogin());
//		List<MemberVO> memberList = 
		return dao.findMail(member);
//		for (int i = 0; i < memberList.size(); i++) {
//			MemberVO editMemberInfo = memberList.get(i);
////			member.setMember_mail(member.getMember_mail().);
//		}
//		return memberList;
	}

	@Override
	public int findPass(MemberVO member) {
		System.err.println("MemberServiceImpl \tfindPass() \t\t[input value] : " + member.toStringLogin());
		member.setMember_pass(encryptionPwd.bCryptPwd(encryptionPwd.shaPwd(member.getMember_pass())));
		return dao.findPass(member);
	}
	
	public void aoptest22(){
		System.out.println("서비스진입");
	}

}
