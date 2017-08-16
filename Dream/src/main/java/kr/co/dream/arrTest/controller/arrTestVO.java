package kr.co.dream.arrTest.controller;

public class arrTestVO {

	private String name;
	private String phone;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "arrTestVO [name=" + name + ", phone=" + phone + "]";
	}
	
	
	
	
}
