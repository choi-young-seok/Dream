package kr.co.dream.projectTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.project.domain.ProjectDTO;
import kr.co.dream.project.persitence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class ProjectTest {
	@Inject
	private ProjectDAO dao;
	
	@Inject
	private SqlSession session;
	
	@Test
	public void TestSelectOne(){
		ProjectDTO project = dao.testSelectOne();
		System.out.println(project.toString());
	}

}
