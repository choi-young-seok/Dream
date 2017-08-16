package kr.co.dream.project.reward.service;

import java.util.List;

import kr.co.dream.project.reward.domain.RewardVO;

public interface RewardService {
	
	//리워드 입력
	public void rewardInfoRegister(List<RewardVO> rewards);
	//리워드 수정
	
	//리워드 삭제
	
	//리워드 조회
	public RewardVO getReward(int reward_no);
	
	//리워드 목록 조회
	public List<RewardVO> rewardList(int project_no);
}
