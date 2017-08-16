-- �Ŀ��� ���� ������Ʈ �ӽ����̺� 

-- user
DROP TABLE Dream_Project;

-- user
CREATE TABLE Dream_Project (
	Member_No				INTEGER  	  references dream_member(Member_No), -- ����� ��ȣ
	Project_No             	INTEGER       primary key, -- ������Ʈ ��ȣ
	Project_Thumbnail       VARCHAR2(300) NOT NULL, -- ������Ʈ ����� 
	Project_Title           VARCHAR2(60)  NOT NULL, -- ������Ʈ Ÿ��Ʋ	 (�ѱ�/���� : 20/30)	
	Project_Summary         VARCHAR2(600) NOT NULL, -- ������Ʈ ��� ���� (�ѱ�/���� : 200/300)
	Project_Category        VARCHAR2(30)  NOT NULL, -- ������Ʈ ī�װ�
	Project_Start_Date      DATE          DEFAULT sysdate, -- ������Ʈ ��������
	Project_End_Date        DATE          NOT NULL, -- ������Ʈ ��������
	Project_Goal_Amount     INTEGER       NOT NULL, -- ������Ʈ ��ǥ�ݾ�
	-- ������Ʈ �⺻ ���� 
		
	Project_Video          	VARCHAR2(300) DEFAULT 'NO VIDEO', -- ������Ʈ ����
	Project_Content        	LONG, 							  -- ������Ʈ ����
	-- ������Ʈ ���丮 ����
	
	Register_Profile		VARCHAR2(300) DEFAULT 'NO PROFILE',
	Register_Name			VARCHAR2(50),
	Register_intro		   	VARCHAR2(300),		   -- ����� �Ұ�
	Register_Sns			VARCHAR2(300),		   -- ����� SNS �ּ�	 (�ѱ�/���� : 100/150)
	-- ����� ������ ����
	
	Register_Address		VARCHAR2(300) DEFAULT 'NO ADDRESS',		   -- ����� �ּ�			 (�ѱ�/���� : 100/150)
	Project_Account		   	INTEGER		  DEFAULT 0, -- ������Ʈ ����
	Access_Terms_Agree		VARCHAR2(10)  DEFAULT 'F', -- �̿��� ����
	-- ������Ʈ ���� ����
	
	Project_ViewCnt		   	INTEGER		  DEFAULT 0,	-- ���� ��ȸ ��
	Now_Amount             	INTEGER       DEFAULT 0, -- ���� �Ŀ� �Ѿ�
	Supporting_Count       	INTEGER       DEFAULT 0, -- ���� �Ŀ� ��
	Project_Register_State 	VARCHAR2(10)  DEFAULT 'F', -- ������Ʈ ��Ͽ��� (T = ��ϿϷ�, F = �����)
	Project_Success_State  	VARCHAR2(10)  DEFAULT 'F' -- ������Ʈ �������� (T = �Ŀ��Ϸ�, T = �Ŀ�����)
	-- �Ⱓ �̳� �޼� ���� �÷��� �Ⱓ ������ ���� �޼����� Į���� ���������� �����ؾ��ҵ�
);
-- alter table dream_project add Projcet_ViewCnt INTEGER DEFAULT 0 (�߰��Ϸ�)
-- alter table dream_project add Register_Profile VARCHAR2(300) DEFAULT 'NO VALUE' (�߰��Ϸ�)
-- alter table dream_project add Register_Name VARCHAR2(50)(�߰��Ϸ�)

-- users
ALTER TABLE Dream_Project
	ADD CONSTRAINT Project_Register_State -- ������Ʈ ��Ͽ���
		CHECK (Project_Register_State in ('T' ,'F'));

-- user
ALTER TABLE Dream_Project
	ADD CONSTRAINT Project_Success_State -- ������Ʈ ��������
		CHECK (Project_Success_State in ('T' ,'F'));
	
drop sequence dream_project_seq;
create sequence dream_project_seq
	start with 1
	increment by 1
	nocycle
	nocache;

		--������ ����
		
	alter table add member_mail varchar2(40) references dream_member(member_mail)
-- ���̵�����
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date,Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample.jpg','�Ͽ콺 Ĭ���� ����','�Ͽ콺 Ĭ���Ͽ� ���� ���� ������ �����մϴ�.!', 110411833284,
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','��ǻ�� ����',1000000,sysdate,sysdate+50,'T');
	
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date, Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample2.jpg','�������� ���ڵ�����','���� ����! �ų��� ���ǰ� �Բ� �ϼ���!', 110411833284,
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','����',1000000,sysdate,sysdate+50,'T');
	
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date,Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample3.jpg','A LITTLE LESS DESPERATION','THERE IS NO INTERESTED GAME IN THIS WEBSITE COME WITH ME!', 110411833284,
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','����',1000000,sysdate,sysdate+50,'T');

--���̵�����
select * from dream_project
DELETE FROM DREAM_PROJECT where project_no = 1

drop table project;
create table project(
	Pro_No			integer		primary key,		
	M_Id			varchar2(20) 	not null references member(M_id),
	Pro_Thumbnail	varchar2(2000)	not null, -- ����� �̹��� url
	Pro_Title		varchar2(300)	not null, -- ������Ʈ Ÿ��Ʋ
	Pro_Catagory	varchar2(50)	not null, -- ������Ʈ ī�װ�
	Pro_Start		date			not null, -- ������Ʈ ������(sysdate)
	Pro_End			date			not null, -- ������Ʈ ����(sysdate+a)
	Pro_Goal		integer			not null, -- ������Ʈ ��ǥ�ݾ�
	Pro_state		integer 	default '0',
	--Pro_state
	--0 : ���� �����
	--1 : ��� �Ϸ� & �Ŀ� ������
	--2 : �Ŀ� �Ⱓ ����		
	--������Ʈ �⺻ ���� �Է½� �ʿ� �÷�
	
	Pro_Video		varchar2(2000), -- ������Ʈ ���� url
	Pro_Content		long, -- ������Ʈ �Ұ� ����
	Pro_link		varchar2(2000), -- ������Ʈ ���� ��ũ url
 	--������Ʈ ���丮 ���� �Է½� �ʿ� �÷�
	
	Pro_fileImage	varchar2(2000), -- ����� ����url
	Pro_fileIntro 		varchar2(2000), --����� �Ұ� ���� (lontext�� �ڷ��� ��ȯ �Ұ�
	Pro_zip             varchar2(2000),
	Pro_address			varchar2(255), --�����ʵ�� ȸ���ּ�
	Pro_fileSns			varchar2(255), -- ����� sns url
	--������Ʈ ����� ������ ���� �Է½� �ʿ� �÷�
	
	Pro_Bank		varchar2(40), -- �Ŀ� �޼��� �Աݹ��� �����
	Pro_Account		varchar2(50)	, 	  -- �Ŀ� �޼��� �Աݹ��� ���¸�
	--������Ʈ ���� ���� �Է½� �ʿ� �÷�
	
	Su_Count		integer default '0', -- ���� ������Ʈ�� �Ŀ����� ��
				
	Now_Amount		integer default '0'--������� �Ŀ��� �ݾ�
);

drop sequence project_seq;
create sequence project_seq
	start with 1
	increment by 1
	nocycle
	nocache;



alter table project ADD(pro_link varchar2(255));
alter table project ADD(pro_sns varchar2(255));
alter table project MODIFY (Pro_Content long);


desc project;
insert into project
(pro_No,m_id,pro_title,pro_thumbnail,pro_catagory,pro_start,pro_end,pro_goal,
su_count)
values (project_seq.nextval,'test2','dreamup','�ھ˶�.jpg','����',
	sysdate,sysdate,2000000,200);


select * from member;
update project set now_amount=2000

	
select pro_no, now_amount from project where pro_no =54;
delete from project where pro_no = 51;
select re_no from reward where pro_no = 51;
delete from reward where re_no =32;
select * from reward where re_no = 34;

select * from support where re_no =34;

delete from support where re_no = (select re_no from reward where pro_no =51 );

alter table project drop (pro_image)	
ALTER TABLE TABLE_NAME  DROP(columnName );

select * from project where pro_no = 53;

select (now_amount/pro_goal)*100 as goal from project where pro_no = #pro_no#
select (pro_end - pro_start) from project

select pro_goal, pro_end, pro_thumbnail, pro_title, trunc((now_amount/pro_goal)*100) as goal, round(pro_end - pro_start)as duedate from project;
		select
		trunc((now_amount/pro_goal)*100) as progress, pro_goal, pro_end,
		pro_thumbnail, pro_title, round(pro_end - pro_start) as due_date
		,pro_no from project
		
		select now_amount, pro_goal from project
	
	select pro_video,su_count,now_amount,pro_goal,
		Pro_fileImage,Pro_fileIntro,Pro_fileSns,
		pro_content,Pro_image
		from
		project
		where pro_no=20
		
		
		select pro_no,pro_thumbnail,pro_title
		from project
		where upper(pro_title) like upper('%D%')
		
				update project set now_amount = 50000 where pro_no = 29
		select pro_no,pro_video,su_count,now_amount,pro_goal,
		Pro_fileImage,Pro_fileIntro,Pro_fileSns
		from
		project
		where pro_no=4
		
		select
		trunc((now_amount/pro_goal)*100) as progress, pro_goal, pro_end,
		pro_thumbnail, pro_title, round(pro_end - pro_start) as due_date
		,pro_no,su_count from project where m_id = 'kancho33' and pro_state = 1
		
		
		
		select * from project where pro_no = 59
		select * from support
		
		select *
		from project
		where pro_no = (select pro_no from support where m_id = 'kancho33')
		
		