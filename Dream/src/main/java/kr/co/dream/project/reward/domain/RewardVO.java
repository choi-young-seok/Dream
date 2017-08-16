package kr.co.dream.project.reward.domain;

import java.sql.Date;
import java.util.List;

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
	private int reward_count;

	public int getReward_no() {
		return reward_no;
	}

	public void setReward_no(int reward_no) {
		this.reward_no = reward_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public int getTotal_reward_no() {
		return total_reward_no;
	}

	public void setTotal_reward_no(int total_reward_no) {
		this.total_reward_no = total_reward_no;
	}

	public String getReward_title() {
		return reward_title;
	}

	public void setReward_title(String reward_title) {
		this.reward_title = reward_title;
	}

	public String getReward_items() {
		return reward_items;
	}

	public void setReward_items(String reward_items) {
		this.reward_items = reward_items;
	}

	public Date getReward_delivery_date() {
		return reward_delivery_date;
	}

	public void setReward_delivery_date(Date reward_delivery_date) {
		this.reward_delivery_date = reward_delivery_date;
	}

	public int getReward_limited_count() {
		return reward_limited_count;
	}

	public void setReward_limited_count(int reward_limited_count) {
		this.reward_limited_count = reward_limited_count;
	}

	public int getReward_amount() {
		return reward_amount;
	}

	public void setReward_amount(int reward_amount) {
		this.reward_amount = reward_amount;
	}

	public int getReward_count() {
		return reward_count;
	}

	public void setReward_count(int reward_count) {
		this.reward_count = reward_count;
	}

	@Override
	public String toString() {
		return "RewardVO [reward_no=" + reward_no + ", member_no=" + member_no + ", project_no=" + project_no
				+ ", reward_title=" + reward_title + ", reward_items=" + reward_items + ", reward_delivery_date="
				+ reward_delivery_date + ", reward_limited_count=" + reward_limited_count + ", reward_amount="
				+ reward_amount + "]";
	}

}
