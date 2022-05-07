package com.univ.rouen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univ.rouen.entity.UserEntity;
import com.univ.rouen.repository.UserRepository;

/**
 * Service pour User
 * @author GROUPE JEE
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// find lutin by id
	public UserEntity findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	// existe by id
	public boolean existsById(Long id) {
		
		return userRepository.existsById(id);
	}
}
