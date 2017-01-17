package kr.co.dream.project.domain;

import java.util.Date;

public class ProjectVO {
	private	int project_no;
	private	String project_thumbnail;
	private	String project_title;
	private	String project_content;
	private	String project_video;
	private	String project_catagory;
	private	int project_goalAmount;
	private	Date project_endDate;
	private	Date project_StartDate;
	private	int now_amount;
	private	int supporting_count;
	private	String project_register_state;
	private	String project_success_state;
	
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
	public String getProject_content() {
		return project_content;
	}
	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}
	public String getProject_video() {
		return project_video;
	}
	public void setProject_video(String project_video) {
		this.project_video = project_video;
	}
	public String getProject_catagory() {
		return project_catagory;
	}
	public void setProject_catagory(String project_catagory) {
		this.project_catagory = project_catagory;
	}
	public int getProject_goalAmount() {
		return project_goalAmount;
	}
	public void setProject_goalAmount(int project_goalAmount) {
		this.project_goalAmount = project_goalAmount;
	}
	public Date getProject_endDate() {
		return project_endDate;
	}
	public void setProject_endDate(Date project_endDate) {
		this.project_endDate = project_endDate;
	}
	public Date getProject_StartDate() {
		return project_StartDate;
	}
	public void setProject_StartDate(Date project_StartDate) {
		this.project_StartDate = project_StartDate;
	}
	public int getNow_amount() {
		return now_amount;
	}
	public void setNow_amount(int now_amount) {
		this.now_amount = now_amount;
	}
	public int getSupporting_count() {
		return supporting_count;
	}
	public void setSupporting_count(int supporting_count) {
		this.supporting_count = supporting_count;
	}
	public String getProject_register_state() {
		return project_register_state;
	}
	public void setProject_register_state(String project_register_state) {
		this.project_register_state = project_register_state;
	}
	public String getProject_succeSS_state() {
		return project_success_state;
	}
	public void setProject_succeSS_state(String project_succeSS_state) {
		this.project_success_state = project_succeSS_state;
	}
	@Override
	public String toString() {
		return "ProjectVO [project_no=" + project_no + ", project_thumbnail=" + project_thumbnail + ", project_title="
				+ project_title + ", project_content=" + project_content + ", project_video=" + project_video
				+ ", project_catagory=" + project_catagory + ", project_goalAmount=" + project_goalAmount
				+ ", project_endDate=" + project_endDate + ", project_StartDate=" + project_StartDate + ", now_amount="
				+ now_amount + ", supporting_count=" + supporting_count + ", project_register_state="
				+ project_register_state + ", project_succeSS_state=" + project_success_state + "]";
	}
	
	
}
