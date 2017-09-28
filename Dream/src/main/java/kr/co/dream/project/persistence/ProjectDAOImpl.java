package kr.co.dream.project.persistence;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	private SqlSession sqlSession;
	// 프로젝트 등록---------------------------------------------------------------------

	// 프로젝트 기본정보 등록
	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		sqlSession.insert("projectRegister.projectBasicInfo", projectBasicInfo);
		return projectBasicInfo.getProject_no();
	}

	// 프로젝트 스토리 정보 등록
	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		sqlSession.update("projectRegister.projectStoryInfo", projectStoryInfo);
	}

	// 프로젝트 프로필 정보 등록
	@Override
	public void projectMemberProfile_update(ProjectProfileDTO projectProfileDTO) {
		sqlSession.update("projectRegister.projectMemberProfile_update", projectProfileDTO);
	}

	@Override
	public void projectRegisterProfile_update(ProjectProfileDTO projectProfileDTO) {
		sqlSession.update("projectRegister.projectRegisterProfile_update", projectProfileDTO);

	}

	@Override
	public void memberAddress_insert(MemberAddressVO memberAddressVO) {
		sqlSession.insert("projectRegister.memberAddress_insert", memberAddressVO);
	}

	// 프로젝트 계좌 정보 등록
	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		sqlSession.update("projectRegister.projectAccountInfo", projectAccountInfo);

	}

	// 프로젝트 최종등록
	@Override
	public void projectRegister(int project_no) {
		sqlSession.update("projectRegister.projectRegister", project_no);
	}

	// ---------------------------------------------------------------------
	// 프로젝트 상세조회
	@Override
	public ProjectVO projectInfoView(int project_no) {
		return sqlSession.selectOne("project_info.projectInfoView", project_no);
	}
	// 프로젝트 등록자 프로필 사진 조회
	@Override
	public String get_projectRegisterProfile(int member_no) {
		return sqlSession.selectOne("project_info.get_memberProfile", member_no);
	}
	@Override
	public void projectViewCnt(int project_no) {
		sqlSession.update("project_info.project_view_count", project_no);
	}

	// 결제화면 프로젝트 정보
	@Override
	public ProjectPointDTO support_project_point_info(int project_no) {
		return sqlSession.selectOne("project_info.ProjectPointInfo", project_no);
	}


}
