package kr.co.dream.project.domain;

import java.sql.Date;

public class ProjectVO {
	private int member_no;
	private int project_no;
	private String project_thumbnail;
	private String project_title;
	private String project_summary;
	private String project_category;
	private Date project_end_date;
	private Date project_start_date;
	private int project_goal_amount;
	// 프로젝트 기본 정보

	private ProjectInfoDto infoDto;
	// 연산 결과 DTO


	public ProjectInfoDto getInfoDto() {
		return infoDto;
	}

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public void setInfoDto(ProjectInfoDto infoDto) {
		this.infoDto = infoDto;
	}

	public String toStringProjectBasicInfo() {
		return "ProjectVO [member_no =" + member_no + ", project_no=" + project_no + ", project_thumbnail="
				+ project_thumbnail + ", project_title=" + project_title + ", project_summary=" + project_summary
				+ ", project_category=" + project_category + ", project_end_date=" + project_end_date
				+ ", project_Start_date=" + project_start_date + ", project_goal_amount=" + project_goal_amount + "]";
	}

	private String project_video;
	private String project_content;
	// 프로젝트 스토리정보

	public String toStringProjectStoryInfo() {
		return "ProjectVO [project_no=" + project_no + ", project_video=" + project_video + ", project_content="
				+ project_content + "]";
	}

	private String register_profile;
	private String register_name;
	private String register_phone;
	private String register_intro;
	private String register_sns;
	// 등록자 프로필 정보

	public String toStringProjectProfileInfo() {
		return "ProjectVO [register_profile=" + register_profile + ", register_name=" + register_name
				+ ", register_phone=" + register_phone + ", register_intro=" + register_intro + ", register_sns="
				+ register_sns + "]";
	}

	private String register_address;
	private int project_account;
	private String access_terms_agree;
	// 프로젝트 계좌정보

	public String toStringAccountInfo() {
		return "ProjectVO [member_no=" + member_no + ", project_no=" + project_no + ", register_address="
				+ register_address + ", project_account=" + project_account + ", access_terms_agree="
				+ access_terms_agree + "]";
	}

	private int project_viewcnt;
	private int now_amount;
	private int supporting_count;
	private String project_register_state;
	private String project_success_state;
	// 프로젝트 등록 완료 통계 정보 정보

	public String toStringDefaultInfo() {
		return "ProjectVO [project_no=" + project_no + ", project_viewcnt=" + project_viewcnt + ", now_amount="
				+ now_amount + ", supporting_count=" + supporting_count + ", project_register_state="
				+ project_register_state + ", project_success_state=" + project_success_state + "]";
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
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

	public String getProject_summary() {
		return project_summary;
	}

	public void setProject_summary(String project_summary) {
		this.project_summary = project_summary;
	}

	public String getProject_category() {
		return project_category;
	}

	public void setProject_category(String project_category) {
		this.project_category = project_category;
	}

	public Date getProject_end_date() {
		return project_end_date;
	}

	public void setProject_end_date(Date project_end_date) {
		this.project_end_date = project_end_date;
	}

	public Date getProject_start_date() {
		return project_start_date;
	}

	public void setProject_start_date(Date project_start_date) {
		this.project_start_date = project_start_date;
	}

	public int getProject_goal_amount() {
		return project_goal_amount;
	}

	public void setProject_goal_amount(int project_goal_amount) {
		this.project_goal_amount = project_goal_amount;
	}

	public String getProject_video() {
		return project_video;
	}

	public void setProject_video(String project_video) {
		this.project_video = project_video;
	}

	public String getProject_content() {
		return project_content;
	}

	public void setProject_content(String project_content) {
		this.project_content = project_content;
	}

	public String getRegister_profile() {
		return register_profile;
	}

	public void setRegister_profile(String register_profile) {
		this.register_profile = register_profile;
	}

	public String getRegister_name() {
		return register_name;
	}

	public void setRegister_name(String register_name) {
		this.register_name = register_name;
	}

	public String getRegister_phone() {
		return register_phone;
	}

	public void setRegister_phone(String register_phone) {
		this.register_phone = register_phone;
	}

	public String getRegister_intro() {
		return register_intro;
	}

	public void setRegister_intro(String register_intro) {
		this.register_intro = register_intro;
	}

	public String getRegister_sns() {
		return register_sns;
	}

	public void setRegister_sns(String register_sns) {
		this.register_sns = register_sns;
	}

	public String getRegister_address() {
		return register_address;
	}

	public void setRegister_address(String register_address) {
		this.register_address = register_address;
	}

	public int getProject_account() {
		return project_account;
	}

	public void setProject_account(int project_account) {
		this.project_account = project_account;
	}

	public String getAccess_terms_agree() {
		return access_terms_agree;
	}

	public void setAccess_terms_agree(String access_terms_agree) {
		this.access_terms_agree = access_terms_agree;
	}

	public int getProject_viewcnt() {
		return project_viewcnt;
	}

	public void setProject_viewcnt(int project_viewcnt) {
		this.project_viewcnt = project_viewcnt;
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

	public String getProject_success_state() {
		return project_success_state;
	}

	public void setProject_success_state(String project_success_state) {
		this.project_success_state = project_success_state;
	}

	@Override
	public String toString() {
		return "ProjectVO [member_no=" + member_no + ", project_no=" + project_no + ", project_thumbnail="
				+ project_thumbnail + ", project_title=" + project_title + ", project_summary=" + project_summary
				+ ", project_category=" + project_category + ", project_end_date=" + project_end_date
				+ ", project_start_date=" + project_start_date + ", project_goal_amount=" + project_goal_amount
				+ ", project_video=" + project_video + ", project_content=" + project_content + ", register_profile="
				+ register_profile + ", register_name=" + register_name + ", register_phone=" + register_phone
				+ ", register_intro=" + register_intro + ", register_sns=" + register_sns + ", register_address="
				+ register_address + ", project_account=" + project_account + ", access_terms_agree="
				+ access_terms_agree + ", project_viewcnt=" + project_viewcnt + ", now_amount=" + now_amount
				+ ", supporting_count=" + supporting_count + ", project_register_state=" + project_register_state
				+ ", project_success_state=" + project_success_state + "]";
	}

}
