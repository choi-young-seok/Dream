* 제약조건 추가
 
   alter table 테이블명 add primary key(추가할 기본키 컬럼);
   alter table 테이블명 add unique(추가할 유니크 컬럼);
   alter table 테이블명 add foreign key(추가할 외래키 컬럼) references 부모 테이블(추가할 외래키 컬럼);  => 뒤에가 부모 table
   alter table 테이블명 modify 수정할 컬럼명 not null;
   alter table 테이블명 add constraint dept01_deptno_pk primary key(deptno); 
