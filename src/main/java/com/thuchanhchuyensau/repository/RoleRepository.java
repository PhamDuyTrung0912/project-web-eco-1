package com.thuchanhchuyensau.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuchanhchuyensau.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
}
