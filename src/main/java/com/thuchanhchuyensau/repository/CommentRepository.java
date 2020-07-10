package com.thuchanhchuyensau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thuchanhchuyensau.dto.CommentDTO;
import com.thuchanhchuyensau.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	
	@Query(value = "delete * from cmt where cmt.product_id=:id;",nativeQuery = true)
	void DeleteComment(@Param("id") Long id);
	
	@Query(value = "select count(*) from cmt where cmt.product_id=:id;",nativeQuery = true)
	int CountByIdProduct(@Param("id") Long id);
}
