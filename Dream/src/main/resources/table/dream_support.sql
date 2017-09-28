-- 후원(결제)
DROP TABLE Dream_Support;

-- 후원(결제)
CREATE TABLE Dream_Support (
	Member_No			INTEGER  	 	references dream_member(Member_No), -- 등록자 번호
	Project_No      	INTEGER  	 	references	dream_project(Project_No), -- 프로젝트 번호
	Support_No      	INTEGER     	primary key, -- 후원 번호
	Member_Name     	VARCHAR2(50) 	NOT NULL, -- 후원자 성명
	Pay_Method			VARCHAR2(200)	NOT NULL, -- 결제방법
	Pay_Account_Number 	VARCHAR2(200) 	NOT NULL, -- 결제 카드번호 OR 입금계좌번호
	Support_Amount   	INTEGER      	NOT NULL, -- 후원 금액
	Support_Date    	DATE         	DEFAULT sysdate, -- 후원 일자
	Payback_Check		VARCHAR2(30)	DEFAULT 'N' -- 환불여부
);

drop sequence dream_support_seq;
create sequence dream_support_seq
	start with 1
	increment by 1
	nocycle
	nocache;