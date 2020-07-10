package com.thuchanhchuyensau.dto;

import java.util.ArrayList;
import java.util.List;

public class TagDTO extends AbstractDTO<TagDTO> {
	
	private String code;
	
	private String name;
	
	private List<ProductDTO> list=new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDTO> getList() {
		return list;
	}

	public void setList(List<ProductDTO> list) {
		this.list = list;
	}
	
	
}
