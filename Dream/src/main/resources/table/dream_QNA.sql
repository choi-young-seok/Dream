
   
-- ���� �Խ���
DROP TABLE Dream_QNA;

-- ���� �Խ���
CREATE TABLE Dream_QNA (
	QNA_No       INTEGER       primary key, -- ���� ��ȣ
	Manager_Mail VARCHAR2(40)  REFERENCES Dream_Manager(Manager_Mail), -- ������ �̸���
	Member_Mail  VARCHAR2(40)  NOT NULL REFERENCES Dream_Member(Member_Mail), -- ȸ�� �̸���
	Member_Name  VARCHAR2(50)  NOT NULL, -- �ۼ���
	QNA_Title    VARCHAR2(300) NOT NULL, -- ���� ����
	QNA_Content     LONG      NOT NULL, -- ���� ����
	QNA_Regdate  DATE          DEFAULT sysdate, -- ���� �ۼ�����
	QNA_Check    VARCHAR2(10)  DEFAULT 'T' -- ���� Ȯ�� ����
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
   (dream_qna_seq.nextval, 'admin@dream.com', 'test@naver.com', '�ֿ뼮',
   'qna ���� �׽�Ʈ', 'qna ���� �׽�Ʈ')

   insert into dream_qna 
   (qna_no,  Member_Mail, Member_Name, 
   QNA_Title, QNA_Content)
   values
   (dream_qna_seq.nextval,  'test@naver.com', '�ֿ뼮',
   'qna ���� �׽�Ʈ', 'qna ���� �׽�Ʈ')
   
   select * from dream_qna