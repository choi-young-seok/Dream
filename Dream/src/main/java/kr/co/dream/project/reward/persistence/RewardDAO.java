package kr.co.dream.project.reward.persistence;

import java.util.List;

import kr.co.dream.project.reward.domain.RewardVO;

public interface RewardDAO {
	
	//������Ʈ ������ ���� ���
	public void rewardInfoRegister(List<RewardVO> rewards);
	public void rewardRegisterState(int project_no);
	
	//������ ���� ������ ��ȸ
	public RewardVO getReward(int reward_no);
	
	//������Ʈ ������ ��� ��ȸ
	public List<RewardVO> rewardList(int project_no);
}
