package com.thuchanhchuyensau.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thuchanhchuyensau.dto.GenderDTO;
import com.thuchanhchuyensau.dto.PageableDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.dto.TagDTO;
import com.thuchanhchuyensau.service.IProductService;
import com.thuchanhchuyensau.service.impl.ProductService;

@RestController(value = "productApiOfWeb")
public class ProductApi {
	
	@Autowired
	private IProductService productService;
	
	
	
	@PostMapping("/api/loadmore")
	public List<ProductDTO> getProductByCategory(@RequestBody PageableDTO pageabledto){
		
		Pageable pageable=new PageRequest(pageabledto.getCount(),6);
		
		ProductDTO productDto=new ProductDTO();
		
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		
		list=productService.findAll(pageable);
			
			
	
		return list;
		
//		Pageable pageable=new PageRequest(count,6);
	
	}
	

	
	@PostMapping("/api/filter/gender")
	public List<ProductDTO> getProductGender(@RequestBody GenderDTO genderDTO){
		
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		
		list=productService.findByGender(genderDTO.getName());
	
		return list;
		
//		Pageable pageable=new PageRequest(count,6);
	
	}
	
	@PostMapping("/api/filter/tag")
	public List<ProductDTO> getProductTag(@RequestBody TagDTO tagDTO){
		
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		
		list=productService.findByTag(tagDTO.getName());
	
		return list;
		
//		Pageable pageable=new PageRequest(count,6);
	
	}
	
	
}
