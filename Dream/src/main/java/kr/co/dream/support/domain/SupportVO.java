package kr.co.dream.support.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.reward.domain.RewardVO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportVO {
	// 후원 기본정보
	private int member_no; // 후원자 회원 번호
	private int project_no; // 프로젝트 번호
	private int support_no; // 후원(결제) 번호

	// 결제 정보
	private String member_name; // 후원자(결제자) 성명
	private String pay_bank;
	private String pay_method; // 결제 방법 (카드 or 무통장)
	private String pay_account_number; // 결제카드번호 or 입금계좌번호
	private int support_amount; // 후원(결제) 금액
	private Date support_date; // 후원(결제) 일자
	private String support_category; // 리워드 후원 o/x 구분

	// 환불정보
	private String payback_bank; // 환불 은행
	private String payback_account; //환불 여부
	private String payback_check; // 환불 여부(프로젝트 달성여부에 따른)
	

	// 배송정보
	private SupportDeliveryDTO deliveryDTO;
//	private ProjectPointDTO projectPointDTO;
	
}
