-- 회원주소
CREATE TABLE Dream_Member_Address (
	Member_No               INTEGER       NOT NULL, -- 회원 번호
	Address_Member_No       INTEGER       NOT NULL, -- 주소지 번호
	Address_Member_Name     VARCHAR2(30)  NOT NULL, -- 주소지 회원 이름
	Address_Ailais          VARCHAR2(30)  NOT NULL, -- 주소지 별칭
	Member_Address_zip_code INTEGER    	  NOT NULL, -- 주소지 우편번호
	Member_Address          VARCHAR2(200) NOT NULL, -- 주소지 법정명 주소
	Member_Detail_Address   VARCHAR2(200) NOT NULL, -- 주소지 상세 주소
	Address_Member_Phone    VARCHAR2(30)  NOT NULL,  -- 주소지 연락처
	Delivery_Address        VARCHAR2(20) 
);

-- 회원주소
ALTER TABLE Dream_Member_Address
	ADD CONSTRAINT PK_Member_Address -- 회원주소 기본키
		PRIMARY KEY (
			Member_No,         -- 회원 번호
			Address_Member_No  -- 주소지 번호
		);

-- 회원주소
ALTER TABLE Dream_Member_Address
	ADD CONSTRAINT FK_Member_TO_Member_Address -- 회원 -> 회원주소
		FOREIGN KEY (
			Member_No -- 회원 번호
		)
		REFERENCES Dream_Member ( -- 회원
			Member_No -- 회원 번호
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_address_seq;
CREATE SEQUENCE dream_address_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;