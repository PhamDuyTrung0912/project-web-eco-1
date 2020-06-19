package com.thuchanhchuyensau.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "adverting")
@Entity
public class AdvertingEntity extends BaseEntity {
	
	@Column
	private String imageAdvert;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@OneToOne
	@JoinColumn(name="new_id")
	private NewEntity newEntity;

	public String getImage() {
		return imageAdvert;
	}

	public void setImage(String image) {
		this.imageAdvert = image;
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

	public NewEntity getNewEntity() {
		return newEntity;
	}

	public void setNewEntity(NewEntity newEntity) {
		this.newEntity = newEntity;
	}
	
	
}
