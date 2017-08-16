package kr.co.dream.paging.domain;

public class Criteria {

	private int page; // 현재 페이지 정보
	private int perPageNum; // 한 화면에 보여줄 행의 수

	public Criteria() {
		page = 1; // 기본 1페이지로 설정
		perPageNum = 10; // 한화면에 10개씩 출력하는 것을 디폴트로 설정
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	// -------------------------------------------------------

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
		// RowBounds 의 매개변수의 값을 설정하는 메소드
		// RouwBounds 의 start index는 0부터 시작하므로
		// 1페이지 : 1-1 * 10 = 0 ->>
		// 2페이지 : 2-1 * 10 = 10 ->>
	}

	@Override
	public String toString() {
		return "Criteria [현재 페이지=" + page + ", 페이지당 출력행수=" + perPageNum + "]";
	}

}
