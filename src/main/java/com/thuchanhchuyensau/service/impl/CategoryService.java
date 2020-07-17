package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.CategoryConvert;
import com.thuchanhchuyensau.dto.CategoryDTO;
import com.thuchanhchuyensau.entity.CategoryEntity;
import com.thuchanhchuyensau.repository.CategoryRepository;
import com.thuchanhchuyensau.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConvert categoryConvert;
	
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> categoryDTOs=new ArrayList<>();
		List<CategoryEntity> categoryEntitys=categoryRepository.findAll();
			for(CategoryEntity item : categoryEntitys) {
				CategoryDTO categoryDTO=categoryConvert.toDto(item);
				categoryDTOs.add(categoryDTO);
			}
		return categoryDTOs;
	}
	
	
	

}
