* �������� �߰�
 
   alter table ���̺�� add primary key(�߰��� �⺻Ű �÷�);
   alter table ���̺�� add unique(�߰��� ����ũ �÷�);
   alter table ���̺�� add foreign key(�߰��� �ܷ�Ű �÷�) references �θ� ���̺�(�߰��� �ܷ�Ű �÷�);  => �ڿ��� �θ� table
   alter table ���̺�� modify ������ �÷��� not null;
   alter table ���̺�� add constraint dept01_deptno_pk primary key(deptno); 

   
   alter table dream_member modify member_profile varchar2(255) default 'NO PROFILE' 
   
   select * from dream_member where member_name = '����'
   
   update dream_member set member_profile ='NO PROFILE'