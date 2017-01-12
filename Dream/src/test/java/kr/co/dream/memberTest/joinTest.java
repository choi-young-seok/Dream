package kr.co.dream.memberTest;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.join.persistence.JoinDAO;
import kr.co.dream.member.join.service.JoinService;
import kr.co.dream.member.join.service.JoinServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class joinTest {
	
	@Inject
	private JoinDAO dao;
	
	@Inject JoinService service;

	MemberVO member = new MemberVO();
	
	//@Test
	public void voToStringTest(){
		member.setMember_mail("rcn115@naver.com");
		member.setMember_name("�ֿ뼮");
		member.setMember_stop_state("F");
		
		System.out.println(member.toStringStopMember());
		
	}
	
	@Test
	public void joinTest(){
		member.setMember_mail("rcn115@naver.com");
		member.setMember_pass("000");
		member.setMember_name("�ֿ뼮");
		member.setMember_birth("910602");
		member.setMember_gender("M");
		
//		dao.memberJoin(member);
		service.memberJoin(member);
	}
}