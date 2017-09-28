package kr.co.dream.reward.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.reward.domain.RewardVO;
import kr.co.dream.reward.persistence.RewardDAO;

@Service
public class RewardServiceImpl implements RewardService {

	@Inject
	private RewardDAO rewardDAO;

	@Transactional
	@Override
	public void rewardInfoRegister(List<RewardVO> rewards) {
		System.out.println("리워드 등록 서비스");
		for (int i = 0; i < rewards.size(); i++) {
			System.out.println(rewards.get(i).toString());
		}
		try {
			rewardDAO.rewardInfoRegister(rewards);
			rewardDAO.rewardRegisterState(rewards.get(0).getProject_no());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public RewardVO getReward(int reward_no) {
		return rewardDAO.getReward(reward_no);
	}

	@Override
	public List<RewardVO> rewardList(int project_no) {
		return rewardDAO.rewardList(project_no);

	}

}
