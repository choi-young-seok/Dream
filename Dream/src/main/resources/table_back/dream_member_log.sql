-- �� ���̺�
ALTER TABLE Dream_Member_Log
	DROP FOREIGN KEY FK_Dream_Member_TO_Dream_Member_Log; -- ȸ�� -> �� ���̺�

-- �� ���̺�
DROP TABLE Dream_Member_Log;

-- �� ���̺�
CREATE TABLE Dream_Member_Log (
	Member_No   INTEGER      NOT NULL references dream_member(member_no), -- ȸ�� ��ȣ
	Member_Mail VARCHAR2(40) NOT NULL , -- ȸ�� �̸���
	Login_Date  DATE         NOT NULL  -- �α��� �Ͻ�
);