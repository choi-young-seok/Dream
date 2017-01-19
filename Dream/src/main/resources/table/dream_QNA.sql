

-- ���� ���� ����
DROP TABLE Dream_FAQ;
-- ���� ���� ����
CREATE TABLE Dream_FAQ (
	FAQ_No       INTEGER       primary key, -- ���ǻ��� ��ȣ
	Manager_Mail VARCHAR2(40)  NOT NULL REFERENCES Dream_manager(Manager_Mail), -- ������ �̸���
	FAQ_Title    VARCHAR2(300) NOT NULL, -- ���ǻ��� ����
	FAQ_Text     LONGTEXT      NOT NULL, -- ���ǻ��� ����
	FAQ_Category VARCHAR2(30)  DEFAULT 'T' -- ���ǻ��� ���⿩��
);

drop sequence dream_faq_seq;
create sequence dream_faq_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   