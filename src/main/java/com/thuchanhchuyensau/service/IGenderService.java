package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.GenderDTO;
@Service
public interface IGenderService {
	
	List<GenderDTO> findAllWithGender();
}
