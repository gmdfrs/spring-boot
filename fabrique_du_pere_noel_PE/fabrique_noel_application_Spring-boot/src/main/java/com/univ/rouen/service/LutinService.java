package com.univ.rouen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.univ.rouen.dto.LutinDto;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.entity.CompetenceEntity;
import com.univ.rouen.entity.LutinEntity;
import com.univ.rouen.entity.Role;
import com.univ.rouen.entity.UserEntity;
import com.univ.rouen.repository.LutinRepository;
import com.univ.rouen.repository.RoleRepository;
import com.univ.rouen.repository.UserRepository;

import com.univ.rouen.util.*;

/**
 * Service Lutin
 * @author GROUPE JEE
 */
@Service
public class LutinService {
	
	
	@Autowired
	private LutinRepository lutinRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;

//////////////////////////////////
	// gestion du lutin 
/////////////////////////////////

	public LutinEntity saveLutin(LutinEntity lutin) throws Exception {

		if (Util.isEmailValid(lutin.getEmail()) && Util.isPasswordValid(lutin.getPassword())) {
			String roleName = (lutin.getRole() == null) ? "ROLE_LUTIN" : lutin.getRole().getName();
			Role r = roleRepository.findByName(roleName);
			lutin.setRole(r);
			// 
			lutin.setPassword(bCryptPasswordEncoder.encode(lutin.getPassword()));
			//
			return lutinRepository.save(lutin);
			
		} else {
			throw new Exception("email or password invalid");
		} 
	}
	
	public LutinEntity updateLutin(LutinEntity lutin) throws Exception {
		
		if (Util.isEmailValid(lutin.getEmail()) && Util.isPasswordValid(lutin.getPassword())) {
			String roleName = (lutin.getRole() == null) ? "ROLE_LUTIN" : lutin.getRole().getName();
			Role r = roleRepository.findByName(roleName);
			lutin.setRole(r);
			// 
			lutin.setPassword(bCryptPasswordEncoder.encode(lutin.getPassword()));
			//
			return lutinRepository.save(lutin);
		
		} else {
			throw new Exception("email or password invalid");
		}
	}
	
	// delete lutin
	public void deleteLutin(Long lutinId) {
		
		lutinRepository.deleteById(lutinId);
	}

	// find lutin by id
	public LutinEntity findLutinById(Long lutinId) {
		
		return lutinRepository.findById(lutinId).orElse(null);
	}
	
	// find lutin by mail
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

	// find all
	public List<LutinEntity> findAll() {
		
		return lutinRepository.findAll();
	}
	
	
//////////////////////////////////
// Gestion des Jouets du catalogue
/////////////////////////////////
	
	/// à faire

//////////////////////////////////
// Gestion des catégories de jouets
/////////////////////////////////
	
	/// a faire
	
//////////////////////////////////
// Gestion des compétences des lutins, et des compétences nécéssaires à la fabrication des jouets
/////////////////////////////////	
	
	/// a faire
	
//////////////////////////////////
// Export (PDF ou json ou XML ou csv) listing Lutins
/////////////////////////////////
	
	/// à faire
	
	
	
//////////////////////////////////
// Export (PDF ou json ou XML ou csv) commandes avec état (à faire / en cours / réalisée)
/////////////////////////////////

	/// à faire
}
