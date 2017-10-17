package kr.co.dream.support.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.address.persistence.AddressDAO;
import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.domain.supportPayInfoDTO;
import kr.co.dream.support.persistence.SupportDAO;

@Service
public class SupportServiceImpl implements SupportService {

	@Inject
	private SupportDAO supportDAO;
	
	@Inject
	private AddressDAO addressDAO;

	private static final Logger logger = LoggerFactory.getLogger(SupportServiceImpl.class);

	@Transactional
	public int supportRegister_noReward(SupportVO supportVO) {

		int support_no = supportDAO.support_Register(supportVO);
		// // 후원 테이블에 데이터 등록 :
		// 결제(번호, 방법, 카드번호,금액, 회원번호, 일자 ) 결제자 이름
		// 결제 정보 등록 : 결제 완료 화면의 결제 정보를 봉주기 위한 파라미터 후원 번호를 반환

		supportDAO.project_nowAmount_update(supportVO);
		// 프로젝트 테이블에 후원금액, 후원횟수 반영

		supportDAO.project_successState_update(supportVO.getProject_no());
		// 반영된 후원금액이 100%이상일 경우 프로젝트 성공상태값 변경 (project_success_stat ='T')
			System.out.println("리워드 없는 후원");
			return support_no;
	}

	//
	@Override
	public int supportRegister_reward(SupportVO supportVO) {
		System.out.println("리워드 후원 배송정보, 리워드정보 처리");
		int support_no =  supportRegister_noReward(supportVO);

		supportVO.getDeliveryDTO().setMember_no(supportVO.getMember_no());
		supportVO.getDeliveryDTO().setProject_no(supportVO.getProject_no());
		supportVO.getDeliveryDTO().setSupport_no(support_no);
		
		supportDAO.reward_limited_count_update(supportVO.getDeliveryDTO().getTotal_reward_no());
		// 리워드 테이블에 결제 리워드 수량 1 감소
		
		supportVO.getDeliveryDTO().setSenderAddressVO(addressDAO.get_project_delivery_address(supportVO.getProject_no()));
		System.out.println("리워드 후원 발송자 주소 정보!! : " + supportVO.getDeliveryDTO());
		//프로젝트 등록자 주소지 정보 셋팅
		System.out.println("등록자 주소지 : " + supportVO.getDeliveryDTO().getSenderAddressVO());
		
		supportDAO.delivery_address_register(supportVO.getDeliveryDTO());
		return support_no;
	}

	@Override
	public SupportDetailDTO get_SupportDetail(int member_no, int support_no, String payback_check) {
		SupportDetailDTO detailDTO = new SupportDetailDTO();
		detailDTO.setSupport_no(support_no);
		detailDTO.setMember_no(member_no);
		detailDTO.setPayback_check(payback_check);
		if (payback_check.equals("N")) {
			detailDTO = supportDAO.get_RewardSupportDetail(detailDTO);
		} else {
			System.out.println("환불정보");
			// detailDTO =
		}
		return detailDTO;
	}
	
	@Override
	public void update_paybackInfo(supportPayInfoDTO payInfoDTO) {
		supportDAO.update_paybackInfo(payInfoDTO);
		
	}

}
