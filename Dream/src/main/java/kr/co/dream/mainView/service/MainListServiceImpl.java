package kr.co.dream.mainView.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.mainView.persistence.MainListDAO;
import kr.co.dream.project.domain.ProjectVO;

@Service
public class MainListServiceImpl implements MainListService{

	@Inject
	private MainListDAO dao;
	
	@Override
	public List<ProjectVO> mainList() {
		
		return dao.mainList();
	}
}
