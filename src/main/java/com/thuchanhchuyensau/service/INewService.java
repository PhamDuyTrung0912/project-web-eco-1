package com.thuchanhchuyensau.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.NewDTO;

@Service
public interface INewService {
	
	List<NewDTO> findall();
	
}
