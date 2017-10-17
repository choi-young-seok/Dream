package kr.co.dream.project.service;

import java.util.List;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectProfileDTO;
import kr.co.dream.project.domain.ProjectVO;

public interface ProjectService {
	//������Ʈ ���------------
	
	//������Ʈ �⺻���� ���
	public int projectBasicInfo(ProjectVO projectBasicInfo);
	
	//������Ʈ ���丮 ���� ���
	public void projectStoryInfo(ProjectVO projectStoryInfo);
	
	//������Ʈ ������ ���� ���
	public void projectProfileInfo(ProjectProfileDTO projectProfileDTO);
	
	//������Ʈ �������� ���
	public void projectAccountInfo(ProjectVO projectAccountInfo);
	
	//������Ʈ �̸�����
	public ProjectVO projectPreview(int project_no);
//	public void projectRegister(ProjectVO project);
	public void projectRegister(int project_no);
	//������Ʈ ���
	
	//������Ʈ �󼼺���
	public ProjectVO projectInfoView(int project_no);
	
	//������Ʈ ��������
	public ProjectPointDTO support_project_point_info(int project_no);
	
	//����� ������ ���� ȭ�� ����� ������ ����
	public String get_projectRegisterProfile(int member_no);
	
	// --- ���������� ---
	//���� ���� ���� ������Ʈ ����Ʈ
	public List<ProjectPointDTO> myProjectList(int member_no, String request);
	
	
}
