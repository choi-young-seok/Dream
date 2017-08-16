package kr.co.dream.mainView.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.domain.ProjectInfoDto;
import kr.co.dream.project.domain.ProjectVO;

@Repository
public class MainListDAOImpl implements MainListDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectVO> mainList() {
		List<ProjectVO> mainList = sqlSession.selectList("mainList.mainList", null, new RowBounds(0, 10));
		return mainList;
	}

	@Override
	public List<ProjectVO> mainList2() {
		List<ProjectVO> mainList = sqlSession.selectList("mainList.mainList2", null, new RowBounds(0, 10));
		return mainList;
	}
	
	@Override
	public ProjectInfoDto getDTO(int project_no){
		return sqlSession.selectOne("mainList.getDTO", project_no);
	}
	
}
