package com.thuchanhchuyensau.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.MediaDTO;
import com.thuchanhchuyensau.dto.TagDTO;
import com.thuchanhchuyensau.entity.MediaEntity;
import com.thuchanhchuyensau.entity.TagEntity;

@Component
public class TagConvert {
	
	public TagDTO toDto(TagEntity entity) {
		TagDTO dto =new TagDTO();
		
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public List<TagDTO> toDtoE(List<TagEntity> entity){
		List<TagDTO> dtos=new ArrayList<TagDTO>();
		for(TagEntity item :entity) {
			TagDTO dto=toDto(item);
			dtos.add(dto);
		}
	
		return dtos;
	}
	
}
