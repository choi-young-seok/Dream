package kr.co.dream.project.persitence;

import java.util.List;

import kr.co.dream.project.domain.ProjectVO;

public interface ProjectDAO {
	public int projectBasicInfo(ProjectVO projectBasicInfo);
	public void getProjectNo(int member_no);
	public void projectStoryInfo(ProjectVO projectStoryInfo);
	public void projectProfileInfo(ProjectVO projectProfileInfo);
	public void projectAccountInfo(ProjectVO projectAccountInfo);
	
	public ProjectVO projectPreview(int project_no);
//	public void projectPreviewEdit(ProjectVO project);
	public void projectRegister(int project_no);
	
	public void projectInfoView(int project_no);
	
	// --- ���������� ---
	//���� ���� ���� ������Ʈ ����Ʈ
	public List<ProjectVO> processing_project_list(int member_no);
	//���� ������Ʈ ����Ʈ
	public List<ProjectVO> end_project_list(int member_no);
}
