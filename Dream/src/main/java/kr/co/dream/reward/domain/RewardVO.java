package kr.co.dream.reward.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RewardVO {

	private int member_no; // 회원 번호
	private int project_no; // 프로젝트 번호
	private int total_reward_no; // 전체 리워드 번호
	private int reward_no; // 리워드 번호
	private String reward_title; // 리워드 제목
	private String reward_items; // 리워드 품목
	private Date reward_delivery_date; // 배송 예정일
	private int reward_limited_count; // 한정 수량
	private int reward_amount; // 서약(리워드) 금액

}
