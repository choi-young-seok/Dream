-- 회원
CREATE TABLE Dream_Member (
	Member_No             INTEGER       NOT NULL, -- 회원 번호
	Member_Mail           VARCHAR2(40)  NOT NULL, -- 회원 이메일
	Mmeber_Pass           VARCHAR2(100) NOT NULL, -- 회원 비밀번호
	Member_Name           VARCHAR2(30)  NOT NULL, -- 회원 이름
	Member_Birth          VARCHAR2(16)  NOT NULL, -- 회원 생년월일
	Member_Gender         VARCHAR2(6)   NOT NULL, -- 회원 성별
	Member_Regdate        TIMESTAMP     DEFAULT sysdate, -- 회원 가입 일자
	Member_Profile_image  VARCHAR2(300) DEFAULT 'NO PROFILE', -- 회원 프로필 사진 파일 이름
	Member_Stop_State     VARCHAR2(2)   DEFAULT 'F', -- 회원 정지 여부
	Member_Withdraw_State VARCHAR2(2)   DEFAULT 'F' -- 회원 탈퇴 여부
);

-- 회원
ALTER TABLE Dream_Member
	ADD CONSTRAINT PK_Member -- 회원 기본키
		PRIMARY KEY (
			Member_No -- 회원 번호
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
		
		
DROP SEQUENCE dream_member_seq;
CREATE SEQUENCE dream_member_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;
