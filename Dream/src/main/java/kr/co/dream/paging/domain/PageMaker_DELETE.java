package kr.co.dream.paging.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker_DELETE {
	private int displayPageNum = 10;// 화면에 출력할 데이터 행수
	private int totalCount;// 전체 레코드 수

	private int startPage;// 화면에 출력되는 시작 넘버
	private int endPage;// 화면에 출력되는 끝 넘버

	private boolean prev;// '<<'버튼 출력여부
	private boolean next;// '>>'버튼 출력여부

	private Criteria cri;

	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum)) * displayPageNum;
		// 현재페이지 정보를 이용한 끝페이지에 대한 연산
		// ex) 현재 페이지 (pageInfo.getPage()) = 13
		// 하단 페이징 바에 보여줄 페이징바 개수 = diplayPageNum = 10개
		// 연산 : ceil(13/10.0) * 10 => 2 * 10 = 20까지
		// 11 12 13 14 15 16 17 18 19 20

		startPage = (endPage - displayPageNum) + 1;
		// 끝페이지 정보를 이용한 현재 페이지에 대한 연산
		// ex) 현재페이지 pageInfo.getPage()) = 13
		// 끝페이지 endPage = 20
		// 하단 페이징 바에 보여줄 페이징바 개수 = displayPageNum = 10
		// 시작페이지 = (20 - 10) + 1 = 11

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		// 검색 결과 행수를 이용한 전체 총 페이지수 연산
		// pageInfo.getPerPageNum = 한 화면에 출력할 행의 개수
		// ex) totalCount = 512
		// pageInfo.getPerPageNum = 10
		// tempEndPage = ceil(512 / 10.0) = 52
		// 51.2의 결과를 올림 => 51페이지 까지는 한 화면당 10개의 게시물이 출력
		// 마지막 52페이지에 0.2에 해당하는 2개의 게시물 출력

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

		prev = (startPage == 1) ? false : true;
		// ====> 1 ~ 10페이지를 출력할 때는 좌측의 '<<'버튼 생략
		
		next = (endPage * cri.getPerPageNum()) >= totalCount ? false : true;
		// ====> 총 100페이지, 출력하는 페이지가 90~100일때 우측의 '>>'버튼 생략
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("page", page) // page = 3
				.queryParam("perPageNum", cri.getPerPageNum()) // page=3&perPageNum=10
				.build(); // ?page=3&perPageNum=10
		return uriComponentsBuilder.toUriString(); // ?page=3&perPageNum=10의 값을 리턴
	}

	public String makeSearch(int page) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria) cri).getsearchType())
				.queryParam("keyword", ((SearchCriteria) cri).getKeyword()).build();
				//기존 makeQuery메소드에
				//SearchCriteria의 속성변수를 추가하여
				//쿼리생성
				//최종 쿼리 형태
				//http://localhost/sboard/list?page=1&perPageNum=10&searchType=t&keyword=title
				//?page=1&perPageNum=10&searchType=t&keyword=title
				//page=cri.getPage() = 파라미터 page
				//perPageNum = cri.getPerPageNum
				//searchType = (SearchCriteria) cri.getsearchType() : cri의 자식클래스의 get메소드
				//keyword = (SearchCriteria) cri.getKeyword() : cri의 자식 클래스의 get메소드
				//.build()메소드를 이용해 최종적으로
				//http://localhost/sboard/list?page=1&perPageNum=10&searchType=t&keyword=title
		return uriComponents.toUriString();
	}

}
