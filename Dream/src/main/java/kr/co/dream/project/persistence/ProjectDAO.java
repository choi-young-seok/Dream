package kr.co.dream.project.persistence;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectDAO {
	// ������Ʈ �⺻���� ���
	public int projectBasicInfo(ProjectVO projectBasicInfo);

	// ������Ʈ ���丮 ���� ���
	public void projectStoryInfo(ProjectVO projectStoryInfo);

	// ������Ʈ ������ ���� ���
	public void projectMemberProfile_update(ProjectProfileDTO projectProfileDTO);

	public void projectRegisterProfile_update(ProjectProfileDTO projectProfileDTO);

	public void memberAddress_insert(MemberAddressVO memberAddressVO);

	// ������Ʈ ���� ���� ���
	public void projectAccountInfo(ProjectVO projectAccountInfo);

	// ������Ʈ ���� ���
	public void projectRegister(int project_no);

	// ----------------------------------------------------------
	// ������Ʈ ��ȸ
	public ProjectVO projectInfoView(int project_no);
	// ����� ������ ���� ��ȸ
	public String get_projectRegisterProfile(int member_no);

	// ������Ʈ ��ȸ��
	public void projectViewCnt(int project_no);

	// ������Ʈ �������� : ����ȭ�� ������Ʈ ����
	public ProjectPointDTO support_project_point_info(int project_no);

}
