package kr.co.dream.project.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.address.domain.MemberAddressVO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectProfileDTO {

	private int project_no;
	private int member_no;
	private int address_member_no;
	private String register_name;
	private String register_intro;
	private String member_profile;
	
	private MemberAddressVO memberAddressVO;
	
}
