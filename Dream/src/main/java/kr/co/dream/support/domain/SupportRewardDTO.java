package kr.co.dream.support.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportRewardDTO {

	private int support_no;
	private int total_reward_no;
	
	private String reward_title;
	private String reward_items;
	private String reward_amount;
	private Date reward_delivery_date;
}
