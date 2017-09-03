-- ������
CREATE TABLE Dream_Reward (
	Member_No               INTEGER       NOT NULL, -- ȸ�� ��ȣ
	Project_No              INTEGER       NOT NULL, -- ������Ʈ ��ȣ
	Total_Reward_No         INTEGER       NOT NULL, -- ��ü ������ ��ȣ
	Reward_No               INTEGER       NOT NULL, -- ������Ʈ ������ ��ȣ(��ǰ ��ȣ)
	Reward_Items            VARCHAR2(300) NOT NULL, -- ������ ǰ��
	Reward_Explain          VARCHAR2(300) NOT NULL, -- ������ ��ǰ����
	Reward_Delivery_Date    TIMESTAMP     NOT NULL, -- ��� ������
	Reward_Limited_Count    INTEGER       NOT NULL, -- ������ ��������
	Reward_Amount           INTEGER       NOT NULL  -- ������ �ݾ�
);

-- ������
ALTER TABLE Dream_Reward
	ADD CONSTRAINT PK_Reward -- ������ �⺻Ű
		PRIMARY KEY (
			Member_No,       -- ȸ�� ��ȣ
			Project_No,      -- ������Ʈ ��ȣ
			Total_Reward_No  -- ��ü ������ ��ȣ
		);

-- ������
ALTER TABLE Dream_Reward
	ADD CONSTRAINT FK_Project_TO_Reward -- ������Ʈ -> ������
		FOREIGN KEY (
			Member_No,  -- ȸ�� ��ȣ
			Project_No  -- ������Ʈ ��ȣ
		)
		REFERENCES Dream_Project ( -- ������Ʈ
			Member_No,  -- ��� ȸ�� ��ȣ
			Project_No  -- ������Ʈ ��ȣ
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_reward_seq;
CREATE SEQUENCE dream_reward_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;