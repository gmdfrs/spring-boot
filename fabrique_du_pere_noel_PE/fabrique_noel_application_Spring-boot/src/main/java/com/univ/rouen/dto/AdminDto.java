package com.univ.rouen.dto;

import java.util.List;

import com.univ.rouen.entity.CommandeEntity;

/**
 * Dto Admin
 * @author GROUPE JEE
 */
public class AdminDto extends UserDto {
	
	private Long id;
	// liste des commandes
	private List<CommandeEntity> commandes;

	public AdminDto() {}

	public AdminDto(List<CommandeEntity> commandes) {
		super();
		this.commandes = commandes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CommandeEntity> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeEntity> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "AdminDto [commandes=" + commandes + "]";
	}	
}
