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
		addressVO.setAddress_member_name("�ֿ뼮");
		addressVO.setAddress_member_phone("010-3338-5525");
		addressVO.setAddress_alias("��");
		// addressVO.setAddress("����Ư���� ��õ�� ���굿");
		// addressVO.setZip_code(561340);
		addressVO.setMember_detail_address("����� 602ȣ");

		System.out.println(addressVO);
	}

	// @Test
	public void projectProjfileDTOTest() {
		ProjectProfileDTO profileDTO = new ProjectProfileDTO();

		profileDTO.setProject_no(1);
		profileDTO.setRegister_name("ȫ�浿");
		profileDTO.setRegister_intro("�ȳ��ϼ���");
		profileDTO.setMember_profile("�������/���ϸ�ó��/��¥ó��/�̹����̸�");

		MemberAddressVO MemberddressVO = new MemberAddressVO();
		MemberddressVO.setMember_no(1);
		// MemberddressVO.setMember_address_no(1);
		MemberddressVO.setAddress_member_name("�ֿ뼮");
		MemberddressVO.setAddress_member_phone("010-3338-5525");
		MemberddressVO.setAddress_alias("��");
		MemberddressVO.setMember_detail_address("����� 602ȣ");

		AddressVO addressVO = new AddressVO();
		addressVO.setAddress("����Ư���� ��õ�� ���굿");
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
		memberAddressVO.setAddress_member_name("���̿�");
		memberAddressVO.setAddress_member_phone("010-5107-0533");
		memberAddressVO.setAddress_alias("������");
		memberAddressVO.setMember_address("���ֱ����� ���� ��ȣ�� �ο�����Ʈ");
		memberAddressVO.setMember_address_zip_code(561340);
		memberAddressVO.setMember_detail_address("102�� 103ȣ");

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
