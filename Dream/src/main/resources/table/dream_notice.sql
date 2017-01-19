
-- 공지사항
DROP TABLE Dream_Notice ;

-- 공지사항
CREATE TABLE Dream_Notice (
	Notice_No      INTEGER       primary key, -- 공지사항 번호
	Manager_Mail   VARCHAR2(40)  NOT NULL REFERENCES Dream_Manager(Manager_Mail), -- 관리자 이메일
	Notice_Title   VARCHAR2(300) NOT NULL, -- 공지사항 제목
	Notice_Content LONG      	 NOT NULL, -- 공지사항 내용
	Notice_Regdate DATE          DEFAULT sysdate, -- 공지사항 작성일자
	Notice_Check   VARCHAR2(10)  DEFAULT 'T' -- 공지사항 노출여부
);

drop sequence dream_notice_seq;
create sequence dream_notice_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   