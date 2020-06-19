package com.thuchanhchuyensau.dto;

public class NewDTO extends AbstractDTO<NewDTO> {
	
	private String newImage;
	
	private String title;
	
	private String content;
	
	private AdvertingDTO advertingDTO;

	public String getNewImage() {
		return newImage;
	}

	public void setNewImage(String newImage) {
		this.newImage = newImage;
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

	public AdvertingDTO getAdvertingDTO() {
		return advertingDTO;
	}

	public void setAdvertingDTO(AdvertingDTO advertingDTO) {
		this.advertingDTO = advertingDTO;
	}
	
	
	

}
