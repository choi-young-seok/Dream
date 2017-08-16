-- 후원 임시테이블

-- 새 테이블4
ALTER TABLE Dream_Support
	DROP FOREIGN KEY FK_Dream_Member_TO_Dream_Support; -- 회원 -> 새 테이블4

-- 새 테이블4
ALTER TABLE Dream_Support
	DROP FOREIGN KEY FK_Dream_Project_TO_Dream_Support; -- user -> 새 테이블4

-- 새 테이블4
DROP TABLE Dream_Support;

-- 새 테이블4
CREATE TABLE Dream_Support (
	Support_No    INTEGER      primary key, -- 후원 번호
	Member_Mail   VARCHAR2(40) NOT NULL REFERENCES Dream_Member(Member_Mail), -- 회원 이메일
	Project_No    INTEGER      NOT NULL REFERENCES Dream_Project(Project_No), -- 프로젝트 번호
	Support_Money INTEGER      DEFAULT 0, -- 후원 금액
	Support_Date  DATE         DEFAULT sysdate -- 후원 일자
);
	-- Member_Name   VARCHAR2(18) NOT NULL REFERENCES Dream_Member(Member_Name), -- 후원자 성명
	
	
drop sequence support_seq;
create sequence support_seq
	start with 1
	increment by 1
	nocycle
	nocache; 
--여기까지


drop table support;
create table support(
	Su_No			integer			primary key, --후원번호
	Pro_No			integer		not null references project(Pro_No), --후원하는 프로젝트 번호
	M_Id			varchar2(20)  	not null references member(M_id), --후원한 사람 ID
	Re_No			integer		references reward(Re_No), -- 후원시 받을 리워즈번호
	
	Su_Money		integer		not null, --후원금액
	Su_Name			varchar2(20)	not null, -- 배송 받을 사람 이름
	Su_Zip          varchar2(20)    not null, -- 배송우편번호
	Su_Address		varchar2(255)	not null, -- 배송지 주소
	Su_Phone		varchar2(20)	not null, -- 배송 받을 사람 번호
	PaymentPlan		varchar2(20)	not null, --결제방식
	Su_refundAccount varchar2(30) not null, --환불계좌
	Su_refundBank    varchar2(30) not null, --환불은행
	Su_Date			date		not null, -- 후원 날짜
	--프로젝트 후원 정보 입력시 필요 컬럼

	Su_State		varchar2(1)	 default '0' --환불여부

);

select * from support

insert into support (su_no,m_id,pro_no,re_no,su_money,su_name, su_address,
		             su_zip,su_phone,paymentPlan,su_refundAccount,su_refundBank,su_date)
		values
		            (support_seq.nextval,'test1',1,1,1300,'정다우니','수원시팔달구',
		             '34012','01084685154','현금','23112312','국민은행',sysdate);
		
                
           ALTER TABLE support  DROP(columnName );
           alter table support MODIFY (Re_No integer);
		             
drop sequence support_seq;
create sequence support_seq
	start with 1
	increment by 1
	nocycle
	nocache; 