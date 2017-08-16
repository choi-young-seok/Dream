package kr.co.dream.project.reward.domain;

import java.util.List;

public class RewardsList {

	private List<RewardVO> rewardsList;

	public List<RewardVO> getRewardsList() {
		return rewardsList;
	}

	public void setRewardsList(List<RewardVO> rewardsList) {
		this.rewardsList = rewardsList;
	}

	@Override
	public String toString() {
		return "RewardsList [rewardsList=" + rewardsList + "]";
	}

}
