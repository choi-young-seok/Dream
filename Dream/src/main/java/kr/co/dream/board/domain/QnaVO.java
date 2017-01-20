package kr.co.dream.board.domain;

import java.util.Date;

public class QnaVO {

	private int qna_no;
	private String manager_mail;
	private String member_mail;
	private String member_name;
	private String qna_title;
	private String qna_content;
	
	private Date qna_regdate;
	private String qna_check;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getManager_mail() {
		return manager_mail;
	}
	public void setManager_mail(String manager_mail) {
		this.manager_mail = manager_mail;
	}
	public String getMember_mail() {
		return member_mail;
	}
	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_regdate() {
		return qna_regdate;
	}
	public void setQna_regdate(Date qna_regdate) {
		this.qna_regdate = qna_regdate;
	}
	public String getQna_check() {
		return qna_check;
	}
	public void setQna_check(String qna_check) {
		this.qna_check = qna_check;
	}
	@Override
	public String toString() {
		return "QnaVO [member_mail=" + member_mail + ", member_name=" + member_name + ", qna_title=" + qna_title
				+ ", qna_content=" + qna_content + "]";
	}
	
	
}
