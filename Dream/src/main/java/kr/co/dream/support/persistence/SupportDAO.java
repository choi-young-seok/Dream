package kr.co.dream.support.persistence;

import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.domain.supportPayInfoDTO;

public interface SupportDAO {
	//�Ŀ��������
	public int support_Register(SupportVO supportVO);
	public void project_nowAmount_update(SupportVO supportVO);
	public void project_successState_update(int project_no);
	public void reward_limited_count_update(int reward_no);
	public int delivery_address_register(SupportDeliveryDTO deliveryInfoDTO);
	
	//������ �Ŀ� �� ��ȸ
	public SupportDetailDTO get_RewardSupportDetail(SupportDetailDTO detailDTO);
	public void update_paybackInfo(supportPayInfoDTO payInfoDTO);
}
