package com.univ.rouen.auth0.dto;

import java.io.Serializable;

/**
 * Dto Auth0Request
 * @author 
 */
public class Auth0Request implements Serializable{
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	//need default constructor for JSON Parsing
	public Auth0Request(){}

	public Auth0Request(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
