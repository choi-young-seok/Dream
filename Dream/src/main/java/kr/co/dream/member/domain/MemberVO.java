package kr.co.dream.member.domain;

import java.util.Date;

public class MemberVO {

	private int member_no; // ȸ�� ��ȣ
	private String member_email; // ȸ�� �̸���(���̵�)
	private String member_pwd; // ȸ�� ��й�ȣ
	private String member_name; // ȸ�� �̸�
	private String member_birth; // ȸ�� �������(yyyy-mm-dd)
	private String member_gender; // ȸ�� ����
	// ȸ�� ���Խ� �Է� �޴� �׸�

	private Date member_regdate; // ȸ�� ������ (default sysdate)
	private int member_total_project_count; // ��� ������Ʈ �� (default 0)
	private int member_progressing_project_count; // �������� ������Ʈ �� (default 0)
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

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
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

	public int getMember_progressing_project_count() {
		return member_progressing_project_count;
	}

	public void setMember_progressing_project_count(int member_progressing_project_count) {
		this.member_progressing_project_count = member_progressing_project_count;
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

	//ȸ������
	public String toStringJoinMember() {
		return "MemberVO [member_no=" + member_no + ", member_email=" + member_email + ", member_pwd=" + member_pwd
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_regdate=" + member_regdate + "]";
	}

	//���� ȸ�� 
	public String toStringStopMember() {
		return "MemberVO [member_email=" + member_email + ", member_name=" + member_name + ", member_stop_state="
				+ member_stop_state + "]";
	}
	
	// ȸ�� ��� ����
	public String toStringMemberStats() {
		return "MemberVO [member_no=" + member_no + ", member_email=" + member_email + ", member_name=" + member_name
				+ ", member_total_project_count=" + member_total_project_count + ", member_progressing_project_count="
				+ member_progressing_project_count + ", member_supporting_count=" + member_supporting_count
				+ ", member_total_supported_count=" + member_total_supported_count + "]";
	}

	//ȸ�� ��ü ����
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_email=" + member_email + ", member_name=" + member_name
				+ ", member_birth=" + member_birth + ", member_gender=" + member_gender + ", member_regdate="
				+ member_regdate + ", member_total_project_count=" + member_total_project_count
				+ ", member_progressing_project_count=" + member_progressing_project_count
				+ ", member_supporting_count=" + member_supporting_count + ", member_total_supported_count="
				+ member_total_supported_count + ", member_stop_state=" + member_stop_state + ", member_withdraw_state="
				+ member_withdraw_state + "]";
	}
	
}
