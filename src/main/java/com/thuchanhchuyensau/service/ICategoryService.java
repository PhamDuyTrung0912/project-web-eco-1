package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.CategoryDTO;
@Service
public interface ICategoryService {

	List<CategoryDTO> findAll();
}
