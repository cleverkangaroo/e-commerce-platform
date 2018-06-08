package com.kangaroo.microservices.provider.base.utils;

import java.io.Serializable;

public class PageParam implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer curPage=1;
	
	private Integer pageSize=10;
	
	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		if (curPage!=null&&curPage>0) {
			this.curPage = curPage;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize!=null&&pageSize>=0) {
			this.pageSize = pageSize;
		}
	}

	public Integer getOffset() {
		return (curPage-1)*pageSize;
	}

}
