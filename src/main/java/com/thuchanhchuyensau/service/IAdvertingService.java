package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.AdvertingDTO;

@Service
public interface IAdvertingService {

	List<AdvertingDTO> findAll(Pageable pageable);
	
}
