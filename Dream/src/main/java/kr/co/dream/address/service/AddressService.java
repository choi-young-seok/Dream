package kr.co.dream.address.service;

import java.util.List;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;

public interface AddressService {
	
	public List<FindResultAddressVO> findResultAddress(SearchCriteria criteria);
	public int listSearchCount(SearchCriteria criteria);
}
