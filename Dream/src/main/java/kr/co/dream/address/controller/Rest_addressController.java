package kr.co.dream.address.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.address.service.AddressService;
import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.supportPayInfoDTO;

@RestController
public class Rest_addressController {

	@Inject
	private AddressService service;

	// ����� ��� �ּҸ�� ��ȸ
	@RequestMapping(value = "/get_memberAddress_list/{member_no}", method = RequestMethod.GET)
	public ResponseEntity<List<MemberAddressVO>> get_memberAddress_list(@PathVariable("member_no") int member_no) {
		System.out.println("��䰡");
		ResponseEntity<List<MemberAddressVO>> entity = null;
		entity = new ResponseEntity<List<MemberAddressVO>>(service.get_memberAddress_list(member_no), HttpStatus.OK);
		return entity;
	}

	// �Ŀ�ȭ�� �ֽ� ����� ��ȸ
	@RequestMapping(value = "/get_laterMemberAddress/{member_no}", method = RequestMethod.GET)
	public MemberAddressVO get_laterMemberAddress(@PathVariable("member_no") int member_no) {
		return service.get_laterMemberAddress(member_no);

	}

	// ���� ����� ��ȸ
	@RequestMapping(value = "/get_memberAddress/{address_member_no}", method = RequestMethod.GET)
	public MemberAddressVO get_memberAddress(@PathVariable("address_member_no") int address_member_no) {
		return service.get_memberAddress(address_member_no);

	}

	// �Ŀ��Ϸ� ȭ�� ����� ��ȸ
	@RequestMapping(value = "/get_receiverAddress/{support_no}", method = RequestMethod.GET)
	public SupportDeliveryDTO get_receiverAddress(@PathVariable("support_no") int support_no) {
		SupportDeliveryDTO deliveryDTO = service.get_receiverAddress(support_no);
		System.out.println(deliveryDTO);
		return deliveryDTO;

	}

	// �ּ��Է�(�߰�)
	@RequestMapping(value = "/insert_memberAddress", method = RequestMethod.POST)
	public ResponseEntity<String> insert_memberAddress(@RequestBody MemberAddressVO memberAddressVO) {
		ResponseEntity<String> entity = null;

		try {
			service.insert_memberAddress(memberAddressVO);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			e.printStackTrace();
		}
		return entity;
	}

	// �ּҼ���
	@RequestMapping(value = "/update_memberAddress", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update_memberAddress(@RequestBody MemberAddressVO memberAddressVO) {
		service.update_memberAddress(memberAddressVO);
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}

	// �ּһ���
	@RequestMapping(value = "/delete_memberAddress/{address_member_no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete_memberAddress(@PathVariable("address_member_no") int address_member_no) {
		service.delete_memberAddress(address_member_no);
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}

	// �Ŀ� �ּҼ���
	@RequestMapping(value = "/update_receiverAddress", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update_receiverAddress(@RequestBody SupportDeliveryDTO SupportDeliveryDTO) {
		service.update_receiverAddress(SupportDeliveryDTO);
		ResponseEntity<String> entity = null;
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}

}
