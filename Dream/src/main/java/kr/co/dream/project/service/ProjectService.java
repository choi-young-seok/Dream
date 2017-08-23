package kr.co.dream.project.service;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
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
	public ProjectVO projectInfoView(int project_no);
	
	//������Ʈ ��������
	public ProjectPointDTO support_project_point_info(int project_no);
	
	
	// --- ���������� ---
	//���� ���� ���� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> myProjectList(int member_no, String request);

	
}
