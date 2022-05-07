package com.univ.rouen.dto;

import java.util.List;

/**
 * Dto user
 * @author GROUPE JEE
 */
public class UserDto {
	// le nom d un utilisateur
	private String firstName;
	// le prenom d un utilisateur
	private String lastName;
	// email d un utilsateur 
	private String email;
	// le mot de passe d un utilisateur
	private String password;
	// role
	private RoleDto role;
	
	public UserDto() {}

	public UserDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
}
