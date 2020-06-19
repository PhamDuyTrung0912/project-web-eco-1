package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.UserConvert;
import com.thuchanhchuyensau.dto.UserDTO;
import com.thuchanhchuyensau.entity.RoleEntity;
import com.thuchanhchuyensau.entity.UserEntity;
import com.thuchanhchuyensau.repository.RoleRepository;
import com.thuchanhchuyensau.repository.UserRepository;
import com.thuchanhchuyensau.service.IUserService;



@Service
public class UserService implements IUserService {

	@Autowired
	private UserConvert userConvert;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO save(UserDTO dto) {
		
		RoleEntity roleEntity=roleRepository.findOne((long) 2);
		List<RoleEntity> roles=new ArrayList<>();
		roles.add(roleEntity);
		
		UserEntity userEntity =new UserEntity();
		UserEntity olduserEntity= userRepository.findOneByUserName(dto.getUserName());
		if(olduserEntity!=null) {
				return null;
		}else {		
			 userEntity =userConvert.toEntity(dto); 
			 userEntity.setRoles(roles);
			 
			 return userConvert.toDto(userRepository.save(userEntity));
		}
		
		
	}

	@Override
	public UserDTO findByUsername(String username) {
		
		UserEntity userEntity= userRepository.findOneByUserName(username);
		
		return userConvert.toDto(userEntity);
	}
	
}
