package com.thuchanhchuyensau.service.impl;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.UserDTO;
import com.thuchanhchuyensau.entity.UserEntity;
import com.thuchanhchuyensau.service.IUserService;

@Service
public class UserService implements IUserService {

	@Override
	public UserDTO save(UserDTO dto) {
		
		UserEntity userEntity= new UserEntity();
		
		
		return null;
	}
	
}
