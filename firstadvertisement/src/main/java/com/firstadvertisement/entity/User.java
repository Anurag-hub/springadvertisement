package com.firstadvertisement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@GeneratedValue
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String userpassword;
	
	private String sessionId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}
	public User(String username, String userpassword,long id) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.sessionId=sessionId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
}
