package kr.co.dream.project.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.persitence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService{
		
	@Inject
	private ProjectDAO dao;

	@Override
	public ProjectVO testSelectOne() {
		return dao.testSelectOne();
	}
	
}
