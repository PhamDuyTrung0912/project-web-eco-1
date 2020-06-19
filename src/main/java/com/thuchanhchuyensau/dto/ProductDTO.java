package com.thuchanhchuyensau.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.thuchanhchuyensau.entity.CommentEntity;

public class ProductDTO extends AbstractDTO<ProductDTO> {

	
	
	private String name;
	
	
	private Float price;
	
	
	private String shortDesc;
	

	private String content;
	
	
	private String imageProduct;
	

	private String size;
	

	private Integer frProduct;
	
	
	private Long categoryId;
	
	private String categoryCode;

	
	private List<GenderDTO> listgender=new ArrayList<>();
	
	private List<MediaDTO> mediaDTOs=new ArrayList<>();
	
	private List<CommentDTO> commentDTOs=new ArrayList<>();
	
	
	
	
	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
	}

	public List<MediaDTO> getMediaDTOs() {
		return mediaDTOs;
	}

	public void setMediaDTOs(List<MediaDTO> mediaDTOs) {
		this.mediaDTOs = mediaDTOs;
	}

	public List<GenderDTO> getListgender() {
		return listgender;
	}

	public void setListgender(List<GenderDTO> listgender) {
		this.listgender = listgender;
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

	public String getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
	
}
