-- ȸ��
CREATE TABLE Dream_Member (
	Member_No             INTEGER       NOT NULL, -- ȸ�� ��ȣ
	Member_Mail           VARCHAR2(40)  NOT NULL, -- ȸ�� �̸���
	Mmeber_Pass           VARCHAR2(100) NOT NULL, -- ȸ�� ��й�ȣ
	Member_Name           VARCHAR2(30)  NOT NULL, -- ȸ�� �̸�
	Member_Birth          VARCHAR2(16)  NOT NULL, -- ȸ�� �������
	Member_Gender         VARCHAR2(6)   NOT NULL, -- ȸ�� ����
	Member_Regdate        TIMESTAMP     DEFAULT sysdate, -- ȸ�� ���� ����
	Member_Profile_image  VARCHAR2(300) DEFAULT 'NO PROFILE', -- ȸ�� ������ ���� ���� �̸�
	Member_Stop_State     VARCHAR2(2)   DEFAULT 'F', -- ȸ�� ���� ����
	Member_Withdraw_State VARCHAR2(2)   DEFAULT 'F' -- ȸ�� Ż�� ����
);

-- ȸ��
ALTER TABLE Dream_Member
	ADD CONSTRAINT PK_Member -- ȸ�� �⺻Ű
		PRIMARY KEY (
			Member_No -- ȸ�� ��ȣ
		);

-- ȸ��
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Withdraw_State -- ȸ�� Ż�� ���� �׸� �˻�
		CHECK (Member_Withdraw_State in ('T' ,'F'));

-- ȸ��
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Stop_State -- ȸ�� ���� ���� �׸� �˻�
		CHECK (Member_Stop_State in ('T','F'));

-- ȸ��
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Gender -- ȸ�� ���� �׸� �˻�
		CHECK (Member_Gender in ('M' , 'F'));
		
		
DROP SEQUENCE dream_member_seq;
CREATE SEQUENCE dream_member_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;
