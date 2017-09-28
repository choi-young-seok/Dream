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

	// 후원정보 등록
	@Override
	public int support_Register(SupportVO supportVO) {
		sqlSession.insert("support.support_register", supportVO);
		return supportVO.getSupport_no();
	}

	// 프로젝트테이블 후원금액 반영
	@Override
	public void project_nowAmount_update(SupportVO supportVO) {
		sqlSession.update("support.project_nowAmount_update", supportVO);
	}

	// 반영 후원금액이 100%이상일 경우 project_success_state 변경
	@Override
	public void project_successState_update(int project_no) {
		sqlSession.update("support.project_successState_update", project_no);
	}

	// 리워드테이블 한정수량 감소
	@Override
	public void reward_limited_count_update(int reward_no) {
		sqlSession.update("support.reward_limited_count_update", reward_no);
	}

	// 배송테이블 배송정보 등록
	@Override
	public int delivery_address_register(SupportDeliveryDTO deliveryInfoDTO) {
		sqlSession.insert("support.delivery_address_register", deliveryInfoDTO);
		return deliveryInfoDTO.getDelivery_address_no();
	}

	// 리워드 후원 상세 조회
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
