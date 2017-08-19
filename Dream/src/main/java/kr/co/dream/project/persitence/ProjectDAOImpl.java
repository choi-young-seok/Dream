package kr.co.dream.project.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.domain.ProjectInfoDto;
import kr.co.dream.project.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		sqlSession.insert("project.projectBasicInfo", projectBasicInfo);
		return projectBasicInfo.getProject_no();
	}

	@Override
	public void getProjectNo(int member_no) {
		sqlSession.selectOne("project.getProjectNo", member_no);

	}

	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		sqlSession.update("project.projectStoryInfo", projectStoryInfo);
	}

	@Override
	public void projectProfileInfo(ProjectVO projectProfileInfo) {
		sqlSession.update("project.projectProfileInfo", projectProfileInfo);

	}

	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		System.out.println("projectAccountInfo \t"+projectAccountInfo.toStringAccountInfo());
		sqlSession.update("project.projectAccountInfo",projectAccountInfo);

	}

	@Override
	public ProjectVO projectPreview(int project_no) {
		System.out.println("ProjectDAOImpl \tprojectPreview \t" +project_no);
		return sqlSession.selectOne("project.projectPreview", project_no);
	}
	

	@Override
	public void projectRegister(int project_no) {
		sqlSession.update("project.projectRegister",project_no);
	}

	@Override
	public void projectInfoView(int project_no) {
		sqlSession.selectOne("project.projectInfoView",project_no);
	}

	//마이 페이지 프로젝트 리스트
	@Override
	public List<ProjectVO> processing_project_list(int member_no) {
		System.out.println("daoImpl : " +member_no);
		return sqlSession.selectList("mypageProject.processing_project_list",member_no);
	}

	@Override
	public List<ProjectVO> end_project_list(int member_no) {
		return sqlSession.selectList("project.end_project_list",member_no);
		//list 처리 할것 : selectList(..,new rowbounds);
	}

	@Override
	public ProjectInfoDto get_project_dto_info(int project_no) {
		ProjectInfoDto dto =sqlSession.selectOne("project.get_project_dto_info",project_no);
		System.out.println(dto.toString());
		return dto;
	}



}
