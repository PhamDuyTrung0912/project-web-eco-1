package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.NewConvert;
import com.thuchanhchuyensau.dto.NewDTO;
import com.thuchanhchuyensau.entity.NewEntity;
import com.thuchanhchuyensau.repository.NewRepository;
import com.thuchanhchuyensau.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConvert newConvert;
	
	@Override
	public List<NewDTO> findall() {
		List<NewDTO> dtos=new ArrayList<NewDTO>();
		List<NewEntity> entities=newRepository.findAll();
		for(NewEntity item:entities) {
			NewDTO newdto=newConvert.toDto(item);
			dtos.add(newdto);
		}
		return dtos;
		
			
	}

	
}
