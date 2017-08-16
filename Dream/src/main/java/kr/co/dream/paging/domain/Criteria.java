package kr.co.dream.paging.domain;

public class Criteria {

	private int page; // ���� ������ ����
	private int perPageNum; // �� ȭ�鿡 ������ ���� ��

	public Criteria() {
		page = 1; // �⺻ 1�������� ����
		perPageNum = 10; // ��ȭ�鿡 10���� ����ϴ� ���� ����Ʈ�� ����
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
		// RowBounds �� �Ű������� ���� �����ϴ� �޼ҵ�
		// RouwBounds �� start index�� 0���� �����ϹǷ�
		// 1������ : 1-1 * 10 = 0 ->>
		// 2������ : 2-1 * 10 = 10 ->>
	}

	@Override
	public String toString() {
		return "Criteria [���� ������=" + page + ", �������� ������=" + perPageNum + "]";
	}

}
