package kr.co.dream.support.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kr.co.dream.address.domain.MemberAddressVO;
import kr.co.dream.reward.domain.RewardVO;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SupportDeliveryDTO{

	private int member_no; //���� ȸ����ȣ
	private int project_no; // ���� ������Ʈ��ȣ
	private int support_no; // ������ȣ
	private int total_reward_no; //���� ǰ��
	private int delivery_address_no; // �����ȣ
	
	private MemberAddressVO senderAddressVO; // ������Ʈ ����� ������ �߼��� �ּ�
	private SupportRewardDTO supportRewardDTO; // ������Ʈ ������

	private String receiver_name; // ������ �̸�
	private String receiver_address_alias; // �߼��� �ּ�
	private int receiver_zip_code; // �߼��� �ּ�
	private String receiver_address; // �߼��� �ּ�
	private String receiver_detail_address; // �߼��� �ּ�
	private String receiver_phone; // ������ ����ó

	private String shipping_check; // ��ۿ��� Defalt 'N'

	
}
