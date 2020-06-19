package com.thuchanhchuyensau.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO extends AbstractDTO<UserDTO> {
	
	
	private String thumbnail;
	
	@NotEmpty(message = "email is required")
	@Email
	private String userName;
	
	@NotEmpty(message = "password is required")
	private String password;
	
	private String fullName;
	
	private Integer status;
	
	private String roleCode;
	

	
	
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
