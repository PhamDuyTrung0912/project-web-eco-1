package com.thuchanhchuyensau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thuchanhchuyensau.entity.GenderEntity;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
	
	List<GenderEntity> findByTypegender(String type);

}
