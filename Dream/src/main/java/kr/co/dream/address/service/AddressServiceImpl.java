package kr.co.dream.address.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.supportPayInfoDTO;

@Service
public class AddressServiceImpl implements AddressService {

	@Inject
	private AddressDAO addressDAO;
	
	@Override
	public List<AddressVO> findResultAddress(SearchCriteria criteria) {
		return addressDAO.findResultAddress(criteria);
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) {
		return addressDAO.listSearchCount(criteria);
	}

	@Override
	public void insert_memberAddress(MemberAddressVO memberAddressVO) {
			addressDAO.insert_memberAddress(memberAddressVO);
	}

	@Override
	public List<MemberAddressVO> get_memberAddress_list(int member_no) {
		return addressDAO.get_memberAddress_list(member_no);
	}

	@Override
	public void update_memberAddress(MemberAddressVO memberAddressVO) {
			addressDAO.update_memberAddress(memberAddressVO);
	}

	@Override
	public void delete_memberAddress(int address_member_no) {
			addressDAO.delete_memberAddress(address_member_no);
	}

	@Override
	public MemberAddressVO get_memberAddress(int address_member_no) {
		return addressDAO.get_memberAddress(address_member_no);
	}
	
	@Override
	public SupportDeliveryDTO get_receiverAddress(int support_no) {
		return addressDAO.get_receiverAddress(support_no);
	}

	@Override
	public int get_memberAddress_count(int member_no) {
		return addressDAO.get_memberAddress_count(member_no);
	}
	

	@Override
	public MemberAddressVO get_laterMemberAddress(int member_no) {
		return addressDAO.get_laterMemberAddress(member_no);
	}

	@Override
	public void update_receiverAddress(SupportDeliveryDTO deliveryDTO) {
		addressDAO.update_receiverAddress(deliveryDTO);
	}



	

}
