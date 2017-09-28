package kr.co.dream.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dream.mypage.persistence.MySupportDAO;
import kr.co.dream.support.domain.SupportPointDTO;

@Service
public class MySupportServiceImpl implements MySupportService {

	@Inject
	private MySupportDAO mySupportDAO;

	@Override
	public List<SupportPointDTO> get_mySupport_reward_info_list(int member_no, String payback_check) {
		// TODO Auto-generated method stub
		System.out.println("서비스 : " + member_no + " " + payback_check);
		SupportPointDTO supportPointDTO = new SupportPointDTO();
		supportPointDTO.setMember_no(member_no);
		supportPointDTO.setPayback_check(payback_check);
		return mySupportDAO.get_mySupport_reward_info_list(supportPointDTO);
	}

	@Override
	public List<SupportPointDTO> get_mySupport_noReward_info_list(int member_no, String payback_check) {
		System.out.println("서비스 : " + member_no + " " + payback_check);
		SupportPointDTO supportPointDTO = new SupportPointDTO();
		supportPointDTO.setMember_no(member_no);
		supportPointDTO.setPayback_check(payback_check);
		return mySupportDAO.get_mySupport_noReward_info_list(supportPointDTO);
	}

}
