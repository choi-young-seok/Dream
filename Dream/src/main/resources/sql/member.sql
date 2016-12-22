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

drop sequence dream_member_seq;
create sequence dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
    