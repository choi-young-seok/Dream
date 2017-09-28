package kr.co.dream.mypage.service;

import java.util.List;

import kr.co.dream.support.domain.SupportPointDTO;

public interface MySupportService {

	public List<SupportPointDTO> get_mySupport_reward_info_list(int member_no, String payback_check);
	public List<SupportPointDTO> get_mySupport_noReward_info_list(int member_no, String payback_check);
	
}
