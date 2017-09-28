DROP TABLE DREAM_DELIVERY;
-- 배송주소지
CREATE TABLE Dream_Delivery (
	Project_No             INTEGER       NOT NULL, -- 프로젝트 번호
	Support_No             INTEGER       NOT NULL, -- 후원 번호
	Delivery_Address_No    INTEGER       NOT NULL, -- 송장번호
	Total_Reward_NO		   INTEGER       NOT NULL, -- 결제 품목 번호
	Member_No			   INTEGER		 NOT NULL, -- 후원 회원 번호
	
	Sender_Name            VARCHAR2(30)  NOT NULL, -- 발송자 이름
	Sender_Zip_Code        INTEGER       NOT NULL,     -- 발송지 우편번호
	Sender_Address         VARCHAR2(200) NOT NULL, -- 발송지 주소
	Sender_Detail_Address  VARCHAR2(200) NOT NULL,     -- 발송지 상세주소
	Sender_Phone           VARCHAR2(30)  NOT NULL, -- 발송자연락처
	
	Receiver_Name          VARCHAR2(30)  NOT NULL, -- 수령자 이름
	Receiver_Address_Alias VARCHAR2(30)  NOT NULL,     -- 수령지 별칭
	Receiver_Phone         VARCHAR2(30)  NOT NULL, -- 수령자 연락처
	Receiver_Zip_Code      INTEGER       NOT NULL, -- 배송지 우편번호
	Receiver_Address       VARCHAR2(200) NOT NULL, -- 배송지 주소
	Receiver_Detail_Address VARCHAR2(200) NOT NULL, -- 배송지 상세주소
	Shipping_Check         VARCHAR2(30)  DEFAULT 'F'  -- 배송여부
);

-- 배송주소지
ALTER TABLE Dream_Delivery
	ADD CONSTRAINT PK_Delivery -- 배송주소지 기본키
		PRIMARY KEY (
			Project_No,          -- 프로젝트 번호
			Support_No,          -- 후원 번호
			Delivery_Address_No  -- 송장번호
		);

-- 배송주소지
ALTER TABLE Dream_Delivery
	ADD CONSTRAINT FK_Support_TO_Delivery -- 후원(결제) -> 배송주소지
		FOREIGN KEY (
			Project_No, -- 후원 프로젝트 번호
			Support_No  -- 후원 번호
		)
		REFERENCES Dream_Support ( -- 후원(결제)
			Project_No, -- 후원 프로젝트 번호
			Support_No  -- 후원 번호
		);
		
		
DROP SEQUENCE dream_delivery_seq;
CREATE SEQUENCE dream_delivery_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;		