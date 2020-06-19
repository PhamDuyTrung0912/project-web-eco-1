package com.thuchanhchuyensau.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="product")
public class ProductEntity extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private Float price;
	
	@Column
	private String shortDesc;
	
	@Column
	private String content;
	
	@Column
	private String imageProduct;
	
	
	@Column 
	private String size;
	
	@Column
	private Integer frProduct;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;
	
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinTable(name = "product_gender", joinColumns = @JoinColumn(name="product_id"),
									inverseJoinColumns = @JoinColumn(name="gender_id"))
	
	private List<GenderEntity> genders=new ArrayList<>();
	
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinTable(name = "product_tag", joinColumns = @JoinColumn(name="product_id"),
									inverseJoinColumns = @JoinColumn(name="tag_id"))
	
	private List<TagEntity> tags=new ArrayList<>();
	
	@OneToMany(mappedBy = "productEntity")
	private List<MediaEntity> medias= new ArrayList<>();
	
	@OneToMany(mappedBy = "productE")
	private List<CommentEntity> cmt= new ArrayList<>();
	
	
	
	
	public List<CommentEntity> getCmt() {
		return cmt;
	}

	public void setCmt(List<CommentEntity> cmt) {
		this.cmt = cmt;
	}

	public List<MediaEntity> getMedias() {
		return medias;
	}

	public void setMedias(List<MediaEntity> medias) {
		this.medias = medias;
	}

	public List<TagEntity> getTags() {
		return tags;
	}

	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getFrProduct() {
		return frProduct;
	}

	public void setFrProduct(Integer frProduct) {
		this.frProduct = frProduct;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public String getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}

	public List<GenderEntity> getGenders() {
		return genders;
	}

	public void setGenders(List<GenderEntity> genders) {
		this.genders = genders;
	}
	
	
	
	
}
