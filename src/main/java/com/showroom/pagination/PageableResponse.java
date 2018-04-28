package com.showroom.pagination;

import java.util.ArrayList;
import java.util.List;

public class PageableResponse<T> {

	private PageableRequest request;
	private List<T> data;
	private Long totalRecords;

	public PageableRequest getRequest() {
		return request;
	}

	public void setRequest(PageableRequest request) {
		this.request = request;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	/*public int getCurrentPage() {
		return request.getPage();
	}*/

	/*public int getLastPage() {

		if (totalRecords == null)
			return 1;
		if (totalRecords == 0L)
			return 1;
		return (int) Math.ceil(totalRecords.doubleValue() / request.getPageSize());
	}*/

	/*public List<Integer> getPages() {
		int lastPage = getLastPage();
		int currentPage = request.getPage();

		List<Integer> pages = new ArrayList<>();
		pages.add(currentPage);
		for (int i = 1; i < 7 && pages.size() < 7; i++) {

			int prev = pages.get(0) - 1;
			if (prev >= 1)
				pages.add(0, prev);
			int next = pages.get(pages.size() - 1) + 1;
			if (next <= lastPage)
				pages.add(next);
		}

		return pages;
	}*/

}
