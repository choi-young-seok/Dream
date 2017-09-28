package kr.co.dream.mypage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.support.domain.SupportPointDTO;

@Repository
public class MySupportDAOImpl implements MySupportDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<SupportPointDTO> get_mySupport_reward_info_list(SupportPointDTO pointDTO) {
		return sqlSession.selectList("support_info.get_mySupport_reward_info_list", pointDTO);
	}
	@Override
	public List<SupportPointDTO> get_mySupport_noReward_info_list(SupportPointDTO pointDTO) {
		return sqlSession.selectList("support_info.get_mySupport_noReward_info_list", pointDTO);
	}

}
