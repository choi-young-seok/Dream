-- 리워드
DROP TABLE Dream_Reward;

-- 리워드
CREATE TABLE Dream_Reward (
	Reward_No            INTEGER       NOT NULL, -- 리워드 번호
	Member_No          	 INTEGER       NOT NULL references dream_member(member_no), -- 등록자 이메일
	Project_No           INTEGER       NOT NULL references dream_project(project_no), -- 프로젝트 번호
	Reward_Title         VARCHAR2(300) NOT NULL, -- 리워드 타이틀
	Reward_Items         VARCHAR2(300) NOT NULL, -- 리워드 품목
	Reward_Delivery_Date DATE          NOT NULL, -- 배송 예정일
	Reward_Limited_Count INTEGER       NOT NULL, -- 리워드 한정수량
	Reward_Amount        INTEGER       NOT NULL  -- 리워드 금액
);

-- 리워드 sequence
drop SEQUENCE dream_reward_seq;
create SEQUENCE dream_reward_seq
   start with 1
   increment by 1
   nocycle
   nocache;