package kr.co.dream.email.domain;

import java.util.Random;

public class EmailForm {

	private String member_authMail;
	private String member_name;
	private String subject = "DreamUp ȸ������ ���� �����Դϴ�.";
	private String Content;
	private static int authNum;

	public static int createAuthNum() {

		Random random = new Random();
		// 6�ڸ� ���� ���� ����
		authNum = random.nextInt(1000000) + 100000;
		//1000000(7�ڸ�)+100000(6�ڸ�) = 100001(6�ڸ� : �ּҰ�) ~ 1100000(7�ڸ� : �ִ밪)
		
		if (authNum > 1000000) {
			//7�ڸ��� �������
			authNum = authNum - 100000;
			//6�ڸ��� ����
		}

		return authNum;
	}

	public static String mailContent(String member_name) {
		
		// ȸ�����Խ� + ���̵� ã�� + ��й�ȣ �缳��(��й�ȣ ã��)
		if (member_name == "" || member_name.equals("") || member_name == null) {
			return "ȸ������ ������ȣ��[" + createAuthNum() + "]�Դϴ�";
		} 
		// �������� ���� + ��й�ȣ ���� 
		else {
			return member_name + "���� ȸ������ ������ȣ��[" + createAuthNum() + "]�Դϴ�";
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
