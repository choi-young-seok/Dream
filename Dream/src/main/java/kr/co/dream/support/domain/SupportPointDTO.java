package kr.co.dream.support.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.project.domain.ProjectPointDTO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportPointDTO {
	private int member_no; //������ �̸�
	private int support_no; // �Ŀ�(����) ��ȣ
	private int project_no; // ������Ʈ ��ȣ
	
	private String member_name; // �Ŀ���(������) ����
	private String pay_method; // ���� ��� (ī�� or ������)\	
	private int support_amount; // �Ŀ�(����) �ݾ�
	private Date support_date; // �Ŀ�(����) ����
	
	private String payback_check;
	
	private ProjectPointDTO projectPointDTO;
	private SupportDeliveryDTO supportDeliveryDTO;
	
}
