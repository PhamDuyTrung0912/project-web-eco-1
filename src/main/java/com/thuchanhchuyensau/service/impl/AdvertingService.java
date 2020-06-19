package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.AdvertingConvert;
import com.thuchanhchuyensau.dto.AdvertingDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.entity.AdvertingEntity;
import com.thuchanhchuyensau.entity.ProductEntity;
import com.thuchanhchuyensau.repository.AdvertingRepository;
import com.thuchanhchuyensau.service.IAdvertingService;

@Service
public class AdvertingService implements IAdvertingService {

	@Autowired
	private AdvertingConvert advertingConvert;
	
	@Autowired
	private AdvertingRepository advertingRepository;
	
	@Override
	public List<AdvertingDTO> findAll(Pageable pageable) {
		List<AdvertingDTO> advertingDTOs =new ArrayList<>();
		List<AdvertingEntity> entities=advertingRepository.findAll(pageable).getContent();
		for(AdvertingEntity item:entities) {
			AdvertingDTO advertingDTO=advertingConvert.toDto(item);
			advertingDTOs.add(advertingDTO);
		}
		return advertingDTOs;
	}
	
	
}
