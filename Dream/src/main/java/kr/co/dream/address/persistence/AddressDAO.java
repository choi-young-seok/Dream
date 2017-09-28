package kr.co.dream.address.persistence;

import java.util.List;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.supportPayInfoDTO;

public interface AddressDAO {
	
	//주소검색 모달 
	public List<AddressVO> findResultAddress(SearchCriteria criteria);
	public int listSearchCount(SearchCriteria criteria);
	
	//프로젝트 등록 주소지 delivery_addres컬럼 상태 변경 NULL -> delivery_address
	public void update_project_delivery_address(int address_member_no);
	
	//프로젝트 등록자 배송지 조회
	public MemberAddressVO get_project_delivery_address(int project_no);
	
	//마이페이지 회원 주소관리
	public int insert_memberAddress(MemberAddressVO memberAddressVO);
	public List<MemberAddressVO> get_memberAddress_list(int member_no);
	public void update_memberAddress(MemberAddressVO memberAddressVO);
	public void delete_memberAddress(int address_member_no);
	public MemberAddressVO get_memberAddress(int address_member_no);
	
	//후원하기 화면
	public int get_memberAddress_count(int member_no);
	public MemberAddressVO get_laterMemberAddress(int member_no);
	
	//후원 완료 화면
	public SupportDeliveryDTO get_receiverAddress(int support_no);
	public void update_receiverAddress(SupportDeliveryDTO deliveryDTO);
	
}
