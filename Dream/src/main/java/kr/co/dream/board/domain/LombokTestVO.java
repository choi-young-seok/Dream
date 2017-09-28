package kr.co.dream.board.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LombokTestVO {
	
	private int no;
	private String name;
	
	private Data regdate;

}