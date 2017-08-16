
   
-- 질문 게시판
DROP TABLE Dream_QNA;

-- 질문 게시판
CREATE TABLE Dream_QNA (
	QNA_No       INTEGER       primary key, -- 질문 번호
	Manager_Mail VARCHAR2(40)  REFERENCES Dream_Manager(Manager_Mail), -- 관리자 이메일
	Member_Mail  VARCHAR2(40)  NOT NULL REFERENCES Dream_Member(Member_Mail), -- 회원 이메일
	Member_Name  VARCHAR2(50)  NOT NULL, -- 작성자
	QNA_Title    VARCHAR2(300) NOT NULL, -- 질문 제목
	QNA_Content     LONG      NOT NULL, -- 질문 내용
	QNA_Regdate  DATE          DEFAULT sysdate, -- 질문 작성일자
	QNA_Check    VARCHAR2(10)  DEFAULT 'T' -- 질문 확인 여부
);

drop sequence dream_qna_seq;
create sequence dream_qna_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
   
   insert into dream_qna 
   (qna_no, Manager_Mail, Member_Mail, Member_Name, 
   QNA_Title, QNA_Content)
   values
   (dream_qna_seq.nextval, 'admin@dream.com', 'test@naver.com', '최용석',
   'qna 제목 테스트', 'qna 내용 테스트')

   insert into dream_qna 
   (qna_no,  Member_Mail, Member_Name, 
   QNA_Title, QNA_Content)
   values
   (dream_qna_seq.nextval,  'test@naver.com', '최용석',
   'qna 제목 테스트', 'qna 내용 테스트')
   
   select * from dream_qna