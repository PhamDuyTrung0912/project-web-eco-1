package com.thuchanhchuyensau.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.thuchanhchuyensau.dto.UserDTO;
import com.thuchanhchuyensau.entity.UserEntity;

@Component
public class UserConvert {
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserDTO toDto (UserEntity userEntity) {
		UserDTO userDto=new UserDTO();
		userDto.setId(userEntity.getId());
		userDto.setUserName(userEntity.getUserName());
		userDto.setPassword(userEntity.getPassword());
		userDto.setFullName(userEntity.getFullName());
		userDto.setStatus(userEntity.getStatus());
		userDto.setRoleCode("USER");
		userDto.setThumbnail(userEntity.getThumbnail());	
			return userDto;
	}
	
	public UserEntity toEntity (UserDTO userDto) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserName(userDto.getUserName());
		userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userEntity.setFullName(userDto.getFullName());
		userEntity.setStatus(1);
		return userEntity;
	}
}
