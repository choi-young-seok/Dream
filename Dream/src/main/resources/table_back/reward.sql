drop table reward;
create table reward(
	Re_No		integer			primary key,		
	Pro_No		integer		 	not null references project(Pro_No),
	Re_Money	integer			not null, -- 후원(서약) 금액
	Re_Title	varchar2(50)	not null, -- 리워드 타이틀
	Re_Item		varchar2(50)	not null, -- 리워트 아이템 목록
	Re_delivery date			not null, -- 배송 예정일
	Re_Limite	integer			 -- 리워드 한정수량
	--프로젝트 리워드 등록시 필요 컬럼
);

drop sequence reward_seq;
create sequence reward_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
alter table reward add colum re_delivery 

alter table reward ADD(re_delivery date not null);

select * from reward


select * from project

select * from reward where re_no=3

insert into reward
(Re_No,Pro_No,Re_Money,Re_Title,Re_Item,Re_delivery,Re_Limite)
values
(reward_seq.nextval,34,15000,'대밍이부시기','옥수수',to_date('16-11-23'),15);

insert into reward
(Re_No,Pro_No,Re_Money,Re_Title,Re_Item,Re_delivery,Re_Limite)
values
(reward_seq.nextval,34,15000,'대밍이부시기','옥수수',to_date('16-11-23'),15);




insert into reward
(re_no, pro_no) values(reward_seq.nextval, 34)
insert into reward
(Re_No,Pro_No,Re_Money,Re_Title,Re_Item,Re_delivery,Re_Limite)
values
(reward_seq.nextval,34,15000,'대밍이부시기','옥수수',sysdate,15);

select re_no,pro_no from reward;
select re_no from reward where pro_no =36 ;
select pro_no from project;