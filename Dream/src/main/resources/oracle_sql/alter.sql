* �������� �߰�
 
   alter table ���̺�� add primary key(�߰��� �⺻Ű �÷�);
   alter table ���̺�� add unique(�߰��� ����ũ �÷�);
   alter table ���̺�� add foreign key(�߰��� �ܷ�Ű �÷�) references �θ� ���̺�(�߰��� �ܷ�Ű �÷�);  => �ڿ��� �θ� table
   alter table ���̺�� modify ������ �÷��� not null;
   alter table ���̺�� add constraint dept01_deptno_pk primary key(deptno); 
