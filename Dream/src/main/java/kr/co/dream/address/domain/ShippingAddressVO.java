package kr.co.dream.address.domain;

import kr.co.dream.support.domain.ShippingItemsVO;

public class ShippingAddressVO extends FindResultAddressVO {
	private int shipping_address_no; // 송장번호

	private String sender_name; // 발송자 이름
	private String sender_address; // 발송자 주소
	private String sender_phone; // 발송자 연락처

	private String receiver_name; // 수령자 이름
	private String receiver_phone; // 수령자 연라처

	private int zip_code; // 배송지 우편번호
	private String receiver_address; // 배송지 주소
	private String detail_address; // 배송지 상세주소

	private String shipping_check; // 배송여부 Defalt 'N'
	
	private ShippingItemsVO itemsVO;

	public ShippingItemsVO getItemsVO() {
		return itemsVO;
	}

	public void setItemsVO(ShippingItemsVO itemsVO) {
		this.itemsVO = itemsVO;
	}

	public int getShipping_address_no() {
		return shipping_address_no;
	}

	public void setShipping_address_no(int shipping_address_no) {
		this.shipping_address_no = shipping_address_no;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getSender_address() {
		return sender_address;
	}

	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}

	public String getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(String sender_phone) {
		this.sender_phone = sender_phone;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getShipping_check() {
		return shipping_check;
	}

	public void setShipping_check(String shipping_check) {
		this.shipping_check = shipping_check;
	}

	@Override
	public String toString() {
		return "ShippingAddressVO [shipping_address_no=" + shipping_address_no + ", sender_name=" + sender_name
				+ ", sender_address=" + sender_address + ", sender_phone=" + sender_phone + ", receiver_name="
				+ receiver_name + ", receiver_phone=" + receiver_phone + ", zip_code=" + zip_code
				+ ", receiver_address=" + receiver_address + ", detail_address=" + detail_address + ", shipping_check="
				+ shipping_check + "]";
	}

}
