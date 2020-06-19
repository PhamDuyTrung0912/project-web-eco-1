package com.thuchanhchuyensau.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thuchanhchuyensau.dto.FilterDTO;
import com.thuchanhchuyensau.dto.PageableDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.impl.ProductService;

@RestController
public class ProductApi {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/api/loadmore")
	public List<ProductDTO> getProductByCategory(@RequestBody PageableDTO pageabledto){
		
		Pageable pageable=new PageRequest(pageabledto.getCount(),3);
		
		ProductDTO productDto=new ProductDTO();
		
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		
		list=productService.findAll(pageable);
			
			
	
		return list;
		
//		Pageable pageable=new PageRequest(count,6);
	
	}
}
