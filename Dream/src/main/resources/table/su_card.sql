create table Su_card(
	Su_No			integer		primary key references support(su_no),
	Su_CardNo		integer		not null,
	CardCompany		varchar2(20) 	not null
);