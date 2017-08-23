package kr.co.dream.project.domain;

import java.sql.Date;

public class ProjectPointDTO {
	private int member_no;
	private int project_no;
	private String project_thumbnail;
	private String project_title;
	private Date project_start_date;
	private Date project_end_date;
	private int project_goal_amount;
	private int now_amount;
	private int project_viewcnt;
	private int supporting_count;
	private String project_summary;

	private ProjectOperDTO projectOperDTO;

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public String getProject_thumbnail() {
		return project_thumbnail;
	}

	public void setProject_thumbnail(String project_thumbnail) {
		this.project_thumbnail = project_thumbnail;
	}

	public String getProject_title() {
		return project_title;
	}

	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}

	public Date getProject_start_date() {
		return project_start_date;
	}

	public void setProject_start_date(Date project_start_date) {
		this.project_start_date = project_start_date;
	}

	public Date getProject_end_date() {
		return project_end_date;
	}

	public void setProject_end_date(Date project_end_date) {
		this.project_end_date = project_end_date;
	}

	public int getProject_goal_amount() {
		return project_goal_amount;
	}

	public void setProject_goal_amount(int project_goal_amount) {
		this.project_goal_amount = project_goal_amount;
	}

	public int getNow_amount() {
		return now_amount;
	}

	public void setNow_amount(int now_amount) {
		this.now_amount = now_amount;
	}

	public ProjectOperDTO getProjectOperDTO() {
		return projectOperDTO;
	}

	public void setProjectOperDTO(ProjectOperDTO projectOperDTO) {
		this.projectOperDTO = projectOperDTO;
	}

	public int getProject_viewcnt() {
		return project_viewcnt;
	}

	public void setProject_viewcnt(int project_viewcnt) {
		this.project_viewcnt = project_viewcnt;
	}

	public int getSupporting_count() {
		return supporting_count;
	}

	public void setSupporting_count(int supporting_count) {
		this.supporting_count = supporting_count;
	}

	public String getProject_summary() {
		return project_summary;
	}

	public void setProject_summary(String project_summary) {
		this.project_summary = project_summary;
	}

	@Override
	public String toString() {
		return "ProjectPointDTO [member_no=" + member_no + ", project_no=" + project_no + ", project_thumbnail="
				+ project_thumbnail + ", project_title=" + project_title + ", project_start_date=" + project_start_date
				+ ", project_end_date=" + project_end_date + ", project_goal_amount=" + project_goal_amount
				+ ", now_amount=" + now_amount + ", project_viewcnt=" + project_viewcnt + ", supporting_count="
				+ supporting_count + ", project_summary=" + project_summary + ", projectOperDTO=" + projectOperDTO
				+ "]";
	}

}
