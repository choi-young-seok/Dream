
-- ������
DROP TABLE Dream_Manager ;

-- ������
CREATE TABLE Dream_Manager (
	Manager_No    INTEGER      NOT NULL, -- ������ ��ȣ
	Manager_Mail  VARCHAR2(40) primary key, -- ������ �̸���
	Manager_Grade VARCHAR2(10) DEFAULT 'GM', -- ������ ���
	Active_Date	  TIMESTAMP	   NOT NULL
);

drop sequence dream_manager_seq;
create sequence dream_manager_seq
	start with 1
	increment by 1
	nocycle
	nocache;
