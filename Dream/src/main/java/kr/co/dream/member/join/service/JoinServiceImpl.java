package kr.co.dream.member.join.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.member.domain.LoginDTO;
import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.join.persistence.JoinDAO;


@Service
public class JoinServiceImpl implements JoinService{

	@Inject
	private JoinDAO dao;

	@Override
	public void memberJoin(MemberVO member) {
		System.out.println("JoinServiceImpl [memberJoin()] : "+member.toStringJoinMember());
		dao.memberJoin(member);
	}

	@Override
	public String authEmail(String member_mail) {
		// TODO Auto-generated method stub
		return null;
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
