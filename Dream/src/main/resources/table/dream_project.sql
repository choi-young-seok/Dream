-- 후원을 위한 프로젝트 임시테이블 

-- user
DROP TABLE Dream_Project;

-- user
CREATE TABLE Dream_Project (
	Member_No				INTEGER  	  references dream_member(Member_No), -- 등록자 번호
	Project_No             	INTEGER       primary key, -- 프로젝트 번호
	Project_Thumbnail       VARCHAR2(300) NOT NULL, -- 프로젝트 썸네일 
	Project_Title           VARCHAR2(60)  NOT NULL, -- 프로젝트 타이틀	 (한글/영문 : 20/30)	
	Project_Summary         VARCHAR2(600) NOT NULL, -- 프로젝트 요약 설명 (한글/영문 : 200/300)
	Project_Category        VARCHAR2(30)  NOT NULL, -- 프로젝트 카테고리
	Project_Start_Date      DATE          DEFAULT sysdate, -- 프로젝트 시작일자
	Project_End_Date        DATE          NOT NULL, -- 프로젝트 종료일자
	Project_Goal_Amount     INTEGER       NOT NULL, -- 프로젝트 목표금액
	-- 프로젝트 기본 정보 
		
	Project_Video          	VARCHAR2(300) DEFAULT 'NO VIDEO', -- 프로젝트 영상
	Project_Content        	LONG, 							  -- 프로젝트 내용
	-- 프로젝트 스토리 정보
	
	Register_Profile		VARCHAR2(300) DEFAULT 'NO PROFILE',
	Register_Name			VARCHAR2(50),
	Register_intro		   	VARCHAR2(300),		   -- 등록자 소개
	Register_Sns			VARCHAR2(300),		   -- 등록자 SNS 주소	 (한글/영문 : 100/150)
	-- 등록자 프로필 정보
	
	Register_Address		VARCHAR2(300) DEFAULT 'NO ADDRESS',		   -- 등록자 주소			 (한글/영문 : 100/150)
	Project_Account		   	INTEGER		  DEFAULT 0, -- 프로젝트 계좌
	Access_Terms_Agree		VARCHAR2(10)  DEFAULT 'F', -- 이용약관 동의
	-- 프로젝트 계좌 정보
	
	Project_ViewCnt		   	INTEGER		  DEFAULT 0,	-- 현재 조회 수
	Now_Amount             	INTEGER       DEFAULT 0, -- 현재 후원 총액
	Supporting_Count       	INTEGER       DEFAULT 0, -- 현재 후원 수
	Project_Register_State 	VARCHAR2(10)  DEFAULT 'F', -- 프로젝트 등록여부 (T = 등록완료, F = 등록중)
	Project_Success_State  	VARCHAR2(10)  DEFAULT 'F' -- 프로젝트 성공여부 (T = 후원완료, T = 후원실패)
	-- 기간 이내 달성 여부 컬럼과 기간 만료후 최종 달성여부 칼람이 독립적으로 존재해야할듯
);
-- alter table dream_project add Projcet_ViewCnt INTEGER DEFAULT 0 (추가완료)
-- alter table dream_project add Register_Profile VARCHAR2(300) DEFAULT 'NO VALUE' (추가완료)
-- alter table dream_project add Register_Name VARCHAR2(50)(추가완료)

-- users
ALTER TABLE Dream_Project
	ADD CONSTRAINT Project_Register_State -- 프로젝트 등록여부
		CHECK (Project_Register_State in ('T' ,'F'));

-- user
ALTER TABLE Dream_Project
	ADD CONSTRAINT Project_Success_State -- 프로젝트 성공여부
		CHECK (Project_Success_State in ('T' ,'F'));
	
drop sequence dream_project_seq;
create sequence dream_project_seq
	start with 1
	increment by 1
	nocycle
	nocache;

		--요기까지 복붙
		
	alter table add member_mail varchar2(40) references dream_member(member_mail)
-- 더미데이터
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date,Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample.jpg','하우스 칵테일 저널','하우스 칵테일에 관한 저널 정보를 제공합니다.!', 110411833284,
	'데이터 스트림 마이닝 기술은 실시간으로 발생하는 데이터를 분석하여 유용한 정보를 얻는 기술이다. 데이터 스트림 마이닝 기술 중에서 빈발항목 마이닝은 전송되는 데이터들 중에서 어떤 항목이 빈발한지 찾는 기술이며, 찾은 빈발 항목들은 다양한 분야에서 패턴분석이나 마케팅의 목적으로 사용된다. 기존에 제안된 데이터 스트림 빈발항목 마이닝은 악의적인 공격자가 전송되는 데이터를 스니핑할 경우 데이터 제공자의 실시간 정보가 노출되는 문제점을 가지고 있다. 이러한 문제는 전송되는 데이터에서 원본 데이터를 구별 못하게 하는 더미 데이터 삽입 기법을 통해 해결가능하다. 본 논문에서는 더미 데이터 삽입 기법을 이용한 프라이버시 보존 데이터 스트림 빈발항목 마이닝 기법을 제안한다. 또한, 제안하는 기법은 암호화 기법이나 다른 수학적 연산이 요구되지 않아 연산량 측면에서 효과적이다.',
	'영상주소','컴퓨터 공학',1000000,sysdate,sysdate+50,'T');
	
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date, Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample2.jpg','디스코팡팡 레코드팡팡','디스코 팡팡! 신나는 음악과 함께 하세요!', 110411833284,
	'데이터 스트림 마이닝 기술은 실시간으로 발생하는 데이터를 분석하여 유용한 정보를 얻는 기술이다. 데이터 스트림 마이닝 기술 중에서 빈발항목 마이닝은 전송되는 데이터들 중에서 어떤 항목이 빈발한지 찾는 기술이며, 찾은 빈발 항목들은 다양한 분야에서 패턴분석이나 마케팅의 목적으로 사용된다. 기존에 제안된 데이터 스트림 빈발항목 마이닝은 악의적인 공격자가 전송되는 데이터를 스니핑할 경우 데이터 제공자의 실시간 정보가 노출되는 문제점을 가지고 있다. 이러한 문제는 전송되는 데이터에서 원본 데이터를 구별 못하게 하는 더미 데이터 삽입 기법을 통해 해결가능하다. 본 논문에서는 더미 데이터 삽입 기법을 이용한 프라이버시 보존 데이터 스트림 빈발항목 마이닝 기법을 제안한다. 또한, 제안하는 기법은 암호화 기법이나 다른 수학적 연산이 요구되지 않아 연산량 측면에서 효과적이다.',
	'영상주소','음악',1000000,sysdate,sysdate+50,'T');
	
	insert into Dream_Project 
	(member_no, Project_No, Project_Thumbnail, Project_Title, Project_Summary, Project_Account,
	Project_Content, Project_Video,
	Project_Category,Project_Goal_Amount,Project_Start_Date,Project_End_Date,Project_Register_state) 
	values(1,dream_project_seq.nextval,'resources/img/ThumnailSample3.jpg','A LITTLE LESS DESPERATION','THERE IS NO INTERESTED GAME IN THIS WEBSITE COME WITH ME!', 110411833284,
	'데이터 스트림 마이닝 기술은 실시간으로 발생하는 데이터를 분석하여 유용한 정보를 얻는 기술이다. 데이터 스트림 마이닝 기술 중에서 빈발항목 마이닝은 전송되는 데이터들 중에서 어떤 항목이 빈발한지 찾는 기술이며, 찾은 빈발 항목들은 다양한 분야에서 패턴분석이나 마케팅의 목적으로 사용된다. 기존에 제안된 데이터 스트림 빈발항목 마이닝은 악의적인 공격자가 전송되는 데이터를 스니핑할 경우 데이터 제공자의 실시간 정보가 노출되는 문제점을 가지고 있다. 이러한 문제는 전송되는 데이터에서 원본 데이터를 구별 못하게 하는 더미 데이터 삽입 기법을 통해 해결가능하다. 본 논문에서는 더미 데이터 삽입 기법을 이용한 프라이버시 보존 데이터 스트림 빈발항목 마이닝 기법을 제안한다. 또한, 제안하는 기법은 암호화 기법이나 다른 수학적 연산이 요구되지 않아 연산량 측면에서 효과적이다.',
	'영상주소','게임',1000000,sysdate,sysdate+50,'T');

--더미데이터
select * from dream_project
DELETE FROM DREAM_PROJECT where project_no = 1

drop table project;
create table project(
	Pro_No			integer		primary key,		
	M_Id			varchar2(20) 	not null references member(M_id),
	Pro_Thumbnail	varchar2(2000)	not null, -- 썸네일 이미지 url
	Pro_Title		varchar2(300)	not null, -- 프로젝트 타이틀
	Pro_Catagory	varchar2(50)	not null, -- 프로젝트 카테고리
	Pro_Start		date			not null, -- 프로젝트 시작일(sysdate)
	Pro_End			date			not null, -- 프로젝트 끝일(sysdate+a)
	Pro_Goal		integer			not null, -- 프로젝트 목표금액
	Pro_state		integer 	default '0',
	--Pro_state
	--0 : 현재 등록중
	--1 : 등록 완료 & 후원 진행중
	--2 : 후원 기간 마감		
	--프로젝트 기본 정보 입력시 필요 컬럼
	
	Pro_Video		varchar2(2000), -- 프로젝트 비디오 url
	Pro_Content		long, -- 프로젝트 소개 내용
	Pro_link		varchar2(2000), -- 프로젝트 관련 링크 url
 	--프로젝트 스토리 정보 입력시 필요 컬럼
	
	Pro_fileImage	varchar2(2000), -- 등록자 사진url
	Pro_fileIntro 		varchar2(2000), --등록자 소개 정보 (lontext로 자료형 변환 할것
	Pro_zip             varchar2(2000),
	Pro_address			varchar2(255), --프로필등록 회사주소
	Pro_fileSns			varchar2(255), -- 등록자 sns url
	--프로젝트 등록자 프로필 정보 입력시 필요 컬럼
	
	Pro_Bank		varchar2(40), -- 후원 달성시 입금받을 은행명
	Pro_Account		varchar2(50)	, 	  -- 후원 달성시 입금받을 계좌명
	--프로젝트 계좌 정보 입력시 필요 컬럼
	
	Su_Count		integer default '0', -- 현재 프로젝트가 후원받은 수
				
	Now_Amount		integer default '0'--현재까지 후원된 금액
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
values (project_seq.nextval,'test2','dreamup','코알라.jpg','음악',
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
		
		