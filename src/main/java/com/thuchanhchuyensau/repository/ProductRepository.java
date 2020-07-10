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

	@Query(value = "select product.*,tag.id,tag.name,product_tag.product_id,product_tag.tag_id "
			+ "from product  inner join product_tag ON product.id=product_tag.product_id inner join tag "
			+ "on product_tag.tag_id=tag.id where tag.name= :type limit 0,5  ; ", nativeQuery=true)
	List<ProductEntity> findByTag_Type(@Param("type") String type);
	
	ProductEntity findOneById(Long id);

	@Query(value = "select * from product inner join category on produc t.category_id=category.id where category.name=:filter limit 0,5 ; ",nativeQuery = true)
	List<ProductEntity> findByCategory(@Param("filter")String filter);
	
	@Query(value = "select * from product where product.name like %:key% limit 0,5 ; ",nativeQuery = true)
	List<ProductEntity> findProductkey(@Param("key")String key);
	
	@Query(value = "delete product_gender.*,product_tag.* from product inner join product_gender on product_gender.product_id=product.id "
			+ "inner join product_tag on product_tag.product_id=product.id where product.id=:id;",nativeQuery = true)
	void deleteRelationshipProduct(@Param("id") Long id);
	
		
}
