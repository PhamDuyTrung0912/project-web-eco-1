package com.thuchanhchuyensau.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thuchanhchuyensau.convert.ProductConvert;
import com.thuchanhchuyensau.dto.CommentDTO;
import com.thuchanhchuyensau.dto.ProductDTO;
import com.thuchanhchuyensau.entity.CategoryEntity;
import com.thuchanhchuyensau.entity.CommentEntity;
import com.thuchanhchuyensau.entity.MediaEntity;
import com.thuchanhchuyensau.entity.ProductEntity;
import com.thuchanhchuyensau.entity.RoleEntity;
import com.thuchanhchuyensau.entity.UserEntity;
import com.thuchanhchuyensau.repository.CategoryRepository;
import com.thuchanhchuyensau.repository.CommentRepository;
import com.thuchanhchuyensau.repository.MediaRepository;
import com.thuchanhchuyensau.repository.ProductRepository;
import com.thuchanhchuyensau.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConvert productConvert;
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findAll(pageable).getContent();
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> findByGender(String type) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findByGenders_Type(type);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}
	
	

	@Override
	public ProductDTO findOneById(Long id) {
		ProductEntity entity=productRepository.findOneById(id);
		return productConvert.toDto(entity);	
	}

	@Override
	public List<ProductDTO> findByFilter(String filter) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findByCategory(filter);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> findByTag(String type) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findByTag_Type(type);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> findProductKey(String key) {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findProductkey(key);
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		//productRepository.deleteRelationshipProduct(id);
//		int countMedia =mediaRepository.CountByIdProduct(id);
//		int countComment=commentRepository.CountByIdProduct(id);
//		if(countMedia > 0 ) {
//			mediaRepository.DeleteMedia(id);
//		}
//		if(countComment>0) {	
//			commentRepository.DeleteComment(id);	
//		}
		productRepository.delete(id);
		
	}

	@Override
	public List<ProductDTO> findAllProduct() {
		List<ProductDTO> productDTOs=new ArrayList<>();
		List<ProductEntity> entities=productRepository.findAll();
		for(ProductEntity item:entities) {
			ProductDTO productDTO=productConvert.toDto(item);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		
		
		CategoryEntity categoryEntity =categoryRepository.findOneByCode(dto.getCategoryCode());
		
		ProductEntity proEntity =new ProductEntity();
		
		if(dto.getId()!=null) {
			ProductEntity oldProduct=productRepository.findOne(dto.getId());
			oldProduct.setCategoryEntity(categoryEntity);
			proEntity=productConvert.toEntity(oldProduct,dto);
			
		}else {
		
		proEntity=productConvert.toEntity(dto);
		proEntity.setCategoryEntity(categoryEntity);
		}
		return productConvert.toDto(productRepository.save(proEntity));
	
	
	}

	@Override
	public List<ProductDTO> findByPrice(int min, int max) {
			List<ProductDTO> productDTOs=new ArrayList<>();
			List<ProductEntity> productEntities=productRepository.findByPrice(min, max);
			for(ProductEntity item:productEntities) {
				ProductDTO productDTO=productConvert.toDto(item);
				productDTOs.add(productDTO);
			}
			return productDTOs;
	}
	
	
}
