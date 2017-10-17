package kr.co.dream.supportTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.support.persistence.SupportDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SupportTest {

	@Inject
	private SupportDAO supportDAO;

	@Inject
	private AddressDAO addressDAO;

	@Inject
	private SqlSession sqlSession;

	
//	@Test
//	public void setSupportVO(){
//		SupportVO supportVO = new SupportVO();
//		
//		supportVO.setMember_no(2);
//		supportVO.setProject_no(30);
//		
//		supportVO.setMember_name("안태수");
//		supportVO.setPay_method("card");
//		supportVO.setPay_account_number("110411833284");
//		supportVO.setSupport_amount(50000);
//		
//		int support_no = supportDAO.support_Register(supportVO);
//		System.out.println(support_no);
//		supportDAO.project_nowAmount_update(supportVO);
//		
//		SupportDeliveryDTO addressVO = new SupportDeliveryDTO();
//		addressVO.setTotal_reward_no(35);
//		addressVO.setReceiver_name("안태수");
//		addressVO.setReceiver_address_alias("의왕");
//		addressVO.setReceiver_zip_code(561340);
//		addressVO.setReceiver_address("경기도 의명시 원룸촌");
//		addressVO.setReceiver_detail_address("아트빌 604호");
//		addressVO.setReceiver_phone("010-3338-5525");
//		supportVO.setDeliveryDTO(addressVO);
//
//		supportDAO.reward_limited_count_update(supportVO.getDeliveryDTO().getTotal_reward_no());
////		
//		supportVO.getDeliveryDTO().setSenderAddressVO(addressDAO.get_project_delivery_address(supportVO.getProject_no()));
////		
//		System.out.println(supportVO.getDeliveryDTO().getSenderAddressVO());
////		
////		
//		int delivery_no = supportDAO.delivery_address_register(supportVO.getDeliveryDTO());
//
//		
//	}
	
	@Test
	public void senderAddressTest(){
		addressDAO.get_project_delivery_address(109);
	}
}
