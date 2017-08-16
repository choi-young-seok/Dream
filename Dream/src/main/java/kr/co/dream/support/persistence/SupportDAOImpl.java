package kr.co.dream.support.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.reward.domain.RewardVO;
import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;

@Repository
public class SupportDAOImpl implements SupportDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public int support_Register(SupportVO supportVO) {
		sqlSession.insert("support.support_register", supportVO);
		return supportVO.getSupport_no();
	}

	@Override
	public void project_nowAmount_update(SupportVO supportVO) {
		sqlSession.update("support.project_nowAmount_update",supportVO);
	}

	@Override
	public void reward_limited_count_update(int reward_no) {
		sqlSession.update("support.reward_limited_count_update",reward_no);
	}

	@Override
	public ProjectVO get_projectUser_profile(int project_no) {
		return sqlSession.selectOne("support.get_projectUser_profile", project_no);
	}

	@Override
	public int shipping_address_register(ShippingAddressVO addressVO) {
		sqlSession.insert("support.shipping_address_register",addressVO);
		return addressVO.getShipping_address_no();
	}

	@Override
	public void shipping_items_register(ShippingItemsVO itemsVO) {
		sqlSession.insert("support.shipping_items_register", itemsVO);
	}

	@Override
	public SupportVO get_support_info(int support_no) {
		return sqlSession.selectOne("support.get_support_info", support_no);
	}
	
	@Override
	public ShippingAddressVO get_support_shipping_info(int shipping_address_no) {
		return sqlSession.selectOne("support.get_support_shipping_info", shipping_address_no);
	}

	@Override
	public ShippingItemsVO get_support_shipping_items_info(int shipping_address_no) {
		return sqlSession.selectOne("support.get_support_shipping_items_info", shipping_address_no);
	}

	@Override
	public RewardVO get_support_items(int total_reward_no) {
		return sqlSession.selectOne("support.get_support_items",total_reward_no);
	}

}
