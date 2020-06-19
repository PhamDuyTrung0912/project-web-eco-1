package com.thuchanhchuyensau.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "new")
@Entity
public class NewEntity extends BaseEntity {
	
	@Column
	private String imageNew;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@OneToOne(mappedBy = "newEntity")
	private AdvertingEntity advertingEntity;

	public String getImageNew() {
		return imageNew;
	}

	public void setImageNew(String imageNew) {
		this.imageNew = imageNew;
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

	public AdvertingEntity getAdvertingEntity() {
		return advertingEntity;
	}

	public void setAdvertingEntity(AdvertingEntity advertingEntity) {
		this.advertingEntity = advertingEntity;
	}
	
	
}
