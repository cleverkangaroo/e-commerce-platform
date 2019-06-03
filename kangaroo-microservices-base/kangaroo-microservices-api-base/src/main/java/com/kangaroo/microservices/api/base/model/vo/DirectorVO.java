package com.kangaroo.microservices.api.base.model.vo;

import java.io.Serializable;

public class DirectorVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	private ImageVO avatars;
	
	public DirectorVO() {
		
	}
	
	public DirectorVO(String id, String name, ImageVO avatars) {
		this.id = id;
		this.name = name;
		this.avatars = avatars;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public ImageVO getAvatars() {
		return avatars;
	}

	public void setAvatars(ImageVO avatars) {
		this.avatars = avatars;
	}
	
	
}
