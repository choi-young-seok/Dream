package kr.co.dream.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persitence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService{
		
	@Inject
	private ProjectDAO dao;

	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		return dao.projectBasicInfo(projectBasicInfo);
	}

	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		dao.projectStoryInfo(projectStoryInfo);
	}

	@Override
	public void projectProfileInfo(ProjectVO projectProfileInfo) {
		dao.projectProfileInfo(projectProfileInfo);
	}

	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		System.out.println("222"+projectAccountInfo.toStringAccountInfo());
		dao.projectAccountInfo(projectAccountInfo);
	}

	@Override
	public ProjectVO projectPreview(int project_no) {
		return dao.projectPreview(project_no);
	}

	@Transactional
	@Override
	public void projectRegister(int project_no) {
//		if(project != null){
//			dao.projectPreviewEdit(project);
//		}
		dao.projectRegister(project_no);
	}

	@Override
	public void projectInfoView(int project_no) {
		dao.projectInfoView(project_no);
		
	}

	//마이페이지 프로젝트 
	@Override
	public List<ProjectVO> processing_project_list(int member_no) {
		return dao.processing_project_list(member_no);
	}

	@Override
	public List<ProjectVO> end_project_list(int member_no) {
		// TODO Auto-generated method stub
		return dao.end_project_list(member_no);
	}


	
}
