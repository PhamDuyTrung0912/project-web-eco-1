package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.ProductConvert;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.entity.ProductEntity;
import com.thuchanhchuyensau.repository.ProductRepository;
import com.thuchanhchuyensau.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConvert productConvert;
	
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findAll(pageable).getContent();
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> findByGender(String type) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findByGenders_Type(type);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public ProductDTO findOneById(Long id) {
		ProductEntity entity=productRepository.findOneById(id);
		return productConvert.toDto(entity);	
	}

	@Override
	public List<ProductDTO> findByFilter(String filter) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findByCategory(filter);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}
	
	
}
