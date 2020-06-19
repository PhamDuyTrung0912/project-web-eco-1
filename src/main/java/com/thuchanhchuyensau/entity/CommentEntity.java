package com.thuchanhchuyensau.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cmt")
public class CommentEntity extends BaseEntity {
	
	@Column
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productE;

	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	
	
	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ProductEntity getProductE() {
		return productE;
	}

	public void setProductE(ProductEntity productE) {
		this.productE = productE;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
