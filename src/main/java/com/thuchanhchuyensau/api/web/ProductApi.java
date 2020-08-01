package com.thuchanhchuyensau.api.web;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.ParseInfo;
import com.thuchanhchuyensau.dto.GenderDTO;
import com.thuchanhchuyensau.dto.PageableDTO;
import com.thuchanhchuyensau.dto.PriceDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.dto.TagDTO;
import com.thuchanhchuyensau.service.IProductService;
import com.thuchanhchuyensau.service.impl.ProductService;
import com.thuchanhchuyensau.util.UploadFileUtils;

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
	
	@PostMapping("/api/filter/price")
	public List<ProductDTO> getProductPrice(@RequestBody PriceDTO priceDTO ){
		
		
		int min= Integer.parseInt(priceDTO.getMinprice());
		int max= Integer.parseInt(priceDTO.getMaxprice());
		
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		
		list=productService.findByPrice(min, max);
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
	
	
	@Autowired
	private UploadFileUtils uploadFile;
	
	@PostMapping(value="/api/product",consumes = {org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ProductDTO createNew(@RequestBody ProductDTO productDTO )  {
		
	
//		byte[] decodeBase64=Base64.getDecoder().decode(productDTO.getImageProduct().split(",")[1].getBytes());
//		
//		try {
//			uploadFile.writeOrupdate(decodeBase64,"/"+productDTO.getNameImage());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		
//				
//		
//		ProductDTO proDto= productService.save(productDTO);
//		
//				
	
		return null ;	
	}	 
	
	@PutMapping("/api/product")
	public String updateNew(@RequestBody ProductDTO proDto) {
		return "ok";
	}
	
	
	
}
