package kr.co.dream.project.persitence;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectDAO {
	// 프로젝트 기본정보 등록
	public int projectBasicInfo(ProjectVO projectBasicInfo);

//	public void getProjectNo(int member_no);

	// 프로젝트 스토리 정보 등록
	public void projectStoryInfo(ProjectVO projectStoryInfo);

	// 프로젝트 프로필 정보 등록
	public void projectProfileInfo(ProjectVO projectProfileInfo);

	// 프로젝트 계좌 정보 등록
	public void projectAccountInfo(ProjectVO projectAccountInfo);

	// 프로젝트 최종 등록
	public void projectRegister(int project_no);

	// ----------------------------------------------------------
	// 프로젝트 조회
	public ProjectVO projectInfoView(int project_no);

	// 프로젝트 조회수
	public void projectViewCnt(int project_no);

	// 프로젝트 간략정보 : 결제화면 프로젝트 정보
	public ProjectPointDTO support_project_point_info(int project_no);

	// ----------------------------------------------------------
	// --- 마이페이지 프로젝트 리스트 ---

	// 진행 중 프로젝트 리스트
	public List<ProjectPointDTO> processing_project(int member_no);

	// 성공 프로젝트 리스트
	public List<ProjectPointDTO> success_project(int member_no);

	// 만료 프로젝트 리스트
	public List<ProjectPointDTO> expire_project(int member_no);

	// 등록 중 프로젝트 리스트
	public List<ProjectPointDTO> during_registration(int member_no);
}
