package kr.co.dream.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.mypage.domain.MyProjectCondition;
import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.support.domain.SupportPointDTO;

@Repository
public class MyProjectDAOImpl implements MyProjectDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ProjectPointDTO> myProjectList(MyProjectCondition projectCondition) {
		return sqlSession.selectList("myProjectList.myProject", projectCondition);
	}

	@Override
	public ProjectVO during_registration(MyProjectCondition projectCondition) {
		return sqlSession.selectOne("myProjectList.during_registration_project", projectCondition);
	}

}
