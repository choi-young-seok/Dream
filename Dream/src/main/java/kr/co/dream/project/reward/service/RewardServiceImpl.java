package kr.co.dream.project.reward.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.project.reward.domain.RewardVO;
import kr.co.dream.project.reward.persistence.RewardDAO;

@Service
public class RewardServiceImpl implements RewardService {

	@Inject
	private RewardDAO rewardDAO;

	@Override
	public void rewardInfoRegister(List<RewardVO> rewards) {
		System.out.println("������ ��� ����");
		for (int i = 0; i < rewards.size(); i++) {
			System.out.println(rewards.get(i).toString());
		}
		rewardDAO.rewardInfoRegister(rewards);
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