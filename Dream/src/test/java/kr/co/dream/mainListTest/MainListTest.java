package kr.co.dream.mainListTest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.mainView.domain.ProjectCategoryDTO;
import kr.co.dream.mainView.persistence.MainListDAO;
import kr.co.dream.project.domain.ProjectPointDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MainListTest {
	
	@Inject
	private MainListDAO dao;
	
	@Inject
	private SqlSession session;
	
	
//	@Test
	public void mainListTest(){
//		dao.mainList();
	}
	
//	@Test
	public void category_project_4(){
		List<String> categoryDTOs = session.selectList("mainList.project_category");
		System.out.println(categoryDTOs);
		Map<String, List<ProjectPointDTO>> categroy_map = new HashMap<>();
		for (int i = 0; i < categoryDTOs.size(); i++) {
			categroy_map.put(categoryDTOs.get(i), session.selectList("mainList.project_category_list", categoryDTOs.get(i), new RowBounds(0, 4)));
		}
//		categroy_map.put(categoryDTOs.get(0), session.selectList("mainList.project_category_list", categoryDTOs.get(0), new RowBounds(0, 4)));
//		System.out.println(categoryDTOs.get(0));
		System.out.println(categroy_map);
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
//	@Test
//	public void nestedSeleteTest(){
//		List<ProjectVO> mainList = dao.mainList2();
//		for (int i = 0; i < mainList.size(); i++) {
//			ProjectVO project = mainList.get(i);
//			System.out.println(project.getInfoDto().toString());
//		}
//	}
//	
////	@Test
//	public void nestedSeleteTest2(){
//		ProjectVO mainList = dao.mainList3(57);
//	}
	
	@Test
	public void project_category_collection_test(){
		session.selectList("mainList.project_category_list");
	}

}
