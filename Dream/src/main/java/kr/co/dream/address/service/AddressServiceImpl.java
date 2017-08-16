package kr.co.dream.address.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.paging.domain.SearchCriteria;

@Service
public class AddressServiceImpl implements AddressService {

	@Inject
	private AddressDAO address;
	
	@Override
	public List<FindResultAddressVO> findResultAddress(SearchCriteria criteria) {
		return address.findResultAddress(criteria);
	}

	@Override
	public int listSearchCount(SearchCriteria criteria) {
		return address.listSearchCount(criteria);
	}

}
