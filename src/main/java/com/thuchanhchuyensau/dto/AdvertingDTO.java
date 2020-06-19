package com.thuchanhchuyensau.dto;

public class AdvertingDTO extends AbstractDTO<AdvertingDTO> {
	
	private String imageAdvert;
	private String title;
	private String content;
	private Long newID;
	
	public String getImageAdvert() {
		return imageAdvert;
	}
	public void setImageAdvert(String imageAdvert) {
		this.imageAdvert = imageAdvert;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getNewID() {
		return newID;
	}
	public void setNewID(Long newID) {
		this.newID = newID;
	}
	
	

}
