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
		// // �Ŀ� ���̺� ������ ��� :
		// ����(��ȣ, ���, ī���ȣ,�ݾ�, ȸ����ȣ, ���� ) ������ �̸�
		// ���� ���� ��� : ���� �Ϸ� ȭ���� ���� ������ ���ֱ� ���� �Ķ���� �Ŀ� ��ȣ�� ��ȯ

		supportDAO.project_nowAmount_update(supportVO);
		// ������Ʈ ���̺� �Ŀ��ݾ�, �Ŀ�Ƚ�� �ݿ�

		supportDAO.project_successState_update(supportVO.getProject_no());
		// �ݿ��� �Ŀ��ݾ��� 100%�̻��� ��� ������Ʈ �������°� ���� (project_success_stat ='T')
			System.out.println("������ ���� �Ŀ�");
			return support_no;
	}

	//
	@Override
	public int supportRegister_reward(SupportVO supportVO) {
		System.out.println("������ �Ŀ� �������, ���������� ó��");
		int support_no =  supportRegister_noReward(supportVO);

		supportVO.getDeliveryDTO().setMember_no(supportVO.getMember_no());
		supportVO.getDeliveryDTO().setProject_no(supportVO.getProject_no());
		supportVO.getDeliveryDTO().setSupport_no(support_no);
		
		supportDAO.reward_limited_count_update(supportVO.getDeliveryDTO().getTotal_reward_no());
		// ������ ���̺� ���� ������ ���� 1 ����
		
		supportVO.getDeliveryDTO().setSenderAddressVO(addressDAO.get_project_delivery_address(supportVO.getProject_no()));
		System.out.println("������ �Ŀ� �߼��� �ּ� ����!! : " + supportVO.getDeliveryDTO());
		//������Ʈ ����� �ּ��� ���� ����
		System.out.println("����� �ּ��� : " + supportVO.getDeliveryDTO().getSenderAddressVO());
		
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
			System.out.println("ȯ������");
			// detailDTO =
		}
		return detailDTO;
	}
	
	@Override
	public void update_paybackInfo(supportPayInfoDTO payInfoDTO) {
		supportDAO.update_paybackInfo(payInfoDTO);
		
	}

}
