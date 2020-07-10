package com.thuchanhchuyensau.service;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.UserDTO;

@Service
public interface IUserService {
	UserDTO save(UserDTO dto);
	UserDTO findByUsername(String username);
	
}
