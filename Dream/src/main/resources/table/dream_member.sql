-- exerd DDL구문 oracle에 적용할때 주의사항
	-- 1.NULL허용 구문 삭제
		-- ex)  Member_Total_Project_Count       INTEGER       		NULL,  			(X) : (NULL명시 -> mysql문법)
		-- ex2) Member_Total_Project_Count       INTEGER, 							(O)
	
	-- 2.default에 숫자가 아닌 문자일경우 ''안에 default값 설정
		-- ex)  Member_Stop_State                VARCHAR2(10)       DEFAULT F, 		(X) : (기본값에 해당하는 값의 자료형이 문자일경우 ''로 지정)
		-- ex2) Member_Stop_State                VARCHAR2(10)       DEFAULT 'F',	(O)
	
	-- 3.칼럼명은 30글자가 넘지 않을것
		-- ex)  Member_Processing_Project_State	 INTEGER,			(X) : (31글자 -> 30글자 이상은 컬럼생성 안됨)
		-- ex2) Member_Ongoing_Project_Count     INTEGER          	(O) : (28글자)
		
	-- 4.MY_SCHEMA.예약어 모두 지울것
		-- ex)  CREATE TABLE MY_SCHEMA.Dream_Member ();				(X) : (MY_SCHEMA.테이블명 -> mysql예약어)
		-- ex2) CREATE TABLE Dream_Member ();						(O)
	
	-- 5.exerd에서 autoincrement설정했다면 sequence로 대체할것
		-- ex)  autoincrement설정 -> mysql 문법
		-- ex2) orcle의 경우 sequence로 대체하여 사용

-- ↓↓ 2017/01/12 이후 회원 DB 스키마 (최신)
-- 회원 테이블 DDL 
-- 여기서부터 복붙
DROP TABLE Dream_Member;

-- 회원
CREATE TABLE Dream_Member (
	Member_No                       INTEGER       		NOT NULL, -- 회원 번호
	Member_Mail                     VARCHAR2(40)  		primary key, -- 회원 이메일
	Member_Pass                     VARCHAR2(100) 		NOT NULL, -- 회원 비밀번호
	Member_Name                     VARCHAR2(18)  		NOT NULL, -- 회원 이름
	Member_Birth                    VARCHAR2(16)  		NOT NULL, -- 회원 생년월일
	Member_Gender                   VARCHAR2(6)   		NOT NULL, -- 회원 성별
	Member_Regdate                  DATE            	DEFAULT sysdate, -- 회원 가입 일자
		    --회원가입시 입력 받는 컬럼 (INSERT)
	Member_Total_Project_Count      INTEGER       		DEFAULT 0,     -- 등록 프로젝트 수
	Member_Ongoing_Project_Count 	INTEGER            	DEFAULT 0, -- 진행중인 프로젝트 수
	Member_Supporting_Count         INTEGER            	DEFAULT 0, -- 해당 회원이 후원하는 프로젝트 수
	Member_Total_Supported_Count    INTEGER            	DEFAULT 0, -- 해당 회원의 전체 프로젝트 후원 수 합계
	Member_Stop_State               VARCHAR2(10)       	DEFAULT 'F', -- 회원 정지 여부
	Member_Withdraw_State           VARCHAR2(10)       	DEFAULT 'F', -- 회원 탈퇴 여부
		-- 회원가입시 default 처리 되는 컬럼
	Member_Profile					VARCHAR2(150)					-- 회원 프로필 사진
		-- 회원가입시 null 처리 되는 컬럼
);

-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Withdraw_State -- 회원 탈퇴 여부 항목 검사
		CHECK (Member_Withdraw_State in ('T' ,'F'));

-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Stop_State -- 회원 정지 여부 항목 검사
		CHECK (Member_Stop_State in ('T','F'));

-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Gender -- 회원 성별 항목 검사
		CHECK (Member_Gender in ('M' , 'F'));

-- 회원번호 sequence
drop SEQUENCE dream_member_seq;
create SEQUENCE dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;

  
-- 여기까지 복붙

-- ↓↓ 2017/01/04 이후 회원 DB 스키마    
   
-- 회원
DROP TABLE Dream_Member

-- 회원
CREATE TABLE Dream_Member (
	Member_No              INTEGER       primary key, -- 회원 번호
	Member_Email           VARCHAR2(40)  NOT NULL, -- 회원 이메일
	Mmeber_Pwd             VARCHAR2(100) NOT NULL, -- 회원 비밀번호
	Member_Name            VARCHAR2(18)  NOT NULL, -- 회원 이름
	Member_Birth           VARCHAR2(12)  NOT NULL, -- 회원 생년월일
	Member_Gender          VARCHAR2(6)   NOT NULL, -- 회원 성별
	Member_Regdate         DATE               		DEFAULT sysdate, -- 회원 가입 일자
	    --회원가입시 입력 받는 컬럼 (INSERT)
	Member_Withdraw_State  VARCHAR2(10)       		DEFAULT 'F', -- 회원 탈퇴 여부
	Member_Refund_Count    INTEGER            		DEFAULT 0, -- 회원 환불 횟수
	Member_Stop_State      VARCHAR2(10)       		DEFAULT 'F', -- 회원 정지 여부
	Member_Stop_Count      INTEGER            		DEFAULT 0, -- 회원 정지 횟수
	-- 회원가입시 default 처리 되는 컬럼
	Member_Stop_Date       DATE,			   -- 회원 정지 일자
	Member_Refund_LastDate DATE                -- 회원 마지막 환불 일자
	-- 환불 및 회원 정지 발생시 변경 되는 컬럼 (UPDATE)
);

-- 회원
ALTER TABLE Dream_Member 
	ADD CONSTRAINT Member_Withdraw_State -- 회원 탈퇴 여부 항목 검사
		CHECK (Member_Withdraw_State in ('T' ,'F'));


-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Stop_State -- 회원 정지 여부 항목 검사
		CHECK (Member_Stop_State in ('T','F'));

-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT Member_Gender -- 회원 성별 항목 검사
		CHECK (Member_Gender in ('M' , 'F'));

		
drop sequence dream_member_seq;
create sequence dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
-- ↓↓ 2017/01/04 이전 회원 DB 스키마    
drop table dream_member;
create table dream_member(
   member_No         	integer,               -- 멤버 번호         
   member_Id         	varchar2(30)    primary key, -- 멤버 아이디
   member_Password  	varchar2(150)   not null, -- 멤버 비밀번호
   member_Email         varchar2(150)   not null, -- 멤버 이메일 , 중복검사 할것
   member_Name         	varchar2(30)    not null, --멤버 이름
   member_Date         	date		    not null 	default sysdate, -- 가입일
    --회원가입시 입력 받는 컬럼 (INSERT)
    
   member_Phone         varchar2(13), --1.후원할때 or 2.프로젝트 등록시 입력
   member_Zip          	varchar2(13),
   member_Address     	varchar2(255), -- 1.후원할때 배송지 정보 or 2.프로젝트 등록시 주소정보 입력
   member_Post         	varchar2(20), -- 1.후원할때 배송지 정보 or 2.프로젝트 등록시 주소정보 입력
   
   member_BankName      varchar2(30), -- 환불시 은행명
   member_Account      	varchar2(20), -- 환불시 계좌번호
   --후원정보 입력시 입력 받는 컬럼 (UPDATE)
   
   member_SupportingCount     	integer		default '0', -- 내가 후원하는 프로젝트 수 총합계 (후원시 +1)
   member_SupportedCount      	integer		default '0', -- 내 프로젝트 총 후원합계 (환불시 -1)
   member_Withdraw				varchar2(10)	default 'F' check(member_Withdraw in ('T','F')) 
);

drop sequence dream_member_seq;
create sequence dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
   select * from dream_member;
   
