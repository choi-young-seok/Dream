package kr.co.dream.support.persistence;

import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.reward.domain.RewardVO;
import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;

public interface SupportDAO {
	//후원정보등록
	public int support_Register(SupportVO supportVO);
	public void project_nowAmount_update(SupportVO supportVO);
	public void reward_limited_count_update(int reward_no);
	public ProjectVO get_projectUser_profile(int project_no);
	public int shipping_address_register(ShippingAddressVO addressVO);
	public void shipping_items_register(ShippingItemsVO itemsVO);
	
	//후원정보조회
	public SupportVO get_support_info(int support_no);
	public ShippingAddressVO get_support_shipping_info(int shipping_address_no);
	public ShippingItemsVO get_support_shipping_items_info(int shipping_address_no);
	public RewardVO get_support_items(int total_reward_no);
}
