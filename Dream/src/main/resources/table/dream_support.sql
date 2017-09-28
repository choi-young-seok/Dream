-- �Ŀ�(����)
DROP TABLE Dream_Support;

-- �Ŀ�(����)
CREATE TABLE Dream_Support (
	Member_No			INTEGER  	 	references dream_member(Member_No), -- ����� ��ȣ
	Project_No      	INTEGER  	 	references	dream_project(Project_No), -- ������Ʈ ��ȣ
	Support_No      	INTEGER     	primary key, -- �Ŀ� ��ȣ
	Member_Name     	VARCHAR2(50) 	NOT NULL, -- �Ŀ��� ����
	Pay_Method			VARCHAR2(200)	NOT NULL, -- �������
	Pay_Account_Number 	VARCHAR2(200) 	NOT NULL, -- ���� ī���ȣ OR �Աݰ��¹�ȣ
	Support_Amount   	INTEGER      	NOT NULL, -- �Ŀ� �ݾ�
	Support_Date    	DATE         	DEFAULT sysdate, -- �Ŀ� ����
	Payback_Check		VARCHAR2(30)	DEFAULT 'N' -- ȯ�ҿ���
);

drop sequence dream_support_seq;
create sequence dream_support_seq
	start with 1
	increment by 1
	nocycle
	nocache;