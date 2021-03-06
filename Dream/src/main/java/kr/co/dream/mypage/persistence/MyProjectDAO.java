package kr.co.dream.mypage.persistence;

import java.util.List;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.support.domain.SupportPointDTO;

public interface MyProjectDAO {

	public List<ProjectPointDTO> myProjectList(MyProjectCondition projectCondition);

	public ProjectVO during_registration(MyProjectCondition projectCondition);

}
