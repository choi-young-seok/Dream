package kr.co.dream.reward.service;

import java.util.List;

import kr.co.dream.reward.domain.RewardVO;


public interface RewardService {
	
	//������ �Է�
	public void rewardInfoRegister(List<RewardVO> rewards);
	//������ ����
	
	//������ ����
	
	//������ ��ȸ
	public RewardVO getReward(int reward_no);
	
	//������ ��� ��ȸ
	public List<RewardVO> rewardList(int project_no);
}
