


-- 배송주소지
CREATE TABLE dream_shipping_address (
	Shipping_Address_No INTEGER       PRIMARY KEY, -- 송장번호
	Support_No      	INTEGER  	  references	dream_support(Support_No), -- 프로젝트 번호
	Sender_Name         VARCHAR2(50)  NOT NULL, -- 발송자 이름
	Sender_Address      VARCHAR2(300) NOT NULL, -- 발송자 주소
	Sender_Phone        VARCHAR2(30)  NOT NULL, -- 발송자연락처
	Receiver_Name       VARCHAR2(50)  NOT NULL, -- 수령자 이름
	Receiver_Phone      VARCHAR2(30)  NOT NULL, -- 수령자 연락처
	Zip_Code            INTEGER       NOT NULL, -- 배송지 우편번호
	Receiver_Address    VARCHAR2(300) NOT NULL, -- 배송지 주소
	Detail_Address       VARCHAR2(300) NOT NULL, -- 배송지 상세주소
	Shipping_Check       VARCHAR2(30)  DEFAULT 'N'  -- 배송여부
);

drop sequence Dream_Shipping_Address_seq;
create sequence Dream_Shipping_Address_seq
	start with 1
	increment by 1
	nocycle
	nocache;