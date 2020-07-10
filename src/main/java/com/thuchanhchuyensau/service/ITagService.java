package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.TagDTO;

@Service
public interface ITagService {
	
	List<TagDTO> tags();

}
