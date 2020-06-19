package com.thuchanhchuyensau.convert;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.AdvertingDTO;
import com.thuchanhchuyensau.entity.AdvertingEntity;

@Component
public class AdvertingConvert {
	
	public AdvertingDTO toDto(AdvertingEntity advertingEntity) {
		AdvertingDTO advertingDTO=new AdvertingDTO();
		
		advertingDTO.setId(advertingEntity.getId());
		advertingDTO.setImageAdvert(advertingEntity.getImage());
		advertingDTO.setTitle(advertingEntity.getTitle());
		advertingDTO.setContent(advertingEntity.getContent());
		advertingDTO.setNewID(advertingEntity.getNewEntity().getId());
		
		return advertingDTO;
	}
}
