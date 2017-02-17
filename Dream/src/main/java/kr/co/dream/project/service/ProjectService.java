package kr.co.dream.project.service;

import java.util.List;

import kr.co.dream.project.domain.ProjectVO;

public interface ProjectService {
	
	public int projectBasicInfo(ProjectVO projectBasicInfo);
	public void projectStoryInfo(ProjectVO projectStoryInfo);
	public void projectProfileInfo(ProjectVO projectProfileInfo);
	public void projectAccountInfo(ProjectVO projectAccountInfo);
	//������Ʈ ���
	
	public ProjectVO projectPreview(int project_no);
	//������Ʈ �̸�����
//	public void projectRegister(ProjectVO project);
	public void projectRegister(int project_no);
	//������Ʈ ���
	
	//������Ʈ �󼼺���
	public void projectInfoView(int project_no);
	
	
	// --- ���������� ---
	//���� ���� ���� ������Ʈ ����Ʈ
	public List<ProjectVO> processing_project_list(int member_no);
	//���� ������Ʈ ����Ʈ
	public List<ProjectVO> end_project_list(int member_no);
	
}
