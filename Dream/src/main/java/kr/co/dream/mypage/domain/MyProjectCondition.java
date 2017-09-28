package kr.co.dream.mypage.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author Choi-Young-Seok
 *
 */
/**
 * @author Choi-Young-Seok
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class MyProjectCondition {

//	@JsonInclude(Include.NON_NULL)
	private int member_no;
	private int project_no;
	private String request;
	private String success_state;

}
