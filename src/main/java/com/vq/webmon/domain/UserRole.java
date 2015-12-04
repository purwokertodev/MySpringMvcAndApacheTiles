package com.vq.webmon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ROLE_ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "ROLE_NAME", unique = true, nullable = false)
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private List<UserModel> users;
	
	public UserRole(){
		
	}
	
	public UserRole(Integer id, String roleName, List<UserModel> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	
	

}
