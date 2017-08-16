-- 새 테이블
ALTER TABLE Dream_Member_Log
	DROP FOREIGN KEY FK_Dream_Member_TO_Dream_Member_Log; -- 회원 -> 새 테이블

-- 새 테이블
DROP TABLE Dream_Member_Log;

-- 새 테이블
CREATE TABLE Dream_Member_Log (
	Member_No   INTEGER      NOT NULL references dream_member(member_no), -- 회원 번호
	Member_Mail VARCHAR2(40) NOT NULL , -- 회원 이메일
	Login_Date  DATE         NOT NULL  -- 로그인 일시
);