package kr.co.dream.member.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
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

	private MultipartFile member_profile_image;
	private String member_profile;

	// ȸ������ ����
	public String toStringJoinMember() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_pass=" + member_pass
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_regdate=" + member_regdate + "]";
	}

	// ���̵� ã��
	public String toStringFindInfo() {
		return "MemberVO [member_mail(��й�ȣ ���� / ã�� ���̵�)=" + member_mail + ", member_regdate=" + member_regdate
				+ ", member_name(���̵� ã��)=" + member_name + ", member_birth(���̵� ã��)=" + member_birth + "]";
	}

	// �α��� ȸ������
	public String toStringLogin() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_name=" + member_name
				+ ", member_ongoing_project_count=" + member_ongoing_project_count +"]";
	}

	// ȸ�� ������ ���� ����
	public String toStringProfile() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_name=" + member_name
				+ ", member_profile=" + member_profile + "]";
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

	// toString Override Method
	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_pass=" + member_pass
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_regdate=" + member_regdate + ", member_total_project_count=" + member_total_project_count
				+ ", member_ongoing_project_count=" + member_ongoing_project_count + ", member_supporting_count="
				+ member_supporting_count + ", member_total_supported_count=" + member_total_supported_count
				+ ", member_stop_state=" + member_stop_state + ", member_withdraw_state=" + member_withdraw_state + "]";
	}

}
