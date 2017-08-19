package kr.co.dream.mainListTest;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.mainView.persistence.MainListDAO;
import kr.co.dream.project.domain.ProjectInfoDto;
import kr.co.dream.project.domain.ProjectVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MainListTest {
	
	@Inject
	private MainListDAO dao;
	
//	@Test
	public void mainListTest(){
		dao.mainList();
	}

//	@Test
//	public void mainListTest2(){
//		List<ProjectVO> mainList = dao.mainList2();
//		for (int i = 0; i < mainList.size(); i++) {
//			ProjectVO project = mainList.get(i);
////			project.setProjectInfoDto(dao.getDTO(project.getProject_no()));
////			System.out.println(project.getProjectInfoDto().toString());
//		}
//	}
//	
////	@Test
//	public void getDTOTest(){
//		ProjectInfoDto dto = dao.getDTO(59);
//		System.out.println(dto.toString());
//	}
//	
	@Test
	public void nestedSeleteTest(){
		List<ProjectVO> mainList = dao.mainList2();
		for (int i = 0; i < mainList.size(); i++) {
			ProjectVO project = mainList.get(i);
			System.out.println(project.getInfoDto().toString());
		}
	}
//	
////	@Test
//	public void nestedSeleteTest2(){
//		ProjectVO mainList = dao.mainList3(57);
//	}

}
