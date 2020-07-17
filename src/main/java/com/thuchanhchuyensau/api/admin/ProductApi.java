package com.thuchanhchuyensau.api.admin;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.service.IProductService;
import com.thuchanhchuyensau.service.IUserService;
import com.thuchanhchuyensau.service.impl.ProductService;
import com.thuchanhchuyensau.util.UploadFileUtils;

@RestController(value = "productApiOfAdmin")
public class ProductApi {
	
//	@Autowired
//	private IProductService productService;			
//	
//	@Autowired
//	private UploadFileUtils uploadFile;
//	
//	@PostMapping("/api/product")
//	public String createNew(@RequestBody ProductDTO productDTO ) throws IOException {
//		byte[] decodeBase64=Base64.getDecoder().decode(productDTO.getImageProduct().split(",")[1].getBytes());
//		
//		uploadFile.writeOrupdate(decodeBase64,"/"+productDTO.getNameImage());
//		
//		//ProductDTO proDto= productService.save(productDTO);
//		
//				
//	
//		return "ok" ;	
//	}	 
//	
//	@PutMapping("/api/product")
//	public String updateNew(@RequestBody ProductDTO proDto) {
//		return "ok";
//	}
}
