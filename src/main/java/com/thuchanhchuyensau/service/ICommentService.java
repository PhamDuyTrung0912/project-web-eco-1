package com.thuchanhchuyensau.service;

import org.springframework.stereotype.Service;

import com.thuchanhchuyensau.dto.CommentDTO;

@Service
public interface ICommentService {
	String save(CommentDTO dto,Long idpr);
}
