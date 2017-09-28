DROP TABLE DREAM_DELIVERY;
-- ����ּ���
CREATE TABLE Dream_Delivery (
	Project_No             INTEGER       NOT NULL, -- ������Ʈ ��ȣ
	Support_No             INTEGER       NOT NULL, -- �Ŀ� ��ȣ
	Delivery_Address_No    INTEGER       NOT NULL, -- �����ȣ
	Total_Reward_NO		   INTEGER       NOT NULL, -- ���� ǰ�� ��ȣ
	Member_No			   INTEGER		 NOT NULL, -- �Ŀ� ȸ�� ��ȣ
	
	Sender_Name            VARCHAR2(30)  NOT NULL, -- �߼��� �̸�
	Sender_Zip_Code        INTEGER       NOT NULL,     -- �߼��� �����ȣ
	Sender_Address         VARCHAR2(200) NOT NULL, -- �߼��� �ּ�
	Sender_Detail_Address  VARCHAR2(200) NOT NULL,     -- �߼��� ���ּ�
	Sender_Phone           VARCHAR2(30)  NOT NULL, -- �߼��ڿ���ó
	
	Receiver_Name          VARCHAR2(30)  NOT NULL, -- ������ �̸�
	Receiver_Address_Alias VARCHAR2(30)  NOT NULL,     -- ������ ��Ī
	Receiver_Phone         VARCHAR2(30)  NOT NULL, -- ������ ����ó
	Receiver_Zip_Code      INTEGER       NOT NULL, -- ����� �����ȣ
	Receiver_Address       VARCHAR2(200) NOT NULL, -- ����� �ּ�
	Receiver_Detail_Address VARCHAR2(200) NOT NULL, -- ����� ���ּ�
	Shipping_Check         VARCHAR2(30)  DEFAULT 'F'  -- ��ۿ���
);

-- ����ּ���
ALTER TABLE Dream_Delivery
	ADD CONSTRAINT PK_Delivery -- ����ּ��� �⺻Ű
		PRIMARY KEY (
			Project_No,          -- ������Ʈ ��ȣ
			Support_No,          -- �Ŀ� ��ȣ
			Delivery_Address_No  -- �����ȣ
		);

-- ����ּ���
ALTER TABLE Dream_Delivery
	ADD CONSTRAINT FK_Support_TO_Delivery -- �Ŀ�(����) -> ����ּ���
		FOREIGN KEY (
			Project_No, -- �Ŀ� ������Ʈ ��ȣ
			Support_No  -- �Ŀ� ��ȣ
		)
		REFERENCES Dream_Support ( -- �Ŀ�(����)
			Project_No, -- �Ŀ� ������Ʈ ��ȣ
			Support_No  -- �Ŀ� ��ȣ
		);
		
		
DROP SEQUENCE dream_delivery_seq;
CREATE SEQUENCE dream_delivery_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;		