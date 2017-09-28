package kr.co.dream.mypage.persistence;

import java.util.List;

import kr.co.dream.support.domain.SupportPointDTO;

public interface MySupportDAO {

	public List<SupportPointDTO> get_mySupport_reward_info_list(SupportPointDTO pointDTO);
	public List<SupportPointDTO> get_mySupport_noReward_info_list(SupportPointDTO pointDTO);
}
