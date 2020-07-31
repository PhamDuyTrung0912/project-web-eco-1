package com.thuchanhchuyensau.dto;


public class CommentDTO extends AbstractDTO<CommentDTO> {
	
	private String content;
	
	private UserDTO userDTO;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
	
	
}
