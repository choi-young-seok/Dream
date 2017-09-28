package kr.co.dream.support.service;

import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.domain.supportPayInfoDTO;

public interface SupportService {
	public int supportRegister_noReward(SupportVO supportVO);
	public int supportRegister_reward(SupportVO supportVO);
	
	public SupportDetailDTO get_SupportDetail(int member_no, int support_no, String payback_check);
	public void update_paybackInfo(supportPayInfoDTO payInfoDTO);
	
}
