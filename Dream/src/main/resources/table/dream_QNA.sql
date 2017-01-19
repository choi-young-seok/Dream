

-- 자주 묻는 질문
DROP TABLE Dream_FAQ;
-- 자주 묻는 질문
CREATE TABLE Dream_FAQ (
	FAQ_No       INTEGER       primary key, -- 문의사항 번호
	Manager_Mail VARCHAR2(40)  NOT NULL REFERENCES Dream_manager(Manager_Mail), -- 관리자 이메일
	FAQ_Title    VARCHAR2(300) NOT NULL, -- 문의사항 제목
	FAQ_Text     LONGTEXT      NOT NULL, -- 문의사항 내용
	FAQ_Category VARCHAR2(30)  DEFAULT 'T' -- 문의사항 노출여부
);

drop sequence dream_faq_seq;
create sequence dream_faq_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   