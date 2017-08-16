package kr.co.dream.support.domain;

import java.sql.Date;

import kr.co.dream.address.domain.ShippingAddressVO;
import kr.co.dream.project.reward.domain.RewardVO;

public class SupportVO {
	// 후원 기본정보
	private int member_no; // 등록자 번호
	private int project_no; // 프로젝트 번호
	private int total_reward_no; // 후원(결제) 품목 번호
	private int support_no; // 후원(결제) 번호

	// 결제 정보
	private String member_name; // 후원자(결제자) 성명
	private String pay_method; // 결제 방법 (카드 or 무통장)
	private String pay_account_number; // 결제카드번호 or 입금계좌번호
	private int support_amount; // 후원(결제) 금액
	private Date supprot_date; // 후원(결제) 일자

	// 환불정보
	private String payback_check; // 환불 여부(프로젝트 달성여부에 따른)

	// 배송정보
	private ShippingAddressVO addressVO;

	public ShippingAddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(ShippingAddressVO addressVO) {
		this.addressVO = addressVO;
	}
	
	//결제 상품 정보
	private RewardVO rewardVO;

	public RewardVO getRewardVO() {
		return rewardVO;
	}

	public void setRewardVO(RewardVO rewardVO) {
		this.rewardVO = rewardVO;
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

	public int getSupport_no() {
		return support_no;
	}

	public void setSupport_no(int support_no) {
		this.support_no = support_no;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getPay_account_number() {
		return pay_account_number;
	}

	public void setPay_account_number(String pay_account_number) {
		this.pay_account_number = pay_account_number;
	}

	public int getSupport_amount() {
		return support_amount;
	}

	public void setSupport_amount(int support_amount) {
		this.support_amount = support_amount;
	}

	public Date getSupprot_date() {
		return supprot_date;
	}

	public void setSupprot_date(Date supprot_date) {
		this.supprot_date = supprot_date;
	}

	public String getPayback_check() {
		return payback_check;
	}

	public void setPayback_check(String payback_check) {
		this.payback_check = payback_check;
	}

	@Override
	public String toString() {
		return "SupportVO [member_no=" + member_no + ", project_no=" + project_no + ", total_reward_no="
				+ total_reward_no + ", support_no=" + support_no + ", member_name=" + member_name + ", pay_method="
				+ pay_method + ", pay_account_number=" + pay_account_number + ", support_amount=" + support_amount
				+ ", supprot_date=" + supprot_date + ", payback_check=" + payback_check + "]";
	}

}
