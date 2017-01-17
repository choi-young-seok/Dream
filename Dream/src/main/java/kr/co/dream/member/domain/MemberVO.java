package kr.co.dream.member.domain;

import java.util.Date;

public class MemberVO {

	private int member_no; // ȸ�� ��ȣ
	private String member_mail; // ȸ�� �̸���(���̵�)
	private String member_pass; // ȸ�� ��й�ȣ
	private String member_name; // ȸ�� �̸�
	private String member_birth; // ȸ�� �������(yyyy-mm-dd)
	private String member_gender; // ȸ�� ����
	// ȸ�� ���Խ� �Է� �޴� �׸�

	private Date member_regdate; // ȸ�� ������ (default sysdate)
	private int member_total_project_count; // ��� ������Ʈ �� (default 0)
	private int member_ongoing_project_count; // �������� ������Ʈ �� (default 0)
	private int member_supporting_count; // �ش� ȸ���� �Ŀ��ϴ� ������Ʈ �� (default 0)
	private int member_total_supported_count; // �ش� ȸ���� ��ü �Ŀ� �� (default 0)

	private String member_stop_state; // ȸ�� ���� ����
	private String member_withdraw_state; // ȸ�� Ż�� ����

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_mail() {
		return member_mail;
	}

	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}

	public String getMember_pass() {
		return member_pass;
	}

	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Date getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}

	public int getMember_total_project_count() {
		return member_total_project_count;
	}

	public void setMember_total_project_count(int member_total_project_count) {
		this.member_total_project_count = member_total_project_count;
	}

	public int getmember_ongoing_project_count() {
		return member_ongoing_project_count;
	}

	public void setmember_ongoing_project_count(int member_ongoing_project_count) {
		this.member_ongoing_project_count = member_ongoing_project_count;
	}

	public int getMember_supporting_count() {
		return member_supporting_count;
	}

	public void setMember_supporting_count(int member_supporting_count) {
		this.member_supporting_count = member_supporting_count;
	}

	public int getMember_total_supported_count() {
		return member_total_supported_count;
	}

	public void setMember_total_supported_count(int member_total_supported_count) {
		this.member_total_supported_count = member_total_supported_count;
	}

	public String getMember_stop_state() {
		return member_stop_state;
	}

	public void setMember_stop_state(String member_stop_state) {
		this.member_stop_state = member_stop_state;
	}

	public String getMember_withdraw_state() {
		return member_withdraw_state;
	}

	public void setMember_withdraw_state(String member_withdraw_state) {
		this.member_withdraw_state = member_withdraw_state;
	}

	// �α��� ȸ�� ����
	public String toStringLogin() {
		return "MemberVO [member_mail=" + member_mail + ", member_pass=" + member_pass + ", member_name=" + member_name
				+ "]";
	}

	// ȸ������ ����
	public String toStringJoinMember() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_pass=" + member_pass
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_regdate=" + member_regdate + "]";
	}

	// ���� ȸ�� ����
	public String toStringStopMember() {
		return "MemberVO [member_mail=" + member_mail + ", member_name=" + member_name + ", member_stop_state="
				+ member_stop_state + "]";
	}

	// ȸ�� ��� ����
	public String toStringMemberStats() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_name=" + member_name
				+ ", member_total_project_count=" + member_total_project_count + ", member_ongoing_project_count="
				+ member_ongoing_project_count + ", member_supporting_count=" + member_supporting_count
				+ ", member_total_supported_count=" + member_total_supported_count + "]";
	}



}
