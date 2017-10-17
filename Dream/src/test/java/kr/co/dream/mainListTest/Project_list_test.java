package kr.co.dream.mainListTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.mainView.service.MainListService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class Project_list_test {
	
	@Inject
	private MainListService mainListService;
	
	@Inject
	private SqlSession session;
	
//	@Test
	public void project_category(){
		System.out.println("카테고리별 프로젝트 리스트");
	}
	
	@Test
	public void max_project(){
		session.selectList("mainList.max_support_project");
	}

//	@Test
	public void project_category_count(){
		session.selectList("mainList.project_category_count");
	}
}
