package com.thuchanhchuyensau.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thuchanhchuyensau.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	
	@Query(value = "select product.*,gender.id,gender.typegender,product_gender.product_id,product_gender.gender_id "
			+ "from product  inner join product_gender ON product.id=product_gender.product_id inner join gender "
			+ "on product_gender.gender_id=gender.id where gender.typegender= :type limit 0,5  ; ", nativeQuery=true)
	List<ProductEntity> findByGenders_Type(@Param("type") String type);

	
	ProductEntity findOneById(Long id);

	@Query(value = "select * from product inner join category on product.category_id=category.id where category.name=:filter limit 0,5 ; ",nativeQuery = true)
	List<ProductEntity> findByCategory(@Param("filter")String filter);

}
