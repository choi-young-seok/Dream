package kr.co.dream.address.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.dream.address.domain.AddressVO;
import kr.co.dream.address.service.AddressService;
import kr.co.dream.paging.domain.PageMaker;
import kr.co.dream.paging.domain.SearchCriteria;

@RestController
public class Rest_searchAddressController {

	@Inject
	private AddressService addressService;

	@RequestMapping(value = "/serachAddressList")
	public ResponseEntity<Map<String, Object>> searchAddressList(SearchCriteria criteria) {
		System.out.println(criteria);
		System.out.println(criteria.getPage());
		System.out.println(criteria.getPageStart());
		ResponseEntity<Map<String, Object>> entity;
		entity = new ResponseEntity<Map<String, Object>>(addressService.findResultAddress(criteria), HttpStatus.OK);

		return entity;
	}
	
//	@RequestMapping(value = "/serachAddressList")
//	public ResponseEntity<Map<String, Object>> searchAddressList(SearchCriteria criteria) {
//		System.out.println("AddressRestController \tsearchAddressList \tinput value : " + criteria.getKeyword());
//		PageMaker pageMaker = new PageMaker();
//		
//		pageMaker.setCri(criteria);
//		pageMaker.setTotalCount(addressService.listSearchCount(criteria));
//		
//		List<AddressVO> addressList = addressService.findResultAddress(criteria);
//		
//		Map<String, Object> listResultMap = new HashMap<>();
//		
//		if (addressList.size() == 0) {
//			listResultMap.put("noData", null);
//		} else {
//			listResultMap.put("success", addressList);
//			listResultMap.put("pageMaker", pageMaker);
//		}
//		
//		ResponseEntity<Map<String, Object>> entity;
//		entity = new ResponseEntity<Map<String, Object>>(listResultMap, HttpStatus.OK);
//		
//		return entity;
//	}
}
