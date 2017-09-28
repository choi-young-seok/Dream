package kr.co.dream.support.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.dream.support.domain.SupportDeliveryDTO;
import kr.co.dream.support.domain.SupportDetailDTO;
import kr.co.dream.support.domain.SupportVO;
import kr.co.dream.support.domain.supportPayInfoDTO;

@Repository
public class SupportDAOImpl implements SupportDAO {

	@Inject
	private SqlSession sqlSession;

	// �Ŀ����� ���
	@Override
	public int support_Register(SupportVO supportVO) {
		sqlSession.insert("support.support_register", supportVO);
		return supportVO.getSupport_no();
	}

	// ������Ʈ���̺� �Ŀ��ݾ� �ݿ�
	@Override
	public void project_nowAmount_update(SupportVO supportVO) {
		sqlSession.update("support.project_nowAmount_update", supportVO);
	}

	// �ݿ� �Ŀ��ݾ��� 100%�̻��� ��� project_success_state ����
	@Override
	public void project_successState_update(int project_no) {
		sqlSession.update("support.project_successState_update", project_no);
	}

	// ���������̺� �������� ����
	@Override
	public void reward_limited_count_update(int reward_no) {
		sqlSession.update("support.reward_limited_count_update", reward_no);
	}

	// ������̺� ������� ���
	@Override
	public int delivery_address_register(SupportDeliveryDTO deliveryInfoDTO) {
		sqlSession.insert("support.delivery_address_register", deliveryInfoDTO);
		return deliveryInfoDTO.getDelivery_address_no();
	}

	// ������ �Ŀ� �� ��ȸ
	@Override
	public SupportDetailDTO get_RewardSupportDetail(SupportDetailDTO detailDTO) {
		System.out.println(detailDTO);
		return sqlSession.selectOne("support_info.support_detail_info", detailDTO);
	}
	
	@Override
	public void update_paybackInfo(supportPayInfoDTO payInfoDTO) {
		sqlSession.update("support_info.update_paybackInfo", payInfoDTO);
	}

}
