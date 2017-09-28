package kr.co.dream.project.persistence;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectDAO {
	// 프로젝트 기본정보 등록
	public int projectBasicInfo(ProjectVO projectBasicInfo);

	// 프로젝트 스토리 정보 등록
	public void projectStoryInfo(ProjectVO projectStoryInfo);

	// 프로젝트 프로필 정보 등록
	public void projectMemberProfile_update(ProjectProfileDTO projectProfileDTO);

	public void projectRegisterProfile_update(ProjectProfileDTO projectProfileDTO);

	public void memberAddress_insert(MemberAddressVO memberAddressVO);

	// 프로젝트 계좌 정보 등록
	public void projectAccountInfo(ProjectVO projectAccountInfo);

	// 프로젝트 최종 등록
	public void projectRegister(int project_no);

	// ----------------------------------------------------------
	// 프로젝트 조회
	public ProjectVO projectInfoView(int project_no);
	// 등록자 프로필 사진 조회
	public String get_projectRegisterProfile(int member_no);

	// 프로젝트 조회수
	public void projectViewCnt(int project_no);

	// 프로젝트 간략정보 : 결제화면 프로젝트 정보
	public ProjectPointDTO support_project_point_info(int project_no);

}
