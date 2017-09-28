package kr.co.dream.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.mypage.persistence.MyProjectDAO;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.support.domain.SupportPointDTO;

@Service
public class MyProjectServiceImpl implements MyProjectService {

	@Inject
	private MyProjectDAO dao;

	@Override
	public List<ProjectPointDTO> myProjectList(MyProjectCondition projectCondition) {
		return dao.myProjectList(projectCondition);
	}

	@Override
	public ProjectVO during_registration(MyProjectCondition projectCondition) {
		return dao.during_registration(projectCondition);
	}

}
