drop table dream_member;
create table dream_member(
   member_No         	integer,               -- 멤버 번호         
   member_Id         	varchar2(30)    primary key, -- 멤버 아이디
   member_Password  	varchar2(150)   not null, -- 멤버 비밀번호
   member_Email         varchar2(150)   not null, -- 멤버 이메일 , 중복검사 할것
   member_Name         	varchar2(30)    not null, --멤버 이름
   member_Date         	date		    not null 	default sysdate, -- 가입일
    --회원가입시 입력 받는 컬럼 (INSERT)
    
   member_Phone         varchar2(13), --1.후원할때 or 2.프로젝트 등록시 입력
   member_Zip          	varchar2(13),
   member_Address     	varchar2(255), -- 1.후원할때 배송지 정보 or 2.프로젝트 등록시 주소정보 입력
   member_Post         	varchar2(20), -- 1.후원할때 배송지 정보 or 2.프로젝트 등록시 주소정보 입력
   
   member_BankName      varchar2(30), -- 환불시 은행명
   member_Account      	varchar2(20), -- 환불시 계좌번호
   --후원정보 입력시 입력 받는 컬럼 (UPDATE)
   
   member_SupportingCount     	integer		default '0', -- 내가 후원하는 프로젝트 수 총합계 (후원시 +1)
   member_SupportedCount      	integer		default '0', -- 내 프로젝트 총 후원합계 (환불시 -1)
   member_Withdraw				varchar2(10)	default 'F' check(member_Withdraw in ('T','F')) 
);

drop sequence dream_member_seq;
create sequence dream_member_seq
   start with 1
   increment by 1
   nocycle
   nocache;
   
    