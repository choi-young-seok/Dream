package kr.co.dream.address.domain;

public class FindResultAddressVO {

	private int zip_code; // �����ȣ
	private String address; // �ּ�

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "FindResultAddressVO [zip_code=" + zip_code + ", address=" + address + "]";
	}
	
}
