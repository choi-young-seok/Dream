package kr.co.dream.project.service;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectService {
	
	public int projectBasicInfo(ProjectVO projectBasicInfo);
	public void projectStoryInfo(ProjectVO projectStoryInfo);
	public void projectProfileInfo(ProjectVO projectProfileInfo);
	public void projectAccountInfo(ProjectVO projectAccountInfo);
	//프로젝트 등록
	
	public ProjectVO projectPreview(int project_no);
	//프로젝트 미리보기
//	public void projectRegister(ProjectVO project);
	public void projectRegister(int project_no);
	//프로젝트 등록
	
	//프로젝트 상세보기
	public ProjectVO projectInfoView(int project_no);
	
	//프로젝트 간략정보
	public ProjectPointDTO support_project_point_info(int project_no);
	
	
	// --- 마이페이지 ---
	//현재 진행 중인 프로젝트 리스트
	public List<ProjectPointDTO> myProjectList(int member_no, String request);

	
}
