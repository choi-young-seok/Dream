drop table cart;
create table cart(
	C_No		integer			primary key,		
	M_Id		varchar2(20) 	not null references member(M_id),
	Pro_No		integer			not null references project(Pro_No),
	C_Date		date			not null
);

drop sequence cart_seq;
create sequence cart_seq
	start with 1
	increment by 1
	nocycle
	nocache;