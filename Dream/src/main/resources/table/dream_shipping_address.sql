


-- ����ּ���
CREATE TABLE Dream_Shipping_Address (
	Shipping_Address_No INTEGER       PRIMARY KEY, -- �����ȣ
	Sender_Name         VARCHAR2(50)  NOT NULL, -- �߼��� �̸�
	Sender_Address      VARCHAR2(300) NOT NULL, -- �߼��� �ּ�
	Sender_Phone        VARCHAR2(30)  NOT NULL, -- �߼��ڿ���ó
	Receiver_Name       VARCHAR2(50)  NOT NULL, -- ������ �̸�
	Receiver_Phone      VARCHAR2(30)  NOT NULL, -- ������ ����ó
	Zip_Code            INTEGER       NOT NULL, -- ����� �����ȣ
	Receiver_Address    VARCHAR2(300) NOT NULL, -- ����� �ּ�
	Detail_Adress       VARCHAR2(300) NOT NULL, -- ����� ���ּ�
	Shipping_Check       VARCHAR2(30)  DEFAULT 'N'  -- ��ۿ���
);

drop sequence Dream_Shipping_Address_seq;
create sequence Dream_Shipping_Address_seq
	start with 1
	increment by 1
	nocycle
	nocache;