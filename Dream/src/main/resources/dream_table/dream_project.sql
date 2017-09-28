DROP TABLE DREAM_PROJECT;
-- 프로젝트
CREATE TABLE Dream_Project (
	Member_No                INTEGER       NOT NULL, -- 등록 회원 번호
	Project_No               INTEGER       NOT NULL, -- 프로젝트 번호
	Address_Member_No		 INTEGER,				 -- 프로젝트 배송지 번호
	Project_Thumbnail        VARCHAR2(300) NOT NULL, -- 프로젝트 썸네일
	Project_Title            VARCHAR2(150) NOT NULL, -- 프로젝트 타이틀
	Project_Summary          VARCHAR2(300) NOT NULL, -- 프로젝트 소개
	Project_Category         VARCHAR2(30)  NOT NULL, -- 프로젝트 카테고리
	Project_Goal_Amount      INTEGER       NOT NULL, -- 프로젝트 목표금액
	Now_Amount				 INTEGER	   DEFAULT 0, -- 프로젝트 현재 후원금액
	Project_Start_Date       DATE     	   DEFAULT sysdate, -- 프로젝트 시작일자
	Project_End_Date         DATE     , -- 프로젝트 종료일자
	Project_Video_Type       VARCHAR2(15)  DEFAULT 'NO TYPE', -- 프로젝트 소개영상
	Project_Video            VARCHAR2(300) DEFAULT 'NO VIDEO', -- 프로젝트 소개영상
	Project_Content          LONG      , -- 프로젝트 상세내용
	Register_Name            VARCHAR2(30)  ,     -- 등록자 이름
	Register_Intro           VARCHAR2(300) ,     -- 등록자 소개
	Access_Terms_Agree       VARCHAR2(2)   DEFAULT 'F', -- 이용 약관 동의
	Project_Account		     VARCHAR2(15)  DEFAULT 0, -- 프로젝트 계좌번호
	Project_Account_Bank     VARCHAR2(30)  , -- 계좌 은행명
	Project_Support_Amount   INTEGER       DEFAULT 0, -- 현재 후원 총액
	Project_View_Count       INTEGER       DEFAULT 0, -- 현재 조회 수
	Supporting_Count 		 INTEGER       DEFAULT 0, -- 현재 후원 수
	Project_Register_State   VARCHAR2(2)   DEFAULT 'F', -- 프로젝트 등록여부
	Project_Success_State    VARCHAR2(2)   DEFAULT 'F' -- 프로젝트 성공여부
);

-- 프로젝트
ALTER TABLE Dream_Project
	ADD CONSTRAINT PK_Project -- 프로젝트 기본키
		PRIMARY KEY (
			Member_No,  -- 등록 회원 번호
			Project_No  -- 프로젝트 번호
		);

-- 프로젝트
ALTER TABLE Dream_Project
	ADD CONSTRAINT FK_Member_TO_Project -- 회원 -> 프로젝트
		FOREIGN KEY (
			Member_No -- 등록 회원 번호
		)
		REFERENCES Dream_Member ( -- 회원
			Member_No -- 회원 번호	
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_project_seq;
CREATE SEQUENCE dream_project_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;