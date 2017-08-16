package kr.co.dream.mainView.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.mainView.persistence.MainListDAO;
import kr.co.dream.project.domain.ProjectInfoDto;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persitence.ProjectDAO;

@Service
public class MainListServiceImpl implements MainListService{

	@Inject
	private MainListDAO dao;
	
	@Inject ProjectDAO projectDAO;
		
	@Override
	public List<ProjectVO> mainList() {
		List<ProjectVO> projectList = dao.mainList();
		for (int i = 0; i < projectList.size(); i++) {
			ProjectVO project = projectList.get(i);
			project.setInfoDto(projectDAO.get_project_dto_info(project.getProject_no()));
		}
		return projectList;
	}
	
}
