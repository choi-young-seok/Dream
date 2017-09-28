-- ȸ���ּ�
CREATE TABLE Dream_Member_Address (
	Member_No               INTEGER       NOT NULL, -- ȸ�� ��ȣ
	Address_Member_No       INTEGER       NOT NULL, -- �ּ��� ��ȣ
	Address_Member_Name     VARCHAR2(30)  NOT NULL, -- �ּ��� ȸ�� �̸�
	Address_Ailais          VARCHAR2(30)  NOT NULL, -- �ּ��� ��Ī
	Member_Address_zip_code INTEGER    	  NOT NULL, -- �ּ��� �����ȣ
	Member_Address          VARCHAR2(200) NOT NULL, -- �ּ��� ������ �ּ�
	Member_Detail_Address   VARCHAR2(200) NOT NULL, -- �ּ��� �� �ּ�
	Address_Member_Phone    VARCHAR2(30)  NOT NULL,  -- �ּ��� ����ó
	Delivery_Address        VARCHAR2(20) 
);

-- ȸ���ּ�
ALTER TABLE Dream_Member_Address
	ADD CONSTRAINT PK_Member_Address -- ȸ���ּ� �⺻Ű
		PRIMARY KEY (
			Member_No,         -- ȸ�� ��ȣ
			Address_Member_No  -- �ּ��� ��ȣ
		);

-- ȸ���ּ�
ALTER TABLE Dream_Member_Address
	ADD CONSTRAINT FK_Member_TO_Member_Address -- ȸ�� -> ȸ���ּ�
		FOREIGN KEY (
			Member_No -- ȸ�� ��ȣ
		)
		REFERENCES Dream_Member ( -- ȸ��
			Member_No -- ȸ�� ��ȣ
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_address_seq;
CREATE SEQUENCE dream_address_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;