-- �Ŀ��� ���� ������Ʈ �ӽ����̺� 

-- user
DROP TABLE Dream_Project;

-- user
CREATE TABLE Dream_Project (
	Project_No             INTEGER       primary key, -- ������Ʈ ��ȣ
	Project_Thumbnail      VARCHAR2(300) NOT NULL, -- ������Ʈ �����
	Project_Title          VARCHAR2(50)  NOT NULL, -- ������Ʈ Ÿ��Ʋ
	Project_Content        LONG          NOT NULL, -- ������Ʈ ����
	Project_Video          VARCHAR2(300) NOT NULL, -- ������Ʈ ����
	Project_Catagory       VARCHAR2(30)  NOT NULL, -- ������Ʈ ī�װ�
	Project_GoalAmount     INTEGER       NOT NULL, -- ������Ʈ ��ǥ�ݾ�
	Project_EndDate        DATE          NOT NULL, -- ������Ʈ ��������
	Project_StartDate      DATE          DEFAULT sysdate, -- ������Ʈ ��������
	Now_Amount             INTEGER       DEFAULT 0, -- ���� �Ŀ��Ѿ�
	Supporting_Count       INTEGER       DEFAULT 0, -- ���� �Ŀ���
	Project_Register_State VARCHAR2(10)  DEFAULT 'F', -- ������Ʈ ��Ͽ���
	Project_Success_State  VARCHAR2(10)  DEFAULT 'F' -- ������Ʈ ��������
);

select * from dream_project
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
-- ���̵�����
	insert into Dream_Project (Project_No,Project_Thumbnail,Project_Title,Project_Content,Project_Video,
	Project_Catagory,Project_GoalAmount,Project_StartDate,Project_EndDate) 
	values(dream_project_seq.nextval,'resources/img/ThumnailSample.jpg','�Ͽ콺 Ĭ���� ����',
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','��ǻ�� ����',1000000,sysdate,sysdate+50);
	
	insert into Dream_Project (Project_No,Project_Thumbnail,Project_Title,Project_Content,Project_Video,
	Project_Catagory,Project_GoalAmount,Project_StartDate,Project_EndDate) 
	values(dream_project_seq.nextval,'resources/img/ThumnailSample2.jpg','�������� ���ڵ�����',
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','����',2000000,sysdate,sysdate+40);
	
	insert into Dream_Project (Project_No,Project_Thumbnail,Project_Title,Project_Content,Project_Video,
	Project_Catagory,Project_GoalAmount,Project_StartDate,Project_EndDate) 
	values(dream_project_seq.nextval,'resources/img/ThumnailSample3.jpg','A LITTLE LESS DESPERATION',
	'������ ��Ʈ�� ���̴� ����� �ǽð����� �߻��ϴ� �����͸� �м��Ͽ� ������ ������ ��� ����̴�. ������ ��Ʈ�� ���̴� ��� �߿��� ����׸� ���̴��� ���۵Ǵ� �����͵� �߿��� � �׸��� ������� ã�� ����̸�, ã�� ��� �׸���� �پ��� �о߿��� ���Ϻм��̳� �������� �������� ���ȴ�. ������ ���ȵ� ������ ��Ʈ�� ����׸� ���̴��� �������� �����ڰ� ���۵Ǵ� �����͸� �������� ��� ������ �������� �ǽð� ������ ����Ǵ� �������� ������ �ִ�. �̷��� ������ ���۵Ǵ� �����Ϳ��� ���� �����͸� ���� ���ϰ� �ϴ� ���� ������ ���� ����� ���� �ذᰡ���ϴ�. �� �������� ���� ������ ���� ����� �̿��� �����̹��� ���� ������ ��Ʈ�� ����׸� ���̴� ����� �����Ѵ�. ����, �����ϴ� ����� ��ȣȭ ����̳� �ٸ� ������ ������ �䱸���� �ʾ� ���귮 ���鿡�� ȿ�����̴�.',
	'�����ּ�','����',3000000,sysdate,sysdate+30);

--���̵�����


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
		
		