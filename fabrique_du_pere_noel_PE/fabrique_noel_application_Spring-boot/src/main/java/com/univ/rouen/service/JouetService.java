package com.univ.rouen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.JouetEntity;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.repository.JouetRepository;

/**
 * Service pour jouet
 * @author GROUPE JEE
 */
@Service
public class JouetService implements IJouetService {

	@Autowired
	private JouetRepository jouetRep; 
	
	@Override
	public JouetEntity saveJouet(JouetEntity jouet) {
		
		return	jouetRep.save(jouet);
	}
	@Override
	public JouetEntity updateJouet(JouetEntity jouet) {
		
		return jouetRep.save(jouet);
	}

	@Override
	public void deleteJouet(Long jouetId) {
		jouetRep.deleteById(jouetId);

	}

	@Override
	public JouetEntity findJouetById(Long jouetId) {
		
		return jouetRep.findById(jouetId).orElse(null);
	}

	
	@Override
	public boolean checkIfIdexists(Long id) {
		// TODO Auto-generated method stub
		return jouetRep.existsById(id);
	}

	@Override
	public List<JouetEntity> findAll() {
		
		return jouetRep.findAll();
	}


}
