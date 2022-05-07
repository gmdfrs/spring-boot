package com.univ.rouen.service;

import java.util.List;

import com.univ.rouen.entity.CommandeEntity;

/**
 * Service pour icommande
 * @author GROUPE JEE
 */
public interface ICommandeService {
	public CommandeEntity saveCommande(CommandeEntity commande);
	public CommandeEntity updateCommande(CommandeEntity commande);
	public void deleteCommande(Long commandeId);
	public CommandeEntity findCommandeById(Long commandeId);
	public List<CommandeEntity> findAll();
	public boolean checkIfIdexists(Long id);
}
