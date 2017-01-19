
-- 包府磊
DROP TABLE Dream_Manager ;

-- 包府磊
CREATE TABLE Dream_Manager (
	Manager_No    INTEGER      NOT NULL, -- 包府磊 锅龋
	Manager_Mail  VARCHAR2(40) primary key, -- 包府磊 捞皋老
	Manager_Grade VARCHAR2(10) DEFAULT 'GM', -- 包府磊 殿鞭
	Active_Date	  TIMESTAMP	   NOT NULL
);

drop sequence dream_manager_seq;
create sequence dream_manager_seq
	start with 1
	increment by 1
	nocycle
	nocache;
