package kr.co.dream.supportInfoTest;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportPointDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SupportInfoTest {

	@Inject
	private SqlSession session;
	
//	@Test
//	public void supportPointInfoTest(){
//		SupportPointDTO supportPointDTO = new SupportPointDTO();
//		String payback_check = "N";
//		int member_no = 4;
//		
//		supportPointDTO.setPayback_check(payback_check);
//		supportPointDTO.setMember_no(member_no);
//		
//		session.selectList("support_info.support_point_info",supportPointDTO);
//		
//	}
	
////	@Test
//	public void supportDeatilInfoTest(){
//		SupportDetailDTO supportDetailDTO = new SupportDetailDTO();
//		int support_no = 114;
//		String payback_check = "N";
//		
//		supportDetailDTO.setSupport_no(support_no);
//		supportDetailDTO.setPayback_check(payback_check);
//
//		supportDetailDTO = session.selectOne("support_info.support_detail_info",supportDetailDTO);
//		System.out.println(supportDetailDTO.toString());
//	}
	
//	@Test
	public void supportDeliveryInfoTest(){
		SupportDeliveryDTO supportDeliveryDTO = new SupportDeliveryDTO();
		
		
		int support_no = 74;
		
		supportDeliveryDTO.setSupport_no(support_no);
		
//		supportDeliveryDTO = session.selectOne("support_resultMap.support_delivery_info",support_no);
		System.out.println(supportDeliveryDTO);
	}
	
//	@Test
	public void supportDetailInfoTest(){
		SupportDetailDTO supportDetailDTO = new SupportDetailDTO();
		
		
		int support_no = 74;
		
		supportDetailDTO.setSupport_no(support_no);
		
		supportDetailDTO = session.selectOne("support_info.support_detail_info",support_no);
		System.out.println(supportDetailDTO);
	}
	
	@Test
	public void supportPointInfoTest(){
		int member_no = 2;
		List<SupportPointDTO> pointDTOs = session.selectList("support_info.get_support_point_info", member_no);
		for (int i = 0; i < pointDTOs.size(); i++) {
		SupportPointDTO pointDTO = pointDTOs.get(i);  
			System.out.println(pointDTO);
		} 
	}
	
}
