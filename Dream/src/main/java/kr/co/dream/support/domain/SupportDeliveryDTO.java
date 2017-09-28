package kr.co.dream.support.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.reward.domain.RewardVO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportDeliveryDTO{

	private int member_no; //결제 회원번호
	private int project_no; // 결제 프로젝트번호
	private int support_no; // 결제번호
	private int total_reward_no; //결제 품목
	private int delivery_address_no; // 송장번호
	
	private MemberAddressVO senderAddressVO; // 프로젝트 등록자 리워드 발송지 주소
	private SupportRewardDTO supportRewardDTO; // 프로젝트 리워드

	private String receiver_name; // 수령자 이름
	private String receiver_address_alias; // 발송자 주소
	private int receiver_zip_code; // 발송자 주소
	private String receiver_address; // 발송자 주소
	private String receiver_detail_address; // 발송자 주소
	private String receiver_phone; // 수령자 연라처

	private String shipping_check; // 배송여부 Defalt 'N'

	
}
