package kr.co.dream.support.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.project.domain.ProjectPointDTO;
import kr.co.dream.reward.domain.RewardVO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportVO {
	// �Ŀ� �⺻����
	private int member_no; // �Ŀ��� ȸ�� ��ȣ
	private int project_no; // ������Ʈ ��ȣ
	private int support_no; // �Ŀ�(����) ��ȣ

	// ���� ����
	private String member_name; // �Ŀ���(������) ����
	private String pay_bank;
	private String pay_method; // ���� ��� (ī�� or ������)
	private String pay_account_number; // ����ī���ȣ or �Աݰ��¹�ȣ
	private int support_amount; // �Ŀ�(����) �ݾ�
	private Date support_date; // �Ŀ�(����) ����
	private String support_category; // ������ �Ŀ� o/x ����

	// ȯ������
	private String payback_bank; // ȯ�� ����
	private String payback_account; //ȯ�� ����
	private String payback_check; // ȯ�� ����(������Ʈ �޼����ο� ����)
	

	// �������
	private SupportDeliveryDTO deliveryDTO;
//	private ProjectPointDTO projectPointDTO;
	
}
