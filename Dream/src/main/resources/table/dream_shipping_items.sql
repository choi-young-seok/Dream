-- 새 테이블7
CREATE TABLE Dream_Shipping_Items (
	Project_No          INTEGER       references dream_project(project_no), -- 프로젝트 번호
	Support_No          INTEGER       references dream_support(support_no), -- 후원 번호
	Shipping_Address_No INTEGER       references dream_shipping_address(Shipping_Address_No), -- 송장번호
	Total_Reward_No     INTEGER       references dream_reward(reward_no), -- 전체 리워드 번호(결제품목)
	Member_No           INTEGER       references dream_member(member_no) -- 회원 번호
);


CREATE TABLE Dream_Shipping_Items (
	Shipping_Address_No INTEGER NOT NULL, -- 송장번호
	Member_No           INTEGER NOT NULL, -- 회원 번호
	Support_No          INTEGER NOT NULL, -- 후원 번호
	Project_No          INTEGER NOT NULL, -- 프로젝트 번호
	Total_Reward_No     INTEGER NOT NULL  -- 전체 리워드 번호(결제품목)
);

-- 새 테이블7
ALTER TABLE Dream_Shipping_Items
	ADD CONSTRAINT PK_Dream_Shipping_Items -- 새 테이블7 기본키
		PRIMARY KEY (
			Shipping_Address_No, -- 송장번호
			Member_No,           -- 회원 번호
			Support_No,          -- 후원 번호
			Project_No,          -- 프로젝트 번호
			Total_Reward_No      -- 전체 리워드 번호(결제품목)
		);

-- 새 테이블7
ALTER TABLE Dream_Shipping_Items
	ADD CONSTRAINT FK_Dream_Shipping_Address_TO_Dream_Shipping_Items -- 배송주소지 -> 새 테이블7
		FOREIGN KEY (
			Shipping_Address_No -- 송장번호
		)
		REFERENCES MY_SCHEMA.Dream_Shipping_Address ( -- 배송주소지
			Shipping_Address_No -- 송장번호
		);

-- 새 테이블7
ALTER TABLE MY_SCHEMA.Dream_Shipping_Items
	ADD CONSTRAINT FK_Dream_Support_TO_Dream_Shipping_Items -- 후원(결제) -> 새 테이블7
		FOREIGN KEY (
			Member_No,       -- 회원 번호
			Project_No,      -- 프로젝트 번호
			Total_Reward_No, -- 전체 리워드 번호(결제품목)
			Support_No       -- 후원 번호
		)
		REFERENCES MY_SCHEMA.Dream_Support ( -- 후원(결제)
			Member_No,       -- 회원 번호
			Project_No,      -- 프로젝트 번호
			Total_Reward_No, -- 전체 리워드 번호(결제품목)
			Support_No       -- 후원 번호
		);