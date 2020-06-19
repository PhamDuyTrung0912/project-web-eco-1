package com.thuchanhchuyensau.convert;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.entity.ProductEntity;

@Component
public class ProductConvert {
	
	@Autowired
	private GenderConvert genderConvert;
	
	@Autowired 
	private MediaConvert mediaConvert;
	
	@Autowired
	private CommentConvert commentConvert;
	

	public ProductDTO toDto(ProductEntity entity) {	
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setShortDesc(entity.getShortDesc());
		result.setContent(entity.getContent());
		result.setImageProduct(entity.getImageProduct());
		result.setSize(entity.getSize());
		result.setFrProduct(entity.getFrProduct());
		result.setCategoryCode(entity.getCategoryEntity().getCode());
		result.setListgender(genderConvert.toDto(entity.getGenders()));
		result.setMediaDTOs(mediaConvert.toDto(entity.getMedias()));
		result.setCommentDTOs(commentConvert.toDto(entity.getCmt()));
		return result;
	}
}
