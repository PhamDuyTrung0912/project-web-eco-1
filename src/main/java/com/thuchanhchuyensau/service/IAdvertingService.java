package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.thuchanhchuyensau.dto.AdvertingDTO;

public interface IAdvertingService {

	List<AdvertingDTO> findAll(Pageable pageable);
	
}
