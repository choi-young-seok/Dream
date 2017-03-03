package kr.co.dream.reward.domain;

import java.sql.Date;

public class RewardVO {

	private int member_no; //회원 번호
	private int project_no; //프로젝트 번호
	private int reward_no; //리워드 번호
	private String reward_title; //리워드 제목
	private String reward_items; //리워드 품목
	private Date delivert_date; //배송 예정일
	private int reward_limited_count; //한정 수량
	private int reward_amount; //서약(리워드) 금액
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

	public Date getDelivert_date() {
		return delivert_date;
	}

	public void setDelivert_date(Date delivert_date) {
		this.delivert_date = delivert_date;
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
				+ ", reward_title=" + reward_title + ", reward_items=" + reward_items + ", delivert_date="
				+ delivert_date + ", reward_limited_count=" + reward_limited_count + ", reward_amount=" + reward_amount
				+ "]";
	}

}
