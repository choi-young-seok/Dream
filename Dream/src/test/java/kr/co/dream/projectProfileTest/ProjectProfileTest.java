package kr.co.dream.projectProfileTest;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.project.domain.ProjectProfileDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ProjectProfileTest {

	@Inject
	private SqlSession session;
	
	@Test
	public void memberProfile_updateTest(){
		ProjectProfileDTO dto = new ProjectProfileDTO();
		dto.setMember_profile("/uploadFile/rcn115@naver.com/register_profile/2017/09/10/s_d3aaaab6-d32f-4968-a8aa-8962373dd5cf_사진.png");
		dto.setMember_no(2);
		
		session.update("projectRegister.projectMemberProfile_update",dto);
	}
	
	@Test
	public void memberAddress_insertTest(){
		MemberAddressVO addressVO = new MemberAddressVO();
		addressVO.setMember_no(2);
		addressVO.setAddress_member_name("최용석");
		addressVO.setAddress_alias("집");
		addressVO.setMember_address_zip_code(153023);
		addressVO.setMember_address("서울특별시 금천구 가산동");
		addressVO.setMember_detail_address("동명빌 602호");
		addressVO.setAddress_member_phone("010-3338-5525");
		
		session.insert("projectRegister.memberAddress_insert", addressVO);
	}
}
