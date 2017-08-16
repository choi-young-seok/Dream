-- �� ���̺�7
CREATE TABLE Dream_Shipping_Items (
	Project_No          INTEGER       references dream_project(project_no), -- ������Ʈ ��ȣ
	Support_No          INTEGER       references dream_support(support_no), -- �Ŀ� ��ȣ
	Shipping_Address_No INTEGER       references dream_shipping_address(Shipping_Address_No), -- �����ȣ
	Total_Reward_No     INTEGER       references dream_reward(reward_no), -- ��ü ������ ��ȣ(����ǰ��)
	Member_No           INTEGER       references dream_member(member_no) -- ȸ�� ��ȣ
);


CREATE TABLE Dream_Shipping_Items (
	Shipping_Address_No INTEGER NOT NULL, -- �����ȣ
	Member_No           INTEGER NOT NULL, -- ȸ�� ��ȣ
	Support_No          INTEGER NOT NULL, -- �Ŀ� ��ȣ
	Project_No          INTEGER NOT NULL, -- ������Ʈ ��ȣ
	Total_Reward_No     INTEGER NOT NULL  -- ��ü ������ ��ȣ(����ǰ��)
);

-- �� ���̺�7
ALTER TABLE Dream_Shipping_Items
	ADD CONSTRAINT PK_Dream_Shipping_Items -- �� ���̺�7 �⺻Ű
		PRIMARY KEY (
			Shipping_Address_No, -- �����ȣ
			Member_No,           -- ȸ�� ��ȣ
			Support_No,          -- �Ŀ� ��ȣ
			Project_No,          -- ������Ʈ ��ȣ
			Total_Reward_No      -- ��ü ������ ��ȣ(����ǰ��)
		);

-- �� ���̺�7
ALTER TABLE Dream_Shipping_Items
	ADD CONSTRAINT FK_Dream_Shipping_Address_TO_Dream_Shipping_Items -- ����ּ��� -> �� ���̺�7
		FOREIGN KEY (
			Shipping_Address_No -- �����ȣ
		)
		REFERENCES MY_SCHEMA.Dream_Shipping_Address ( -- ����ּ���
			Shipping_Address_No -- �����ȣ
		);

-- �� ���̺�7
ALTER TABLE MY_SCHEMA.Dream_Shipping_Items
	ADD CONSTRAINT FK_Dream_Support_TO_Dream_Shipping_Items -- �Ŀ�(����) -> �� ���̺�7
		FOREIGN KEY (
			Member_No,       -- ȸ�� ��ȣ
			Project_No,      -- ������Ʈ ��ȣ
			Total_Reward_No, -- ��ü ������ ��ȣ(����ǰ��)
			Support_No       -- �Ŀ� ��ȣ
		)
		REFERENCES MY_SCHEMA.Dream_Support ( -- �Ŀ�(����)
			Member_No,       -- ȸ�� ��ȣ
			Project_No,      -- ������Ʈ ��ȣ
			Total_Reward_No, -- ��ü ������ ��ȣ(����ǰ��)
			Support_No       -- �Ŀ� ��ȣ
		);