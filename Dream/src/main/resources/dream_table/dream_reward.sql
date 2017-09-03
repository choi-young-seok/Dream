-- 리워드
CREATE TABLE Dream_Reward (
	Member_No               INTEGER       NOT NULL, -- 회원 번호
	Project_No              INTEGER       NOT NULL, -- 프로젝트 번호
	Total_Reward_No         INTEGER       NOT NULL, -- 전체 리워드 번호
	Reward_No               INTEGER       NOT NULL, -- 프로젝트 리워드 번호(상품 번호)
	Reward_Items            VARCHAR2(300) NOT NULL, -- 리워드 품목
	Reward_Explain          VARCHAR2(300) NOT NULL, -- 리워드 상품설명
	Reward_Delivery_Date    TIMESTAMP     NOT NULL, -- 배송 예정일
	Reward_Limited_Count    INTEGER       NOT NULL, -- 리워드 한정수량
	Reward_Amount           INTEGER       NOT NULL  -- 리워드 금액
);

-- 리워드
ALTER TABLE Dream_Reward
	ADD CONSTRAINT PK_Reward -- 리워드 기본키
		PRIMARY KEY (
			Member_No,       -- 회원 번호
			Project_No,      -- 프로젝트 번호
			Total_Reward_No  -- 전체 리워드 번호
		);

-- 리워드
ALTER TABLE Dream_Reward
	ADD CONSTRAINT FK_Project_TO_Reward -- 프로젝트 -> 리워드
		FOREIGN KEY (
			Member_No,  -- 회원 번호
			Project_No  -- 프로젝트 번호
		)
		REFERENCES Dream_Project ( -- 프로젝트
			Member_No,  -- 등록 회원 번호
			Project_No  -- 프로젝트 번호
		)
		ON DELETE CASCADE;
		
DROP SEQUENCE dream_reward_seq;
CREATE SEQUENCE dream_reward_seq
   START WITH 1
   INCREMENT BY 1
   NOCYCLE
   NOCACHE;