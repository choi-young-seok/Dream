package kr.co.dream.project.domain;

import lombok.Data;

@Data
public class ProjectOperDTO {
	private int project_no;
	private int project_percentage;
	// �޼��� = (����ݾ� / ��ǥ�ݾ�)*100;

	private int project_d_day;
	// �ܿ��Ⱓ ��ǥ�� - ���ó�¥

}
