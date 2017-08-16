
-- ��������
DROP TABLE Dream_Notice ;

-- ��������
CREATE TABLE Dream_Notice (
	Notice_No      INTEGER       primary key, -- �������� ��ȣ
	Manager_Mail   VARCHAR2(40)  NOT NULL REFERENCES Dream_Manager(Manager_Mail), -- ������ �̸���
	Notice_Title   VARCHAR2(300) NOT NULL, -- �������� ����
	Notice_Content LONG      	 NOT NULL, -- �������� ����
	Notice_Regdate DATE          DEFAULT sysdate, -- �������� �ۼ�����
	Notice_Check   VARCHAR2(10)  DEFAULT 'T' -- �������� ���⿩��
);

drop sequence dream_notice_seq;
create sequence dream_notice_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   