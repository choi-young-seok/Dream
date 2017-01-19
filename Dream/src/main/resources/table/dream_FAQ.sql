
-- ���� �Խ���
DROP TABLE Dream_QNA;

-- ���� �Խ���
CREATE TABLE Dream_QNA (
	QNA_No       INTEGER       primary key, -- ���� ��ȣ
	Manager_Mail VARCHAR2(40)  NOT NULL REFERENCES Dream_Manager(Manager_Mail), -- ������ �̸���
	Member_Mail  VARCHAR2(40)  NOT NULL, -- ȸ�� �̸���
	Member_Name  VARCHAR2(50)  NOT NULL, -- �ۼ���
	QNA_Title    VARCHAR2(300) NOT NULL, -- ���� ����
	QNA_Text     LONG      NOT NULL, -- ���� ����
	QNA_Category VARCHAR2(30)  NOT NULL, -- ���� ī�װ�
	QNA_Regdate  DATE          DEFAULT sysdate, -- ���� �ۼ�����
	QNA_Check    VARCHAR2(10)  DEFAULT 'T' -- ���� Ȯ�� ����
);

drop sequence dream_qna_seq;
create sequence dream_qna_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   