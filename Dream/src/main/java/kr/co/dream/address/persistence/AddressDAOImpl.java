package kr.co.dream.address.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.supportPayInfoDTO;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<AddressVO> findResultAddress(SearchCriteria criteria) {
		return sqlSession.selectList("address.searchAddress",
				criteria.getKeyword(), new RowBounds(criteria.getPageStart(), criteria.getPerPageNum()));
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) {
		return sqlSession.selectOne("address.listSearchCount", criteria);
	}
	
	@Override
	public void update_project_delivery_address(int address_member_no) {
		sqlSession.update("address.update_project_delivery_address",address_member_no);
	}
	
	@Override
	public MemberAddressVO get_project_delivery_address(int project_no) {
		return sqlSession.selectOne("address.get_project_delivery_address", project_no);
	}
	

	@Override
	public int insert_memberAddress(MemberAddressVO memberAddressVO) {
		sqlSession.insert("address.insert_memberAddress",memberAddressVO);
		return memberAddressVO.getAddress_member_no();
	}

	@Override
	public List<MemberAddressVO> get_memberAddress_list(int member_no) {
		return sqlSession.selectList("address.get_memberAddress_list", member_no);
	}

	@Override
	public void update_memberAddress(MemberAddressVO memberAddressVO) {
		sqlSession.update("address.update_memberAddress", memberAddressVO);
	}

	@Override
	public void delete_memberAddress(int address_member_no) {
		sqlSession.delete("address.delete_memberAddress", address_member_no);
	}

	@Override
	public MemberAddressVO get_memberAddress(int address_member_no) {
		return sqlSession.selectOne("address.get_memberAddress",address_member_no);
	}
	
	@Override
	public SupportDeliveryDTO get_receiverAddress(int support_no) {
		return sqlSession.selectOne("address.get_receiverAddress",support_no);
	}

	@Override
	public int get_memberAddress_count(int member_no) {
		return sqlSession.selectOne("address.get_memberAddress_count",member_no);
	}

	@Override
	public MemberAddressVO get_laterMemberAddress(int member_no) {
		return sqlSession.selectOne("address.get_laterMemberAddress",member_no);
	}

	@Override
	public void update_receiverAddress(SupportDeliveryDTO deliveryDTO) {
		System.out.println(deliveryDTO);
		sqlSession.update("address.update_receiverAddress", deliveryDTO);
	}




	
}
