package kr.co.dream.address.persistence;

import java.util.List;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.supportPayInfoDTO;

public interface AddressDAO {
	
	//�ּҰ˻� ��� 
	public List<AddressVO> findResultAddress(SearchCriteria criteria);
	public int listSearchCount(SearchCriteria criteria);
	
	//������Ʈ ��� �ּ��� delivery_addres�÷� ���� ���� NULL -> delivery_address
	public void update_project_delivery_address(int address_member_no);
	
	//������Ʈ ����� ����� ��ȸ
	public MemberAddressVO get_project_delivery_address(int project_no);
	
	//���������� ȸ�� �ּҰ���
	public int insert_memberAddress(MemberAddressVO memberAddressVO);
	public List<MemberAddressVO> get_memberAddress_list(int member_no);
	public void update_memberAddress(MemberAddressVO memberAddressVO);
	public void delete_memberAddress(int address_member_no);
	public MemberAddressVO get_memberAddress(int address_member_no);
	
	//�Ŀ��ϱ� ȭ��
	public int get_memberAddress_count(int member_no);
	public MemberAddressVO get_laterMemberAddress(int member_no);
	
	//�Ŀ� �Ϸ� ȭ��
	public SupportDeliveryDTO get_receiverAddress(int support_no);
	public void update_receiverAddress(SupportDeliveryDTO deliveryDTO);
	
}
