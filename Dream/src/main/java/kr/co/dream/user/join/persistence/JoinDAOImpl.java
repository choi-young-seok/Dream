package kr.co.dream.user.join.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAOImpl implements JoinDAO{

	@Inject
	private SqlSession sqlSession;
	
}
