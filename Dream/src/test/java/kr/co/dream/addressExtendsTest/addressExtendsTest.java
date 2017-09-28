package kr.co.dream.addressExtendsTest;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.member.domain.MemberVO;
import kr.co.dream.project.domain.ProjectProfileDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class addressExtendsTest {

	@Inject
	private AddressDAO dao;

	// @Test
	public void addressExtesndsTest() {
		MemberAddressVO addressVO = new MemberAddressVO();
		addressVO.setMember_no(1);
		// addressVO.setMember_address_no(1);
		addressVO.setAddress_member_name("최용석");
		addressVO.setAddress_member_phone("010-3338-5525");
		addressVO.setAddress_alias("집");
		// addressVO.setAddress("서울특별시 금천구 가산동");
		// addressVO.setZip_code(561340);
		addressVO.setMember_detail_address("동명빌 602호");

		System.out.println(addressVO);
	}

	// @Test
	public void projectProjfileDTOTest() {
		ProjectProfileDTO profileDTO = new ProjectProfileDTO();

		profileDTO.setProject_no(1);
		profileDTO.setRegister_name("홍길동");
		profileDTO.setRegister_intro("안녕하세요");
		profileDTO.setMember_profile("서버경로/파일명처리/날짜처리/이미지이름");

		MemberAddressVO MemberddressVO = new MemberAddressVO();
		MemberddressVO.setMember_no(1);
		// MemberddressVO.setMember_address_no(1);
		MemberddressVO.setAddress_member_name("최용석");
		MemberddressVO.setAddress_member_phone("010-3338-5525");
		MemberddressVO.setAddress_alias("집");
		MemberddressVO.setMember_detail_address("동명빌 602호");

		AddressVO addressVO = new AddressVO();
		addressVO.setAddress("서울특별시 금천구 가산동");
		addressVO.setZip_code(561340);
		// MemberddressVO.setAddressVO(addressVO);

		profileDTO.setMemberAddressVO(MemberddressVO);
		System.out.println(profileDTO);
	}

	@Test
	public void addressCRUDTest() {
		MemberAddressVO memberAddressVO = new MemberAddressVO();
		memberAddressVO.setMember_no(3);
		memberAddressVO.setAddress_member_no(9);
		memberAddressVO.setAddress_member_name("윤미영");
		memberAddressVO.setAddress_member_phone("010-5107-0533");
		memberAddressVO.setAddress_alias("광주집");
		memberAddressVO.setMember_address("광주광역시 서구 금호동 부영아파트");
		memberAddressVO.setMember_address_zip_code(561340);
		memberAddressVO.setMember_detail_address("102동 103호");

		// dao.insert_memberAddress(memberAddressVO);
		// dao.update_memberAddress(memberAddressVO);
		dao.delete_memberAddress(10);
		// dao.get_memberAddress(memberAddressVO.getAddress_member_no());
		// dao.get_memberAddress_list(memberAddressVO.getMember_no());
	}

	@Test
	public void collectionTest() {
		
		Collection<MemberAddressVO> col;
		col = dao.get_memberAddress_list(2);
		
		List<MemberAddressVO> memberList = (List<MemberAddressVO>) col;
		MemberAddressVO memberAddressVO = memberList.get(1);
		System.out.println(memberAddressVO);
		
	}

}
