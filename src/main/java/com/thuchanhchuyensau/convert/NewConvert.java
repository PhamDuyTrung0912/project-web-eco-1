package com.thuchanhchuyensau.convert;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.NewDTO;
import com.thuchanhchuyensau.entity.NewEntity;

@Component
public class NewConvert {

	
	public NewDTO toDto(NewEntity entity) {
		
		NewDTO dto=new NewDTO();
		
		dto.setId(entity.getId());
		dto.setNewImage(entity.getImageNew());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		
		return dto;
	}
}
