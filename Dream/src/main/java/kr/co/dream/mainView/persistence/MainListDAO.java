package kr.co.dream.mainView.persistence;

import java.util.List;

import kr.co.dream.project.domain.ProjectInfoDto;
import kr.co.dream.project.domain.ProjectVO;

public interface MainListDAO {

	public List<ProjectVO> mainList();
	public List<ProjectVO> mainList2();
	ProjectInfoDto getDTO(int project_no);
	
	
}
