package com.univ.rouen.auth0.dto;

import java.io.Serializable;

/**
 * Dto Auth0Response
 * @author GROUPE JEE
 */
public class Auth0Response implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String responseToken;
	
	public Auth0Response(String responseToken) {
		this.responseToken = responseToken;
	}

	public String getToken() {
		return this.responseToken;
	}
}