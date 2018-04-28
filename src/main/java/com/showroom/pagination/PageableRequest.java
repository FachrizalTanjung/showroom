package com.showroom.pagination;

public class PageableRequest {

	private int page = 1;
	private int pageSize = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page < 1) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			this.pageSize = 1;
		} else {
			this.pageSize = pageSize;
		}
	}
	public int getOffset() {
		return (page - 1) * pageSize;
	}

}
