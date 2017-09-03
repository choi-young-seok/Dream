-- �Ŀ�(����)
CREATE TABLE Dream_Support (
	Member_No          INTEGER       NOT NULL, -- �Ŀ� ȸ�� ��ȣ
	Project_No         INTEGER       NOT NULL, -- ������Ʈ ��ȣ
	Support_No         INTEGER       NOT NULL, -- �Ŀ� ��ȣ
	Member_Name        VARCHAR2(30)  NOT NULL, -- �Ŀ��� �̸� (�Ա��� �̸�)
	Pay_Method         VARCHAR2(30)  NOT NULL, -- ���� ���
	Pay_Account_Number VARCHAR2(300) NOT NULL, -- ���� ī�� ��ȣ or �Աݰ���
	Support_Amount     INTEGER       NOT NULL, -- �Ŀ� �ݾ�
	Support_Date       TIMESTAMP     DEFAULT sysdate, -- �Ŀ� ����
	Payback_Check      VARCHAR2(2)   DEFAULT 'N' -- ȯ�� ����
);

-- �Ŀ�(����)
ALTER TABLE Dream_Support
	ADD CONSTRAINT PK_Support -- �Ŀ�(����) �⺻Ű
		PRIMARY KEY (
			Member_No,  -- �Ŀ� ȸ�� ��ȣ
			Project_No, -- ������Ʈ ��ȣ
			Support_No  -- �Ŀ� ��ȣ
		);

-- �Ŀ�(����)
ALTER TABLE Dream_Support
	ADD CONSTRAINT FK_Project_TO_Support -- ������Ʈ -> �Ŀ�(����)
		FOREIGN KEY (
			Member_No,  -- �Ŀ� ȸ�� ��ȣ
			Project_No  -- ������Ʈ ��ȣ
		)
		REFERENCES Dream_Project ( -- ������Ʈ
			Member_No,  -- ��� ȸ�� ��ȣ
			Project_No  -- ������Ʈ ��ȣ
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_support_seq;
CREATE SEQUENCE dream_support_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;