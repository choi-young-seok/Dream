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
	// ������Ʈ ���---------------------------------------------------------------------

	// ������Ʈ �⺻���� ���
	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		sqlSession.insert("projectRegister.projectBasicInfo", projectBasicInfo);
		return projectBasicInfo.getProject_no();
	}

	// ������Ʈ ���丮 ���� ���
	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		sqlSession.update("projectRegister.projectStoryInfo", projectStoryInfo);
	}

	// ������Ʈ ������ ���� ���
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

	// ������Ʈ ���� ���� ���
	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		sqlSession.update("projectRegister.projectAccountInfo", projectAccountInfo);

	}

	// ������Ʈ �������
	@Override
	public void projectRegister(int project_no) {
		sqlSession.update("projectRegister.projectRegister", project_no);
	}

	// ---------------------------------------------------------------------
	// ������Ʈ ����ȸ
	@Override
	public ProjectVO projectInfoView(int project_no) {
		return sqlSession.selectOne("project_info.projectInfoView", project_no);
	}
	// ������Ʈ ����� ������ ���� ��ȸ
	@Override
	public String get_projectRegisterProfile(int member_no) {
		return sqlSession.selectOne("project_info.get_memberProfile", member_no);
	}
	@Override
	public void projectViewCnt(int project_no) {
		sqlSession.update("project_info.project_view_count", project_no);
	}

	// ����ȭ�� ������Ʈ ����
	@Override
	public ProjectPointDTO support_project_point_info(int project_no) {
		return sqlSession.selectOne("project_info.ProjectPointInfo", project_no);
	}


}
