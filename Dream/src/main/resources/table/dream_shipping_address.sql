


-- ����ּ���
CREATE TABLE dream_shipping_address (
	Shipping_Address_No INTEGER       PRIMARY KEY, -- �����ȣ
	Support_No      	INTEGER  	  references	dream_support(Support_No), -- ������Ʈ ��ȣ
	Sender_Name         VARCHAR2(50)  NOT NULL, -- �߼��� �̸�
	Sender_Address      VARCHAR2(300) NOT NULL, -- �߼��� �ּ�
	Sender_Phone        VARCHAR2(30)  NOT NULL, -- �߼��ڿ���ó
	Receiver_Name       VARCHAR2(50)  NOT NULL, -- ������ �̸�
	Receiver_Phone      VARCHAR2(30)  NOT NULL, -- ������ ����ó
	Zip_Code            INTEGER       NOT NULL, -- ����� �����ȣ
	Receiver_Address    VARCHAR2(300) NOT NULL, -- ����� �ּ�
	Detail_Address       VARCHAR2(300) NOT NULL, -- ����� ���ּ�
	Shipping_Check       VARCHAR2(30)  DEFAULT 'N'  -- ��ۿ���
);

drop sequence Dream_Shipping_Address_seq;
create sequence Dream_Shipping_Address_seq
	start with 1
	increment by 1
	nocycle
	nocache;