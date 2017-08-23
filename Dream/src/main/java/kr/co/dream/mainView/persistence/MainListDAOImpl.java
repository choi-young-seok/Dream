package kr.co.dream.mainView.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.domain.ProjectPointDTO;

@Repository
public class MainListDAOImpl implements MainListDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectPointDTO> mainList() {
		List<ProjectPointDTO> mainList = sqlSession.selectList("mainList.projectPointInfoList", null, new RowBounds(0, 10));
		return mainList;
	}
}
