package kr.co.dream;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.board.domain.LombokTestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class LombokAnnotationTest {
	
	@Test
	public void lombokDataTest(){
		LombokTestVO lombokTestVO = new LombokTestVO();
		lombokTestVO.setNo(1);
		lombokTestVO.setName("�ֿ뼮");
		
		System.out.println(lombokTestVO);
	}

}
