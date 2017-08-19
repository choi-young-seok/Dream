package kr.co.dream.support.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.common.encryption.EncryptionPwd;
import kr.co.dream.project.domain.ProjectVO;
import kr.co.dream.project.reward.domain.RewardVO;
import kr.co.dream.support.domain.ShippingItemsVO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.persistence.SupportDAO;

@Service
public class SupportServiceImpl implements SupportService {

	@Inject
	private SupportDAO supportDAO;

	private static final Logger logger = LoggerFactory.getLogger(SupportServiceImpl.class);
	
	@Transactional
	public ShippingItemsVO supportRegister(SupportVO supportVO) {
		logger.info("-------------------------------------------------input value");
		logger.info("\n"+supportVO.toString());
		

//		logger.info("\n"+supportVO.getAddressVO().toString());
		
		// 후원 테이블에 데이터 등록->
		// 프로젝트 테이블에 목표금액 반영(update) ->
		// 리워드 테이블의 해당 리워드 한정수량 -1 반영(update)
		// 프로젝트 테이블에서 발송자이름, 발송자주소, 발송자 연락처 select하여 shippingAddressVO에 값 setting
		// 배송테이블에 데이터 등록 ->

		// 배송 품목 테이블에 데이터 등록 ->
		// 등록 완료된 배송장 정보와 배송품목 정보를 return;
 
		int support_no = supportDAO.support_Register(supportVO); 
		// dream_support 테이블에 SupportVO값 insert
		
		supportDAO.project_nowAmount_update(supportVO); 
		// SupportVO에 저장된 support_amount값을 dream_project테이블의 now_amount컬럼에 update

		supportDAO.reward_limited_count_update(supportVO.getTotal_reward_no());
		// SupportVO에 저장된 total_reward_no에 해당하는 reward품목의 한정수량을 1감소

		//리워드 선택없는 후원
		if(supportVO.getAddressVO()==null){
			System.out.println("널검사완료");
			ShippingItemsVO itemsVO = new ShippingItemsVO();
			itemsVO.setSupport_no(support_no);
			return itemsVO;
		}
		
		ProjectVO projectVO = supportDAO.get_projectUser_profile(supportVO.getProject_no());
		//판매자 정보 조회
		ShippingAddressVO addressVO = supportVO.getAddressVO();
		addressVO.setSender_name(projectVO.getRegister_name());
		addressVO.setSender_address(projectVO.getRegister_address());
//		addressVO.setSender_phone(projectVO.getRegister_phone());
		addressVO.setSender_phone("0101010");
		//Dream_shipping_Address테이블에 판매자 정보 setting
		
		System.out.println(addressVO.toString());
		int shipping_address_no = supportDAO.shipping_address_register(addressVO);
		//Dream_shipping_Address테이블에 shippingAddressVO값 insert (return selectKey)
		
		System.out.println("shipping_address_no : "+shipping_address_no);
		
		ShippingItemsVO itemsVO = new ShippingItemsVO();
		System.out.println(itemsVO.toString());
		itemsVO.setShipping_address_no(shipping_address_no);
		itemsVO.setMember_no(supportVO.getMember_no());
		itemsVO.setProject_no(supportVO.getProject_no());
		itemsVO.setSupport_no(supportVO.getSupport_no());
		itemsVO.setTotal_reward_no(supportVO.getTotal_reward_no());
		
		supportDAO.shipping_items_register(itemsVO);
		//판매 품목 정보 insert
		
		addressVO = supportDAO.get_support_shipping_info(shipping_address_no);
		addressVO.setItemsVO(supportDAO.get_support_shipping_items_info(shipping_address_no));
		//itemsVO가 왜필요한지 모르겟다 2017-08-16
		//알았다. 후원정보 등록과 조회로직을 분리하면서 조회시 필요한 no를 itemsVO에 
		//할당하여 후에 조회요청시 파라미터로 사용하기 위함이다
		RewardVO rewardVO = supportDAO.get_support_items(supportVO.getTotal_reward_no());

		supportVO.setAddressVO(addressVO);
		System.out.println(addressVO.toString());
		supportVO.setRewardVO(rewardVO);
		System.out.println(rewardVO.toString());
		
		
		//가공된 ShippingAddressVO값을 insert한 후 반환되는 shipping_address_no를 dream_shipping_items테이블에 입력
		logger.info("\nreturn supportVO : " + supportVO.toString());
		logger.info("\nreturn addressVO : " + addressVO.toString());
		logger.info("\nreturn rewardVO : " + rewardVO.toString());
//		logger.info("\nreturn itemsVO : " + addressVO.getItemsVO().toString());
		logger.info("-------------------------------------------------");
		
		return itemsVO;
	}

	@Override
	public SupportVO get_supportInfo(int support_no, int shipping_address_no) {
		
		SupportVO supportVO = supportDAO.get_support_info(support_no);
		if(supportVO.getTotal_reward_no()==0){
			return supportVO;
		}
		RewardVO rewardVO = supportDAO.get_support_items(supportVO.getTotal_reward_no());
		ShippingAddressVO addressVO = supportDAO.get_support_shipping_info(shipping_address_no);

		supportVO.setAddressVO(addressVO);
		supportVO.setRewardVO(rewardVO);
		return supportVO;
	}
}
