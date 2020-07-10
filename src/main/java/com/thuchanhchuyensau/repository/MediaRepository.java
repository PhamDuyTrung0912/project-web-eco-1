package com.thuchanhchuyensau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thuchanhchuyensau.dto.MediaDTO;
import com.thuchanhchuyensau.entity.MediaEntity;

@Repository
public interface MediaRepository  extends JpaRepository<MediaEntity, Long>{

	
	@Query(value = "delete * from media where media.product_id=:id;",nativeQuery = true)
	void DeleteMedia(@Param("id") Long id);
	
	@Query(value = "select count(*) from media where media.product_id=:id;",nativeQuery = true)
	int CountByIdProduct(@Param("id") Long id);
}
