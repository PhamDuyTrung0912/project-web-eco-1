package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.thuchanhchuyensau.dto.ProductDTO;

public interface IProductService {

	List<ProductDTO> findAll(Pageable pageable);
	
	List<ProductDTO> findByGender(String type);
	
	ProductDTO findOneById(Long id);

	List<ProductDTO> findByFilter(String filter);
	
	
}
