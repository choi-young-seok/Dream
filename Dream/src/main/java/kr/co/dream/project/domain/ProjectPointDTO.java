package kr.co.dream.project.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectPointDTO {
	private int member_no;
	private int project_no;
	private String project_thumbnail;
	private String project_title;
	private Date project_start_date;
	private Date project_end_date;
	private int project_goal_amount;
	private int now_amount;
	private int project_view_count;
	private int supporting_count;
	private String project_summary;
	private String project_category;

	private ProjectOperDTO projectOperDTO;

}
