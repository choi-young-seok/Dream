package kr.co.dream.project.domain;

import lombok.Data;

@Data
public class ProjectOperDTO {
	private int project_no;
	private int project_percentage;
	// 달성률 = (현재금액 / 목표금액)*100;

	private int project_d_day;
	// 잔여기간 목표일 - 오늘날짜

}
