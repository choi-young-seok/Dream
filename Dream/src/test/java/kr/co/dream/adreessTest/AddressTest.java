package kr.co.dream.adreessTest;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.address.domain.FindResultAddressVO;
import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.address.service.AddressService;
import kr.co.dream.paging.domain.SearchCriteria;
import kr.co.dream.project.domain.ProjectVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class AddressTest {
	
	@Inject
	private AddressDAO addressDAO;
	
	@Inject
	private AddressService addressService;

	@Test
	public void findAddressTest(){
		
		SearchCriteria criteria = new SearchCriteria();
		criteria.setKeyword("가산동");
		criteria.setPage(1);
		criteria.setPerPageNum(10);
//		criteria.getPageStart();
//		System.out.println(criteria.getKeyword());
//		System.out.println(criteria.getPage());
//		System.out.println(criteria.getPerPageNum());
//		System.out.println(criteria.getPageStart());
		
		List<FindResultAddressVO> findList = addressService.findResultAddress(criteria);
		for (int i = 0; i < findList.size(); i++) {
			FindResultAddressVO a = findList.get(i);
			System.out.println(a.toString());
		}
		System.out.println(addressDAO.listSearchCount(criteria));
	}
	
//	@Test
	public void selectSearchCount(){
		SearchCriteria criteria = new SearchCriteria();
		criteria.setKeyword("가산동");
		
		System.out.println(addressDAO.listSearchCount(criteria));
	}
	
}
