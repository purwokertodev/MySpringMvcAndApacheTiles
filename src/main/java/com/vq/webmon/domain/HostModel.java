package com.vq.webmon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HOST")
public class HostModel {

	@Id
	@SequenceGenerator(name="HOST_ID_SEQ", sequenceName="HOST_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOST_ID_SEQ")
	@Column(name = "HOST_ID", unique = true, nullable = false)
	private Long id;
	@Column(name = "HOST_NAME", length = 225)
	private String hostName;
	@Column(name = "PORT")
	private Integer port;
	@Column(name = "SERVER_NAME", length = 225)
	private String serverName;
	@Column(name = "STATUS", length = 50)
	private String status;
	@Column(name = "USERNAME", length = 50)
	private String username;
	@Column(name = "PASSWORD", length = 50)
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	

	
}
