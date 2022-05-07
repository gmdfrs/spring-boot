package com.univ.rouen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.univ.rouen.dto.LutinDto;
import com.univ.rouen.entity.AdminEntity;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.entity.CompetenceEntity;
import com.univ.rouen.entity.LutinEntity;
import com.univ.rouen.entity.Role;
import com.univ.rouen.entity.UserEntity;
import com.univ.rouen.repository.AdminRepository;
import com.univ.rouen.repository.LutinRepository;
import com.univ.rouen.repository.RoleRepository;
import com.univ.rouen.repository.UserRepository;

import com.univ.rouen.util.*;

/**
 * Service pour Admin
 * @author GROUPE JEE
 */
@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;

//////////////////////////////////
	// gestion du admin
/////////////////////////////////
	
	// update admin
	public AdminEntity updateAdmin(AdminEntity admin) throws Exception {
		
		if (Util.isEmailValid(admin.getEmail()) && Util.isPasswordValid(admin.getPassword())) {
			String roleName = (admin.getRole() == null) ? "ROLE_ADMIN" : admin.getRole().getName();
			Role r = roleRepository.findByName(roleName);
			admin.setRole(r);
			// 
			admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
			//
			return adminRepository.save(admin);
		
		} else {
			throw new Exception("email or password invalid");
		}
	}
	
	// find l'admi par id
	public List<AdminEntity> findAdmin() {
		
		return adminRepository.findAll();
	}
	
	// find lutin by id
	public AdminEntity findAdminById(Long adminId) {
		
		return adminRepository.findById(adminId).orElse(null);
	}
	
	// existe par email
	public boolean existsByEmail(String email) {
		
		if(userRepository.findByEmail(email) != null) {
			return true;
		}
		else return false;
	}
	
	// existe par id
	public boolean existsById(Long id) {
		
		return userRepository.existsById(id);
	}	
}
