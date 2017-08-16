create table Su_bank(
	Su_No			integer	primary key references support(su_no),
	BankName		varchar2(20),
	BankAccount		varchar2(20)
);