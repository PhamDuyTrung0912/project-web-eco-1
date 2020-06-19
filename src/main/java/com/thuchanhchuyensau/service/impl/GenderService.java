package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.GenderConvert;
import com.thuchanhchuyensau.dto.GenderDTO;
import com.thuchanhchuyensau.entity.GenderEntity;
import com.thuchanhchuyensau.repository.GenderRepository;
import com.thuchanhchuyensau.service.IGenderService;

@Service
public class GenderService implements IGenderService {

	@Autowired
	private GenderRepository genderRepository;
	
	@Autowired
	private GenderConvert genderConvert;
	
	
	@Override
	public List<GenderDTO> findAllWithGender() {
		
		return null;
	}
	
}
