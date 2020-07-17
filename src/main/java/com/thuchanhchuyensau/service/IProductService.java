package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.ProductDTO;

@Service
public interface IProductService {

	List<ProductDTO> findAllProduct();
	
	List<ProductDTO> findAll(Pageable pageable);
	
	List<ProductDTO> findByGender(String type);
	
	List<ProductDTO> findByTag(String type);
	
	ProductDTO findOneById(Long id);

	List<ProductDTO> findByFilter(String filter);
	
	List<ProductDTO> findProductKey(String key);
	
	void deleteProduct(Long id);
	
	ProductDTO save(ProductDTO dto);
}
