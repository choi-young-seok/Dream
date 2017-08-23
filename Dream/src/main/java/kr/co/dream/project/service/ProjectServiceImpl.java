package kr.co.dream.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persitence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Inject
	private ProjectDAO dao;

	// ----- 프로젝트 등록 -----
	// 프로젝트 기본정보 등록
	@Override
	public int projectBasicInfo(ProjectVO projectBasicInfo) {
		return dao.projectBasicInfo(projectBasicInfo);
	}

	// 프로젝트 스토리 정보 등록
	@Override
	public void projectStoryInfo(ProjectVO projectStoryInfo) {
		dao.projectStoryInfo(projectStoryInfo);
	}

	// 프로젝트 프로필 정보 등록
	@Override
	public void projectProfileInfo(ProjectVO projectProfileInfo) {
		dao.projectProfileInfo(projectProfileInfo);
	}

	// 프로젝트 계좌 정보 등록
	@Override
	public void projectAccountInfo(ProjectVO projectAccountInfo) {
		System.out.println("ProjectServiceImpl \tprojectAccountInfo \t" + projectAccountInfo.toStringAccountInfo());
		dao.projectAccountInfo(projectAccountInfo);
	}

	// 프로젝트 미리보기 화면 : 1 ~ 5단계의 프로젝트 입력 정보 조회
	@Override
	public ProjectVO projectPreview(int project_no) {
		System.out.println("ProjectServiceImpl \tprojectPreview \t" + project_no);
		ProjectVO projectVO = dao.projectInfoView(project_no);
		return projectVO;
	}

	// 프로젝트 최종 등록
	@Override
	public void projectRegister(int project_no) {
		dao.projectRegister(project_no);
	}
	// ----- 프로젝트 등록 로직 끝 -----

	// 프로젝트 조회 화면 및 조회수 처리
	@Transactional
	@Override
	public ProjectVO projectInfoView(int project_no) {
		ProjectVO projectVO = dao.projectInfoView(project_no);
		dao.projectViewCnt(project_no);
		return projectVO;

	}

	// 프로젝트 결제화면 프로젝트 간략 정보 조회
	@Override
	public ProjectPointDTO support_project_point_info(int project_no) {
		return dao.support_project_point_info(project_no);
	}

	// 마이페이지 프로젝트
	@Override
	public List<ProjectPointDTO> myProjectList(int member_no, String request) {
		if (request.equals("processing_project")) {
			System.out.println("진행 중 프로젝트 목록");
		} else if (request.equals("success_project")) {
			System.out.println("성공 프로젝트 목록");
		} else if (request.equals("expire_project")) {
			System.out.println("만료 프로젝트 목록");
		} else if (request.equals("during_registration")) {
			System.out.println("등록 중 프로젝트 목록");
		} else {

		}
		return null;
	}

}
