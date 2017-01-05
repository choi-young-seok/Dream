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
	-- 환불 및 회원 정비 발생시 변경 되는 컬럼 (UPDATE)
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