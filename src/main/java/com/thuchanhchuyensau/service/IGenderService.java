package com.thuchanhchuyensau.service;

import java.util.List;

import com.thuchanhchuyensau.dto.GenderDTO;

public interface IGenderService {
	
	List<GenderDTO> findAllWithGender();
}
