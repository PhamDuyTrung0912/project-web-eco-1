package com.thuchanhchuyensau.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thuchanhchuyensau.entity.TagEntity;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
