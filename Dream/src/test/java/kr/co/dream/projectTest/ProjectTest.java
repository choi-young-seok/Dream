package kr.co.dream.projectTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persitence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class ProjectTest {
	@Inject
	private ProjectDAO dao;
	
	@Inject
	private SqlSession session;

	@Test
	public void profileTest(){
		ProjectVO project = new ProjectVO();
		project.setRegister_intro("소개문구 테스트");
		project.setRegister_name("최용석");
		project.setRegister_profile("사아지인");
		project.setRegister_sns("kancho33@naver.com");
		project.setProject_no(19);
		
		dao.projectProfileInfo(project);
		
	}
	
	@Test
	public void accountTest(){
		ProjectVO project = new ProjectVO();
		project.setProject_no(5);
		project.setRegister_address("주소테스트");
		project.setProject_account(11011);
		project.setAccess_terms_agree("T");
		
		dao.projectAccountInfo(project);
		
		
	}
}
