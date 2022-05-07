package com.univ.rouen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.repository.CommandeRepository;
/**
 * Service pour commande
 * @author GROUPE JEE
 */
@Service
@Transactional
public class CommandeService implements ICommandeService{
	@Autowired
	private CommandeRepository commandeRepository;
	@Override
	public CommandeEntity saveCommande(CommandeEntity commande) {
		
		return	commandeRepository.save(commande);
	}

	@Override
	public CommandeEntity updateCommande(CommandeEntity commande) {
		
		return commandeRepository.save(commande);
	}

	@Override
	public void deleteCommande(Long commandeId) {
		commandeRepository.deleteById(commandeId);

	}

	@Override
	public CommandeEntity findCommandeById(Long commandeId) {
		
		return commandeRepository.findById(commandeId).orElse(null);
	}

	@Override
	public boolean checkIfIdexists(Long id) {
		// TODO Auto-generated method stub
		return commandeRepository.existsById(id);
	}

	@Override
	public List<CommandeEntity> findAll() {
		
		return commandeRepository.findAll();
	}

}
