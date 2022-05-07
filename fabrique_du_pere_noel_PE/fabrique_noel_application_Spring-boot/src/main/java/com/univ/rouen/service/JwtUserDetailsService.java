package com.univ.rouen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.UserEntity;
import com.univ.rouen.repository.UserRepository;

/**
 * Service pour JwtUserDetailsService
 * @author GROUPE JEE
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	// contructeur
	public JwtUserDetailsService(UserRepository userRepository) {
	    this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    UserEntity user = userRepository.findByEmail(email);
	    if (user == null) {
	        throw new UsernameNotFoundException(email);
	    }
	    
	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
	    		

	//	org.springframework.security.core.userdetails.User usr = new org.springframework.security.core.userdetails.User(
	//			user.getUsername(), user.getUserpwd(), grantedAuthorities);

	    User userDetails = new User(user.getEmail(), user.getPassword(), grantedAuthorities);
	    		
	    return userDetails;
	}
}



