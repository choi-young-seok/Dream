DROP TABLE DREAM_PROJECT;
-- ������Ʈ
CREATE TABLE Dream_Project (
	Member_No                INTEGER       NOT NULL, -- ��� ȸ�� ��ȣ
	Project_No               INTEGER       NOT NULL, -- ������Ʈ ��ȣ
	Address_Member_No		 INTEGER,				 -- ������Ʈ ����� ��ȣ
	Project_Thumbnail        VARCHAR2(300) NOT NULL, -- ������Ʈ �����
	Project_Title            VARCHAR2(150) NOT NULL, -- ������Ʈ Ÿ��Ʋ
	Project_Summary          VARCHAR2(300) NOT NULL, -- ������Ʈ �Ұ�
	Project_Category         VARCHAR2(30)  NOT NULL, -- ������Ʈ ī�װ�
	Project_Goal_Amount      INTEGER       NOT NULL, -- ������Ʈ ��ǥ�ݾ�
	Now_Amount				 INTEGER	   DEFAULT 0, -- ������Ʈ ���� �Ŀ��ݾ�
	Project_Start_Date       DATE     	   DEFAULT sysdate, -- ������Ʈ ��������
	Project_End_Date         DATE     , -- ������Ʈ ��������
	Project_Video_Type       VARCHAR2(15)  DEFAULT 'NO TYPE', -- ������Ʈ �Ұ�����
	Project_Video            VARCHAR2(300) DEFAULT 'NO VIDEO', -- ������Ʈ �Ұ�����
	Project_Content          LONG      , -- ������Ʈ �󼼳���
	Register_Name            VARCHAR2(30)  ,     -- ����� �̸�
	Register_Intro           VARCHAR2(300) ,     -- ����� �Ұ�
	Access_Terms_Agree       VARCHAR2(2)   DEFAULT 'F', -- �̿� ��� ����
	Project_Account		     VARCHAR2(15)  DEFAULT 0, -- ������Ʈ ���¹�ȣ
	Project_Account_Bank     VARCHAR2(30)  , -- ���� �����
	Project_Support_Amount   INTEGER       DEFAULT 0, -- ���� �Ŀ� �Ѿ�
	Project_View_Count       INTEGER       DEFAULT 0, -- ���� ��ȸ ��
	Supporting_Count 		 INTEGER       DEFAULT 0, -- ���� �Ŀ� ��
	Project_Register_State   VARCHAR2(2)   DEFAULT 'F', -- ������Ʈ ��Ͽ���
	Project_Success_State    VARCHAR2(2)   DEFAULT 'F' -- ������Ʈ ��������
);

-- ������Ʈ
ALTER TABLE Dream_Project
	ADD CONSTRAINT PK_Project -- ������Ʈ �⺻Ű
		PRIMARY KEY (
			Member_No,  -- ��� ȸ�� ��ȣ
			Project_No  -- ������Ʈ ��ȣ
		);

-- ������Ʈ
ALTER TABLE Dream_Project
	ADD CONSTRAINT FK_Member_TO_Project -- ȸ�� -> ������Ʈ
		FOREIGN KEY (
			Member_No -- ��� ȸ�� ��ȣ
		)
		REFERENCES Dream_Member ( -- ȸ��
			Member_No -- ȸ�� ��ȣ	
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_project_seq;
CREATE SEQUENCE dream_project_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;