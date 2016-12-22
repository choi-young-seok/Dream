drop table reply;
create table reply(
	Rp_No		integer		primary key,		
	Pro_No		integer		not null references project(Pro_No),
	M_id		varchar2(20)	not null references member(M_id),
	Rp_Content	varchar2(100)	not null,
	Rp_Time		date		not null,
	ThumbsUp	integer default '0'
);

drop sequence reply_seq;
create sequence reply_seq
	start with 1
	increment by 1
	nocycle
	nocache;
	
	select * from project where m_id ='kancho33' and pro_state =1 ;
	
			select
		trunc((now_amount/pro_goal)*100) as progress, pro_goal, pro_end,
		pro_thumbnail, pro_title, round(pro_end - pro_start) as due_date
		,pro_no,su_count from project where pro_state = 1 order by pro_start desc;
		
		
		
			select *
		from project
		where pro_no  in (select pro_no from support where m_id = 'kancho33')
		
		select project.pro_no
		from project ,support
		where project.pro_no = support.pro_no and m_id = 'kancho33';
		
		select pro_no from support where m_id = 'kancho33';