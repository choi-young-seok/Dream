package kr.co.dream.project.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		sqlSession.insert("projectRegister.projectBasicInfo", projectBasicInfo);
		return projectBasicInfo.getProject_no();
	}
	
	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		sqlSession.update("projectRegister.projectStoryInfo", projectStoryInfo);
	}

	@Override
	public void projectProfileInfo(ProjectVO projectProfileInfo) {
		sqlSession.update("projectRegister.projectProfileInfo", projectProfileInfo);

	}

	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		sqlSession.update("projectRegister.projectAccountInfo", projectAccountInfo);

	}

	@Override
	public void projectRegister(int project_no) {
		sqlSession.update("projectRegister.projectRegister", project_no);
	}

	@Override
	public ProjectVO projectInfoView(int project_no) {
		return sqlSession.selectOne("project_info.projectInfoView", project_no);
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
// ---------------------------
	//���������� : ���� �� ������Ʈ ����Ʈ
	@Override
	public List<ProjectPointDTO> processing_project(int member_no) {
		System.out.println("������");
		return sqlSession.selectList("project_info.myProject_processing", member_no);
	}

	//���������� : ���� ������Ʈ ����Ʈ
	@Override
	public List<ProjectPointDTO> success_project(int member_no) {
		System.out.println("����");
		return null;
	}

	//���������� : ���� ������Ʈ ����Ʈ
	@Override
	public List<ProjectPointDTO> expire_project(int member_no) {
		System.out.println("����");
		return null;
	}

	//���������� : ��� �� ������Ʈ ����Ʈ
	@Override
	public List<ProjectPointDTO> during_registration(int member_no) {
		System.out.println("��� ��");
		return null;
	}

}
