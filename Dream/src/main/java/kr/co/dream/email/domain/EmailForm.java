package kr.co.dream.email.domain;

import java.util.Random;

public class EmailForm {

	private String member_authMail;
	private String member_name;
	private String subject = "DreamUp 회원가입 인증 메일입니다.";
	private String Content;
	private static int authNum;

	public static int createAuthNum() {

		Random random = new Random();
		// 6자리 난수 생성 로직
		authNum = random.nextInt(1000000) + 100000;
		//1000000(7자리)+100000(6자리) = 100001(6자리 : 최소값) ~ 1100000(7자리 : 최대값)
		
		if (authNum > 1000000) {
			//7자리가 넘을경우
			authNum = authNum - 100000;
			//6자리로 조정
		}

		return authNum;
	}

	public static String mailContent(String member_name) {
		
		// 회원가입시 + 아이디 찾기 + 비밀번호 재설정(비밀번호 찾기)
		if (member_name == "" || member_name.equals("") || member_name == null) {
			return "회원가입 인증번호는[" + createAuthNum() + "]입니다";
		} 
		// 개인정보 변경 + 비밀번호 변경 
		else {
			return member_name + "님의 회원가입 인증번호는[" + createAuthNum() + "]입니다";
		}
	}

	public String getMember_authMail() {
		return member_authMail;
	}

	public void setMember_authMail(String member_authMail) {
		this.member_authMail = member_authMail;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public static int getAuthNum() {
		return authNum;
	}

	public static void setAuthNum(int authNum) {
		EmailForm.authNum = authNum;
	}

	@Override
	public String toString() {
		return "EmailForm [member_authMail=" + member_authMail + ", member_name=" + member_name + "]";
	}

}
