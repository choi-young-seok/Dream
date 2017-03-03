-- ������
DROP TABLE Dream_Reward;

-- ������
CREATE TABLE Dream_Reward (
	Reward_No            INTEGER       NOT NULL, -- ������ ��ȣ
	Member_No          	 INTEGER       NOT NULL references dream_member(member_no), -- ����� �̸���
	Project_No           INTEGER       NOT NULL references dream_project(project_no), -- ������Ʈ ��ȣ
	Reward_Title         VARCHAR2(300) NOT NULL, -- ������ Ÿ��Ʋ
	Reward_Items         VARCHAR2(300) NOT NULL, -- ������ ǰ��
	Reward_Delivery_Date DATE          NOT NULL, -- ��� ������
	Reward_Limited_Count INTEGER       NOT NULL, -- ������ ��������
	Reward_Amount        INTEGER       NOT NULL  -- ������ �ݾ�
);

-- ������ sequence
drop SEQUENCE dream_reward_seq;
create SEQUENCE dream_reward_seq
   start with 1
   increment by 1
   nocycle
   nocache;