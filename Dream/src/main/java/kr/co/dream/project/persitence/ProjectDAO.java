package kr.co.dream.project.persitence;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectDAO {
	// ������Ʈ �⺻���� ���
	public int projectBasicInfo(ProjectVO projectBasicInfo);

//	public void getProjectNo(int member_no);

	// ������Ʈ ���丮 ���� ���
	public void projectStoryInfo(ProjectVO projectStoryInfo);

	// ������Ʈ ������ ���� ���
	public void projectProfileInfo(ProjectVO projectProfileInfo);

	// ������Ʈ ���� ���� ���
	public void projectAccountInfo(ProjectVO projectAccountInfo);

	// ������Ʈ ���� ���
	public void projectRegister(int project_no);

	// ----------------------------------------------------------
	// ������Ʈ ��ȸ
	public ProjectVO projectInfoView(int project_no);

	// ������Ʈ ��ȸ��
	public void projectViewCnt(int project_no);

	// ������Ʈ �������� : ����ȭ�� ������Ʈ ����
	public ProjectPointDTO support_project_point_info(int project_no);

	// ----------------------------------------------------------
	// --- ���������� ������Ʈ ����Ʈ ---

	// ���� �� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> processing_project(int member_no);

	// ���� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> success_project(int member_no);

	// ���� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> expire_project(int member_no);

	// ��� �� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> during_registration(int member_no);
}
