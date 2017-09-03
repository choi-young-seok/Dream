-- 후원(결제)
CREATE TABLE Dream_Support (
	Member_No          INTEGER       NOT NULL, -- 후원 회원 번호
	Project_No         INTEGER       NOT NULL, -- 프로젝트 번호
	Support_No         INTEGER       NOT NULL, -- 후원 번호
	Member_Name        VARCHAR2(30)  NOT NULL, -- 후원자 이름 (입금자 이름)
	Pay_Method         VARCHAR2(30)  NOT NULL, -- 결제 방법
	Pay_Account_Number VARCHAR2(300) NOT NULL, -- 결제 카드 번호 or 입금계좌
	Support_Amount     INTEGER       NOT NULL, -- 후원 금액
	Support_Date       TIMESTAMP     DEFAULT sysdate, -- 후원 일자
	Payback_Check      VARCHAR2(2)   DEFAULT 'N' -- 환불 여부
);

-- 후원(결제)
ALTER TABLE Dream_Support
	ADD CONSTRAINT PK_Support -- 후원(결제) 기본키
		PRIMARY KEY (
			Member_No,  -- 후원 회원 번호
			Project_No, -- 프로젝트 번호
			Support_No  -- 후원 번호
		);

-- 후원(결제)
ALTER TABLE Dream_Support
	ADD CONSTRAINT FK_Project_TO_Support -- 프로젝트 -> 후원(결제)
		FOREIGN KEY (
			Member_No,  -- 후원 회원 번호
			Project_No  -- 프로젝트 번호
		)
		REFERENCES Dream_Project ( -- 프로젝트
			Member_No,  -- 등록 회원 번호
			Project_No  -- 프로젝트 번호
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_support_seq;
CREATE SEQUENCE dream_support_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;