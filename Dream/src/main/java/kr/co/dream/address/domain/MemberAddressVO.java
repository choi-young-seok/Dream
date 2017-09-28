package kr.co.dream.address.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class MemberAddressVO{

	private int member_no;
	private int address_member_no;
	private String address_member_name;
	private String address_alias;
	private int member_address_zip_code;
	private String member_address;
	private String member_detail_address;
	private String address_member_phone;
	private String delivery_address;
	
}
