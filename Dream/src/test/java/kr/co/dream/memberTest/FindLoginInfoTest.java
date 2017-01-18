package kr.co.dream.memberTest;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.member.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class FindLoginInfoTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void findMail(){
		MemberVO member = new MemberVO();
		member.setMember_name("�ֿ뼮");
		member.setMember_birth("910602");
		List<MemberVO> memberList = dao.findMail(member);
		for(int i =0 ; i<memberList.size() ; i++){
			member = memberList.get(i);
			System.out.println(member.toStringFindInfo());
		}
	}
	
}
