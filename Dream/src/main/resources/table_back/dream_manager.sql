
-- 관리자
DROP TABLE Dream_Manager ;

-- 관리자
CREATE TABLE Dream_Manager (
	Manager_No    INTEGER       NOT NULL, -- 관리자 번호
	Manager_Mail  VARCHAR2(40)  primary key, -- 관리자 이메일
	Manager_Pass  VARCHAR2(100) NOT NULL,
	Manager_Grade VARCHAR2(10)  DEFAULT 'GM', -- 관리자 등급
	Active_Date	  TIMESTAMP	    NOT NULL
);

-- 관리자
ALTER TABLE Dream_Manager
	ADD CONSTRAINT Manager_Grade -- 관리자 등급 제약 사항
		CHECK (Manager_Grade in ('GM' ,'CM'));

drop sequence dream_manager_seq;
create sequence dream_manager_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	

	
insert into dream_manager (manager_no, manager_mail, manager_pass, manager_grade, active_date) 
					values (dream_manager_seq.nextval, 'admin@dream.com', '0000', 'CM', sysdate)