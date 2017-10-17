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
		authNum = random.nextInt(1000000) + 100000;
		
		if (authNum > 1000000) {
			authNum = authNum - 100000;
		}
		System.err.println("EmailForm \tcreateAuthNum 인증번호 : ["+authNum+"]");
		return authNum;
	}

	public static String mailContent(String member_name) {
			return "인증번호는[" + createAuthNum() + "]입니다";
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
