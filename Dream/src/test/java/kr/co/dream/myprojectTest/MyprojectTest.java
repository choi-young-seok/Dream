package kr.co.dream.myprojectTest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MyprojectTest {
	
	@Inject
	private SqlSession sqlSession;
	
	@Inject
	private ProjectDAO dao;
	
//	@Test
	public void MyProcessingProjectTest(){
		ProjectPointDTO dto = new ProjectPointDTO();
//		dto.setProject_no(66);
		int project_no = 66;
		dto =  sqlSession.selectOne("project_info.my_processing_project_info",project_no);
		System.out.println(dto.toString());
	}
	
//	@Test
	public void resultMapTestOne(){
		int project_no =66;
		ProjectPointDTO dto = new ProjectPointDTO();
		dto =  sqlSession.selectOne("project_info.ProjectPointInfo",project_no);
		System.out.println(dto.toString());
		
	}

	//메인화면 프로젝트 정보 List Test
	@Test
	public void resultMapTestList(){
		ProjectPointDTO dto = new ProjectPointDTO();
		List<ProjectPointDTO> dtos = new ArrayList<>();
		dtos =  sqlSession.selectList("mainList.projectPointInfoList");
		for (int i = 0; i < dtos.size(); i++) {
			dto = dtos.get(i);
			System.out.println(dto.toString());
		}
	}
	
	//프로젝트 상세정보
//	@Test
	public void projectInfo(){
		int project_no =66;
		ProjectVO dto = new ProjectVO();
		dto =  sqlSession.selectOne("project_info.projectInfoView",project_no);
		System.out.println(dto.toString());
		
	}
	//sql include test
//	@Test
	public void projectInfo2(){
		int project_no =66;
		ProjectPointDTO dto = new ProjectPointDTO();
		dto =  sqlSession.selectOne("myProjectList.projectInfoView",project_no);
		System.out.println(dto.toString());
		
	}

}
