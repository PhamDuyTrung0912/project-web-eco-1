package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.TagConvert;
import com.thuchanhchuyensau.dto.CategoryDTO;
import com.thuchanhchuyensau.dto.TagDTO;
import com.thuchanhchuyensau.entity.CategoryEntity;
import com.thuchanhchuyensau.entity.TagEntity;
import com.thuchanhchuyensau.repository.TagRepository;
import com.thuchanhchuyensau.service.ITagService;

@Service
public class TagService implements ITagService {

	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private TagConvert tagConvert;
	
	@Override
	public List<TagDTO> tags() {
		
		List<TagDTO> listtag=new ArrayList<>();
		List<TagEntity> entitys=tagRepository.findAll();
			for(TagEntity item : entitys) {
				TagDTO tag=tagConvert.toDto(item);
				listtag.add(tag);
			}
		return listtag;
		
	}
	
}
