package kr.co.dream.project.domain;

public class ProjectOperDTO {
	private int project_no;
	private int project_percentage;
	// �޼��� = (����ݾ� / ��ǥ�ݾ�)*100;

	private int project_d_day;
	// �ܿ��Ⱓ ��ǥ�� - ���ó�¥

	public int getProject_no() {
		return project_no;
	}

	public void setProject_no(int project_no) {
		this.project_no = project_no;
	}

	public int getProject_percentage() {
		return project_percentage;
	}

	public void setProject_percentage(int project_percentage) {
		this.project_percentage = project_percentage;
	}

	public int getProject_d_day() {
		return project_d_day;
	}

	public void setProject_d_day(int project_d_day) {
		this.project_d_day = project_d_day;
	}

	@Override
	public String toString() {
		return "ProjectOperDTO [project_no=" + project_no + ", project_percentage=" + project_percentage
				+ ", project_d_day=" + project_d_day + "]";
	}

}
