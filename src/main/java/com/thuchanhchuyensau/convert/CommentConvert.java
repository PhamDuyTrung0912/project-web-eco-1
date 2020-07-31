package com.thuchanhchuyensau.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.CommentDTO;
import com.thuchanhchuyensau.entity.CommentEntity;

@Component
public class CommentConvert {
	
	@Autowired
	private  UserConvert userConvert;
	
	
	public List<CommentDTO> toDto(List<CommentEntity> entity){
		List<CommentDTO> dtos=new ArrayList<CommentDTO>();
		for(CommentEntity item :entity) {
			CommentDTO dto=convert(item);
			dtos.add(dto);
		}
	
		return dtos;
	}
	
	public CommentDTO convert(CommentEntity entity) {
		CommentDTO dto=new CommentDTO();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		dto.setUserDTO(userConvert.toDto(entity.getUserEntity()));
		return dto;			
	}
	
	public CommentEntity toEntity(CommentDTO commentDTO) {
		CommentEntity commentEntity=new CommentEntity();
		commentEntity.setContent(commentDTO.getContent());
		return commentEntity;
	}
}
