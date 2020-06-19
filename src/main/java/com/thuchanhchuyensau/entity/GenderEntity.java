package com.thuchanhchuyensau.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table
@Entity(name = "gender")
public class GenderEntity extends BaseEntity {
	
	@Column(name="typegender")
	private String typegender;
	
	
	@ManyToMany(mappedBy = "genders")
	private List<ProductEntity> products = new ArrayList<>();

	public String getType() {
		return typegender;
	}

	public void setType(String type) {
		this.typegender = type;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	

}
