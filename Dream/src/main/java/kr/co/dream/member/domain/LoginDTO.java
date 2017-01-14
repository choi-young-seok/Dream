package kr.co.dream.member.domain;

public class LoginDTO {

	private String login_mail;
	private String login_pass;
	private boolean useCookie;

	public String getLogin_mail() {
		return login_mail;
	}

	public void setLogin_mail(String login_mail) {
		this.login_mail = login_mail;
	}

	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [login_mail=" + login_mail + ", login_pass=" + login_pass + ", useCookie=" + useCookie + "]";
	}

}
