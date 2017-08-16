package kr.co.dream.address.persistence;

import java.util.List;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.project.domain.ProjectVO;

public interface AddressDAO {
	
	public List<FindResultAddressVO> findResultAddress(SearchCriteria criteria);
	public int listSearchCount(SearchCriteria criteria);
}
