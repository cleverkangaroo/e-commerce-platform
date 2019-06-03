package com.kangaroo.microservices.api.base.model.vo;

import java.io.Serializable;
import java.util.List;

public class SubjectVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String id;
	private String summary;
	private String year;
	private ImageVO images;
	private List<DirectorVO> directors;

	public SubjectVO() {

	}

	public SubjectVO(String id, String title, String summary) {
		this.id = id;
		this.title = title;
		this.summary=summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public ImageVO getImages() {
		return images;
	}

	public void setImages(ImageVO images) {
		this.images = images;
	}

	public List<DirectorVO> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorVO> directors) {
		this.directors = directors;
	}

	

}
