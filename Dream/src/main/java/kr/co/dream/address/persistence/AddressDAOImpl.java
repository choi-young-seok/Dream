package kr.co.dream.address.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.project.domain.ProjectVO;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<FindResultAddressVO> findResultAddress(SearchCriteria criteria) {
		return sqlSession.selectList("address.findAddress",criteria.getKeyword(), new RowBounds(criteria.getPageStart(), criteria.getPerPageNum()));
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) {
		return sqlSession.selectOne("address.listSearchCount", criteria);
	}
}
