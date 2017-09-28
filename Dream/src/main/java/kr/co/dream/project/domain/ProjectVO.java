package kr.co.dream.project.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProjectVO {
	private int member_no;
	private int project_no;
	private String project_thumbnail;
	private String project_title;
	private String project_summary;
	private String project_category;
	private int project_goal_amount;
	private Date project_start_date;
	private Date project_end_date;
	// ������Ʈ �⺻ ����

	private ProjectOperDTO projectOperDTO;
	// ���� ��� DTO

	private String project_video;
	private String project_content;
	private String project_video_type;
	// ������Ʈ ���丮����

	private String register_profile;
	private String register_name;
	private String register_phone;
	private String register_intro;
	// ����� ������ ����

	private String access_terms_agree;
	private String project_account_bank;
	private String project_account;
	// ������Ʈ ��������

	private int project_viewcnt;
	private int now_amount;
	private int supporting_count;
	private String project_register_state;
	private String project_success_state;
	// ������Ʈ ��� �Ϸ� ��� ���� ����

}
