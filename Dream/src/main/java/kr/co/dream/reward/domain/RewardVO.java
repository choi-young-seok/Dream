package kr.co.dream.reward.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RewardVO {

	private int member_no; // ȸ�� ��ȣ
	private int project_no; // ������Ʈ ��ȣ
	private int total_reward_no; // ��ü ������ ��ȣ
	private int reward_no; // ������ ��ȣ
	private String reward_title; // ������ ����
	private String reward_items; // ������ ǰ��
	private Date reward_delivery_date; // ��� ������
	private int reward_limited_count; // ���� ����
	private int reward_amount; // ����(������) �ݾ�

}
