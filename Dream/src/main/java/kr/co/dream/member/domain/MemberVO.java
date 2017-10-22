package kr.co.dream.member.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO {

	private int member_no; // 회원 번호
	private String member_mail; // 회원 이메일(아이디)
	private String member_pass; // 회원 비밀번호
	private String member_name; // 회원 이름
	private String member_birth; // 회원 생년월일(yyyy-mm-dd)
	private String member_gender; // 회원 성별
	// 회원 가입시 입력 받는 항목

	private Date member_regdate; // 회원 가입일 (default sysdate)
	private int member_total_project_count; // 등록 프로젝트 수 (default 0)
	private int member_ongoing_project_count; // 진행중인 프로젝트 수 (default 0)
	private int member_supporting_count; // 해당 회원이 후원하는 프로젝트 수 (default 0)
	private int member_total_supported_count; // 해당 회원의 전체 후원 수 (default 0)

	private String member_stop_state; // 회원 정지 여부
	private String member_withdraw_state; // 회원 탈퇴 여부

	private MultipartFile member_profile_image;
	private String member_profile;

	// 회원가입 정보
	public String toStringJoinMember() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_pass=" + member_pass
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", member_gender=" + member_gender
				+ ", member_regdate=" + member_regdate + "]";
	}

	// 아이디 찾기
	public String toStringFindInfo() {
		return "MemberVO [member_mail(비밀번호 변경 / 찾은 아이디)=" + member_mail + ", member_regdate=" + member_regdate
				+ ", member_name(아이디 찾기)=" + member_name + ", member_birth(아이디 찾기)=" + member_birth + "]";
	}

	// 로그인 회원정보
	public String toStringLogin() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_name=" + member_name
				+ ", member_ongoing_project_count=" + member_ongoing_project_count +"]";
	}

	// 회원 프로필 사진 정보
	public String toStringProfile() {
		return "MemberVO [member_no=" + member_no + ", member_mail=" + member_mail + ", member_name=" + member_name
				+ ", member_profile=" + member_profile + "]";
	}

	// 정지 회원 정보
	public String toStringStopMember() {
		return "MemberVO [member_mail=" + member_mail + ", member_name=" + member_name + ", member_stop_state="
				+ member_stop_state + "]";
	}

	// 회원 통계 정보
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
