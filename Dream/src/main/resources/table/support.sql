-- �Ŀ� �ӽ����̺�

-- �� ���̺�4
ALTER TABLE Dream_Support
	DROP FOREIGN KEY FK_Dream_Member_TO_Dream_Support; -- ȸ�� -> �� ���̺�4

-- �� ���̺�4
ALTER TABLE Dream_Support
	DROP FOREIGN KEY FK_Dream_Project_TO_Dream_Support; -- user -> �� ���̺�4

-- �� ���̺�4
DROP TABLE Dream_Support;

-- �� ���̺�4
CREATE TABLE Dream_Support (
	Support_No    INTEGER      primary key, -- �Ŀ� ��ȣ
	Member_Mail   VARCHAR2(40) NOT NULL REFERENCES Dream_Member(Member_Mail), -- ȸ�� �̸���
	Project_No    INTEGER      NOT NULL REFERENCES Dream_Project(Project_No), -- ������Ʈ ��ȣ
	Support_Money INTEGER      DEFAULT 0, -- �Ŀ� �ݾ�
	Support_Date  DATE         DEFAULT sysdate -- �Ŀ� ����
);
	-- Member_Name   VARCHAR2(18) NOT NULL REFERENCES Dream_Member(Member_Name), -- �Ŀ��� ����
	
	
drop sequence support_seq;
create sequence support_seq
	start with 1
	increment by 1
	nocycle
	nocache; 
--�������


drop table support;
create table support(
	Su_No			integer			primary key, --�Ŀ���ȣ
	Pro_No			integer		not null references project(Pro_No), --�Ŀ��ϴ� ������Ʈ ��ȣ
	M_Id			varchar2(20)  	not null references member(M_id), --�Ŀ��� ��� ID
	Re_No			integer		references reward(Re_No), -- �Ŀ��� ���� �������ȣ
	
	Su_Money		integer		not null, --�Ŀ��ݾ�
	Su_Name			varchar2(20)	not null, -- ��� ���� ��� �̸�
	Su_Zip          varchar2(20)    not null, -- ��ۿ����ȣ
	Su_Address		varchar2(255)	not null, -- ����� �ּ�
	Su_Phone		varchar2(20)	not null, -- ��� ���� ��� ��ȣ
	PaymentPlan		varchar2(20)	not null, --�������
	Su_refundAccount varchar2(30) not null, --ȯ�Ұ���
	Su_refundBank    varchar2(30) not null, --ȯ������
	Su_Date			date		not null, -- �Ŀ� ��¥
	--������Ʈ �Ŀ� ���� �Է½� �ʿ� �÷�

	Su_State		varchar2(1)	 default '0' --ȯ�ҿ���

);

select * from support

insert into support (su_no,m_id,pro_no,re_no,su_money,su_name, su_address,
		             su_zip,su_phone,paymentPlan,su_refundAccount,su_refundBank,su_date)
		values
		            (support_seq.nextval,'test1',1,1,1300,'���ٿ��','�������ȴޱ�',
		             '34012','01084685154','����','23112312','��������',sysdate);
		
                
           ALTER TABLE support  DROP(columnName );
           alter table support MODIFY (Re_No integer);
		             
drop sequence support_seq;
create sequence support_seq
	start with 1
	increment by 1
	nocycle
	nocache; 