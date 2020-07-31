package com.thuchanhchuyensau.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.convert.CommentConvert;
import com.thuchanhchuyensau.dto.CommentDTO;
import com.thuchanhchuyensau.entity.CommentEntity;
import com.thuchanhchuyensau.entity.ProductEntity;
import com.thuchanhchuyensau.entity.UserEntity;
import com.thuchanhchuyensau.repository.CommentRepository;
import com.thuchanhchuyensau.repository.ProductRepository;
import com.thuchanhchuyensau.repository.UserRepository;
import com.thuchanhchuyensau.service.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CommentConvert commentCovert;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public String save(CommentDTO dto,Long idpr) {
		
		ProductEntity entity=productRepository.findOneById(idpr);
		UserEntity userEntity=userRepository.findOneByUserName(dto.getUserDTO().getUserName());
		
		CommentEntity commentEntity= new CommentEntity();
		
				commentEntity=commentCovert.toEntity(dto);
				commentEntity.setUserEntity(userEntity);
				commentEntity.setProductE(entity);
				
				commentRepository.save(commentEntity);
		
		return "ok";
	}

}
