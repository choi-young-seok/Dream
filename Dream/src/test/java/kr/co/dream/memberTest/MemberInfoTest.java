package kr.co.dream.memberTest;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.persistence.MemberDAO;
import kr.co.dream.member.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberInfoTest {

	@Inject
	private MemberDAO dao;

	@Inject
	private MemberService service;
	
	@Test
	public void MemberInfoTestDao(){
		System.out.println(dao.memberInfo(1).toStringLogin());
	}
	
	//@Test
	public void MemberInfoTestService(){
		System.out.println(service.memberInfo(1));
	}
	
}
