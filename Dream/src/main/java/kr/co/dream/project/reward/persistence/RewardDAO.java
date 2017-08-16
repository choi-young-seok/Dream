package kr.co.dream.project.reward.persistence;

import java.util.List;

import kr.co.dream.project.reward.domain.RewardVO;

public interface RewardDAO {
	
	public void rewardInfoRegister(List<RewardVO> rewards);
	
	//결제시 선택 리워드 조회
	public RewardVO getReward(int reward_no);
	
	//프로젝트 리워드 목록 조회
	public List<RewardVO> rewardList(int project_no);
}
