package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.constant.SystemConstant;
import com.thuchanhchuyensau.dto.MyUser;
import com.thuchanhchuyensau.entity.RoleEntity;
import com.thuchanhchuyensau.entity.UserEntity;
import com.thuchanhchuyensau.repository.UserRepository;

@Service
public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity userEntity=userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if(userEntity==null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities=new ArrayList<>();
		for(RoleEntity role:userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		MyUser myUser=new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
