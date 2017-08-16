package kr.co.dream.paging.domain;

public class SearchCriteria extends Criteria{
	
	private String searchType;
	private String keyword;
	
	public String getsearchType() {
		return searchType;
	}
	public void setsearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}
