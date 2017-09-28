package kr.co.dream.support.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class supportPayInfoDTO {

	private int support_no;
	private String payback_bank;
	private String payback_account;
}
