package kr.co.dream.mainListTest;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.mainView.persistence.MainListDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MainListTest {
	
	@Inject
	private MainListDAO dao;
	
	@Test
	public void mainListTest(){
		dao.mainList();
	}

}
