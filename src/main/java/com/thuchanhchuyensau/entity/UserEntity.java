	package com.thuchanhchuyensau.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.thuchanhchuyensau.entity.RoleEntity;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column
	private String thumbnail;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullName; 
	
	@Column(name="status")
	private Integer status;

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"),
									inverseJoinColumns = @JoinColumn(name="role_id"))
	
	private List<RoleEntity> roles=new ArrayList<>();
	
	
	
	
	@OneToMany(mappedBy = "userEntity")
	private List<CommentEntity> commentEntity;
	
	
	
	
	

	public List<CommentEntity> getCommentEntity() {
		return commentEntity;
	}

	public void setCommentEntity(List<CommentEntity> commentEntity) {
		this.commentEntity = commentEntity;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
	
}
