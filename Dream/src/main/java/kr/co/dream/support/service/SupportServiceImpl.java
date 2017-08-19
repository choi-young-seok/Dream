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
		
		// �Ŀ� ���̺� ������ ���->
		// ������Ʈ ���̺� ��ǥ�ݾ� �ݿ�(update) ->
		// ������ ���̺��� �ش� ������ �������� -1 �ݿ�(update)
		// ������Ʈ ���̺��� �߼����̸�, �߼����ּ�, �߼��� ����ó select�Ͽ� shippingAddressVO�� �� setting
		// ������̺� ������ ��� ->

		// ��� ǰ�� ���̺� ������ ��� ->
		// ��� �Ϸ�� ����� ������ ���ǰ�� ������ return;
 
		int support_no = supportDAO.support_Register(supportVO); 
		// dream_support ���̺� SupportVO�� insert
		
		supportDAO.project_nowAmount_update(supportVO); 
		// SupportVO�� ����� support_amount���� dream_project���̺��� now_amount�÷��� update

		supportDAO.reward_limited_count_update(supportVO.getTotal_reward_no());
		// SupportVO�� ����� total_reward_no�� �ش��ϴ� rewardǰ���� ���������� 1����

		//������ ���þ��� �Ŀ�
		if(supportVO.getAddressVO()==null){
			System.out.println("�ΰ˻�Ϸ�");
			ShippingItemsVO itemsVO = new ShippingItemsVO();
			itemsVO.setSupport_no(support_no);
			return itemsVO;
		}
		
		ProjectVO projectVO = supportDAO.get_projectUser_profile(supportVO.getProject_no());
		//�Ǹ��� ���� ��ȸ
		ShippingAddressVO addressVO = supportVO.getAddressVO();
		addressVO.setSender_name(projectVO.getRegister_name());
		addressVO.setSender_address(projectVO.getRegister_address());
//		addressVO.setSender_phone(projectVO.getRegister_phone());
		addressVO.setSender_phone("0101010");
		//Dream_shipping_Address���̺� �Ǹ��� ���� setting
		
		System.out.println(addressVO.toString());
		int shipping_address_no = supportDAO.shipping_address_register(addressVO);
		//Dream_shipping_Address���̺� shippingAddressVO�� insert (return selectKey)
		
		System.out.println("shipping_address_no : "+shipping_address_no);
		
		ShippingItemsVO itemsVO = new ShippingItemsVO();
		System.out.println(itemsVO.toString());
		itemsVO.setShipping_address_no(shipping_address_no);
		itemsVO.setMember_no(supportVO.getMember_no());
		itemsVO.setProject_no(supportVO.getProject_no());
		itemsVO.setSupport_no(supportVO.getSupport_no());
		itemsVO.setTotal_reward_no(supportVO.getTotal_reward_no());
		
		supportDAO.shipping_items_register(itemsVO);
		//�Ǹ� ǰ�� ���� insert
		
		addressVO = supportDAO.get_support_shipping_info(shipping_address_no);
		addressVO.setItemsVO(supportDAO.get_support_shipping_items_info(shipping_address_no));
		//itemsVO�� ���ʿ����� �𸣰ٴ� 2017-08-16
		//�˾Ҵ�. �Ŀ����� ��ϰ� ��ȸ������ �и��ϸ鼭 ��ȸ�� �ʿ��� no�� itemsVO�� 
		//�Ҵ��Ͽ� �Ŀ� ��ȸ��û�� �Ķ���ͷ� ����ϱ� �����̴�
		RewardVO rewardVO = supportDAO.get_support_items(supportVO.getTotal_reward_no());

		supportVO.setAddressVO(addressVO);
		System.out.println(addressVO.toString());
		supportVO.setRewardVO(rewardVO);
		System.out.println(rewardVO.toString());
		
		
		//������ ShippingAddressVO���� insert�� �� ��ȯ�Ǵ� shipping_address_no�� dream_shipping_items���̺� �Է�
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
