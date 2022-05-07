package com.univ.rouen.service;

import java.util.List;

import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.entity.JouetEntity;

/**
 * Service pour ijouet
 * @author GROUPE JEE
 */
public interface IJouetService {
	public JouetEntity saveJouet(JouetEntity jouet);
	public JouetEntity updateJouet(JouetEntity jouet);
	public void deleteJouet(Long jouetId);
	public JouetEntity findJouetById(Long jouetId);
	public List<JouetEntity> findAll();
	public boolean checkIfIdexists(Long id);
}
