package kr.co.dream.support.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.project.domain.ProjectPointDTO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportDetailDTO {
	private int project_no; // 프로젝트 번호
	private int support_no; // 후원(결제) 번호
	private int member_no;

	// 결제 정보
	private String member_name; // 후원자(결제자) 성명
	private String pay_bank; // 결제 방법 (카드 or 무통장)
	private String pay_method; // 결제 방법 (카드 or 무통장)\	
	private int support_amount; // 후원(결제) 금액
	private Date support_date; // 후원(결제) 일자
	
	private String payback_check; // 환불여부
	
	//프로젝트 환불정보
	private supportPayInfoDTO payInfoDTO; 
	
	// 후원 프로젝트 정보
	private ProjectPointDTO projectPointDTO;
	
	//결제품목 및 발송지 정보
	private SupportDeliveryDTO supportDeliveryDTO;

}
