package kr.co.dream.supportTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.persistence.SupportDAO;
import oracle.net.aso.i;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SupportTest {

	@Inject
	private SupportDAO supportDAO;

	@Inject
	private SqlSession sqlSession;

	
	@Test
	public void setSupportVO(){
		SupportVO supportVO = new SupportVO();
		supportVO.setMember_no(1);
		supportVO.setProject_no(59);
		supportVO.setTotal_reward_no(34);
		supportVO.setMember_name("최용석");
		supportVO.setPay_method("card");
		supportVO.setPay_account_number("110411833284");
		supportVO.setSupport_amount(50000);
		
//		supportDAO.support_Register(supportVO);
		supportDAO.project_nowAmount_update(supportVO);
//		supportDAO.reward_limited_count_update(supportVO.getTotal_reward_no());
//		System.out.println(supportDAO.get_projectUser_profile(supportVO.getProject_no()));
		
		ShippingAddressVO addressVO = new ShippingAddressVO();
		addressVO.setSender_name("윤미영");
		addressVO.setSender_address("광주광역시 서구 금호동 부영아파트 102동 103호");
		addressVO.setSender_phone("01051910533");
		addressVO.setReceiver_name("최용석");
		addressVO.setReceiver_phone("010-3338-5525");
		addressVO.setZip_code(561340);
		addressVO.setReceiver_address("서울특별시 금천구 가산동 237-75");
		addressVO.setDetail_address("동명빌 604호");

		System.out.println(supportDAO.shipping_address_register(addressVO));
		
		ShippingItemsVO itemsVO = new ShippingItemsVO();
		itemsVO.setShipping_address_no(1);
		itemsVO.setMember_no(1);
		itemsVO.setSupport_no(1);
		itemsVO.setProject_no(59);
		itemsVO.setTotal_reward_no(34);
		
//		supportDAO.shipping_items_register(itemsVO);
//		System.out.println(supportDAO.get_support_shipping_info(itemsVO.getShipping_address_no()));
//		System.out.println(supportDAO.get_support_shipping_items_info(itemsVO.getShipping_address_no()));
		
	}



	
	public void support_Register(SupportVO supportVO) {
		sqlSession.insert("support_register", supportVO);
	}

	public void project_nowAmount_update() {

	}

	public void reward_limited_count_update() {

	}

	public ProjectVO get_projectUser_profile(int project_no) {
		return null;
	}

	public void shipping_address_register(ShippingAddressVO addressVO) {

	}

	public void shipping_items_register(int shipping_address_no) {

	}

	public ShippingAddressVO get_support_shipping_info(int shipping_address_no) {
		return null;
	}

	public ShippingItemsVO get_support_shipping_items_info(int shipping_address_no) {
		return null;
	}
}
