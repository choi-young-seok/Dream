-- ��� 2017/01/04 ���� ȸ�� DB ��Ű��    
drop table dream_member;
create table dream_member(
   member_No         	integer,               -- ��� ��ȣ         
   member_Id         	varchar2(30)    primary key, -- ��� ���̵�
   member_Password  	varchar2(150)   not null, -- ��� ��й�ȣ
   member_Email         varchar2(150)   not null, -- ��� �̸��� , �ߺ��˻� �Ұ�
   member_Name         	varchar2(30)    not null, --��� �̸�
   member_Date         	date		    not null 	default sysdate, -- ������
    --ȸ�����Խ� �Է� �޴� �÷� (INSERT)
    
   member_Phone         varchar2(13), --1.�Ŀ��Ҷ� or 2.������Ʈ ��Ͻ� �Է�
   member_Zip          	varchar2(13),
   member_Address     	varchar2(255), -- 1.�Ŀ��Ҷ� ����� ���� or 2.������Ʈ ��Ͻ� �ּ����� �Է�
   member_Post         	varchar2(20), -- 1.�Ŀ��Ҷ� ����� ���� or 2.������Ʈ ��Ͻ� �ּ����� �Է�
   
   member_BankName      varchar2(30), -- ȯ�ҽ� �����
   member_Account      	varchar2(20), -- ȯ�ҽ� ���¹�ȣ
   --�Ŀ����� �Է½� �Է� �޴� �÷� (UPDATE)
   
   member_SupportingCount     	integer		default '0', -- ���� �Ŀ��ϴ� ������Ʈ �� ���հ� (�Ŀ��� +1)
   member_SupportedCount      	integer		default '0', -- �� ������Ʈ �� �Ŀ��հ� (ȯ�ҽ� -1)
   member_Withdraw				varchar2(10)	default 'F' check(member_Withdraw in ('T','F')) 
);

-- ��� 2017/01/04 ���� ȸ�� DB ��Ű��    
   
-- ȸ��
DROP TABLE Dream_Member

-- ȸ��
CREATE TABLE Dream_Member (
	Member_No              INTEGER       primary key, -- ȸ�� ��ȣ
	Member_Email           VARCHAR2(40)  NOT NULL, -- ȸ�� �̸���
	Mmeber_Pwd             VARCHAR2(100) NOT NULL, -- ȸ�� ��й�ȣ
	Member_Name            VARCHAR2(18)  NOT NULL, -- ȸ�� �̸�
	Member_Birth           VARCHAR2(12)  NOT NULL, -- ȸ�� �������
	Member_Gender          VARCHAR2(6)   NOT NULL, -- ȸ�� ����
	Member_Regdate         DATE               		DEFAULT sysdate, -- ȸ�� ���� ����
	    --ȸ�����Խ� �Է� �޴� �÷� (INSERT)
	Member_Withdraw_State  VARCHAR2(10)       		DEFAULT 'F', -- ȸ�� Ż�� ����
	Member_Refund_Count    INTEGER            		DEFAULT 0, -- ȸ�� ȯ�� Ƚ��
	Member_Stop_State      VARCHAR2(10)       		DEFAULT 'F', -- ȸ�� ���� ����
	Member_Stop_Count      INTEGER            		DEFAULT 0, -- ȸ�� ���� Ƚ��
	-- ȸ�����Խ� default ó�� �Ǵ� �÷�
	Member_Stop_Date       DATE,			   -- ȸ�� ���� ����
	Member_Refund_LastDate DATE                -- ȸ�� ������ ȯ�� ����
	-- ȯ�� �� ȸ�� ���� �߻��� ���� �Ǵ� �÷� (UPDATE)
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

		
drop sequence dream_member_seq;
create sequence dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;