package com.thuchanhchuyensau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thuchanhchuyensau.entity.GenderEntity;

public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
	
	List<GenderEntity> findByTypegender(String type);

}
