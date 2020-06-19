package com.thuchanhchuyensau.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.GenderDTO;
import com.thuchanhchuyensau.entity.GenderEntity;
import com.thuchanhchuyensau.util.ProductUtil;

@Component
public class GenderConvert {
	
	
//	@Autowired
//	private ProductUtil productUtil;
	
	public List<GenderDTO> toDto(List<GenderEntity> entity) {
		List<GenderDTO> dtos=new ArrayList<GenderDTO>();
		for(GenderEntity item :entity) {
			GenderDTO dto=convert(item);
			dtos.add(dto);
		}
	
		return dtos;
	}
	
	public static GenderDTO convert(GenderEntity entity) {
		GenderDTO dto=new GenderDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getType());
		return dto;			
	}
}
