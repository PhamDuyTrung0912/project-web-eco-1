package com.thuchanhchuyensau.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.MediaDTO;
import com.thuchanhchuyensau.entity.MediaEntity;

@Component
public class MediaConvert {
	
	public List<MediaDTO> toDto(List<MediaEntity> entity){
		List<MediaDTO> dtos=new ArrayList<MediaDTO>();
		for(MediaEntity item :entity) {
			MediaDTO dto=convert(item);
			dtos.add(dto);
		}
	
		return dtos;
	}
	
	public  MediaDTO convert(MediaEntity entity) {
		MediaDTO dto=new MediaDTO();
		 dto.setId(entity.getId());
		 dto.setImage(entity.getImage());
		return dto;			
	}
}
