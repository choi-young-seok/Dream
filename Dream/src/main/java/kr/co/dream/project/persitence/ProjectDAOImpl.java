package kr.co.dream.project.persitence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.project.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public ProjectVO testSelectOne() {
		return null;
	}
}
