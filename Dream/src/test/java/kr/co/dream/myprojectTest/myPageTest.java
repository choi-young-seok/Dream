package kr.co.dream.myprojectTest;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.mypage.domain.MyProjectCondition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class myPageTest {
	
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void conditionTest(){
		MyProjectCondition condition = new MyProjectCondition();
		int member_no = 1;
		String request ="during_registration";
		String success_state = "T";
		
		condition.setMember_no(member_no);
		condition.setRequest(request);
		condition.setSuccess_state(success_state);
		
//		sqlSession.selectList("myProjectList.myProject",condition);
		sqlSession.selectOne("myProjectList.during_registration_project",condition);

	}

}
