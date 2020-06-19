package com.thuchanhchuyensau.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thuchanhchuyensau.dto.FilterDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.IProductService;

@RestController
public class FilterApi {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping("/api/filter")
	public List<ProductDTO> getProductByCategory(@RequestBody FilterDTO filterDTO){
		return productService.findByFilter( filterDTO.getFilter());
	}
}
