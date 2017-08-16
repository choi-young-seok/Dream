package kr.co.dream.project.rewardTest;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dream.project.reward.domain.RewardVO;
import kr.co.dream.project.reward.persistence.RewardDAO;
import kr.co.dream.project.reward.service.RewardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class RewardTest {

	@Inject
//	private RewardService service;
//	private RewardDAO service;
	private SqlSession sqlsession;
	
//	@Test
	public void rewardList(){
		List<RewardVO> rewardList = sqlsession.selectList("reward.rewardList",51);
		for(int i = 0 ; i <= rewardList.size() ; i++){
			System.out.println(rewardList.get(i).toString());
		}
	}

}
