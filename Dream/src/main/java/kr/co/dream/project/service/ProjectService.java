package kr.co.dream.project.service;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectService {
	//프로젝트 등록------------
	
	//프로젝트 기본정보 등록
	public int projectBasicInfo(ProjectVO projectBasicInfo);
	
	//프로젝트 스토리 정보 등록
	public void projectStoryInfo(ProjectVO projectStoryInfo);
	
	//프로젝트 프로필 정보 등록
	public void projectProfileInfo(ProjectProfileDTO projectProfileDTO);
	
	//프로젝트 계좌정보 등록
	public void projectAccountInfo(ProjectVO projectAccountInfo);
	
	//프로젝트 미리보기
	public ProjectVO projectPreview(int project_no);
//	public void projectRegister(ProjectVO project);
	public void projectRegister(int project_no);
	//프로젝트 등록
	
	//프로젝트 상세보기
	public ProjectVO projectInfoView(int project_no);
	
	//프로젝트 간략정보
	public ProjectPointDTO support_project_point_info(int project_no);
	
	//등록자 프로필 정보 화면 등록자 프로필 사진
	public String get_projectRegisterProfile(int member_no);
	
	// --- 마이페이지 ---
	//현재 진행 중인 프로젝트 리스트
	public List<ProjectPointDTO> myProjectList(int member_no, String request);
	
	
}
