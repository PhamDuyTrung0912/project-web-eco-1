package com.thuchanhchuyensau.convert;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.AdvertingDTO;
import com.thuchanhchuyensau.dto.CategoryDTO;
import com.thuchanhchuyensau.entity.AdvertingEntity;
import com.thuchanhchuyensau.entity.CategoryEntity;

@Component
public class CategoryConvert {
	
	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO=new CategoryDTO();
		
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setName(categoryEntity.getName());
		categoryDTO.setCode(categoryEntity.getCode());
		
		return categoryDTO;
	}
}
