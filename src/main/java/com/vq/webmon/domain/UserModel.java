package com.vq.webmon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PENGGUNA")
public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "STATUS")
	private UserStatus status;
	@ManyToMany
	@JoinTable(name = "USER_AND_ROLE", joinColumns=@JoinColumn(name="USER_ID_R"), inverseJoinColumns=@JoinColumn(name="USER_ROLE_ID_R"))
	private List<UserRole> roles;
	
	public UserModel(){
		
	}
	
	public UserModel(Integer id, String username, String password,
			UserStatus status, List<UserRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	
	

}
