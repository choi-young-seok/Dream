package kr.co.dream.support.domain;

public class ShippingItemsVO {

	private int shipping_address_no;
	private int member_no;
	private int support_no;
	private int project_no;
	private int total_reward_no;

	public int getShipping_address_no() {
		return shipping_address_no;
	}

	public void setShipping_address_no(int shipping_address_no) {
		this.shipping_address_no = shipping_address_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getSupport_no() {
		return support_no;
	}

	public void setSupport_no(int support_no) {
		this.support_no = support_no;
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

	@Override
	public String toString() {
		return "ShippingItemsVO [shipping_address_no=" + shipping_address_no + ", member_no=" + member_no
				+ ", support_no=" + support_no + ", project_no=" + project_no + ", total_reward_no=" + total_reward_no
				+ "]";
	}

}
