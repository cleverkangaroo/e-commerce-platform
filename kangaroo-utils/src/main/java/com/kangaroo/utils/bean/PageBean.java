package com.kangaroo.utils.bean;

import java.util.List;


public class PageBean<T> {
	
	private long total;
	
	private List<T> dataList;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
